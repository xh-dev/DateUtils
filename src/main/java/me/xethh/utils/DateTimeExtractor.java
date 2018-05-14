package me.xethh.utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeExtractor {
    public enum Month{
        JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;

        public int toNumber(){
            return ordinal()+1;
        }

        public static Month of(int num){
            for(Month value:Month.values())
                if(num==value.ordinal())
                    return value;
            throw new RuntimeException(String.format("Value[%d] not support for month", num));


        }
    }
    private Calendar cal=Calendar.getInstance();
    private DateTimeExtractor(Date date){
        cal.setTime(date);
    }
    public static DateTimeExtractor get(Date date){
        return new DateTimeExtractor(date);
    }


    public Integer year(){
        return cal.get(Calendar.YEAR);
    }
    public Month month(){
        return Month.of(cal.get(Calendar.MONTH));
    }
    public Integer day(){
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    public Integer hour(){
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    public Integer min(){
        return cal.get(Calendar.MINUTE);
    }
    public Integer second(){
        return cal.get(Calendar.SECOND);
    }
    public Integer ms(){
        return cal.get(Calendar.MILLISECOND);
    }
}
