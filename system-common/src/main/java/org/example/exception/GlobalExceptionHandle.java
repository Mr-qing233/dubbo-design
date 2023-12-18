package org.example.exception;

import org.example.vo.ResultJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常拦截
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    /**
     * 如果抛出的是ServiceException则抛出该方法
     * @param serviceException 业务异常
     * @return Result.Error(serviceException)
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public <T> ResultJson<T> handle(ServiceException serviceException){
        return ResultJson.Error(serviceException);
    }
}
