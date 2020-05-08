package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderImpl;

public interface FormatBuilderProvider {
    default DateFormatBuilder format() {
        return DateFormatBuilderImpl.get();
    }
}
