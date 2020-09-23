package me.xethh.utils.dateUtils.baseInterface;

import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Interface provide operations to date fields
 * e.g. year, month and date
 *
 * @param <T> generic type T which is subclass of CalendarDateBuilder itself
 */
public interface CalendarDateBuilder<T extends CalendarDateBuilder<T>> extends DateViewable {
    /**
     * Return the date of current time
     *
     * @return current time builder
     */
    T now();

    /**
     * alias of year(final int year)
     *
     * @param year year
     * @return builder of year updated
     */
    T y(int year);

    /**
     * alias of month(final Month month)
     *
     * @param month month
     * @return builder of month updated
     */
    T m(Month month);

    /**
     * combine of setting year and month
     *
     * @param year  year
     * @param month month
     * @return builder of year and month updated
     */
    T ym(int year, Month month);

    /**
     * alias of month(Month month)
     *
     * @param month month
     * @param day   day
     * @return builder of month and day updated
     */
    T md(Month month, int day);

    /**
     * combine of setting year, month and day
     *
     * @param year  year
     * @param month month
     * @param day   day
     * @return builder of year, month and day updated
     */
    T ymd(int year, Month month, int day);

    /**
     * Alias of day(int day)
     *
     * @param day day
     * @return builder of day updated
     */
    T d(int day);

    /*
    Year part
     */

    /**
     * set year to be minimum of year in computing - 1970
     *
     * @return builder of year updated to 1970
     */
    T minYear();

    /**
     * Set up year
     *
     * @param year year
     * @return builder of year updated
     */
    T year(final int year);

    /*
    Month part
     */

    /**
     * set minimum month - January
     *
     * @return builder of month updated to Month.JAN
     */
    T minMonth();

    /**
     * Set the month
     *
     * @param month should be enum of Month
     * @return builder of month updated
     */
    T month(final Month month);

    /**
     * Maximum month - December
     *
     * @return builder of month updated to Month.DEC
     */
    T maxMonth();


    /*
    Day part
     */

    /**
     * Set day to minimum day - 1
     *
     * @return builder of day updated to first day of month
     */
    T minDay();

    /**
     * Set day
     *
     * @param date date
     * @return builder of day updated to the last day of current month and year
     */
    T day(final int date);

    /**
     * Return the last day of the current month,
     * the method return depends on the year and month
     *
     * @return builder of last day of the current month and year
     */
    T maxDay();

    /**
     * set the day to be first day of the month,
     * depends on current year and month
     * alias of {@link #minDay()}
     *
     * @return builder of first day of month
     */
    T firstDayOfMonth();

    /**
     * Return the last day of the current month,
     * the method return depends on the year and month
     * alias of {@link #maxDay()}
     *
     * @return builder of last day of the current month and year
     */
    T endDayOfMonth();

    //Time operation
    /*
    Operation
     */

    /**
     * Add number of years to current datebuilder
     *
     * @param years year(s)
     * @return builder after add year
     */
    T addYear(final int years);

    /**
     * Switch the datebuilder to the last year
     *
     * @return builder of previous year
     */
    T lastYear();

    /**
     * Swtich the datebuilder to the next year
     *
     * @return builder of coming year
     */
    T nextYear();

    /**
     * Switch the datebuilder to the last month
     *
     * @return builder of previous month
     */
    T lastMonth();

    /**
     * Switch the datebuuilder to the next month
     *
     * @return builder of coming month
     */
    T nextMonth();

    /**
     * Add number of month to current datebuilder
     *
     * @param months month(s)
     * @return builder after adding month
     */
    T addMonths(final int months);

    /**
     * Days after specific date time, inclusive
     * e.g. 40 days after 01th Jan 2020, should 10th Feb 2020, instead of 11th Feb 2020
     *
     * @param days day(s)
     * @return builder after adding day
     */
    T addDays(final int days);

    /**
     * Switch the datebuilder to yesterday
     *
     * @return builder of previous day
     */
    T yesterday();

    /**
     * Switch the datebuilder to tomorrow
     *
     * @return builder of the coming day
     */
    T tomorrow();

    /**
     * Switch to the next weekday
     *
     * @param startDay start of week day
     * @return builder of the coming same week day
     */
    T nextWeekday(Weekday startDay);

    /**
     * Switch to the previous weekday
     *
     * @param startDay start of week day
     * @return builder of the previous same week day
     */
    T prevWeekday(Weekday startDay);

    /**
     * Switch to start of week
     *
     * @param startDay start of week day
     * @return builder of the start day of week
     */
    T startOfWeek(Weekday startDay);

    /**
     * Switch to end of week
     *
     * @param startDay start of week day
     * @return builder of the end day of week
     */
    T endOfWeek(Weekday startDay);

    /**
     * check if date input is the same year of datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the same year of current builder
     */
    boolean sameYear(Long longDate);

    /**
     * check if date input is the same year of datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the same year of current builder
     */
    boolean sameYear(Date date);

    /**
     * check if date input the same year of datebuilder
     *
     * @param cal date in calendar form
     * @return result of input date(Calendar form) the same year of current builder
     */
    boolean sameYear(Calendar cal);

    /**
     * check if date input the same month of datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the same month of current builder
     */
    boolean sameMonth(Long longDate);

    /**
     * check if date input the same month of datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the same month of current builder
     */
    boolean sameMonth(Date date);

    /**
     * check if date input the same month of datebuilder
     *
     * @param cal date in calendar form
     * @return result of input date(calendar form) the same month of current builder
     */
    boolean sameMonth(Calendar cal);

    /**
     * check if date input the same day of datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the same day of current builder
     */
    boolean sameDay(Long longDate);

    /**
     * check if date input the same day of datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the same day of current builder
     */
    boolean sameDay(Date date);

    /**
     * check if date input the same day of datebuilder
     *
     * @param cal date in calendar form
     * @return result of input date(calendar form) the same day of current builder
     */
    boolean sameDay(Calendar cal);

    /**
     * check if date input the same date(ymd) of the datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the same date of current builder
     */
    boolean sameDate(Long longDate);

    /**
     * check if date input the same date(ymd) of the datebuilder
     *
     * @param date date in date form
     * @return boolean result
     */
    boolean sameDate(Date date);

    /**
     * check if date input the same date(ymd) of the datebuilder
     *
     * @param cal date in calendar form
     * @return result of input date(calendar form) the same date of current builder
     */
    boolean sameDate(Calendar cal);

    /**
     * check if the date input is earlier than datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the same date of current builder
     */
    boolean laterThan(Date date);

    /**
     * check if the date input is earlier than datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the later than date of current builder
     */
    boolean laterThan(Long longDate);

    /**
     * check if the date input is earlier than datebuilder
     *
     * @param calendar date in calendar form
     * @return result of input date(calendar form) the later than date of current builder
     */
    boolean laterThan(Calendar calendar);

    /**
     * check if the date input is earlier or equal to the datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the later or equals than date of current builder
     */
    boolean laterEqualThan(Date date);

    /**
     * check if the date input is earlier or equal to the datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the later or equals than date of current builder
     */
    boolean laterEqualThan(Long longDate);

    /**
     * check if the date input is earlier or equal to the datebuilder
     *
     * @param calendar date in calendar form
     * @return result of input date(calendar form) the later or equals than date of current builder
     */
    boolean laterEqualThan(Calendar calendar);

    /**
     * check if the date input is later than the datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the before date of current builder
     */
    boolean before(Date date);

    /**
     * check if the date input is later than the datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the before date of current builder
     */
    boolean before(Long longDate);

    /**
     * check if the date input is later than the datebuilder
     *
     * @param calendar date in calendar form
     * @return result of input date(calendar form) the before date of current builder
     */
    boolean before(Calendar calendar);

    /**
     * check if the date input is later or equal to the datebuilder
     *
     * @param date date in date form
     * @return result of input date(date form) the before or equals date of current builder
     */
    boolean beforeEqual(Date date);

    /**
     * check if the date input is later or equal to the datebuilder
     *
     * @param longDate date in long form
     * @return result of input date(long form) the before or equals date of current builder
     */
    boolean beforeEqual(Long longDate);

    /**
     * check if the date input is later or equal to the datebuilder
     *
     * @param calendar date in calendar form
     * @return result of input date(calendar form) the before or equals date of current builder
     */
    boolean beforeEqual(Calendar calendar);

    /**
     * Get time zone applied to this builder
     *
     * @return time zone object
     */
    TimeZone getTimeZone();
}
