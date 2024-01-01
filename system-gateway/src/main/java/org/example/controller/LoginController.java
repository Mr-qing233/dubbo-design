package org.example.controller;


import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dto.CheckDto;
import org.example.entity.User;
import org.example.service.LoginService;
import org.example.vo.ResultJson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @DubboReference
    private LoginService loginService;

    @PostMapping("/user")
    public ResultJson<User> loginUser(@RequestBody CheckDto checkDto){
        return loginService.loginUser(checkDto.getUid(), checkDto.getPassword());
    }
}
