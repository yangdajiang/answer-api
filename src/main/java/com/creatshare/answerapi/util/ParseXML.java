package com.creatshare.answerapi.util;

import com.creatshare.answerapi.dao.QuestionMapper;
import com.creatshare.answerapi.pojo.UserInfo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParseXML {

    @Autowired
    QuestionMapper questionMapper;

    public UserInfo RightChioceNum(String xml,UserInfo userInfo) throws DocumentException {

        int userChoice = userInfo.getUserChoice();

        Document doc = DocumentHelper.parseText(xml);
        Element result = doc.getRootElement();
        List<Element> elements = result.elements();

        for (Element e:elements
             ) {

            String quType = e.element("quType").getText();

            if (quType.equals("2")||quType.equals("3")||quType.equals("4")||
                    quType.equals("5")||quType.equals("6")){
                int quId = Integer.parseInt(e.element("quId").getText());
                String quAnswer = e.element("quAnswer").getText();
                String rightAnswer = questionMapper.selectByPrimaryKey(quId).getQuAnswer();
                if(quAnswer.equals(rightAnswer)) userInfo.setUserChoice(userChoice+1);

            }
        }
        return userInfo;
    }

}
