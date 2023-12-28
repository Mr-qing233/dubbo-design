package org.example.service;


import org.example.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * 根据bid搜索书籍信息
     *
     * @param bid 书籍id
     */
    Book searchBookById(String bid);

    /**
     * 根据内容搜索全部字段
     * @param contain 搜索内容
     * @return List<Book>
     */
    List<Book> searchBooksByAllColumn(String contain);

    /**
     * 减少库存书籍
     * @param bid 书籍id
     * @param number 减少量
     * @return boolean
     */
    boolean decreaseStockBook(String bid,Integer number);

    /**
     * 增加库存书籍
     * @param bid 书籍id
     * @param number 增量
     * @return boolean
     */
    boolean increaseStockBook(String bid,Integer number);

    /**
     * 新增书籍
     * @param book 书籍实体
     * @return boolean
     */
    boolean addNewBook(Book book,String uid);
}
