package com.creatshare.answerapi.pojo;

public class HttpResult {

    private int status;
    private String entity;

    public HttpResult(int status, String entity) {
        this.status = status;
        this.entity = entity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }
}
