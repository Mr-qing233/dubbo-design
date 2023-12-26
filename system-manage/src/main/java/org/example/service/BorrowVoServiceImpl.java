package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.repository.BorrowVoQueryRepository;
import org.example.vo.BorrowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@DubboService
public class BorrowVoServiceImpl implements BorrowVoService{

    @Autowired
    private BorrowVoQueryRepository borrowVoQueryRepository;

    /**
     * @param uid 用户id
     * @return List
     */
    @Override
    public List<BorrowVo> findBorrowByUid(String uid) {
        return borrowVoQueryRepository.searchBorrowVoByUid(uid);
    }

    /**
     * @param bid 书籍id
     * @return List
     */
    @Override
    public List<BorrowVo> findBorrowByBid(String bid) {
        return borrowVoQueryRepository.searchBorrowVoByBid(bid);
    }

    /**
     * @param uid 用户id
     * @return List
     */
    @Override
    public List<BorrowVo> findUserNotReturn(String uid) {
        return borrowVoQueryRepository.searchUserNotReturn(uid);
    }
}
