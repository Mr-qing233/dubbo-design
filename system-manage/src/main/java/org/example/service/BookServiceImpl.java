package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Book;
import org.example.exception.ServiceException;
import org.example.repository.BookRepository;

import org.example.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

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
}
