package me.xethh.utils.dateUtils.datetime;

import me.xethh.utils.dateUtils.baseInterface.*;
import me.xethh.utils.dateUtils.date.DateBuilder;

public interface DatetimeBuilderInterface<T extends DatetimeBuilderInterface<T>>
        extends
        DateRangeBuilderInterface,
        DateViewable,
        CalendarDateBuilder<T>, CalendarTimeBuilder<T>,
        TimeUnitConverter,
        FormatterBuilder {

    DateBuilder asDateBuilder();
}
