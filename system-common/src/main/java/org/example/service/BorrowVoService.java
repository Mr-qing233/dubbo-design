package org.example.service;

import org.example.entity.Borrow;
import org.example.vo.BorrowVo;

import java.util.List;

public interface BorrowVoService {
    List<BorrowVo> findBorrowByUid(String uid);
    List<BorrowVo> findBorrowByBid(String bid);
    List<BorrowVo> findUserNotReturn(String uid);
}
