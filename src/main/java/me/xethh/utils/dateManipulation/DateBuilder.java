package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public interface DateBuilder<T extends DateBuilder<T>>
        extends CalendarDateBuilder<T>, CalendarTimeBuilder<T>, CommonDateRepresentation, TImeUnitConverter
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

    T timeZone(final BaseTimeZone timeZone);

    T timePartOnly();

    T now();


    DateInfo view();

    DatetimeRange rangeTo(DateBuilder date);

    DatetimeRange rangeFrom(DateBuilder date);

    DatetimeRange rangeTo(Date date);
    DatetimeRange rangeTo(Long dateLong);
    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);
    DatetimeRange rangeFrom(Long dateLong);
    DatetimeRange rangeFrom(Calendar cal);

    DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end);

    T addTime(final long time);

    T addHours(final int hours);

    T addMins(final int mins);

    T addSecond(final int sec);

    T addMS(final int ms);

    //Compare operation
    boolean sameDatetime(DateBuilder builder);
    boolean sameDatetime(Long longDate);
    boolean sameDatetime(Date date);
    boolean sameDatetime(Calendar cal);

    boolean sameYear(DateBuilder builder);
    boolean sameMonth(DateBuilder builder);
    boolean sameDay(DateBuilder builder);
    boolean sameTime(DateBuilder dateBuilder);
    boolean sameHMS(DateBuilder dateBuilder);
    boolean sameHM(DateBuilder dateBuilder);


    boolean laterThan(DateBuilder dateBuilder);
    boolean laterEqualThan(DateBuilder dateBuilder);
    boolean before(DateBuilder dateBuilder);
    boolean beforeEqual(DateBuilder dateBuilder);

    TimeUnit diffFrom(DateBuilder date);
    TimeUnit diffTo(DateBuilder date);

    String format(String format);
    String format(DateFormatBuilder.Format format);
    String format(DateFormatBuilder fmtBuilder);
    String format(SimpleDateFormat fmt);
    FormatBuilderWrapper format();

    String format(TimeZone timeZone, String format);
    String format(TimeZone timeZone, DateFormatBuilder.Format format);
    String format(TimeZone timeZone, SimpleDateFormat fmt);
}
