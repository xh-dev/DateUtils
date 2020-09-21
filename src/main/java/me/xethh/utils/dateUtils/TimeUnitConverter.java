package me.xethh.utils.dateUtils;

import me.xethh.utils.dateUtils.timeUnit.TimeUnit;

import java.util.Calendar;
import java.util.Date;

public interface TimeUnitConverter {
    /**
     * Time difference from date to builder
     *
     * @param date date in {@link java.util.Date} form
     * @return TimeUnit
     */
    TimeUnit diffFrom(Date date);

    /**
     * Time difference from builder to date
     *
     * @param date date in {@link java.util.Date} form
     * @return TimeUnit
     */
    TimeUnit diffTo(Date date);

    /**
     * Time difference from date to builder
     *
     * @param date date in long form
     * @return TimeUnit
     */
    TimeUnit diffFrom(long date);

    /**
     * Time difference from builder to date
     *
     * @param date date in long form
     * @return TimeUnit
     */
    TimeUnit diffTo(long date);

    /**
     * Time difference from date to builder
     *
     * @param date date in {@link java.util.Calendar} form
     * @return TimeUnit
     */
    TimeUnit diffFrom(Calendar date);

    /**
     * Time difference from builder to date
     *
     * @param date date in {@link java.util.Calendar} form
     * @return TimeUnit
     */
    TimeUnit diffTo(Calendar date);
}
