package org.example.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @DubboReference
    private BorrowService borrowService;

    /**
     * 根据bid与uid搜索特定记录
     * @param bid 书籍id
     * @param uid 用户id
     */
    @GetMapping("/findBorrowRecord")
    public List<Borrow> findBorrowRecord(@RequestParam("bid") String bid,
                                         @RequestParam("uid") String uid){
        return borrowService.searchBookByBidAndUid(bid, uid);
    }

    /**
     * 根据bid搜索特定记录
     * @param bid 书籍id
     */
    @GetMapping("/findBorrowRecord/bid")
    public List<Borrow> findBorrowRecordByBid(@RequestParam("bid") String bid){
        return borrowService.searchBookByBid(bid);
    }

    /**
     * 根据uid搜索特定记录
     * @param uid 用户id
     */
    @GetMapping("/findBorrowRecord/uid")
    public List<Borrow> findBorrowRecordByUid(@RequestParam("uid") String uid){
        return borrowService.searchBookByUid(uid);
    }
    @GetMapping("/findIds/borrowId")
    public HashMap<String,String > findIdsByBorrowId(@RequestParam("borrowId") Integer borrowId){
        return borrowService.searchIdsByBorrowId(borrowId);
    }

    @PostMapping("/saveRecord")
    public boolean saveRecord(@RequestBody Borrow borrow){
        return borrowService.addRecord(borrow);
    }

    @PostMapping("/return")
    public boolean returnRecord(@RequestParam("borrowId") Integer borrowId){
        return borrowService.returnRecord(borrowId);
    }
}
