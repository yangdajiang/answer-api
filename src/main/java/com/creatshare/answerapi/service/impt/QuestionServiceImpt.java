package com.creatshare.answerapi.service.impt;

import com.creatshare.answerapi.pojo.Question;

import java.util.List;

public interface QuestionServiceImpt {

    int insertQues(Question question);
    int deleteQues(int quId);
    int updateQues(Question question);
    Question selectQuesById(int quId);
    List<Question> selectAllQues();
    List<Question> selectQuesByType(int quType);
    List<Question> randomSelectQues(String direction,String userNum);

}
