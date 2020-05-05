package me.xethh.utils.datetimeFactory;

import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;

public interface FormatBuilderProvider {
    default DateFormatBuilder format(){
        return DateFormatBuilderImpl.get();
    }
}
