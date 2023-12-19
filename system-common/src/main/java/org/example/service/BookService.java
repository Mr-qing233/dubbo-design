package org.example.service;


import org.example.entity.Book;

public interface BookService {
    /**
     * 根据bid搜索书籍信息
     * @param bid 书籍id
     */
    Book searchBookById(String bid);
}
