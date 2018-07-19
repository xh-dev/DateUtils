package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
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
    public Weekday weekday(){
        return Weekday.values()[cal.get(Calendar.DAY_OF_WEEK)-1];
    }


    public DateBuilder asBuilder(){
        return DateBuilderFactory.from(cal.getTime());
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
    public String asNumberDatetime(){
        return DateFormatBuilder.NUMBER_DATETIME.format(asDate());
    }
    public String asNumberDate(){
        return DateFormatBuilder.NUMBER_DATE.format(asDate());
    }
    public String asSimpleDateTime(){
        return DateFormatBuilder.SIMPLE_DATETIME.format(asDate());
    }
    public String asSimpleDate(){
        return DateFormatBuilder.SIMPLE_DATE.format(asDate());
    }
    public String asISO8601(){
        return DateFormatBuilder.ISO8601.format(asDate());
    }
    public String asFormat(DateFormatBuilder builder){
        return asFormat(builder.build());
    }
    public String asFormat(SimpleDateFormat fmt){
        return fmt.format(asDate());
    }
}

