package me.xethh.utils.dateManipulation;

import java.util.Calendar;
import java.util.Date;

public interface CalendarTimeBuilder<T extends CalendarTimeBuilder<T>> {
    T hmsms(int hour, int minute, int second, int mSecond);
    T hms(int hour, int minute, int second);
    T hm(int hour, int minute);
    T h(int hour);


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

    /*
    Time manipulation
     */

    /**
     * Cast the date builder object to maximum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.999
     * @return maximum date time value up to millisecond
     */
    T maxDayTime();
    /**
     * Cast the date builder object to maximum day time of the day up to second
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.000
     * @return maximum date time value up to second
     */
    T maxDayTimeSec();
    /**
     * Cast the date builder object to maximum day time of the day up to minutes
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:00.000
     * @return maximum date time value up to minutes
     */
    T maxDayTimeMin();
    /**
     * Cast the date builder object to minimum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 00:00:00.000
     * @return minimum date time value up to millisecond
     */
    T minDayTime();

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
}
