package com.creatshare.answerapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.creatshare.answerapi.dao")
public class AnswerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnswerApiApplication.class, args);
    }
}
