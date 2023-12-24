package org.example.vo;

public enum ResultEnum implements BaseErrorInfo{
    SUCCESS("200","成功"),
    ERROR("500","系统错误"),
    MISSINGSERVLETREQUESTPARAMETER("1001","Servlet缺少必要参数"),
    MISSINGPARAMTERBODY("1002","缺少请求体"),
    BINDENTITYERROR("1003","实体对象传参绑定方法参数错误"),
    METHODARGUMENTERROR("1004","实体对象请求体传参异常:方法参数无效"),
    UPDATEERROR("2001","更新业务错误"),
    SAVEERROR("2002","数据新增业务错误"),
    DELETEERROR("2003","数据删除业务错误"),
    SEARCHERROR("2004","数据搜索业务错误"),
    SEARCHNOTFOUND("2005","没有搜索到结果"),
    MISSINGPARAMS("2006","缺少必要参数"),
    PARAMSDOMAINERROR("2007","参数不符合条件"),
    HAVENOTRETURNED("2008","有书籍未归还"),
    BORROWFAILED("2009","借阅失败"),
    DECREASEFAILED("2010","减少书籍失败"),
    INCREASEFAILED("2011","增加书籍失败"),
    RETURNFAILED("2012","归还书籍失败"),
    ;

    private String code;
    private String msg;
    ResultEnum(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取错误码
     * @return String
     */
    @Override
    public String getResultCode() {
        return code;
    }

    /**
     * 获取错误信息
     * @return String
     */
    @Override
    public String getResultMsg() {
        return msg;
    }
}
