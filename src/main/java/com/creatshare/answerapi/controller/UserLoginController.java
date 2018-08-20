package com.creatshare.answerapi.controller;

import com.creatshare.answerapi.pojo.User;
import com.creatshare.answerapi.service.UserLoginService;
import com.creatshare.answerapi.util.ResultCode;
import com.creatshare.answerapi.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    @PostMapping(value = "/login")
    public ResultData userLogin(@RequestParam String phone,
                                @RequestParam String code,
                                HttpSession session) throws Exception {

        User user = userLoginService.userLogin(phone,code);
        if(user == null) return new ResultData(ResultCode.WARN,"登录失败");
        session.setAttribute("user",user.getNumber());
        session.setMaxInactiveInterval(120*60);
        return new ResultData(ResultCode.SUCCESS,user);
    }

}
