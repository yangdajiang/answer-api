package com.creatshare.answerapi.util;

import java.util.Calendar;
import java.util.TimeZone;

public class InitTime {

    public Calendar initTime(int year,int month,int day,int hour,int minute) {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        return calendar;
    }
}
