package org.example.service;

import org.example.entity.Borrow;

public interface BorrowService {
    /**
     * 根据bid与uid搜索特定记录
     * @param bid 书籍id
     * @param uid 用户id
     */
    Borrow searchBookByBidAndUid(String bid, String uid);
}
