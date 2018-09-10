package com.creatshare.answerapi.util;

import com.creatshare.answerapi.enums.CardEnum;
import com.creatshare.answerapi.pojo.Card;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GetCard {
    private List<Card> list;
    public List<Card> getAllCard() {
        this.list = new ArrayList<>();
        for (CardEnum ce:CardEnum.values()
             ) {
            list.add(new Card(ce));
        }
        return list;
    }

    public Calendar getCardByDirection(String direction){

        switch (direction){
            case "后端":return new Card(CardEnum.SERVICE).getCalendar();
            case "前端":return new Card(CardEnum.FRONT).getCalendar();
            case "视觉":return new Card(CardEnum.VISION).getCalendar();
            case "产品":return new Card(CardEnum.PRODUCT).getCalendar();
            case "运营":return new Card(CardEnum.OPERATE).getCalendar();
            default:return null;
        }
    }
}
