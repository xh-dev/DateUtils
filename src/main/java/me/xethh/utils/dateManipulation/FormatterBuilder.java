package me.xethh.utils.dateManipulation;

import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public interface FormatterBuilder {
    String format(String format);
    String format(DateFormatBuilder.Format format);
    String format(DateFormatBuilder fmtBuilder);
    String format(SimpleDateFormat fmt);
    FormatBuilderWrapper format();

    String format(TimeZone timeZone, String format);
    String format(TimeZone timeZone, DateFormatBuilder.Format format);
    String format(TimeZone timeZone, SimpleDateFormat fmt);
}
