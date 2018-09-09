package com.creatshare.answerapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerApiApplicationTests {

    public static int test = 10;


    @Test
    public void contextLoads() {

        System.out.println(test);
        test = 20;
        System.out.println(test);
        System.out.println(test);

    }

}