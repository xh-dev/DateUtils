package me.xethh.utils.dateManipulation.datetime;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.buildInterfaces.*;
import me.xethh.utils.dateManipulation.dataInfo.DateInfo;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public interface DatetimeBuilder<T extends DatetimeBuilder<T>>
        extends
        CalendarDateBuilder<T>, CalendarTimeBuilder<T>,
        CommonDateRepresentation,
        TimeUnitConverter,
        FormatterBuilder
{
    @Override
    T y(int year);

    @Override
    T ym(int year, Month month);

    @Override
    T md(Month month, int day);

    @Override
    T ymd(int year, Month month, int day);

    @Override
    T minYear();

    @Override
    T year(final int year);

    @Override
    T minMonth();

    @Override
    T month(final Month month);

    @Override
    T minDay();

    @Override
    T day(final int date);

    @Override
    T firstDayOfMonth();

    @Override
    T endDayOfMonth();

    @Override
    T addYear(final int years);

    @Override
    T lastYear();

    @Override
    T nextYear();

    @Override
    T lastMonth();

    @Override
    T nextMonth();

    @Override
    T addMonths(final int months);

    @Override
    T addDays(final int days);

    @Override
    T yesterday();

    @Override
    T tomorrow();

    @Override
    T nextWeekday(Weekday day);

    @Override
    T prevWeekday(Weekday day);

    @Override
    T startOfWeek(Weekday startDay);

    @Override
    T endOfWeek(Weekday startDay);

    @Override
    T hmsms(int hour, int minute, int second, int mSecond);

    @Override
    T hms(int hour, int minute, int second);

    @Override
    T hm(int hour, int minute);

    @Override
    T h(int hour);

    @Override
    T minHour();

    @Override
    T maxHour();

    @Override
    T hour(final int hour);

    @Override
    T minMinute();

    @Override
    T maxMinute();

    @Override
    T minute(final int min);

    @Override
    T minSecond();

    @Override
    T maxSecond();

    @Override
    T second(final int second);

    @Override
    T minMs();

    @Override
    T maxMs();

    @Override
    T ms(final int ms);

    @Override
    T maxDayTime();

    @Override
    T maxDayTimeSec();

    @Override
    T maxDayTimeMin();

    @Override
    T minDayTime();
    T now();


    DateInfo view();

    DatetimeRange rangeTo(DatetimeBuilder date);

    DatetimeRange rangeFrom(DatetimeBuilder date);

    DatetimeRange rangeTo(Date date);
    DatetimeRange rangeTo(Long dateLong);
    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);
    DatetimeRange rangeFrom(Long dateLong);
    DatetimeRange rangeFrom(Calendar cal);

    //Compare operation
    boolean sameDate(DatetimeBuilder builder);
    boolean sameDate(Long longDate);
    boolean sameDate(Date date);
    boolean sameDate(Calendar cal);

    boolean sameDatetime(DatetimeBuilder builder);
    @Override
    boolean sameDatetime(Long longDate);
    @Override
    boolean sameDatetime(Date date);
    @Override
    boolean sameDatetime(Calendar cal);

    boolean sameYear(DatetimeBuilder builder);
    boolean sameMonth(DatetimeBuilder builder);
    boolean sameDay(DatetimeBuilder builder);
    boolean sameTime(DatetimeBuilder datetimeBuilder);
    boolean sameHMS(DatetimeBuilder datetimeBuilder);
    boolean sameHM(DatetimeBuilder datetimeBuilder);


    boolean laterThan(DatetimeBuilder datetimeBuilder);
    boolean laterEqualThan(DatetimeBuilder datetimeBuilder);
    boolean before(DatetimeBuilder datetimeBuilder);
    boolean beforeEqual(DatetimeBuilder datetimeBuilder);

    TimeUnit diffFrom(DatetimeBuilder date);
    TimeUnit diffTo(DatetimeBuilder date);

    @Override
    T addTime(final long time);

    @Override
    T addHours(final int hours);

    @Override
    T addMins(final int mins);

    @Override
    T addSecond(final int sec);

    @Override
    T addMS(final int ms);

    @Override
    T timeZone(final BaseTimeZone timeZone);

    @Override
    T timeZone(final TimeZone timeZone);

    @Override
    T swapTimeZone(final BaseTimeZone timeZone);

    @Override
    T swapTimeZone(final TimeZone timeZone);

    @Override
    T timePartOnly();

    DateBuilder asDateBuilder();
}
