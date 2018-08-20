package com.creatshare.answerapi.service;

import com.creatshare.answerapi.dao.QuestionMapper;
import com.creatshare.answerapi.pojo.Question;
import com.creatshare.answerapi.pojo.QuestionExample;
import com.creatshare.answerapi.service.impt.QuestionServiceImpt;
import com.creatshare.answerapi.util.GetCard;
import com.creatshare.answerapi.util.InitTime;
import com.creatshare.answerapi.util.QuestionType;
import com.creatshare.answerapi.util.SelectQuestionDire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class QuestionService implements QuestionServiceImpt {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public int insertQues(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public int deleteQues(int quId) {
        return questionMapper.deleteByPrimaryKey(quId);
    }

    @Override
    public int updateQues(Question question) {
        return questionMapper.updateByPrimaryKeyWithBLOBs(question);
    }

    @Override
    public Question selectQuesById(int quId) {
        return questionMapper.selectByPrimaryKey(quId);
    }

    @Override
    public List<Question> selectAllQues() {
        QuestionExample questionExample = new QuestionExample();
        questionExample.or().andQuIdIsNotNull();
        List<Question> list = questionMapper.selectByExampleWithBLOBs(questionExample);
        return list;
    }

    @Override
    public List<Question> selectQuesByType(int quType) {

        QuestionExample questionExample = new QuestionExample();
        questionExample.or().
                andQuTypeEqualTo(quType);

        return questionMapper.selectByExampleWithBLOBs(questionExample);
    }

    @Override
    public List<Question> randomSelectQues(String direction,String userNum) {

        Calendar newTime = Calendar.getInstance();
        Calendar startTime = new GetCard().getCardByDirection(direction);

        if(newTime.after(startTime)){
            SelectQuestionDire selectQuestionDire = new SelectQuestionDire();

            QuestionType questionType =
                    selectQuestionDire.returnDire(direction);

            List<Question> list =
                    questionMapper.randomSelect(questionType.getBase(),userNum,3);

            list.addAll(questionMapper.randomSelect(questionType.getChoice(),userNum,10));
            list.addAll(questionMapper.randomSelect(questionType.getAnswer(),userNum,3));
            list.addAll(questionMapper.randomSelect(questionType.getProgram(),userNum,3));

            return list;
        }
        return null;
    }
}
