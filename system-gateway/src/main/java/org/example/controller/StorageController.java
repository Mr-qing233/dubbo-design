package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.Storage;
import org.example.service.StorageService;
import org.example.vo.ResultJson;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @DubboReference
    private StorageService storageService;

    /**
     * 仅仅增加记录，不修改book数量
     * @param uid 用户id
     * @param bid 书籍id
     * @param count 数量
     * @return boolean
     */
    @PostMapping("/addStorage")
    public ResultJson<Boolean> addStorageRecord(@RequestParam("uid") String uid, @RequestParam("bid") String bid, @RequestParam("count") Integer count){
        return storageService.addStorage(uid, bid, count);
    }
    /**
     * 增加库存同时修改book库存
     * @param uid 用户id
     * @param bid 书籍id
     * @param count 数量
     * @return boolean
     */
    @PostMapping("/newStorage")
    public ResultJson<Boolean> newStorageRecord(@RequestParam("uid") String uid,@RequestParam("bid") String bid,@RequestParam("count") Integer count){
        return storageService.newStorage(uid, bid, count);
    }

    @GetMapping("/showAll")
    public ResultJson<List<Storage>> showAllRecord(){
        return storageService.showAll();
    }
}
