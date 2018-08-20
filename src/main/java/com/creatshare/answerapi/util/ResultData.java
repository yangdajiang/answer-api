package com.creatshare.answerapi.util;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData {

    private int code;
    private String msg;
    private Object object;

    public ResultData(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ResultData(ResultCode resultCode,Object object){
        this(resultCode);
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObject() {
        return object;
    }
}
