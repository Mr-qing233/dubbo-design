package org.example.exception;

import lombok.Getter;
import org.example.vo.ResultEnum;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    private String code;
    private String msg;
    public ServiceException(ResultEnum resultEnum){
        super(resultEnum.getResultMsg());
        this.code = resultEnum.getResultCode();
        this.msg = resultEnum.getResultMsg();
    }
}
