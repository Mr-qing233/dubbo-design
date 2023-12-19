package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    /**
     * 根据bid搜索书籍信息
     * @param bid 书籍id
     */
    Book findBookByBid(String bid);
}
