package org.example.controller;


import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Borrow;
import org.example.service.BorrowVoService;
import org.example.vo.BorrowVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/borrowVo")
public class BorrowVoController {
    @DubboReference
    private BorrowVoService borrowVoService;

    /**
     * 根据bid搜索特定记录
     * @param bid 书籍id
     */
    @GetMapping("/bookRecord")
    public List<BorrowVo> showBookRecord(@RequestParam("bid") String bid){
        return borrowVoService.findBorrowByBid(bid);
    }

    /**
     * 根据uid搜索特定记录
     * @param uid 用户id
     */
    @GetMapping("/userRecord")
    public List<BorrowVo> showUserRecord(@RequestParam("uid") String uid){
        return borrowVoService.findBorrowByUid(uid);
    }

    /**
     * 根据uid搜索特定记录
     * @param uid 用户id
     */
    @GetMapping("/notReturn")
    public List<BorrowVo> showNotReturnRecord(@RequestParam("uid") String uid){
        return borrowVoService.findUserNotReturn(uid);
    }
}
