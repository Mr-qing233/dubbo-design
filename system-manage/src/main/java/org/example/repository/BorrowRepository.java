package org.example.repository;

import org.example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
    Borrow findBorrowByBidAndUid(String bid, String uid);
}
