package me.xethh.utils.dateUtils.baseInterface;

import java.util.Calendar;
import java.util.Date;

/**
 * Interface provide common output form of date and time
 */
public interface CommonDateRepresentation {
    /**
     * Represent the builder as {@link java.util.Date}
     *
     * @return {@link java.util.Date}
     */
    Date asDate();

    /**
     * Represent the builder as {@link java.util.Calendar}
     *
     * @return {@link java.util.Calendar}
     */
    Calendar asCalendar();

    /**
     * Represent the builder as {@link java.lang.Long}
     *
     * @return {@link java.lang.Long}
     */
    Long asLong();

    /**
     * Represent the builder as {@link java.sql.Date}
     *
     * @return {@link java.sql.Date}
     */
    java.sql.Date asSqlDate();

    /**
     * Represent the builder as {@link java.sql.Time}
     *
     * @return {@link java.sql.Time}
     */
    java.sql.Time asSqlTime();

    /**
     * Represent the builder as {@link java.sql.Timestamp}
     *
     * @return {@link java.sql.Timestamp}
     */
    java.sql.Timestamp asSqlTimestamp();
}
