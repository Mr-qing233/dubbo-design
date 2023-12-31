package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.repository.BorrowVoQueryRepository;
import org.example.vo.BorrowVo;
import org.example.vo.ResultJson;
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
    public ResultJson<List<BorrowVo>> findBorrowByUid(String uid) {
        return ResultJson.Success(borrowVoQueryRepository.searchBorrowVoByUid(uid));
    }

    /**
     * @param bid 书籍id
     * @return List
     */
    @Override
    public ResultJson<List<BorrowVo>> findBorrowByBid(String bid) {
        return ResultJson.Success(borrowVoQueryRepository.searchBorrowVoByBid(bid));
    }

    /**
     * @param uid 用户id
     * @return List
     */
    @Override
    public ResultJson<List<BorrowVo>> findUserNotReturn(String uid) {
        return ResultJson.Success(borrowVoQueryRepository.searchUserNotReturn(uid));
    }
}
