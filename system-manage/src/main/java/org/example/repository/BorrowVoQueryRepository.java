package org.example.repository;

import org.example.vo.BorrowVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowVoQueryRepository extends JpaRepository<BorrowVo,Integer> {
    @Query(value = "SELECT borrow_id,bname,uname,b_date,r_date,state FROM vo_borrow WHERE uid = :uid",nativeQuery = true)
    List<BorrowVo> searchBorrowVoByUid(@Param("uid") String uid);
    @Query(value = "SELECT borrow_id,bname,uname,b_date,r_date,state FROM vo_borrow WHERE bid = :bid",nativeQuery = true)
    List<BorrowVo> searchBorrowVoByBid(@Param("bid") String bid);

    @Query(value = "SELECT borrow_id,bname,uname,b_date,r_date,state FROM vo_borrow WHERE uid = :uid AND state != 1",nativeQuery = true)
    List<BorrowVo> searchUserNotReturn(@Param("uid") String uid);
}
