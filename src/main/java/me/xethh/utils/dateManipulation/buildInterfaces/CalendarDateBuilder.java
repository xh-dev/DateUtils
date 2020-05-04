package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public interface CalendarDateBuilder<T extends CalendarDateBuilder<T>> {
    /**
     * alias of year(final int year)
     *
     * @param year
     * @return
     */
    T y(int year);

    /**
     * alias of month(final Month month)
     *
     * @param month
     * @return
     */
    T m(Month month);

    /**
     * combine of setting year and month
     *
     * @param year
     * @param month
     * @return
     */
    T ym(int year, Month month);

    /**
     * alias of month(Month month)
     *
     * @param month
     * @param day
     * @return
     */
    T md(Month month, int day);

    /**
     * combine of setting year, month and day
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    T ymd(int year, Month month, int day);

    /**
     * Alias of day(int day)
     * @param day
     * @return
     */
    T d(int day);

    /*
    Year part
     */

    /**
     * set year to be minimum of year in computing - 1970
     *
     * @return
     */
    T minYear();

    /**
     * Set up year
     *
     * @param year
     * @return
     */
    T year(final int year);

    /*
    Month part
     */

    /**
     * set minimum month - January
     *
     * @return
     */
    T minMonth();

    /**
     * Set the month
     *
     * @param month should be enum of Month
     * @return DatetimeBuilder Object
     */
    T month(final Month month);

    /**
     * Maximum month - December
     *
     * @return
     */
    T maxMonth();


    /*
    Day part
     */

    /**
     * Set day to minimum day - 1
     *
     * @return
     */
    T minDay();

    /**
     * Set day
     *
     * @param date
     * @return
     */
    T day(final int date);

    /**
     * set the day to be first day of the month,
     * depends on current year and month
     * @return
     */
    T firstDayOfMonth();

    /**
     * Return the last day of the current month,
     * the method return depends on the year and month
     *
     * @return
     */
    T endDayOfMonth();

    //Time operation
    /*
    Operation
     */

    /**
     * Add number of years to current datebuilder
     * @param years
     * @return
     */
    T addYear(final int years);

    /**
     * Switch the datebuilder to the last year
     * @return
     */
    T lastYear();

    /**
     * Swtich the datebuilder to the next year
     * @return
     */
    T nextYear();

    /**
     * Switch the datebuilder to the last month
     * @return
     */
    T lastMonth();

    /**
     * Switch the datebuuilder to the next month
     * @return
     */
    T nextMonth();

    /**
     * Add number of month to current datebuilder
     * @param months
     * @return
     */
    T addMonths(final int months);

    /**
     * Days after specific date time, inclusive
     * e.g. 40 days after 01th Jan 2020, should 10th Feb 2020, instead of 11th Feb 2020
     *
     * @param days
     * @return
     */
    T addDays(final int days);

    /**
     * Switch the datebuilder to yesterday
     * @return
     */
    T yesterday();

    /**
     * Switch the datebuilder to tomorrow
     * @return
     */
    T tomorrow();

    /**
     * Switch to the next weekday
     * @param startDay start of week day
     * @return
     */
    T nextWeekday(Weekday startDay);

    /**
     * Switch to the previous weekday
     * @param startDay start of week day
     * @return
     */
    T prevWeekday(Weekday startDay);

    /**
     * Switch to start of week
     * @param startDay start of week day
     * @return
     */
    T startOfWeek(Weekday startDay);

    /**
     * Switch to end of week
     * @param startDay start of week day
     * @return
     */
    T endOfWeek(Weekday startDay);

    /**
     * check if date input is the same year of datebuilder
     * @param longDate
     * @return
     */
    boolean sameYear(Long longDate);

    /**
     * check if date input is the same year of datebuilder
     * @param date
     * @return
     */
    boolean sameYear(Date date);

    /**
     * check if date input the same year of datebuilder
     * @param cal
     * @return
     */
    boolean sameYear(Calendar cal);

    /**
     * check if date input the same month of datebuilder
     * @param longDate
     * @return
     */
    boolean sameMonth(Long longDate);

    /**
     * check if date input the same month of datebuilder
     * @param date
     * @return
     */
    boolean sameMonth(Date date);

    /**
     * check if date input the same month of datebuilder
     * @param cal
     * @return
     */
    boolean sameMonth(Calendar cal);

    /**
     * check if date input the same day of datebuilder
     * @param longDate
     * @return
     */
    boolean sameDay(Long longDate);

    /**
     * check if date input the same day of datebuilder
     * @param date
     * @return
     */
    boolean sameDay(Date date);

    /**
     * check if date input the same day of datebuilder
     * @param cal
     * @return
     */
    boolean sameDay(Calendar cal);

    /**
     * check if date input the same date(ymd) of the datebuilder
     * @param longDate
     * @return
     */
    boolean sameDate(Long longDate);

    /**
     * check if date input the same date(ymd) of the datebuilder
     * @param date
     * @return
     */
    boolean sameDate(Date date);

    /**
     * check if date input the same date(ymd) of the datebuilder
     * @param cal
     * @return
     */
    boolean sameDate(Calendar cal);

    /**
     * check if the date input is earlier than datebuilder
     * @param date
     * @return
     */
    boolean laterThan(Date date);

    /**
     * check if the date input is earlier than datebuilder
     * @param longDate
     * @return
     */
    boolean laterThan(Long longDate);

    /**
     * check if the date input is earlier than datebuilder
     * @param calendar
     * @return
     */
    boolean laterThan(Calendar calendar);

    /**
     * check if the date input is earlier or equal to the datebuilder
     * @param date
     * @return
     */
    boolean laterEqualThan(Date date);

    /**
     * check if the date input is earlier or equal to the datebuilder
     * @param longDate
     * @return
     */
    boolean laterEqualThan(Long longDate);

    /**
     * check if the date input is earlier or equal to the datebuilder
     * @param calendar
     * @return
     */
    boolean laterEqualThan(Calendar calendar);

    /**
     * check if the date input is later than the datebuilder
     * @param date
     * @return
     */
    boolean before(Date date);

    /**
     * check if the date input is later than the datebuilder
     * @param longDate
     * @return
     */
    boolean before(Long longDate);

    /**
     * check if the date input is later than the datebuilder
     * @param calendar
     * @return
     */
    boolean before(Calendar calendar);

    /**
     * check if the date input is later or equal to the datebuilder
     * @param date
     * @return
     */
    boolean beforeEqual(Date date);

    /**
     * check if the date input is later or equal to the datebuilder
     * @param longDate
     * @return
     */
    boolean beforeEqual(Long longDate);

    /**
     * check if the date input is later or equal to the datebuilder
     * @param calendar
     * @return
     */
    boolean beforeEqual(Calendar calendar);

    TimeZone getTimeZone();
}
