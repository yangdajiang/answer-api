package com.creatshare.answerapi.service.impt;

import com.creatshare.answerapi.pojo.UserInfo;
import com.creatshare.answerapi.pojo.UserPaper;

import java.util.List;

public interface UserInfoServiceImpt {

    int insertUserInfo(UserInfo userInfo);
    int deleteUserInfo(int id);
    int updateUserInfoById(UserInfo userInfo);
    UserInfo selectUserInfoById(int id);
    List<UserInfo> selectAllUserInfo();
    List<UserInfo> selectUserInfoByResult(int userResult);
    List<UserInfo> selectUserInfoByNum(String userNum);
    UserPaper selectUserPapById(int id);

}
