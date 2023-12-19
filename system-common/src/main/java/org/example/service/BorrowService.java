package org.example.service;

import org.example.entity.Borrow;

public interface BorrowService {
    Borrow searchBookByBidAndUid(String bid, String uid);
}
