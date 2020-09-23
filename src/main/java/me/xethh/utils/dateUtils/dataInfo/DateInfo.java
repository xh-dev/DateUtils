package me.xethh.utils.dateUtils.dataInfo;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public interface DateInfo {
    static DateInfo from(Date date) {
        return new DateInfoImpl(DatetimeFactory.instance().getTimezone(), date);
    }

    static DateInfo from(TimeZone timeZone, Date date) {
        return new DateInfoImpl(timeZone, date);
    }

    static DateInfo from(BaseTimeZone baseTimeZone, Date date) {
        return new DateInfoImpl(baseTimeZone.timeZone(), date);
    }


    Integer year();

    Month month();

    Integer day();

    Integer weekOfYear();

    Integer weekOfMonth();

    Integer dayOfYear();

    Integer hour();

    Integer min();

    Integer second();

    Integer ms();

    Weekday weekday();

    DatetimeBuilder asBuilder();

    Date asDate();

    Calendar asCalendar();

    Long asLong();

    String asNumberDatetime();

    String asNumberDate();

    String asSimpleDateTime();

    String asSimpleDate();

    String asISO8601();

    String asFormat(DateFormatBuilderInterface builder);

    String asFormat(SimpleDateFormat fmt);

}
