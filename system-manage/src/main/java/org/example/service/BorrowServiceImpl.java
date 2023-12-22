package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.exception.ServiceException;
import org.example.repository.BorrowRepository;
import org.example.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService
public class BorrowServiceImpl implements BorrowService{
    /**
     *
     */
    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * 根据Bid与Uid搜索借阅记录
     *
     * @param bid 书籍id
     * @param uid 用户id
     * @return List
     */
    @Override
    public List<Borrow> searchBookByBidAndUid(String bid, String uid) {
        List<Borrow> borrow = borrowRepository.findBorrowByBidAndUid(bid, uid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }

    /**
     * 根据bid搜索特定记录
     *
     * @param bid 书籍id
     */
    @Override
    public List<Borrow> searchBookByBid(String bid) {
        List<Borrow> borrow = borrowRepository.findBorrowByBid(bid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }

    /**
     * 根据uid搜索特定记录
     *
     * @param uid 用户id
     */
    @Override
    public List<Borrow> searchBookByUid(String uid) {
        List<Borrow> borrow = borrowRepository.findBorrowByUid(uid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }
}
