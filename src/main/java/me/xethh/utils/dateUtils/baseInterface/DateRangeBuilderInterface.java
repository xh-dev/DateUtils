package me.xethh.utils.dateUtils.baseInterface;

import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.util.Calendar;
import java.util.Date;

public interface DateRangeBuilderInterface extends DateViewable {
    DatetimeRange rangeTo(Date date);

    DatetimeRange rangeTo(Long dateLong);

    DatetimeRange rangeTo(Calendar cal);

    DatetimeRange rangeToSelf();

    DatetimeRange rangeFrom(Date date);

    DatetimeRange rangeFrom(Long dateLong);

    DatetimeRange rangeFrom(Calendar cal);

    <X extends CalendarDateBuilder<X>> DatetimeRange rangeTo(X date);

    <X extends CalendarDateBuilder<X>> DatetimeRange rangeFrom(X date);
}
