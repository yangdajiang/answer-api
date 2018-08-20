package com.creatshare.answerapi.service.impt;

public interface CacheServiceImpt {

    void subCache(String userNum,String subNum, String subContent);
    String returnCache(String userNum);

}
