package me.xethh.utils.dateUtils.dataInfo;

import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.weekday.Weekday;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateInfoImpl implements DateInfo {
    private Calendar cal=Calendar.getInstance(DatetimeFactory.instance().getTimezone());
    /*
    Constructor
     */
    public DateInfoImpl(Date date){
        this(DatetimeFactory.instance().getTimezone(), date);
    }
    public DateInfoImpl(TimeZone timeZone, Date date){
        cal = Calendar.getInstance(timeZone);
        cal.setTime(date);
    }
    public DateInfoImpl(BaseTimeZone baseTimeZone, Date date){
        this(baseTimeZone.timeZone(), date);
    }
    @Override
    public Integer year(){
        return cal.get(Calendar.YEAR);
    }
    @Override
    public Month month(){
        return Month.ofOrdinal(cal.get(Calendar.MONTH));
    }
    @Override
    public Integer day(){
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    @Override
    public Integer weekOfYear(){
        return cal.get(Calendar.WEEK_OF_YEAR);
    }
    @Override
    public Integer weekOfMonth(){
        return cal.get(Calendar.WEEK_OF_MONTH);
    }
    @Override
    public Integer dayOfYear(){
        return cal.get(Calendar.DAY_OF_YEAR);
    }
    @Override
    public Integer hour(){
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    @Override
    public Integer min(){
        return cal.get(Calendar.MINUTE);
    }
    @Override
    public Integer second(){
        return cal.get(Calendar.SECOND);
    }
    @Override
    public Integer ms(){
        return cal.get(Calendar.MILLISECOND);
    }
    @Override
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
        return DateFormatBuilderFactory.NUMBER_DATETIME().format(asDate());
    }
    public String asNumberDate(){
        return DateFormatBuilderFactory.NUMBER_DATE().format(asDate());
    }
    public String asSimpleDateTime(){
        return DateFormatBuilderFactory.SIMPLE_DATETIME().format(asDate());
    }
    public String asSimpleDate(){
        return DateFormatBuilderFactory.SIMPLE_DATE().format(asDate());
    }
    public String asISO8601(){
        return DateFormatBuilderFactory.ISO8601().format(asDate());
    }
    public String asFormat(DateFormatBuilder builder){
        return asFormat(builder.build());
    }
    public String asFormat(SimpleDateFormat fmt){
        return fmt.format(asDate());
    }
}

