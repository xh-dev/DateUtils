package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;

import java.util.Calendar;
import java.util.Date;

public interface CalendarDateBuilder <T extends CalendarDateBuilder<T>>{
    T y(int year);
    T ym(int year, Month month);
    T md(Month month, int day);
    T ymd(int year, Month month, int day);

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
     * @param month should be enum of Month
     * @return DatetimeBuilder Object
     */
    T month(final Month month);


    /*
    Day part
     */
    T minDay();
    T day(final int date);
    T firstDayOfMonth();
    T endDayOfMonth();

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

    boolean sameYear(Long longDate);
    boolean sameYear(Date date);
    boolean sameYear(Calendar cal);

    boolean sameMonth(Long longDate);
    boolean sameMonth(Date date);
    boolean sameMonth(Calendar cal);

    boolean sameDay(Long longDate);
    boolean sameDay(Date date);
    boolean sameDay(Calendar cal);

    boolean laterThan(Date date);
    boolean laterThan(Long longDate);
    boolean laterThan(Calendar calendar);
    boolean laterEqualThan(Date date);
    boolean laterEqualThan(Long longDate);
    boolean laterEqualThan(Calendar calendar);
    boolean before(Date date);
    boolean before(Long longDate);
    boolean before(Calendar calendar);
    boolean beforeEqual(Date date);
    boolean beforeEqual(Long longDate);
    boolean beforeEqual(Calendar calendar);
}
