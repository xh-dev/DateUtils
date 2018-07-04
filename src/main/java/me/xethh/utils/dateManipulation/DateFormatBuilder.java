package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateFormatBuilder {
    private static String VARIABLE_PREFIX = "/***xxxxdafd/";
    public static SimpleDateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    public static SimpleDateFormat SIMPLE_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat SIMPLE_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat NUMBER_DATE = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat NUMBER_DATETIME = new SimpleDateFormat("yyyyMMddHHmmss");

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
    private DateFormatBuilder(){
    }
    protected DateFormatBuilder(Map<String,String> variables, List<Build> build){
        this.builds.addAll(build);
        this.variables.putAll(variables);
    }
    protected DateFormatBuilder(Map<String,String> variables, List<Build> builds, Build newBuild){
        this(variables,builds);
        this.builds.add(newBuild);
    }

    public static DateFormatBuilder get(){
        return new DateFormatBuilder();
    }

    /**
     * e.g. 2018-01-02 == "2018"
     * @return {date string}+"yyyy"
     */
    public DateFormatBuilder yyyy(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("yyyy");
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "01"
     * @return {date string}+"MM"
     */
    public DateFormatBuilder MM(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("MM");
            }
        });
    }

    /**
     * e.g. 2018-01-02 == "02"
     * @return {date string}+"dd"
     */
    public DateFormatBuilder dd(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("dd");
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * @return {date string}+"HH"
     */
    public DateFormatBuilder HH(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("HH");
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     * @return {date string}+"mm"
     */
    public DateFormatBuilder mm(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("mm");
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     * @return {date string}+"ss"
     */
    public DateFormatBuilder ss(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("ss");
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     * @return {date string}+"SSS"
     */
    public DateFormatBuilder SSS(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("SSS");
            }
        });
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"Z"
     */
    public DateFormatBuilder Z(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("Z");
            }
        });
    }

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     * @return {date string}+"'HELLO '"
     */
    public DateFormatBuilder pad(final String string){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("'" + string + "'");
            }
        });
    }

    public DateFormatBuilder space(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(" ");
            }
        });
    }
    public DateFormatBuilder colen(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(":");
            }
        });
    }
    public DateFormatBuilder underLine(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append("_");
            }
        });
    }
    public DateFormatBuilder v1(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V1"));
            }
        });
    }
    public DateFormatBuilder v2(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V2"));
            }
        });
    }
    public DateFormatBuilder v3(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V3"));
            }
        });
    }
    public DateFormatBuilder v4(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V4"));
            }
        });
    }
    public DateFormatBuilder v5(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V5"));
            }
        });
    }
    public DateFormatBuilder v6(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V6"));
            }
        });
    }
    public DateFormatBuilder v7(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V7"));
            }
        });
    }
    public DateFormatBuilder v8(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V8"));
            }
        });
    }
    public DateFormatBuilder v9(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V9"));
            }
        });
    }
    public DateFormatBuilder v10(){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,VARIABLE_PREFIX+"V10"));
            }
        });
    }
    public DateFormatBuilder v(final String v){
        return new DateFormatBuilder(variables, builds, new Build() {
            @Override
            void apply(StringBuilder str,Map<String,String> variables) {
                str.append(getVariable(variables,v));
            }
        });
    }
    public DateFormatBuilder v1(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V1",v);
    }
    public DateFormatBuilder v2(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V2",v);
    }
    public DateFormatBuilder v3(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V3",v);
    }
    public DateFormatBuilder v4(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V4",v);
    }
    public DateFormatBuilder v5(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V5",v);
    }
    public DateFormatBuilder v6(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V6",v);
    }
    public DateFormatBuilder v7(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V7",v);
    }
    public DateFormatBuilder v8(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V8",v);
    }
    public DateFormatBuilder v9(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V9",v);
    }
    public DateFormatBuilder v10(String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(VARIABLE_PREFIX+"V10",v);
    }
    public DateFormatBuilder v(String k,String v){
        DateFormatBuilder build = new DateFormatBuilder(variables, builds);
        return build.setVariable(k,v);
    }

    public String getVariable(String k){
        return variables.get(k) != null ? variables.get(k) : "";
    }
    public DateFormatBuilder setVariable(String k,String v){
        DateFormatBuilder builder = new DateFormatBuilder(variables,builds);

        if(builder.variables.get(k)!=null) builder.variables.remove(k);
        builder.variables.put(k,v);

        return builder;
    }

    public SimpleDateFormat build(){
        StringBuilder s = new StringBuilder();
        for(Build ss: builds)
            ss.apply(s,variables);
        return new SimpleDateFormat(s.toString());
    }
}
