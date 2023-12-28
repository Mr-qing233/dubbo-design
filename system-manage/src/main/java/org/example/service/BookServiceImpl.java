package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Book;
import org.example.exception.ServiceException;
import org.example.repository.BookRepository;

import org.example.vo.ResultEnum;
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
    public Book searchBookById(String bid) {
        Book bookByBid = bookRepository.findBookByBid(bid);
        if (bookByBid == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return bookByBid;
    }

    /**
     * 根据内容搜索全部字段
     * @param contain 搜索内容
     * @return List<Book>
     */
    @Override
    public List<Book> searchBooksByAllColumn(String contain) {
        List<Book> bookList = bookRepository.findByAllColumn(contain);
        if (bookList == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return bookList;
    }

    /**
     * 减少库存
     * @param bid    书籍id
     * @param number 减少量
     * @return boolean
     */
    @Override
    public boolean decreaseStockBook(String bid, Integer number) {
        if(bookRepository.decreaseStock(bid,number)==0){
            throw new ServiceException(ResultEnum.DECREASEFAILED);
        }
        return true;
    }

    /**
     * 增加库存
     * @param bid    书籍id
     * @param number 增量
     * @return boolean
     */
    @Override
    public boolean increaseStockBook(String bid, Integer number) {
        if(bookRepository.increaseStock(bid,number)==0){
            throw new ServiceException(ResultEnum.INCREASEFAILED);
        }
        return true;
    }

    /**
     * @param book 书籍实体
     * @return boolean
     */
    @Override
    @Transactional
    public boolean addNewBook(Book book,String uid) {
        // 检索是否已存在
        if(bookRepository.judgeExist(book.getBName(),book.getAuthor())!=null){
            throw new ServiceException(ResultEnum.BOOKHASEXISTED);
        }
        // 新增书籍
        if (bookRepository.addNewBook(book)!=0){
            Book bookAltered = bookRepository.judgeExist(book.getBName(), book.getAuthor());
            // 修改storage记录
            storageService.addStorage(uid,bookAltered.getBid(),bookAltered.getTotalQuantity());
        }else {
            throw new ServiceException(ResultEnum.NEWBOOKFAILED);
        }

        return true;
    }
}
