package com.creatshare.answerapi.pojo;

import com.creatshare.answerapi.util.CardEnum;
import com.creatshare.answerapi.util.InitTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    private String direction;
    private String timeString;
    @JsonIgnore
    private Calendar calendar;

    public Card(CardEnum cardEnum) {
        this.direction = cardEnum.getDirection();
        this.calendar = new InitTime().initTime(
                cardEnum.getYear(),
                cardEnum.getMonth(),
                cardEnum.getDay(),
                cardEnum.getHour(),
                cardEnum.getMinute());
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd-HH:mm");
        this.timeString = timeFormat.format(this.calendar.getTime());
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

}
