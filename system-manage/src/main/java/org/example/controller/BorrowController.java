package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
