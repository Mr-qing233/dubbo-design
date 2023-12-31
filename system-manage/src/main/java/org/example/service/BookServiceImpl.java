package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Book;
import org.example.exception.ServiceException;
import org.example.repository.BookRepository;

import org.example.vo.ResultEnum;
import org.example.vo.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DubboService
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StorageService storageService;

    /**
     * 根据id搜索书籍数据
     * @return Book
     */
    @Override
    public ResultJson<Book> searchBookById(String bid) {
        Book bookByBid = bookRepository.findBookByBid(bid);
        if (bookByBid == null){
            return ResultJson.Error(ResultEnum.SEARCHNOTFOUND);
        }
        return ResultJson.Success(bookByBid);
    }

    /**
     * 根据内容搜索全部字段
     * @param contain 搜索内容
     * @return List<Book>
     */
    @Override
    public ResultJson<List<Book>> searchBooksByAllColumn(String contain) {
        List<Book> bookList = bookRepository.findByAllColumn(contain);
        if (bookList == null){
            return ResultJson.Error(ResultEnum.SEARCHNOTFOUND);
        }
        return ResultJson.Success(bookList);
    }

    /**
     * 减少库存
     * @param bid    书籍id
     * @param number 减少量
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> decreaseStockBook(String bid, Integer number) {
        if(bookRepository.decreaseStock(bid,number)==0){
            return ResultJson.Error(ResultEnum.DECREASEFAILED);
        }
        return ResultJson.Success(true);
    }

    /**
     * 增加库存
     * @param bid    书籍id
     * @param number 增量
     * @return boolean
     */
    @Override
    public ResultJson<Boolean> increaseStockBook(String bid, Integer number) {
        if(bookRepository.increaseStock(bid,number)==0){
            return ResultJson.Error(ResultEnum.INCREASEFAILED);
        }
        return ResultJson.Success(true);
    }

    /**
     * @param book 书籍实体
     * @return boolean
     */
    @Override
    @Transactional
    public ResultJson<Boolean> addNewBook(Book book,String uid) {
        // 检索是否已存在
        if(bookRepository.judgeExist(book.getBName(),book.getAuthor())!=null){
            return ResultJson.Error(ResultEnum.BOOKHASEXISTED);
        }
        // 新增书籍
        if (bookRepository.addNewBook(book)!=0){
            Book bookAltered = bookRepository.judgeExist(book.getBName(), book.getAuthor());
            // 修改storage记录
            storageService.addStorage(uid,bookAltered.getBid(),bookAltered.getTotalQuantity());
        }else {
            return ResultJson.Error(ResultEnum.NEWBOOKFAILED);
        }

        return ResultJson.Success(true);
    }
}
