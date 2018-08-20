package com.creatshare.answerapi.service.impt;

import com.creatshare.answerapi.pojo.User;

public interface UserLoginServiceImp {
    User userLogin(String phone, String code) throws Exception;
}
