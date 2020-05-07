package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.formatBuilder.FormatBuilderWrapper;

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
    String format(TimeZone timeZone, DateFormatBuilder fmtBuilder);
    String format(TimeZone timeZone, SimpleDateFormat fmt);
}
