package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public interface DateBuilder<T extends DateBuilder<T>>
        extends CalendarDateBuilder<T>, CalendarTimeBuilder<T>
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

    Date asDate();
    Calendar asCalendar();
    Long asLong();
    java.sql.Date asSqlDate();
    java.sql.Time asSqlTime();
    java.sql.Timestamp asSqlTimestamp();

    DateInfo view();

    DatetimeRange rangeTo(T date);

    DatetimeRange rangeFrom(T date);

    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeFrom(Date date);

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
    boolean sameYear(Long longDate);
    boolean sameYear(Date date);
    boolean sameYear(Calendar cal);

    boolean sameMonth(DateBuilder builder);
    boolean sameMonth(Long longDate);

    boolean sameMonth(Date date);
    boolean sameMonth(Calendar cal);

    boolean sameDay(DateBuilder builder);
    boolean sameDay(Long longDate);
    boolean sameDay(Date date);
    boolean sameDay(Calendar cal);

    boolean sameTime(DateBuilder dateBuilder);
    boolean sameTime(Long dateLong);
    boolean sameTime(Date date);
    boolean sameTime(Calendar calendar);

    boolean sameHMS(DateBuilder dateBuilder);
    boolean sameHMS(Long dateLong);
    boolean sameHMS(Date date);
    boolean sameHMS(Calendar calendar);

    boolean sameHM(DateBuilder dateBuilder);
    boolean sameHM(Long dateLong);
    boolean sameHM(Date date);
    boolean sameHM(Calendar calendar);

    boolean laterThan(DateBuilder dateBuilder);
    boolean laterThan(Date date);
    boolean laterThan(Long longDate);
    boolean laterThan(Calendar calendar);

    boolean laterEqualThan(DateBuilder dateBuilder);
    boolean laterEqualThan(Date date);
    boolean laterEqualThan(Long longDate);
    boolean laterEqualThan(Calendar calendar);

    boolean before(DateBuilder dateBuilder);
    boolean before(Date date);
    boolean before(Long longDate);
    boolean before(Calendar calendar);

    boolean beforeEqual(DateBuilder dateBuilder);
    boolean beforeEqual(Date date);
    boolean beforeEqual(Long longDate);
    boolean beforeEqual(Calendar calendar);

    TimeUnit diffFrom(Date date);
    TimeUnit diffTo(Date date);
    TimeUnit diffFrom(DateBuilder date);
    TimeUnit diffTo(DateBuilder date);
    TimeUnit diffFrom(long date);
    TimeUnit diffTo(long date);
    TimeUnit diffFrom(Calendar date);
    TimeUnit diffTo(Calendar date);

    String format(String format);
    String format(DateFormatBuilder.Format format);
    String format(SimpleDateFormat fmt);
    String format(DateFormatBuilder fmtBuilder);
    FormatBuilderWrapper format();

    String format(TimeZone timeZone, String format);
    String format(TimeZone timeZone, DateFormatBuilder.Format format);
    String format(TimeZone timeZone, SimpleDateFormat fmt);
}
