package com.creatshare.answerapi.util;


public class SelectQuestionDire {

    public QuestionType returnDire(String direction){
        switch (direction){
            case "后端": return QuestionType.SERVICE;
            case "前端": return QuestionType.FRONT;
            case "产品": return QuestionType.PRODUCT;
            case "视觉": return QuestionType.VISION;
            case "运营": return QuestionType.OPERATE;
        }
        return null;
    }

}
