package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.util.Calendar;
import java.util.Date;

public interface DatetimeRangeBuilderGenerator extends DatetimeBuilderGenerator {
    DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder);

    default DatetimeRange rangeOnNow() {
        return rangeOn(now());
    }

    default DatetimeRange rangeOn(Date date) {
        return rangeOn(from(date));
    }

    default DatetimeRange rangeOn(Long dateLong) {
        return rangeOn(from(dateLong));
    }

    default DatetimeRange rangeOn(Calendar cal) {
        return rangeOn(from(cal));
    }

}
