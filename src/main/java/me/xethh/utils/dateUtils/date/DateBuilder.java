package me.xethh.utils.dateUtils.date;

import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;
import me.xethh.utils.dateUtils.CalendarDateBuilder;
import me.xethh.utils.dateUtils.CommonDateRepresentation;
import me.xethh.utils.dateUtils.FormatterBuilder;
import me.xethh.utils.dateUtils.TimeUnitConverter;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.util.Calendar;
import java.util.Date;

/**
 * DateBuilder interface ind
 *
 * @param <T> generic type of DateBuilder
 */
public interface DateBuilder<T extends DateBuilder<T>>
        extends
        CalendarDateBuilder<T>,
        CommonDateRepresentation,
        TimeUnitConverter,
        FormatterBuilder {
    @Override
    T y(int year);

    @Override
    T ym(int year, Month month);

    @Override
    T md(Month month, int day);

    @Override
    T ymd(int year, Month month, int day);

    @Override
    T minYear();

    @Override
    T year(final int year);

    @Override
    T minMonth();

    @Override
    T month(final Month month);

    @Override
    T minDay();

    @Override
    T day(final int date);

    @Override
    T firstDayOfMonth();

    @Override
    T endDayOfMonth();

    @Override
    T addYear(final int years);

    @Override
    T lastYear();

    @Override
    T nextYear();

    @Override
    T lastMonth();

    @Override
    T nextMonth();

    @Override
    T addMonths(final int months);

    @Override
    T addDays(final int days);

    @Override
    T yesterday();

    @Override
    T tomorrow();

    @Override
    T nextWeekday(Weekday startDay);

    @Override
    T prevWeekday(Weekday startDay);

    @Override
    T startOfWeek(Weekday startDay);

    @Override
    T endOfWeek(Weekday startDay);

    @Override
    T now();


    DateInfo view();

    DatetimeRange rangeTo(DateBuilder date);

    DatetimeRange rangeTo(DatetimeBuilder date);

    DatetimeRange rangeFrom(DateBuilder date);

    DatetimeRange rangeFrom(DatetimeBuilder date);

    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeTo(Long dateLong);

    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);

    DatetimeRange rangeFrom(Long dateLong);

    DatetimeRange rangeFrom(Calendar cal);

    boolean sameDate(DateBuilder builder);

    boolean sameDate(Long longDate);

    boolean sameDate(Date date);

    boolean sameDate(Calendar cal);

    boolean sameYear(DateBuilder builder);

    boolean sameYear(DatetimeBuilder builder);

    boolean sameMonth(DateBuilder builder);

    boolean sameMonth(DatetimeBuilder builder);

    boolean sameDay(DateBuilder builder);

    boolean sameDay(DatetimeBuilder builder);

    boolean laterThan(DateBuilder datetimeBuilder);

    boolean laterThan(DatetimeBuilder datetimeBuilder);

    boolean laterEqualThan(DateBuilder datetimeBuilder);

    boolean laterEqualThan(DatetimeBuilder datetimeBuilder);

    boolean before(DateBuilder datetimeBuilder);

    boolean before(DatetimeBuilder datetimeBuilder);

    boolean beforeEqual(DateBuilder datetimeBuilder);

    boolean beforeEqual(DatetimeBuilder datetimeBuilder);

    TimeUnit diffFrom(DateBuilder date);

    TimeUnit diffFrom(DatetimeBuilder date);

    TimeUnit diffTo(DateBuilder date);

    TimeUnit diffTo(DatetimeBuilder date);

    DatetimeBuilder asDatetimeBuilder();
}
