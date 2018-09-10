package com.creatshare.answerapi.controller;

import com.creatshare.answerapi.pojo.Card;
import com.creatshare.answerapi.util.GetCard;
import com.creatshare.answerapi.enums.ResultCodeEnum;
import com.creatshare.answerapi.util.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @RequestMapping("/getAllCard")
    public ResultData getCard(){
        List<Card> list = new GetCard().getAllCard();
        return new ResultData(ResultCodeEnum.SUCCESS,list);
    }
}
