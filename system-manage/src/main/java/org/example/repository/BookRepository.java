package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    /**
     * 根据bid搜索书籍信息
     *
     * @param bid 书籍id
     */
    Book findBookByBid(String bid);

    /**
     * 根据内容搜索全部字段
     * @param contain 搜索内容
     */
    @Query(value = "SELECT * FROM db_book WHERE CONCAT(bid,bname,author,category,publish,location) LIKE CONCAT('%',:contain,'%')",nativeQuery = true)
    List<Book> findByAllColumn(@Param("contain") String contain);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `db_book` SET stock_quantity=stock_quantity-:num WHERE bid=:bid", nativeQuery = true)
    Integer decreaseStock(@Param("bid") String bid,@Param("num") Integer num);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `db_book` SET stock_quantity=stock_quantity+:num WHERE bid=:bid", nativeQuery = true)
    Integer increaseStock(@Param("bid") String bid,@Param("num") Integer num);
}
