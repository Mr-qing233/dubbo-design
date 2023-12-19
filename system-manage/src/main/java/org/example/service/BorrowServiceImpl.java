package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.exception.ServiceException;
import org.example.repository.BorrowRepository;
import org.example.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * 根据Bid与Uid搜索借阅记录
     * @param bid String
     * @param uid String
     * @return Borrow
     */
    @Override
    public Borrow searchBookByBidAndUid(String bid, String uid) {
        Borrow borrow = borrowRepository.findBorrowByBidAndUid(bid, uid);
        if (borrow == null){
            throw new ServiceException(ResultEnum.SEARCHNOTFOUND);
        }
        return borrow;
    }
}
