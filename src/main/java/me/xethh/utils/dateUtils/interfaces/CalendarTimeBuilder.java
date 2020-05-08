package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Interface provide operation to time fields
 * e.g. hour, minute, second and millisecond
 * @param <T>
 */
public interface CalendarTimeBuilder<T extends CalendarTimeBuilder<T>> {
    /**
     * Return the datetime of current datetime
     * @return builder of current datetime
     */
    T now();

    /**
     * Set hour, minute, second and millisecond
     *
     * @param hour hour(s)
     * @param minute minute(s)
     * @param second second(s)
     * @param mSecond millisecond(s)
     * @return builder of updated hour, minute, second and millisecond
     */
    T hmsms(int hour, int minute, int second, int mSecond);

    /**
     * Set hour, minute, second and minimize millisecond
     *
     * @param hour hour(s)
     * @param minute minute(s)
     * @param second second(s)
     * @return builder of updated hour, minute and second
     */
    T hms(int hour, int minute, int second);

    /**
     * Set hour, minute and minimize second and millisecond
     *
     * @param hour hour(s)
     * @param minute minute(s)
     * @return builder of updated hour and minute
     */
    T hm(int hour, int minute);

    /**
     * Set hour and minimize minute, second, millisecond
     *
     * @param hour hour(s)
     * @return builder of updated hour
     */
    T h(int hour);


    /*
    Hour part
     */

    /**
     * Minimize hour - 0
     *
     * @return builder of hour set to 0
     */
    T minHour();

    /**
     * Maximize hour - 23
     *
     * @return builder of hour set to 23
     */
    T maxHour();

    /**
     * Set hour
     *
     * @param hour hour
     * @return builder of hour set
     */
    T hour(final int hour);

    /*
    Minute part
     */

    /**
     * Minimize minute - 0
     *
     * @return builder of minute set to 0
     */
    T minMinute();

    /**
     * Maximize minute - 59
     *
     * @return builder of minute set to 59
     */
    T maxMinute();

    /**
     * Set minute
     *
     * @param min minute(s)
     * @return builder of minute set
     */
    T minute(final int min);

    /*
    Second part
     */

    /**
     * Minimize second
     *
     * @return builder of second set to 0
     */
    T minSecond();

    /**
     * Maximize second - 59
     *
     * @return  builder of second set 59
     */
    T maxSecond();

    /**
     * Set second
     *
     * @param second second(s)
     * @return builder of second set
     */
    T second(final int second);

    /*
    Millisecond
     */

    /**
     * Minimize millisecond - 0
     *
     * @return builder of millisecond to 0
     */
    T minMs();

    /**
     * Maximize millisecond - 999
     *
     * @return builder of millisecond to 999
     */
    T maxMs();

    /**
     * Set millisecond
     *
     * @param ms millisecond
     * @return builder of millisecond set
     */
    T ms(final int ms);

    /*
    Time manipulation
     */

    /**
     * Cast the date builder object to maximum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.999
     *
     * @return maximum date time value up to millisecond
     */
    T maxDayTime();

    /**
     * Cast the date builder object to maximum day time of the day up to second
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.000
     *
     * @return maximum date time value up to second
     */
    T maxDayTimeSec();

    /**
     * Cast the date builder object to maximum day time of the day up to minutes
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:00.000
     *
     * @return maximum date time value up to minutes
     */
    T maxDayTimeMin();

    /**
     * Cast the date builder object to minimum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 00:00:00.000
     *
     * @return minimum date time value up to millisecond
     */
    T minDayTime();

    /**
     * return whether builder and input date are the same
     * @param longDate date in long form
     * @return boolean
     */
    boolean sameDatetime(Long longDate);

    /**
     * return whether builder and input date are the same
     * @param date date in date form
     * @return boolean
     */
    boolean sameDatetime(Date date);

    /**
     * return whether builder and input date are the same
     * @param cal date in calendar form
     * @return boolean
     */
    boolean sameDatetime(Calendar cal);

    /**
     * return whether builder and input date are the same in time part
     * @param dateLong date in long form
     * @return boolean
     */
    boolean sameTime(Long dateLong);

    /**
     * return whether builder and input date are the same in time part
     * @param date date in date form
     * @return boolean
     */
    boolean sameTime(Date date);

    /**
     * return whether builder and input date are the same in time part
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean sameTime(Calendar calendar);

    /**
     * return whether builder's hour, minute and second are the same of {@code dateLong}
     * @param dateLong date in long form
     * @return boolean
     */
    boolean sameHMS(Long dateLong);

    /**
     * return whether builder's hour, minute and second are the same of {@code date}
     * @param date date in date form
     * @return boolean
     */
    boolean sameHMS(Date date);

    /**
     * return whether builder's hour, minute and second are the same of {@code calendar}
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean sameHMS(Calendar calendar);

    /**
     * return whether builder's hour and minute are the same of input
     * @param dateLong date in long form
     * @return boolean
     */
    boolean sameHM(Long dateLong);

    /**
     * return whether builder's hour and minute are the same of input
     * @param date date in date form
     * @return boolean
     */
    boolean sameHM(Date date);

    /**
     * return whether builder's hour and minute are the same of input
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean sameHM(Calendar calendar);

    /**
     * return whether builder later than the input
     * @param date date in date form
     * @return boolean
     */
    boolean laterThan(Date date);

    /**
     * return whether builder later than the input
     * @param longDate date in long form
     * @return boolean
     */
    boolean laterThan(Long longDate);

    /**
     * return whether builder later than the input
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean laterThan(Calendar calendar);

    /**
     * return whether builder later equal than input
     * @param date date in calendar form
     * @return boolean
     */
    boolean laterEqualThan(Date date);

    /**
     * return whether builder later equal than input
     * @param longDate date in long form
     * @return boolean
     */
    boolean laterEqualThan(Long longDate);

    /**
     * return whether builder later equal than input
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean laterEqualThan(Calendar calendar);

    /**
     * return whether builder before input
     * @param date date in date form
     * @return boolean
     */
    boolean before(Date date);

    /**
     * return whether builder before input
     * @param longDate date in long form
     * @return boolean
     */
    boolean before(Long longDate);

    /**
     * return whether builder before input
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean before(Calendar calendar);

    /**
     * return whether builder before or equals input
     * @param date date in date form
     * @return boolean
     */
    boolean beforeEqual(Date date);

    /**
     * return whether builder before or equals input
     * @param longDate date in long form
     * @return boolean
     */
    boolean beforeEqual(Long longDate);

    /**
     * return whether builder before or equals input
     * @param calendar date in calendar form
     * @return boolean
     */
    boolean beforeEqual(Calendar calendar);

    /**
     * Add time in millisecond
     * @param time millisecond
     * @return builder updated
     */
    T addTime(final long time);

    /**
     * Add hour(s) to builder
     * @param hours hour(s)
     * @return builder updated
     */
    T addHours(final int hours);

    /**
     * Add minute(s) to builder
     * @param mins minute(s)
     * @return builder updated
     */
    T addMins(final int mins);

    /**
     * Add second(s) to builder
     * @param sec second(s)
     * @return builder updated
     */
    T addSecond(final int sec);

    /**
     * Add millisecond
     * @param ms millisecond
     * @return builder updated
     */
    T addMS(final int ms);

    /**
     * set time zone.
     * timeZone method is <strong>passively</strong> applied, will not leading date value update(timezone shifting).
     * e.g. set timezone to TKY, when call asDate() method, the hour field will not shift to corresponding timezone
     * 2020-05-07T18:01:01 HKT to 2020-05-07T18:01:01 JST
     * @param timeZone time zone in BaseTimeZone
     * @return builder updated
     */
    T timeZone(final BaseTimeZone timeZone);

    /**
     * set time zone
     * timeZone method is <strong>passively</strong> applied, will not leading date value update(timezone shifting).
     * e.g. set timezone to TKY, when call asDate() method, the hour field will not shift to corresponding timezone
     * 2020-05-07T18:01:01 HKT to 2020-05-07T18:01:01 JST
     * @param timeZone time zone
     * @return builder updated
     */
    T timeZone(final TimeZone timeZone);

    /**
     * switch time zone to new time zone
     * timeZone method is <strong>actively</strong> applied, will lead to date value update(timezone shifting).
     * e.g. set timezone to TKY, when call asDate() method, the hour field will shift to corresponding timezone
     * 2020-05-07T18:01:01 HKT to 2020-05-07T19:01:01 JST
     * @param timeZone time zone in BaseTimeZone
     * @return builder updated
     */
    T swapTimeZone(final BaseTimeZone timeZone);

    /**
     * switch time zone to new time zone
     * timeZone method is <strong>actively</strong> applied, will lead to date value update(timezone shifting).
     * e.g. set timezone to TKY, when call asDate() method, the hour field will shift to corresponding timezone
     * 2020-05-07T18:01:01 HKT to 2020-05-07T19:01:01 JST
     * @param timeZone time zone
     * @return builder updated
     */
    T swapTimeZone(final TimeZone timeZone);

    /**
     * Eliminate the date part and leaving the time part only in builder
     * 2020-02-12T13:12:14.998 to 1970-01-01T13:12:12.998
     * @return updated builder
     */
    T timePartOnly();


}
