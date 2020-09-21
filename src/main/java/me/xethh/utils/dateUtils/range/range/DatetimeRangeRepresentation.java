package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.util.Date;

public interface DatetimeRangeRepresentation {

    DatetimeRange asDateRange();

    Date startAsDate();

    Date endAsDate();

    DatetimeBuilderInterface startAsDTBuilder();

    DatetimeBuilderInterface endAsDTBuilder();

    DateBuilderInterface startAsDateBuilder();

    DateBuilderInterface endAsDateBuilder();

}
