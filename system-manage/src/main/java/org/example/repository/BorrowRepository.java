package org.example.repository;

import org.example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    /**
     * 根据bid与uid搜索特定记录
     * @param bid 书籍id
     * @param uid 用户id
     */
    Borrow findBorrowByBidAndUid(String bid, String uid);
}
