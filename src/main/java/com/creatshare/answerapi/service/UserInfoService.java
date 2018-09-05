package com.creatshare.answerapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.creatshare.answerapi.dao.QuestionMapper;
import com.creatshare.answerapi.dao.UserInfoMapper;
import com.creatshare.answerapi.pojo.Question;
import com.creatshare.answerapi.pojo.UserInfo;
import com.creatshare.answerapi.pojo.UserInfoExample;
import com.creatshare.answerapi.pojo.UserPaper;
import com.creatshare.answerapi.service.impt.UserInfoServiceImpt;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService implements UserInfoServiceImpt {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionService questionService;

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        int flag = userInfoMapper.insert(userInfo);
        return flag;
    }

    @Override
    public int deleteUserInfo(int id) {
        int flag = userInfoMapper.deleteByPrimaryKey(id);
        return flag;
    }

    @Override
    public int updateUserInfoById(UserInfo userInfo) {
        int flag = userInfoMapper.updateByPrimaryKeyWithBLOBs(userInfo);
        return flag;
    }

    @Override
    public UserInfo selectUserInfoById(int id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public List<UserInfo> selectAllUserInfo() {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.or()
                .andUserIdIsNotNull();
        List<UserInfo> list = userInfoMapper.selectByExampleWithBLOBs(userInfoExample);
        return list;
    }

    @Override
    public List<UserInfo> selectUserInfoByResult(int userResult) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.or()
                .andUserResultEqualTo(userResult);
        List<UserInfo> list = userInfoMapper.selectByExampleWithBLOBs(userInfoExample);
        return list;
    }

    @Override
    public List<UserInfo> selectUserInfoByNum(String userNum) {
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.or()
                .andUserNumEqualTo(userNum);
        List<UserInfo> list = userInfoMapper.selectByExampleWithBLOBs(userInfoExample);
        return list;
    }

    @Override
    public UserPaper selectUserPapById(int id) {

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if(userInfo!=null) {

            JSONObject jsonObject = (JSONObject) JSON.toJSON(userInfo);

            String direction = userInfo.getUserDirection();
            String userNum = userInfo.getUserNum();

            List<Question> list = questionService.randomSelectQues(direction, userNum);

            if (list != null) {
                jsonObject.put("userQuestion", list);

                UserPaper userPaper = JSON.toJavaObject(jsonObject, UserPaper.class);

                return userPaper;
            }
        }
        return null;

    }

    @Override
    public UserInfo getRightChoiceNum(UserInfo userInfo) {

        String xml = userInfo.getUserAnswer();

        Document doc = null;

        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element result = doc.getRootElement();
        List<Element> elements = result.elements();

        for (Element e:elements
                ) {

            String quType = e.element("quType").getText();

            if (quType.equals("2")||quType.equals("3")||quType.equals("4")||
                    quType.equals("5")||quType.equals("6")){

                int quId = Integer.parseInt(e.element("quId").getText());
                //System.out.println(quId);
                String quAnswer = e.element("quAnswer").getText();
                String rightAnswer = questionMapper.selectByPrimaryKey(quId).getQuAnswer();
                //System.out.println(quAnswer + " " + rightAnswer);
                int userChoice = userInfo.getUserChoice();
                if(quAnswer.equals(rightAnswer)) userInfo.setUserChoice(userChoice+1);

            }
        }
        return userInfo;
    }
}