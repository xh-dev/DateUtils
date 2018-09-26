package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface DateBuilder<T extends DateBuilder<T>> {

    T y(int year);
    T ym(int year, Month month);
    T ymd(int year, Month month, int day);
    T hmsms(int hour, int minute, int second, int mSecond);
    T hms(int hour, int minute, int second);
    T hm(int hour, int minute);
    T h(int hour);

    /*
    Year part
     */
    T minYear();
    T year(final int year);

    /*
    Month part
     */
    T minMonth();

    /**
     * Set the month
     * @param month should be normally 1,2,...12 where 1=JAN, 2=FEB....
     * @return
     */
    T month(final Month month);


    /*
    Day part
     */
    T minDay();
    T day(final int date);
    T firstDayOfMonth();
    T endDayOfMonth();


    /*
    Hour part
     */
    T minHour();
    T maxHour();
    T hour(final int hour);

    /*
    Minute part
     */
    T minMinute();
    T maxMinute();
    T minute(final int min);

    /*
    Second part
     */
    T minSecond();
    T maxSecond();
    T second(final int second);

    /*
    Millisecond
     */
    T minMs();
    T maxMs();
    T ms(final int ms);

    T timeZone(final BaseTimeZone timeZone);

    /*
    Time manipulation
     */
    T maxDayTime();
    T minDayTime();
    T timePartOnly();

    Date asDate();
    Calendar asCalendar();
    Long asLong();
    List<Build> getBuilds();

    DateInfo view();

    DatetimeRange rangeTo(T date);

    DatetimeRange rangeFrom(T date);

    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeFrom(Date date);

    DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end);

    //Time operation
    /*
    Operation
     */
    T addYear(final int years);
    T lastYear();
    T nextYear();
    T lastMonth();
    T nextMonth();
    T addMonths(final int months);

    T addDays(final int days);
    T yesterday();
    T tomorrow();

    T nextWeekday(Weekday day);

    T prevWeekday(Weekday day);

    T startOfWeek(Weekday startDay);

    T endOfWeek(Weekday startDay);
    T addTime(final long time);

    T addHours(final int hours);

    T addMins(final int mins);

    T addSecond(final int sec);

    T addMS(final int ms);

    //Compare operation
    boolean sameDatetime(T builder);
    boolean sameDatetime(Long longDate);
    boolean sameDatetime(Date date);
    boolean sameDatetime(Calendar cal);

    boolean sameYear(T builder);
    boolean sameYear(Long longDate);
    boolean sameYear(Date date);
    boolean sameYear(Calendar cal);

    boolean sameMonth(T builder);
    boolean sameMonth(Long longDate);

    boolean sameMonth(Date date);
    boolean sameMonth(Calendar cal);

    boolean sameDay(T builder);
    boolean sameDay(Long longDate);
    boolean sameDay(Date date);
    boolean sameDay(Calendar cal);

    boolean sameTime(T dateBuilder);
    boolean sameTime(Long dateLong);
    boolean sameTime(Date date);
    boolean sameTime(Calendar calendar);

    boolean sameHMS(T dateBuilder);
    boolean sameHMS(Long dateLong);
    boolean sameHMS(Date date);
    boolean sameHMS(Calendar calendar);

    boolean sameHM(T dateBuilder);
    boolean sameHM(Long dateLong);
    boolean sameHM(Date date);
    boolean sameHM(Calendar calendar);

    boolean laterThan(T dateBuilder);
    boolean laterThan(Date date);
    boolean laterThan(Long longDate);
    boolean laterThan(Calendar calendar);

    boolean laterEqualThan(T dateBuilder);
    boolean laterEqualThan(Date date);
    boolean laterEqualThan(Long longDate);
    boolean laterEqualThan(Calendar calendar);

    boolean before(T dateBuilder);
    boolean before(Date date);
    boolean before(Long longDate);
    boolean before(Calendar calendar);

    boolean beforeEqual(T dateBuilder);
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
}
