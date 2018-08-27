package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface DateBuilder<T extends DateBuilder<T>> {

    public T y(int year);
    public T ym(int year, Month month);
    public T ymd(int year, Month month, int day);
    public T hmsms(int hour, int minute, int second, int mSecond);
    public T hms(int hour, int minute, int second);
    public T hm(int hour, int minute);
    public T h(int hour);

    /*
    Year part
     */
    public T minYear();
    public T year(final int year);

    /*
    Month part
     */
    public T minMonth();

    /**
     * Set the month
     * @param month should be normally 1,2,...12 where 1=JAN, 2=FEB....
     * @return
     */
    public T month(final Month month);


    /*
    Day part
     */
    public T minDay();
    public T day(final int date);
    public T firstDayOfMonth();
    public T endDayOfMonth();


    /*
    Hour part
     */
    public T minHour();
    public T maxHour();
    public T hour(final int hour);

    /*
    Minute part
     */
    public T minMinute();
    public T maxMinute();
    public T minute(final int min);

    /*
    Second part
     */
    public T minSecond();
    public T maxSecond();
    public T second(final int second);

    /*
    Millisecond
     */
    public T minMs();
    public T maxMs();
    public T ms(final int ms);

    public T timeZone(final BaseTimeZone timeZone);

    /*
    Time manipulation
     */
    public T maxDayTime();
    public T minDayTime();
    public T timePartOnly();

    public Date asDate();
    public Calendar asCalendar();
    public Long asLong();
    public List<Build> getBuilds();

    public DateInfo view();

    public DatetimeRange rangeTo(T date);

    public DatetimeRange rangeFrom(T date);

    public DatetimeRange rangeTo(Date date);

    public DatetimeRange rangeFrom(Date date);

    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end);

    //Time operation
    /*
    Operation
     */
    public T addYear(final int years);
    public T lastYear();
    public T nextYear();
    public T lastMonth();
    public T nextMonth();
    public T addMonths(final int months);

    public T addDays(final int days);
    public T yesterday();
    public T tomorrow();

    public T nextWeekday(Weekday day);

    public T prevWeekday(Weekday day);

    public T startOfWeek(Weekday startDay);

    public T endOfWeek(Weekday startDay);
    public T addTime(final long time);

    public T addHours(final int hours);

    public T addMins(final int mins);

    public T addSecond(final int sec);

    public T addMS(final int ms);

    //Compare operation
    public boolean sameDatetime(T builder);
    public boolean sameDatetime(Long longDate);
    public boolean sameDatetime(Date date);
    public boolean sameDatetime(Calendar cal);

    public boolean sameYear(T builder);
    public boolean sameYear(Long longDate);
    public boolean sameYear(Date date);
    public boolean sameYear(Calendar cal);

    public boolean sameMonth(T builder);
    public boolean sameMonth(Long longDate);

    public boolean sameMonth(Date date);
    public boolean sameMonth(Calendar cal);

    public boolean sameDay(T builder);
    public boolean sameDay(Long longDate);
    public boolean sameDay(Date date);
    public boolean sameDay(Calendar cal);

    public boolean sameTime(T dateBuilder);
    public boolean sameTime(Long dateLong);
    public boolean sameTime(Date date);
    public boolean sameTime(Calendar calendar);

    public boolean sameHMS(T dateBuilder);
    public boolean sameHMS(Long dateLong);
    public boolean sameHMS(Date date);
    public boolean sameHMS(Calendar calendar);

    public boolean sameHM(T dateBuilder);
    public boolean sameHM(Long dateLong);
    public boolean sameHM(Date date);
    public boolean sameHM(Calendar calendar);

    public boolean laterThan(T dateBuilder);
    public boolean laterThan(Date date);
    public boolean laterThan(Long longDate);
    public boolean laterThan(Calendar calendar);

    public boolean laterEqualThan(T dateBuilder);
    public boolean laterEqualThan(Date date);
    public boolean laterEqualThan(Long longDate);
    public boolean laterEqualThan(Calendar calendar);

    public boolean before(T dateBuilder);
    public boolean before(Date date);
    public boolean before(Long longDate);
    public boolean before(Calendar calendar);

    public boolean beforeEqual(T dateBuilder);
    public boolean beforeEqual(Date date);
    public boolean beforeEqual(Long longDate);
    public boolean beforeEqual(Calendar calendar);

    TimeUnit diffFrom(Date date);
    TimeUnit diffTo(Date date);
    TimeUnit diffFrom(DateBuilder date);
    TimeUnit diffTo(DateBuilder date);
    TimeUnit diffFrom(long date);
    TimeUnit diffTo(long date);
    TimeUnit diffFrom(Calendar date);
    TimeUnit diffTo(Calendar date);
}
