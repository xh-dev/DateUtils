package me.xethh.utils.dateUtils.date;

import me.xethh.utils.dateUtils.CalendarDateBuilder;
import me.xethh.utils.dateUtils.CommonDateRepresentation;
import me.xethh.utils.dateUtils.FormatterBuilder;
import me.xethh.utils.dateUtils.TimeUnitConverter;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;

import java.util.Calendar;
import java.util.Date;

/**
 * DateBuilder interface ind
 *
 * @param <T> generic type of DateBuilder
 */
public interface DateBuilderInterface<T extends DateBuilderInterface<T>>
        extends
        CalendarDateBuilder<T>,
        CommonDateRepresentation,
        TimeUnitConverter,
        FormatterBuilder {

    <X extends DateBuilderInterface<X>> DatetimeRange rangeTo(X date);

    <X extends DatetimeBuilderInterface<X>> DatetimeRange rangeTo(X date);

    <X extends DateBuilderInterface<X>> DatetimeRange rangeFrom(X date);

    <X extends DatetimeBuilderInterface<X>> DatetimeRange rangeFrom(X date);

    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeTo(Long dateLong);

    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);

    DatetimeRange rangeFrom(Long dateLong);

    DatetimeRange rangeFrom(Calendar cal);

    <X extends DateBuilderInterface<X>> boolean sameDate(X builder);

    boolean sameDate(Long longDate);

    boolean sameDate(Date date);

    boolean sameDate(Calendar cal);

    <X extends CalendarDateBuilder<X>> boolean sameYear(X builder);

    <X extends CalendarDateBuilder<X>> boolean sameMonth(X builder);

    <X extends CalendarDateBuilder<X>> boolean sameDay(X builder);

    <X extends CalendarDateBuilder<X>> boolean laterThan(X datetimeBuilder);

    <X extends CalendarDateBuilder<X>> boolean laterEqualThan(X datetimeBuilder);

    <X extends CalendarDateBuilder<X>> boolean before(X datetimeBuilder);

    <X extends CalendarDateBuilder<X>> boolean beforeEqual(X datetimeBuilder);

    <X extends CalendarDateBuilder<X>> TimeUnit diffFrom(X date);

    <X extends CalendarDateBuilder<X>> TimeUnit diffTo(X date);

    DatetimeBuilder asDatetimeBuilder();
}
