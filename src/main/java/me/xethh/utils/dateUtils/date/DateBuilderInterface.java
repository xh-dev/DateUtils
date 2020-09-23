package me.xethh.utils.dateUtils.date;

import me.xethh.utils.dateUtils.baseInterface.CalendarDateBuilder;
import me.xethh.utils.dateUtils.baseInterface.DateRangeBuilderInterface;
import me.xethh.utils.dateUtils.baseInterface.FormatterBuilder;
import me.xethh.utils.dateUtils.baseInterface.TimeUnitConverter;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;

/**
 * DateBuilder interface ind
 *
 * @param <T> generic type of DateBuilder
 */
public interface DateBuilderInterface<T extends DateBuilderInterface<T>>
        extends
        DateRangeBuilderInterface,
        CalendarDateBuilder<T>,
        TimeUnitConverter,
        FormatterBuilder {

    DatetimeBuilder asDatetimeBuilder();
}
