package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @DubboReference
    private TestService testService;

    @GetMapping("/state")
    public String testState(@RequestParam("state") String state){
        return testService.testException(state);
    }
}
