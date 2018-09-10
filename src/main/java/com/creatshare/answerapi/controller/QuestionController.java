package com.creatshare.answerapi.controller;

import com.creatshare.answerapi.enums.ResultCodeEnum;
import com.creatshare.answerapi.pojo.Question;
import com.creatshare.answerapi.service.QuestionService;
import com.creatshare.answerapi.util.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping(value = "/insert")
    public ResultData insertQues(@RequestBody @Validated Question question){
        int flag =
                questionService.insertQues(question);
        if(flag==0){
            return new ResultData(ResultCodeEnum.WARN);
        }
        return new ResultData(ResultCodeEnum.SUCCESS);
    }

    @PostMapping(value = "/delete")
    public ResultData deleteQues(@RequestParam("quId") int quId){

        int flag =
                questionService.deleteQues(quId);

        if(flag==0) return new ResultData(ResultCodeEnum.WARN);

        return new ResultData(ResultCodeEnum.SUCCESS);
    }

    @PostMapping(value = "/update")
    public ResultData updateQues(@RequestBody @Validated Question question){

        int flag =
                questionService.updateQues(question);
        if(flag==0) return new ResultData(ResultCodeEnum.WARN);

        return new ResultData(ResultCodeEnum.SUCCESS);
    }

    @RequestMapping(value = "")
    public ResultData selectAllQues(@RequestParam int page,@RequestParam int size){
        PageHelper.startPage(page,size);
        List<Question> list = questionService.selectAllQues();
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        return new ResultData(ResultCodeEnum.SUCCESS,pageInfo);
    }

    @RequestMapping(value = "/id/{quId}")
    public ResultData selectQuesById(@PathVariable int quId){
        Question question =
                questionService.selectQuesById(quId);
        if(question==null)
            return new ResultData(ResultCodeEnum.WARN);
        return new ResultData(ResultCodeEnum.SUCCESS,question);
    }

    @RequestMapping(value = "/selectByType")
    public ResultData selectQuesByType(@RequestParam int quType,@RequestParam int page,@RequestParam int size){

        if(quType>12||quType<1) return new ResultData(ResultCodeEnum.WARN);

        PageHelper.startPage(page,size);
        List<Question> list =
                questionService.selectQuesByType(quType);
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        return new ResultData(ResultCodeEnum.SUCCESS,pageInfo);
    }

    @PostMapping(value = "/getRandomPap")
    public ResultData randomSelectQues(@RequestParam String direction,@RequestParam String userNum){
        List<Question> list =
                questionService.randomSelectQues(direction,userNum);
        if(list!=null) return new ResultData(ResultCodeEnum.SUCCESS,list);
        return new ResultData(ResultCodeEnum.WARN,"时间未到或查询错误");
    }

}