package org.example.service;


import org.example.entity.Book;
import org.example.vo.ResultJson;

import java.util.List;

public interface BookService {
    /**
     * 根据bid搜索书籍信息
     *
     * @param bid 书籍id
     */
    ResultJson<Book> searchBookById(String bid);

    /**
     * 根据内容搜索全部字段
     * @param contain 搜索内容
     * @return List<Book>
     */
    ResultJson<List<Book>> searchBooksByAllColumn(String contain);

    /**
     * 减少库存书籍
     * @param bid 书籍id
     * @param number 减少量
     * @return boolean
     */
    ResultJson<Boolean> decreaseStockBook(String bid,Integer number);

    /**
     * 增加库存书籍
     * @param bid 书籍id
     * @param number 增量
     * @return boolean
     */
    ResultJson<Boolean> increaseStockBook(String bid,Integer number);

    /**
     * 新增书籍
     * @param book 书籍实体
     * @return boolean
     */
    ResultJson<Boolean> addNewBook(Book book,String uid);
}
