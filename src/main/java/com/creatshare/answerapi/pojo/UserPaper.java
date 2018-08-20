package com.creatshare.answerapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPaper extends UserInfo{

    private String userNum;
    private String userName;
    private String userDirection;
    private Integer userChoice;
    private BigDecimal userProgram;
    private Integer userResult;
    private List<Question> userQuestion;
    private String userAnswer;

    @Override
    public String getUserNum() {
        return userNum;
    }

    @Override
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserDirection() {
        return userDirection;
    }

    @Override
    public void setUserDirection(String userDirection) {
        this.userDirection = userDirection;
    }

    @Override
    public Integer getUserChoice() {
        return userChoice;
    }

    @Override
    public void setUserChoice(Integer userChoice) {
        this.userChoice = userChoice;
    }

    @Override
    public BigDecimal getUserProgram() {
        return userProgram;
    }

    @Override
    public void setUserProgram(BigDecimal userProgram) {
        this.userProgram = userProgram;
    }

    @Override
    public Integer getUserResult() {
        return userResult;
    }

    @Override
    public void setUserResult(Integer userResult) {
        this.userResult = userResult;
    }

    public List<Question> getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(List<Question> userQuestion) {
        this.userQuestion = userQuestion;
    }

    @Override
    public String getUserAnswer() {
        return userAnswer;
    }

    @Override
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
