package com.creatshare.answerapi.controller;

import com.creatshare.answerapi.pojo.UserInfo;
import com.creatshare.answerapi.pojo.UserPaper;
import com.creatshare.answerapi.service.UserInfoService;
import com.creatshare.answerapi.util.ResultCode;
import com.creatshare.answerapi.util.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping(value = "/insert")
    public ResultData insert(@RequestBody UserInfo userInfo) throws DocumentException {

        userInfo = userInfoService.getRightChoiceNum(userInfo);

        System.out.println(userInfo.getUserChoice());

        int flag =
                userInfoService.insertUserInfo(userInfo);
        if(flag!=0) return new ResultData(ResultCode.SUCCESS);
        return new ResultData(ResultCode.WARN);
    }

    @RequestMapping(value = "/delete")
    public ResultData delete(@RequestParam int id){
        int flag =
                userInfoService.deleteUserInfo(id);
        if(flag!=0) return new ResultData(ResultCode.SUCCESS);
        return new ResultData(ResultCode.WARN);
    }

    @PostMapping(value = "/update")
    public ResultData update(@RequestBody UserInfo userInfo){
        int flag =
                userInfoService.updateUserInfoById(userInfo);
        if(flag!=0) return new ResultData(ResultCode.SUCCESS);
        return new ResultData(ResultCode.WARN);
    }

    @RequestMapping("")
    public ResultData selectAll(@RequestParam int page,@RequestParam int size){
        PageHelper.startPage(page,size);
        List<UserInfo> list = userInfoService.selectAllUserInfo();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        return new ResultData(ResultCode.SUCCESS,pageInfo);
    }

    @RequestMapping(value = "/selectById")
    public ResultData selectById(@RequestParam int id){

        UserInfo userInfo = userInfoService.selectUserInfoById(id);
        if(userInfo!=null) return new ResultData(ResultCode.SUCCESS,userInfo);
        return new ResultData(ResultCode.WARN);

    }

    @RequestMapping(value = "/selectByResult")
    public ResultData selectUserInfoByResult(@RequestParam int result,
                                             @RequestParam int page,
                                             @RequestParam int size){
        if(result>=1||result<=3){
            PageHelper.startPage(page,size);
            List<UserInfo> list = userInfoService.selectUserInfoByResult(result);
            PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
            return new ResultData(ResultCode.SUCCESS,pageInfo);
        }
        return new ResultData(ResultCode.WARN);
    }

    @RequestMapping(value = "/selectByNum")
    public ResultData selectUserInfoByNum(@RequestParam String userNum){
        PageHelper.startPage(1,1);
        List<UserInfo> list = userInfoService.selectUserInfoByNum(userNum);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        return new ResultData(ResultCode.SUCCESS,pageInfo);
    }

    @RequestMapping(value = "/selectUserPapById")
    public ResultData selectUserPapById(@RequestParam int id){
        UserPaper userPaper = userInfoService.selectUserPapById(id);
        if(userPaper!=null) return new ResultData(ResultCode.SUCCESS,userPaper);
        return new ResultData(ResultCode.WARN,"答题时间未到或用户不存在");
    }

}
