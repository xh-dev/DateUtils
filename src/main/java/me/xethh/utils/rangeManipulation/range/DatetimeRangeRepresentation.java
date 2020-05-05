package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

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
