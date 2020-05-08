package me.xethh.utils.dateUtils.formatBuilder;

import java.text.SimpleDateFormat;

public class DateFormatBuilderFactory {
    public static SimpleDateFormat ISO8601() {
        return new SimpleDateFormat(DateFormatBuilder.Format.ISO8601.format());
    }

    public static SimpleDateFormat SIMPLE_DATE() {
        return new SimpleDateFormat(DateFormatBuilder.Format.SIMPLE_DATE.format());
    }

    public static SimpleDateFormat SIMPLE_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilder.Format.SIMPLE_DATETIME.format());
    }

    public static SimpleDateFormat NUMBER_DATE() {
        return new SimpleDateFormat(DateFormatBuilder.Format.NUMBER_DATE.format());
    }

    public static SimpleDateFormat NUMBER_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilder.Format.NUMBER_DATETIME.format());
    }

    public static SimpleDateFormat FULL_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilder.Format.FULL_DATETIME.format());
    }

    public static DateFormatBuilder get() {
        return new DateFormatBuilderImpl();
    }

}
