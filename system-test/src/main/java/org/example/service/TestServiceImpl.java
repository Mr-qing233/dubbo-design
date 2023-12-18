package org.example.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.exception.ServiceException;
import org.example.vo.ResultEnum;

@DubboService
public class TestServiceImpl implements TestService{
    /**
     * 测试自定义全局异常
     * @param state
     * @return
     */
    @Override
    public String testException(String state) {
        if (!state.equals("success")){
            throw new ServiceException(ResultEnum.ERROR);
        }
        return "hello";
    }
}
