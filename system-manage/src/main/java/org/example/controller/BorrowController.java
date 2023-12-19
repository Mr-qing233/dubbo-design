package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.Borrow;
import org.example.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @DubboReference
    private BorrowService borrowService;

    @GetMapping("/findBorrowRecord")

    public Borrow findBorrowRecord(@RequestParam("bid") String bid,
                                   @RequestParam("uid") String uid){
        return borrowService.searchBookByBidAndUid(bid, uid);
    }
}
