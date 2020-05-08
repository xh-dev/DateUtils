package me.xethh.utils.dateUtils.formatBuilder;

import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.text.SimpleDateFormat;
import java.util.*;

public interface DateFormatBuilder<X extends DateFormatBuilder> {
    static DateFormatBuilder get() {
        return new DateFormatBuilderImpl();
    }

    String YEAR_4_DIGIT = "yyyy";
    String YEAR_2_DIGIT = "yy";
    String MONTH_2_DIGIT = "MM";
    String MONTH_3_LETTER = "MMM";
    String FULL_MONTH_NAME = "MMMM";
    String DAY_1_DIGIT = "d";
    String DAY_2_DIGIT = "dd";
    String HOUR_IN_DAY24 = "HH";
    String HOUR_IN_DAY12 = "hh";
    String APM = "a";
    String MINUTE = "mm";
    String SECOND = "ss";
    String MILLISECOND = "SSS";
    String GENERAL_TIMEZONE = "z";
    String TIMEZONE_RFC822 = "Z";
    String TIMEZONE_ISO8601_1DIGIT = "X";
    String TIMEZONE_ISO8601_2DIGIT = "XX";
    String TIMEZONE_ISO8601_3DIGIT = "XXX";

    String HYPHEN = "-";
    String COLON = ":";
    String UNDERLINE = "_";
    String SPACE = " ";
    String DOT = ".";

    enum Format {
        ISO8601("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        SIMPLE_DATE("yyyy-MM-dd"),
        SIMPLE_DATETIME("yyyy-MM-dd HH:mm:ss"),
        FULL_DATETIME("yyyy-MM-dd HH:mm:ss.SSS"),
        NUMBER_DATE("yyyyMMdd"),
        NUMBER_DATETIME("yyyyMMddHHmmss");

        private String formatString;

        Format(String formatString) {
            this.formatString = formatString;
        }

        public String format() {
            return formatString;
        }

        public SimpleDateFormat getFormatter() {
            return new SimpleDateFormat(formatString);
        }

        public SimpleDateFormat getFormatter(TimeZone timeZone) {
            SimpleDateFormat sdf = getFormatter();
            sdf.setTimeZone(timeZone);
            return sdf;
        }

    }

    abstract class InternalFormatBuild {
        abstract void apply(StringBuilder str, Map<String, String> variables);

        protected String getVariable(Map<String, String> variables, String k) {
            return quote(variables.get(k) != null ? variables.get(k) : "");
        }

        protected String quote(String k) {
            StringBuilder s = new StringBuilder();
            for (char c : k.toCharArray())
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122))
                    s.append('\'').append(c).append('\'');
                else s.append(c);
            return s.toString();
        }
    }

    /**
     * e.g. 2018-01-02 == "2018"
     *
     * @return {date string}+"yyyy"
     */
    X year4Digit();

    /**
     * e.g. 2018-01-02 == "18"
     *
     * @return {date string}+"yy"
     */
    X year2Digit();

    /**
     * e.g. 2018-01-02 == "01"
     *
     * @return {date string}+"MM"
     */
    X month2Digit();

    /**
     * e.g. 2018-01-02 == "Jan"
     *
     * @return {date string}+"MMM"
     */
    X month3Letters();

    /**
     * e.g. 2018-01-02 == "January"
     *
     * @return {date string}+"MMMMM"
     */
    X monthFullName();

    /**
     * e.g. 2018-01-02 == "02"
     *
     * @param digit number of digit to pad
     * @return {date string}+"dd"
     */
    X dayWithDigit(final int digit);

    /**
     * e.g. 2018-01-02 == "02"
     *
     * @return {date string}+"dd"
     */
    X day2Digit();

    /**
     * e.g. 2018-01-02 == "2"
     *
     * @return {date string}+"d"
     */
    X day1Digit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * Range(00-23)
     *
     * @return {date string}+"HH"
     */
    X hourInDay24();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "3"
     * Range(01-12)
     *
     * @return {date string}+"hh"
     */
    X hourInDay12();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "AM"
     * Range[AM,PM]
     *
     * @return {date string}+"a"
     */
    X apm();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     *
     * @return {date string}+"mm"
     */
    X minute();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     *
     * @return {date string}+"ss"
     */
    X second();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     *
     * @return {date string}+"SSS"
     */
    X ms();

    /**
     * Display GMT only when gmt time, it could be PST or something others
     * e.g. 2018-01-02T03:04:05.444+0800 == "GMT+08:00"
     *
     * @return {date string}+"z"
     */
    X GeneralTimeZone();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     *
     * @return {date string}+"Z"
     */
    X TimeZoneRFC822();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08"
     *
     * @return {date string}+"X"
     */
    X TimeZoneISO8601OneDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     *
     * @return {date string}+"XX"
     */
    X TimeZoneISO8601TwoDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08:00"
     *
     * @return {date string}+"XXX"
     */
    X TimeZoneISO8601ThreeDigit();

    X custFormat(final String string);

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     *
     * @param string string to be padded
     * @return {date string}+"'HELLO '"
     */
    X pad(final String string);

    X hyphen();

    X space();

    X colon();

    X dot();

    X underLine();

    X v1();

    X v2();

    X v3();

    X v4();

    X v5();

    X v6();

    X v7();

    X v8();

    X v9();

    X v10();

    X v(final String v);

    X v1(String v);

    X v2(String v);

    X v3(String v);

    X v4(String v);

    X v5(String v);

    X v6(String v);

    X v7(String v);

    X v8(String v);

    X v9(String v);

    X v10(String v);

    X v(String k, String v);

    String getVariable(String k);

    X setVariable(String k, String v);

    X timeZone(BaseTimeZone timeZone);

    X timeZone(TimeZone timeZone);

    SimpleDateFormat build();

}
