package me.xethh.utils.dateManipulation.dataInfo;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateInfo {
    private Calendar cal=Calendar.getInstance(DatetimeFactory.instance().defaultTimezone());
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
    public Integer weekOfYear(){
        return cal.get(Calendar.WEEK_OF_YEAR);
    }
    public Integer weekOfMonth(){
        return cal.get(Calendar.WEEK_OF_MONTH);
    }
    public Integer dayOfYear(){
        return cal.get(Calendar.DAY_OF_YEAR);
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


    public DatetimeBuilder asBuilder(){
        return DatetimeFactory.instance().from(cal.getTime());
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
        return DateFormatBuilderImpl.NUMBER_DATETIME().format(asDate());
    }
    public String asNumberDate(){
        return DateFormatBuilderImpl.NUMBER_DATE().format(asDate());
    }
    public String asSimpleDateTime(){
        return DateFormatBuilderImpl.SIMPLE_DATETIME().format(asDate());
    }
    public String asSimpleDate(){
        return DateFormatBuilderImpl.SIMPLE_DATE().format(asDate());
    }
    public String asISO8601(){
        return DateFormatBuilderImpl.ISO8601().format(asDate());
    }
    public String asFormat(DateFormatBuilder builder){
        return asFormat(builder.build());
    }
    public String asFormat(SimpleDateFormat fmt){
        return fmt.format(asDate());
    }
}

