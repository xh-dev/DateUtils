package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateFormatBuilder {
    public enum Format{
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
        
    }

    private static String VARIABLE_PREFIX = "/***xxxxdafd/";
    public static SimpleDateFormat ISO8601(){return new SimpleDateFormat(Format.ISO8601.format());}
    public static SimpleDateFormat SIMPLE_DATE(){return new SimpleDateFormat(Format.SIMPLE_DATE.format());}
    public static SimpleDateFormat SIMPLE_DATETIME(){return new SimpleDateFormat(Format.SIMPLE_DATETIME.format());}
    public static SimpleDateFormat NUMBER_DATE(){return new SimpleDateFormat(Format.NUMBER_DATE.format());}
    public static SimpleDateFormat NUMBER_DATETIME(){return new SimpleDateFormat(Format.NUMBER_DATETIME.format());}
    public static SimpleDateFormat FULL_DATETIME(){return new SimpleDateFormat(Format.FULL_DATETIME.format());}

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

    private Map<String,String> variables = new HashMap<>();
    private List<Build> builds = new ArrayList<>();
    private TimeZone timeZone;
    private DateFormatBuilder(){
    }
    protected DateFormatBuilder(Map<String,String> variables, List<Build> build,TimeZone timeZone){
        this.builds.addAll(build);
        this.variables.putAll(variables);
        this.timeZone = timeZone;
    }
    protected DateFormatBuilder(Map<String,String> variables, List<Build> builds,TimeZone timeZone, Build newBuild){
        this(variables,builds,timeZone);
        this.builds.add(newBuild);
    }

    public static DateFormatBuilder get(){
        return new DateFormatBuilder();
    }

    /**
     * e.g. 2018-01-02 == "2018"
     * @return {date string}+"yyyy"
     */
    public DateFormatBuilder year4Digit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(YEAR_4_DIGIT);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "18"
     * @return {date string}+"yy"
     */
    public DateFormatBuilder year2Digit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(YEAR_2_DIGIT);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "01"
     * @return {date string}+"MM"
     */
    public DateFormatBuilder month2Digit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(MONTH_2_DIGIT);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "Jan"
     * @return {date string}+"MMM"
     */
    public DateFormatBuilder month3Letters(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(MONTH_3_LETTER);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "January"
     * @return {date string}+"MMMMM"
     */
    public DateFormatBuilder monthFullName(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(FULL_MONTH_NAME);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "02"
     * @param digit number of digit to pad
     * @return {date string}+"dd"
     */
    public DateFormatBuilder dayWithDigit(final int digit){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                String s = "";
                for(int i=0;i<digit;i++)
                    s+="d";
                str.append(s);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "02"
     * @return {date string}+"dd"
     */
    public DateFormatBuilder day2Digit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(DAY_2_DIGIT);
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "2"
     * @return {date string}+"d"
     */
    public DateFormatBuilder day1Digit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(DAY_1_DIGIT);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * Range(00-23)
     * @return {date string}+"HH"
     */
    public DateFormatBuilder hourInDay24(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(HOUR_IN_DAY24);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "3"
     * Range(01-12)
     * @return {date string}+"hh"
     */
    public DateFormatBuilder hourInDay12(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(HOUR_IN_DAY12);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "AM"
     * Range[AM,PM]
     * @return {date string}+"a"
     */
    public DateFormatBuilder apm(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(APM);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     * @return {date string}+"mm"
     */
    public DateFormatBuilder minute(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(MINUTE);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     * @return {date string}+"ss"
     */
    public DateFormatBuilder second(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(SECOND);
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     * @return {date string}+"SSS"
     */
    public DateFormatBuilder ms(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(MILLISECOND);
            }
        });
    }

    /**
     * Display GMT only when gmt time, it could be PST or something others
     * e.g. 2018-01-02T03:04:05.444+0800 == "GMT+08:00"
     * @return {date string}+"z"
     */
    public DateFormatBuilder GeneralTimeZone(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(GENERAL_TIMEZONE);
            }
        });
    }
    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"Z"
     */
    public DateFormatBuilder TimeZoneRFC822(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(TIMEZONE_RFC822);
            }
        });
    }
    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08"
     * @return {date string}+"X"
     */
    public DateFormatBuilder TimeZoneISO8601OneDigit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(TIMEZONE_ISO8601_1DIGIT);
            }
        });
    }
    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"XX"
     */
    public DateFormatBuilder TimeZoneISO8601TwoDigit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(TIMEZONE_ISO8601_2DIGIT);
            }
        });
    }
    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+08:00"
     * @return {date string}+"XXX"
     */
    public DateFormatBuilder TimeZoneISO8601ThreeDigit(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(TIMEZONE_ISO8601_3DIGIT);
            }
        });
    }
    public DateFormatBuilder custFormat(final String string){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(string);
            }
        });
    }

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     * @param string string to be padded
     * @return {date string}+"'HELLO '"
     */
    public DateFormatBuilder pad(final String string){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("'" + string + "'");
            }
        });
    }

    public DateFormatBuilder hyphen(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(HYPHEN);
            }
        });
    }
    public DateFormatBuilder space(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(SPACE);
            }
        });
    }
    public DateFormatBuilder colon(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(COLON);
            }
        });
    }
    public DateFormatBuilder dot(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(DOT);
            }
        });
    }
    public DateFormatBuilder underLine(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(UNDERLINE);
            }
        });
    }
    public DateFormatBuilder v1(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V1"));
            }
        });
    }
    public DateFormatBuilder v2(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V2"));
            }
        });
    }
    public DateFormatBuilder v3(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V3"));
            }
        });
    }
    public DateFormatBuilder v4(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V4"));
            }
        });
    }
    public DateFormatBuilder v5(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V5"));
            }
        });
    }
    public DateFormatBuilder v6(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V6"));
            }
        });
    }
    public DateFormatBuilder v7(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V7"));
            }
        });
    }
    public DateFormatBuilder v8(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V8"));
            }
        });
    }
    public DateFormatBuilder v9(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V9"));
            }
        });
    }
    public DateFormatBuilder v10(){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V10"));
            }
        });
    }
    public DateFormatBuilder v(final String v){
        return new DateFormatBuilder(variables, builds,timeZone, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,v));
            }
        });
    }
    public DateFormatBuilder v1(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V1",v);
    }
    public DateFormatBuilder v2(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V2",v);
    }
    public DateFormatBuilder v3(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V3",v);
    }
    public DateFormatBuilder v4(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V4",v);
    }
    public DateFormatBuilder v5(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V5",v);
    }
    public DateFormatBuilder v6(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V6",v);
    }
    public DateFormatBuilder v7(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V7",v);
    }
    public DateFormatBuilder v8(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V8",v);
    }
    public DateFormatBuilder v9(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V9",v);
    }
    public DateFormatBuilder v10(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(VARIABLE_PREFIX+"V10",v);
    }
    public DateFormatBuilder v(String k,String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds,timeZone);
        return build.setVariable(k,v);
    }

    public String getVariable(String k){
        return variables.get(k) != null ? variables.get(k) : "";
    }
    public DateFormatBuilder setVariable(String k,String v){
        DateFormatBuilder builder = new DateFormatBuilder(variables,builds,timeZone);

        if(builder.variables.get(k)!=null) builder.variables.remove(k);
        builder.variables.put(k,v);

        return builder;
    }
    public DateFormatBuilder timeZone(BaseTimeZone timeZone){
        DateFormatBuilder builder = new DateFormatBuilder(variables,builds,timeZone.timeZone());
        return builder;
    }
    public DateFormatBuilder timeZone(TimeZone timeZone){
        DateFormatBuilder builder = new DateFormatBuilder(variables,builds,timeZone);
        return builder;
    }

    public SimpleDateFormat build(){
        StringBuilder s = new StringBuilder();
        for(Build ss: builds)
            ss.apply(s,variables);
        SimpleDateFormat sdf = new SimpleDateFormat(s.toString());
        sdf.setTimeZone(timeZone==null? TimeZone.getDefault():timeZone);
        return sdf;
    }
}
