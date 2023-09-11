package me.xethh.utils.dateUtils.dataInfo;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateInfoImpl implements DateInfo {
//    private final Calendar cal;
    private ZonedDateTime cal;

    /*
    Constructor
     */
    public DateInfoImpl(Date date) {
        this(DatetimeFactory.instance().getTimezone(), date);
    }

    public DateInfoImpl(TimeZone timeZone, Date date) {
        cal = ZonedDateTime.ofInstant(date.toInstant(), timeZone.toZoneId());
//        cal = Calendar.getInstance(timeZone);
//        cal.setTime(date);
    }

    public DateInfoImpl(BaseTimeZone baseTimeZone, Date date) {
        this(baseTimeZone.timeZone(), date);
    }

    @Override
    public Integer year() {
        return cal.getYear();
    }

    @Override
    public Month month() {
        return Month.ofTimeMonth(cal.getMonth());
    }

    @Override
    public Integer day() {
        return cal.getDayOfMonth();
    }

    @Override
    public Integer weekOfYear() {
        var c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone(cal.getZone()));
        c.setTime(new Date(cal.toInstant().toEpochMilli()));
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    @Override
    public Integer weekOfMonth() {
        var c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone(cal.getZone()));
        c.setTime(new Date(cal.toInstant().toEpochMilli()));
        return c.get(Calendar.WEEK_OF_MONTH);
    }

    @Override
    public Integer dayOfYear() {
        return cal.getDayOfYear();
    }

    @Override
    public Integer hour() {
        return cal.getHour();
    }

    @Override
    public Integer min() {
        return cal.getMinute();
    }

    @Override
    public Integer second() {
        return cal.getSecond();
    }

    @Override
    public Integer ms() {
        return Math.toIntExact(Duration.ofNanos(cal.getNano()).toMillis());
    }

    @Override
    public Weekday weekday() {
        if(cal.getDayOfWeek().ordinal() == 6){
            return Weekday.Sunday;
        } else {
            return Weekday.values()[cal.getDayOfWeek().ordinal()+1];
        }
//        return Weekday.values()[cal.getDayOfWeek() - 1];
    }


    @Override
    public DatetimeBuilder asBuilder() {
//        return DatetimeFactory.instance().from(cal.getTime());
        return DatetimeFactory.instance().from(cal);
    }

    public Date asDate() {
        return new Date(cal.toInstant().toEpochMilli());
    }

    public Calendar asCalendar() {
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date(cal.toInstant().toEpochMilli()));
        calendar.setTimeZone(TimeZone.getTimeZone(cal.getZone()));
        return calendar;
    }

    public Long asLong() {
        return asDate().getTime();
    }

    public String asNumberDatetime() {
        return DateFormatBuilderFactory.NUMBER_DATETIME().format(asDate());
    }

    public String asNumberDate() {
        return DateFormatBuilderFactory.NUMBER_DATE().format(asDate());
    }

    public String asSimpleDateTime() {
        return DateFormatBuilderFactory.SIMPLE_DATETIME().format(asDate());
    }

    public String asSimpleDate() {
        return DateFormatBuilderFactory.SIMPLE_DATE().format(asDate());
    }

    public String asISO8601() {
        return DateFormatBuilderFactory.ISO8601().format(asDate());
    }

    public String asFormat(DateFormatBuilderInterface builder) {
        return asFormat(builder.build());
    }

    public String asFormat(SimpleDateFormat fmt) {
        return fmt.format(asDate());
    }
}

