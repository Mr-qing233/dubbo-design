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
}
