package org.example.service;

import org.example.entity.Borrow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BorrowService {
    /**
     * 根据bid与uid搜索特定记录
     * @param bid 书籍id
     * @param uid 用户id
     */
    List<Borrow> searchBookByBidAndUid(String bid, String uid);
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

    /**
     * 检索未归还书籍
     * @param bid 书籍id
     * @param uid 用户id
     */
    boolean searchNotReturnedBook(String bid, String uid);

    /**
     * 检索对应bid与uid
     * @param borrowId 借阅id
     * @return Map
     */
    HashMap<String,String > searchIdsByBorrowId(Integer borrowId);

    /**
     * 新增借阅记录
     * @param borrow 书籍实体
     * @return boolean
     */
    boolean addRecord(Borrow borrow);

    /**
     * 还书
     * @param borrowId 借阅id
     * @return boolean
     */
    boolean returnRecord(Integer borrowId);
}
