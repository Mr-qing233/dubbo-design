package org.example.service;

import org.example.entity.Borrow;
import org.example.vo.BorrowVo;
import org.example.vo.ResultJson;

import java.util.List;

public interface BorrowVoService {
    ResultJson<List<BorrowVo>> findBorrowByUid(String uid);
    ResultJson<List<BorrowVo>> findBorrowByBid(String bid);
    ResultJson<List<BorrowVo>> findUserNotReturn(String uid);
}
