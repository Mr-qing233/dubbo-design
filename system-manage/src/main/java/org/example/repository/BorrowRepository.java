package org.example.repository;

import org.example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    /**
     * 根据bid与uid搜索特定记录
     *
     * @param bid 书籍id
     * @param uid 用户id
     */
    List<Borrow> findBorrowByBidAndUid(String bid, String uid);
    /**
     * 根据bid搜索特定记录
     * @param bid 书籍id
     */
    List<Borrow> findBorrowByBid(String bid);
    /**
     * 根据uid搜索特定记录
     * @param uid 用户id
     */
    List<Borrow> findBorrowByUid(String uid);
}
