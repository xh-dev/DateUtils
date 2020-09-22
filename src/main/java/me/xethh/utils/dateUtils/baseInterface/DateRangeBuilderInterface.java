package me.xethh.utils.dateUtils.baseInterface;

import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
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
    <X extends DateRangeBuilderInterface> DatetimeRange rangeTo(X date);
    <X extends DateRangeBuilderInterface> DatetimeRange rangeFrom(X date);
}
