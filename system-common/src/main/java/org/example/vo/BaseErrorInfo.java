package org.example.vo;

/**
 *  接口美剧返回码
 */
public interface BaseErrorInfo {
    /**
     * 获取错误码
     * @return String
     */
    String getResultCode();

    /**
     * 获取错误信息
     * @return String
     */
    String getResultMsg();
}
