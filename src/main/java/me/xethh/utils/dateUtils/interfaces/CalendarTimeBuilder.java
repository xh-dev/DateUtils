package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public interface CalendarTimeBuilder<T extends CalendarTimeBuilder<T>> {
    /**
     * Return the datetime of current datetime
     * @return
     */
    T now();

    /**
     * Set hour, minute, second and millisecond
     *
     * @param hour
     * @param minute
     * @param second
     * @param mSecond
     * @return
     */
    T hmsms(int hour, int minute, int second, int mSecond);

    /**
     * Set hour, minute, second and minimize millisecond
     *
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    T hms(int hour, int minute, int second);

    /**
     * Set hour, minute and minimize second and millisecond
     *
     * @param hour
     * @param minute
     * @return
     */
    T hm(int hour, int minute);

    /**
     * Set hour and minimize minute, second, millisecond
     *
     * @param hour
     * @return
     */
    T h(int hour);


    /*
    Hour part
     */

    /**
     * Minimize hour to 0
     *
     * @return
     */
    T minHour();

    /**
     * Maximize hour to 23
     *
     * @return
     */
    T maxHour();

    /**
     * Set hour
     *
     * @param hour
     * @return
     */
    T hour(final int hour);

    /*
    Minute part
     */

    /**
     * Minimize minute to 0
     *
     * @return
     */
    T minMinute();

    /**
     * Maximize minute to 59
     *
     * @return
     */
    T maxMinute();

    /**
     * Set minute
     *
     * @param min
     * @return
     */
    T minute(final int min);

    /*
    Second part
     */

    /**
     * Minimize second
     *
     * @return
     */
    T minSecond();

    /**
     * Maximize second
     *
     * @return
     */
    T maxSecond();

    /**
     * Set second
     *
     * @param second
     * @return
     */
    T second(final int second);

    /*
    Millisecond
     */

    /**
     * Minimize millisecond
     *
     * @return
     */
    T minMs();

    /**
     * Maximize millisecond
     *
     * @return
     */
    T maxMs();

    /**
     * Set millisecond
     *
     * @param ms
     * @return
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

    boolean sameDatetime(Long longDate);

    boolean sameDatetime(Date date);

    boolean sameDatetime(Calendar cal);

    boolean sameTime(Long dateLong);

    boolean sameTime(Date date);

    boolean sameTime(Calendar calendar);

    boolean sameHMS(Long dateLong);

    boolean sameHMS(Date date);

    boolean sameHMS(Calendar calendar);

    boolean sameHM(Long dateLong);

    boolean sameHM(Date date);

    boolean sameHM(Calendar calendar);

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

    T addTime(final long time);

    T addHours(final int hours);

    T addMins(final int mins);

    T addSecond(final int sec);

    T addMS(final int ms);

    T timeZone(final BaseTimeZone timeZone);

    T timeZone(final TimeZone timeZone);

    T swapTimeZone(final BaseTimeZone timeZone);

    T swapTimeZone(final TimeZone timeZone);

    T timePartOnly();


}
