package com.creatshare.answerapi.controller;

import com.creatshare.answerapi.service.CacheService;
import com.creatshare.answerapi.enums.ResultCodeEnum;
import com.creatshare.answerapi.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @PostMapping(value = "/subCache")
    public ResultData subCache(@RequestParam String userNum,
                               @RequestParam String subNum,
                               @RequestParam String subContent){
        cacheService.subCache(userNum,subNum,subContent);
        return new ResultData(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "/getCache")
    public String getCache(@RequestParam String userNum){
        String json = cacheService.returnCache(userNum);
        return json;
    }
}
