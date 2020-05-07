package me.xethh.utils.dateUtils.interfaces;

import java.util.Calendar;
import java.util.Date;

public interface CommonDateRepresentation {
    Date asDate();
    Calendar asCalendar();
    Long asLong();
    java.sql.Date asSqlDate();
    java.sql.Time asSqlTime();
    java.sql.Timestamp asSqlTimestamp();
}
