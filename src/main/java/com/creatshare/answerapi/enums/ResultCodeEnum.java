package com.creatshare.answerapi.enums;

public enum ResultCodeEnum {

    SUCCESS(0,"request success"),
    WARN(-1,"request fail");

    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
