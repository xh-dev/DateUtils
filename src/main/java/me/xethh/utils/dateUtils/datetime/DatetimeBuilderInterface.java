package me.xethh.utils.dateUtils.datetime;

import me.xethh.utils.dateUtils.baseInterface.*;
import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;

import java.util.Calendar;
import java.util.Date;

public interface DatetimeBuilderInterface<T extends DatetimeBuilderInterface<T>>
        extends
        DateRangeBuilderInterface,
        DateViewable,
        CalendarDateBuilder<T>, CalendarTimeBuilder<T>,
        TimeUnitConverter,
        FormatterBuilder {

    <X extends DatetimeBuilderInterface<X>> DatetimeRange rangeTo(X date);

    <X extends DatetimeBuilderInterface<X>> DatetimeRange rangeFrom(X date);

    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeTo(Long dateLong);

    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);

    DatetimeRange rangeFrom(Long dateLong);

    DatetimeRange rangeFrom(Calendar cal);

    //Compare operation
    <X extends DatetimeBuilderInterface<X>> boolean sameDate(X builder);

    <X extends DatetimeBuilderInterface<X>> boolean sameDatetime(X builder);

    <X extends DatetimeBuilderInterface<X>> boolean sameYear(X builder);

    <X extends DatetimeBuilderInterface<X>> boolean sameMonth(X builder);

    <X extends DatetimeBuilderInterface<X>> boolean sameDay(X builder);

    <X extends DatetimeBuilderInterface<X>> boolean sameTime(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> boolean sameHMS(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> boolean sameHM(X datetimeBuilder);


    <X extends DatetimeBuilderInterface<X>> boolean laterThan(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> boolean laterEqualThan(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> boolean before(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> boolean beforeEqual(X datetimeBuilder);

    <X extends DatetimeBuilderInterface<X>> TimeUnit diffFrom(X date);

    <X extends DatetimeBuilderInterface<X>> TimeUnit diffTo(X date);

    DateBuilderInterface asDateBuilder();
}