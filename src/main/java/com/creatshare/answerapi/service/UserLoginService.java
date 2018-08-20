package com.creatshare.answerapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.creatshare.answerapi.component.HttpClientAPI;
import com.creatshare.answerapi.pojo.HttpResult;
import com.creatshare.answerapi.pojo.User;
import com.creatshare.answerapi.service.impt.UserLoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserLoginService implements UserLoginServiceImp {

    @Autowired
    HttpClientAPI httpClientAPI;

    @Override
    public User userLogin(String phone, String code) throws Exception {

        String url = "http://119.3.24.222:8080/nx/LoginServlet";
        Map<String,Object> map = new HashMap<>();
        map.put("phone",phone);
        map.put("code",code);
        HttpResult httpResult = httpClientAPI.doPost(url,map);
        String entity = httpResult.getEntity();
        JSONObject jsonObject = JSON.parseObject(entity);

        if(jsonObject.get("msg").equals(2)) {
            User user = JSON.toJavaObject(jsonObject,User.class);
            return user;
        }
        return null;
    }
}
