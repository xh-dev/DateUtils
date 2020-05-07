package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.util.Date;

public interface DatetimeRangeRepresentation {

    DatetimeRange asDateRange();

    Date startAsDate();

    Date endAsDate();

    DatetimeBuilder startAsDTBuilder();

    DatetimeBuilder endAsDTBuilder();

    DateBuilder startAsDateBuilder();

    DateBuilder endAsDateBuilder();

}
