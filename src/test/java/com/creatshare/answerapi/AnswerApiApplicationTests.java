package com.creatshare.answerapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.creatshare.answerapi.pojo.User;
import com.creatshare.answerapi.util.InitTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerApiApplicationTests {


    @Test
    public void contextLoads() {

        //Calendar newTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

//        Calendar startTime = new InitTime().initTime(2019,9,8,8,8);
//        Calendar startTime1 = new InitTime().initTime(2017,9,8,8,8);

        Calendar newTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        newTime.set(Calendar.YEAR,2019);
        newTime.set(Calendar.MONTH,8);
        newTime.set(Calendar.DAY_OF_MONTH,25);
        newTime.set(Calendar.HOUR_OF_DAY,2);
        newTime.set(Calendar.MINUTE,12);
        //newTime.set(2018,12,5,6,18,00);

        Calendar newTime1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm");

        String time = format.format(newTime.getTime());
        //String time1 = format.format(startTime1.getTime());

        System.out.println(time);
//        System.out.println(time1);

        //int flag = newTime.compareTo(startTime);
        //System.out.println(flag);

        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        calendar.set(Calendar.DAY_OF_YEAR,2018);
//        calendar.set(Calendar.DAY_OF_MONTH,8);
//        calendar.set(Calendar.DAY_OF_MONTH,17);
//        calendar.set(Calendar.HOUR_OF_DAY,23);
//        calendar.set(Calendar.MINUTE,38);




        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
       // Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
//        String time = format.format(calendar.getTime());
//        System.out.println(time);

//        int flag = calendar1.compareTo(calendar);
//        System.out.println(flag);


    }

}
