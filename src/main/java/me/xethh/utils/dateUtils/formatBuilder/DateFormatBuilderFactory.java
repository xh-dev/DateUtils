package me.xethh.utils.dateUtils.formatBuilder;

import java.text.SimpleDateFormat;

public class DateFormatBuilderFactory {
    public static SimpleDateFormat ISO8601() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.ISO8601.format());
    }

    public static SimpleDateFormat SIMPLE_DATE() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.SIMPLE_DATE.format());
    }

    public static SimpleDateFormat SIMPLE_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.SIMPLE_DATETIME.format());
    }

    public static SimpleDateFormat NUMBER_DATE() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.NUMBER_DATE.format());
    }

    public static SimpleDateFormat NUMBER_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.NUMBER_DATETIME.format());
    }

    public static SimpleDateFormat FULL_DATETIME() {
        return new SimpleDateFormat(DateFormatBuilderInterface.Format.FULL_DATETIME.format());
    }

    public static DateFormatBuilder get() {
        return new DateFormatBuilder();
    }

    public static class Const {
        public static String YEAR_4_DIGIT = "yyyy";
        public static String YEAR_2_DIGIT = "yy";
        public static String MONTH_2_DIGIT = "MM";
        public static String MONTH_3_LETTER = "MMM";
        public static String FULL_MONTH_NAME = "MMMM";
        public static String DAY_1_DIGIT = "d";
        public static String DAY_2_DIGIT = "dd";
        public static String HOUR_IN_DAY24 = "HH";
        public static String HOUR_IN_DAY12 = "hh";
        public static String APM = "a";
        public static String MINUTE = "mm";
        public static String SECOND = "ss";
        public static String MILLISECOND = "SSS";
        public static String GENERAL_TIMEZONE = "z";
        public static String TIMEZONE_RFC822 = "Z";
        public static String TIMEZONE_ISO8601_1DIGIT = "X";
        public static String TIMEZONE_ISO8601_2DIGIT = "XX";
        public static String TIMEZONE_ISO8601_3DIGIT = "XXX";

        public static String HYPHEN = "-";
        public static String COLON = ":";
        public static String UNDERLINE = "_";
        public static String SPACE = " ";
        public static String DOT = ".";
    }

}
