package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.*;

public interface DateFormatBuilder {
    public static String YEAR_4_DIGIT = "yyyy";
    public static String YEAR_2_DIGIT = "yy";
    public static String MONTH_2_DIGIT = "MM";
    public static String MONTH_3_LETTER = "MMM";
    public static String FULL_MONTH_NAME = "MMMM";
    public static String DAY_1_DIGIT="d";
    public static String DAY_2_DIGIT="dd";
    public static String HOUR_IN_DAY24="HH";
    public static String HOUR_IN_DAY12="hh";
    public static String APM="a";
    public static String MINUTE="mm";
    public static String SECOND="ss";
    public static String MILLISECOND="SSS";
    public static String GENERAL_TIMEZONE="z";
    public static String TIMEZONE_RFC822="Z";
    public static String TIMEZONE_ISO8601_1DIGIT="X";
    public static String TIMEZONE_ISO8601_2DIGIT="XX";
    public static String TIMEZONE_ISO8601_3DIGIT="XXX";

    public static String HYPHEN="-";
    public static String COLON =":";
    public static String UNDERLINE="_";
    public static String SPACE=" ";
    public static String DOT=".";

    enum Format{
        ISO8601("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        SIMPLE_DATE("yyyy-MM-dd"),
        SIMPLE_DATETIME("yyyy-MM-dd HH:mm:ss"),
        FULL_DATETIME("yyyy-MM-dd HH:mm:ss.SSS"),
        NUMBER_DATE("yyyyMMdd"),
        NUMBER_DATETIME("yyyyMMddHHmmss");
        
        private String formatString;
        private Format(String formatString){
            this.formatString=formatString;
        }
        
        public String format(){
            return formatString;
        }

        public SimpleDateFormat getFormatter(){
            return new SimpleDateFormat(formatString);
        }
        
    }
    abstract class Build{
        abstract void apply(StringBuilder str,Map<String,String> variables);
        protected String getVariable(Map<String,String> variables, String k){
            return quote(variables.get(k) != null ? variables.get(k) : "");
        }
        protected String quote(String k){
            StringBuilder s = new StringBuilder();
            for(char c : k.toCharArray())
                if((c>=65 && c<=90) || (c>=97 && c<=122))
                    s.append('\'').append(c).append('\'');
                else s.append(c);
            return s.toString();
        }
    }

    /**
     * e.g. 2018-01-02 == "2018"
     * @return {date string}+"yyyy"
     */
    public DateFormatBuilder year4Digit();

    /**
     * e.g. 2018-01-02 == "18"
     * @return {date string}+"yy"
     */
    public DateFormatBuilder year2Digit();

    /**
     * e.g. 2018-01-02 == "01"
     * @return {date string}+"MM"
     */
    public DateFormatBuilder month2Digit();

    /**
     * e.g. 2018-01-02 == "Jan"
     * @return {date string}+"MMM"
     */
    public DateFormatBuilder month3Letters();

    /**
     * e.g. 2018-01-02 == "January"
     * @return {date string}+"MMMMM"
     */
    public DateFormatBuilder monthFullName();

    /**
     * e.g. 2018-01-02 == "02"
     * @param digit number of digit to pad
     * @return {date string}+"dd"
     */
    public DateFormatBuilder dayWithDigit(final int digit);

    /**
     * e.g. 2018-01-02 == "02"
     * @return {date string}+"dd"
     */
    public DateFormatBuilder day2Digit();

    /**
     * e.g. 2018-01-02 == "2"
     * @return {date string}+"d"
     */
    public DateFormatBuilder day1Digit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * Range(00-23)
     * @return {date string}+"HH"
     */
    public DateFormatBuilder hourInDay24();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "3"
     * Range(01-12)
     * @return {date string}+"hh"
     */
    public DateFormatBuilder hourInDay12();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "AM"
     * Range[AM,PM]
     * @return {date string}+"a"
     */
    public DateFormatBuilder apm();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     * @return {date string}+"mm"
     */
    public DateFormatBuilder minute();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     * @return {date string}+"ss"
     */
    public DateFormatBuilder second();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     * @return {date string}+"SSS"
     */
    public DateFormatBuilder ms();

    /**
     * Display GMT only when gmt time, it could be PST or something others
     * e.g. 2018-01-02T03:04:05.444+0800 == "GMT+08:00"
     * @return {date string}+"z"
     */
    public DateFormatBuilder GeneralTimeZone();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"Z"
     */
    public DateFormatBuilder TimeZoneRFC822();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08"
     * @return {date string}+"X"
     */
    public DateFormatBuilder TimeZoneISO8601OneDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"XX"
     */
    public DateFormatBuilder TimeZoneISO8601TwoDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08:00"
     * @return {date string}+"XXX"
     */
    public DateFormatBuilder TimeZoneISO8601ThreeDigit();

    public DateFormatBuilder custFormat(final String string);

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     * @param string string to be padded
     * @return {date string}+"'HELLO '"
     */
    public DateFormatBuilder pad(final String string);

    public DateFormatBuilder hyphen();
    public DateFormatBuilder space();
    public DateFormatBuilder colon();
    public DateFormatBuilder dot();
    public DateFormatBuilder underLine();
    public DateFormatBuilder v1();
    public DateFormatBuilder v2();
    public DateFormatBuilder v3();
    public DateFormatBuilder v4();
    public DateFormatBuilder v5();
    public DateFormatBuilder v6();
    public DateFormatBuilder v7();
    public DateFormatBuilder v8();
    public DateFormatBuilder v9();
    public DateFormatBuilder v10();
    public DateFormatBuilder v(final String v);
    public DateFormatBuilder v1(String v);
    public DateFormatBuilder v2(String v);
    public DateFormatBuilder v3(String v);
    public DateFormatBuilder v4(String v);
    public DateFormatBuilder v5(String v);
    public DateFormatBuilder v6(String v);
    public DateFormatBuilder v7(String v);
    public DateFormatBuilder v8(String v);
    public DateFormatBuilder v9(String v);
    public DateFormatBuilder v10(String v);
    public DateFormatBuilder v(String k,String v);

    public String getVariable(String k);
    public DateFormatBuilder setVariable(String k,String v);
    public DateFormatBuilder timeZone(BaseTimeZone timeZone);
    public DateFormatBuilder timeZone(TimeZone timeZone);

    public SimpleDateFormat build();
}
