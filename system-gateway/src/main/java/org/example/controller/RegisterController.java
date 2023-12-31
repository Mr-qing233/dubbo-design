package org.example.controller;


import org.apache.dubbo.config.annotation.DubboReference;
import org.example.entity.User;
import org.example.service.RegisterService;
import org.example.vo.BorrowVo;
import org.example.vo.ResultJson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @DubboReference
    private RegisterService registerService;

    @GetMapping("/nameExist")
    public ResultJson<Boolean> checkNameExist(@RequestParam("uname") String uname){
        return registerService.existUser(uname);
    }

    @PostMapping("/createUser")
    public ResultJson<Boolean> createUser(@RequestBody User user){
        return registerService.registerUser(user);
    }
}
