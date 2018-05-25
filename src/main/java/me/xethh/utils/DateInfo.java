package me.xethh.utils;

import java.util.Calendar;
import java.util.Date;

public class DateInfo {
    private Calendar cal=Calendar.getInstance();
    /*
    Constructor
     */
    private DateInfo(Date date){
        cal.setTime(date);
    }
    public static DateInfo from(Date date){
        return new DateInfo(date);
    }

    public Integer year(){
        return cal.get(Calendar.YEAR);
    }
    public Month month(){
        return Month.ofOrdinal(cal.get(Calendar.MONTH));
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

    public DateBuilder asBuilder(){
        return DateBuilder.from(cal.getTime());
    }
    public Date asDate(){
        return cal.getTime();
    }
    public Calendar asCalendar(){
        return cal;
    }
    public Long asLong(){
        return asDate().getTime();
    }
}

