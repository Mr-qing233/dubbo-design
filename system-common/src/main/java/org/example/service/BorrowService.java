package org.example.service;

import org.example.entity.Borrow;

import java.util.List;

public interface BorrowService {
    /**
     * 根据bid与uid搜索特定记录
     * @param bid 书籍id
     * @param uid 用户id
     */
    List<Borrow>  searchBookByBidAndUid(String bid, String uid);
    /**
     * 根据bid搜索特定记录
     * @param bid 书籍id
     */
    List<Borrow> searchBookByBid(String bid);
    /**
     * 根据uid搜索特定记录
     * @param uid 用户id
     */
    List<Borrow> searchBookByUid(String uid);
}
