package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.*;

public interface DateFormatBuilder {
    String YEAR_4_DIGIT = "yyyy";
    String YEAR_2_DIGIT = "yy";
    String MONTH_2_DIGIT = "MM";
    String MONTH_3_LETTER = "MMM";
    String FULL_MONTH_NAME = "MMMM";
    String DAY_1_DIGIT="d";
    String DAY_2_DIGIT="dd";
    String HOUR_IN_DAY24="HH";
    String HOUR_IN_DAY12="hh";
    String APM="a";
    String MINUTE="mm";
    String SECOND="ss";
    String MILLISECOND="SSS";
    String GENERAL_TIMEZONE="z";
    String TIMEZONE_RFC822="Z";
    String TIMEZONE_ISO8601_1DIGIT="X";
    String TIMEZONE_ISO8601_2DIGIT="XX";
    String TIMEZONE_ISO8601_3DIGIT="XXX";

    String HYPHEN="-";
    String COLON =":";
    String UNDERLINE="_";
    String SPACE=" ";
    String DOT=".";

    enum Format{
        ISO8601("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        SIMPLE_DATE("yyyy-MM-dd"),
        SIMPLE_DATETIME("yyyy-MM-dd HH:mm:ss"),
        FULL_DATETIME("yyyy-MM-dd HH:mm:ss.SSS"),
        NUMBER_DATE("yyyyMMdd"),
        NUMBER_DATETIME("yyyyMMddHHmmss");
        
        private String formatString;
        Format(String formatString){
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
    DateFormatBuilder year4Digit();

    /**
     * e.g. 2018-01-02 == "18"
     * @return {date string}+"yy"
     */
    DateFormatBuilder year2Digit();

    /**
     * e.g. 2018-01-02 == "01"
     * @return {date string}+"MM"
     */
    DateFormatBuilder month2Digit();

    /**
     * e.g. 2018-01-02 == "Jan"
     * @return {date string}+"MMM"
     */
    DateFormatBuilder month3Letters();

    /**
     * e.g. 2018-01-02 == "January"
     * @return {date string}+"MMMMM"
     */
    DateFormatBuilder monthFullName();

    /**
     * e.g. 2018-01-02 == "02"
     * @param digit number of digit to pad
     * @return {date string}+"dd"
     */
    DateFormatBuilder dayWithDigit(final int digit);

    /**
     * e.g. 2018-01-02 == "02"
     * @return {date string}+"dd"
     */
    DateFormatBuilder day2Digit();

    /**
     * e.g. 2018-01-02 == "2"
     * @return {date string}+"d"
     */
    DateFormatBuilder day1Digit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * Range(00-23)
     * @return {date string}+"HH"
     */
    DateFormatBuilder hourInDay24();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "3"
     * Range(01-12)
     * @return {date string}+"hh"
     */
    DateFormatBuilder hourInDay12();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "AM"
     * Range[AM,PM]
     * @return {date string}+"a"
     */
    DateFormatBuilder apm();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     * @return {date string}+"mm"
     */
    DateFormatBuilder minute();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     * @return {date string}+"ss"
     */
    DateFormatBuilder second();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     * @return {date string}+"SSS"
     */
    DateFormatBuilder ms();

    /**
     * Display GMT only when gmt time, it could be PST or something others
     * e.g. 2018-01-02T03:04:05.444+0800 == "GMT+08:00"
     * @return {date string}+"z"
     */
    DateFormatBuilder GeneralTimeZone();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"Z"
     */
    DateFormatBuilder TimeZoneRFC822();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08"
     * @return {date string}+"X"
     */
    DateFormatBuilder TimeZoneISO8601OneDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"XX"
     */
    DateFormatBuilder TimeZoneISO8601TwoDigit();

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08:00"
     * @return {date string}+"XXX"
     */
    DateFormatBuilder TimeZoneISO8601ThreeDigit();

    DateFormatBuilder custFormat(final String string);

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     * @param string string to be padded
     * @return {date string}+"'HELLO '"
     */
    DateFormatBuilder pad(final String string);

    DateFormatBuilder hyphen();
    DateFormatBuilder space();
    DateFormatBuilder colon();
    DateFormatBuilder dot();
    DateFormatBuilder underLine();
    DateFormatBuilder v1();
    DateFormatBuilder v2();
    DateFormatBuilder v3();
    DateFormatBuilder v4();
    DateFormatBuilder v5();
    DateFormatBuilder v6();
    DateFormatBuilder v7();
    DateFormatBuilder v8();
    DateFormatBuilder v9();
    DateFormatBuilder v10();
    DateFormatBuilder v(final String v);
    DateFormatBuilder v1(String v);
    DateFormatBuilder v2(String v);
    DateFormatBuilder v3(String v);
    DateFormatBuilder v4(String v);
    DateFormatBuilder v5(String v);
    DateFormatBuilder v6(String v);
    DateFormatBuilder v7(String v);
    DateFormatBuilder v8(String v);
    DateFormatBuilder v9(String v);
    DateFormatBuilder v10(String v);
    DateFormatBuilder v(String k, String v);

    String getVariable(String k);
    DateFormatBuilder setVariable(String k, String v);
    DateFormatBuilder timeZone(BaseTimeZone timeZone);
    DateFormatBuilder timeZone(TimeZone timeZone);

    SimpleDateFormat build();
}
