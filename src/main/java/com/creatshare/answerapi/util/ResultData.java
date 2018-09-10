package com.creatshare.answerapi.util;

import com.creatshare.answerapi.enums.ResultCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultData {

    private int code;
    private String msg;
    private Object object;

    public ResultData(ResultCodeEnum ResultCodeEnum){
        this.code = ResultCodeEnum.getCode();
        this.msg = ResultCodeEnum.getMsg();
    }

    public ResultData(ResultCodeEnum ResultCodeEnum,Object object){
        this(ResultCodeEnum);
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
