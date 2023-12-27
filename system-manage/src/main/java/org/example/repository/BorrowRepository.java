package org.example.repository;

import org.example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    /**
     * 根据bid与uid搜索特定记录
     */
    List<Borrow> findBorrowByBidAndUid(String bid, String uid);
    /**
     * 根据bid搜索特定记录
     */
    List<Borrow> findBorrowByBid(String bid);
    /**
     * 根据uid搜索特定记录
     */
    List<Borrow> findBorrowByUid(String uid);

    /**
     * 检索未归还
     */
    Borrow findBorrowByBidAndUidAndState(String bid, String uid,Integer state);

    /**
     * 检索对应bid与uid
     */
    Borrow findBorrowByBorrowId(Integer borrowId);

    /**
     * 新增借阅记录
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `db_borrow` (bid,uid,b_date,r_date,state) VALUES (:#{#borrow.bid},:#{#borrow.uid},:#{#borrow.bDate},:#{#borrow.rDate},:#{#borrow.state})",nativeQuery = true)
    Integer addNewRecord(@Param("borrow") Borrow borrow);

    /**
     * 还书
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `db_borrow` SET state=1,r_date=:rDate WHERE borrow_id=:borrowId AND state=0",nativeQuery = true)
    Integer alterRecordState(@Param("borrowId") Integer uid,@Param("rDate") String rDate);
}
