package com.creatshare.answerapi.util;

public enum CardEnum {

    SERVICE("后端",2018,8,19,17,38),
    FRONT("前端",2018,8,19,15,30),
    PRODUCT("产品",2018,8,19,15,30),
    OPERATE("运营",2018,8,19,15,30),
    VISION("视觉",2018,8,19,15,30);

    private String direction;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    CardEnum(String direction, int year, int month, int day, int hour, int minute) {
        this.direction = direction;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public String getDirection() {
        return direction;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
