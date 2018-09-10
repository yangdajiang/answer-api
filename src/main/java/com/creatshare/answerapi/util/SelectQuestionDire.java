package com.creatshare.answerapi.util;


import com.creatshare.answerapi.enums.QuestionTypeEnum;

public class SelectQuestionDire {

    public QuestionTypeEnum returnDire(String direction){
        switch (direction){
            case "后端": return QuestionTypeEnum.SERVICE;
            case "前端": return QuestionTypeEnum.FRONT;
            case "产品": return QuestionTypeEnum.PRODUCT;
            case "视觉": return QuestionTypeEnum.VISION;
            case "运营": return QuestionTypeEnum.OPERATE;
        }
        return null;
    }

}
