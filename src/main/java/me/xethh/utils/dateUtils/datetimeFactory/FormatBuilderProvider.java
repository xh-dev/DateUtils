package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;

public interface FormatBuilderProvider {
    default DateFormatBuilder format() {
        return DateFormatBuilder.get();
    }
}
