package me.xethh.utils.dateManipulation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DateFormatBuilder {
    public static SimpleDateFormat ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    public static SimpleDateFormat SIMPLE_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat SIMPLE_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat NUMBER_DATE = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat NUMBER_DATETIME = new SimpleDateFormat("yyyyMMddHHmmss");
    private List<String> strings = new ArrayList<String>();
    private DateFormatBuilder(){
    }
    protected DateFormatBuilder(List<String> string, String newString){
        strings.addAll(string);
        strings.add(newString);
    }

    public static DateFormatBuilder get(){
        return new DateFormatBuilder();
    }

    /**
     * e.g. 2018-01-02 == "2018"
     * @return {date string}+"yyyy"
     */
    public DateFormatBuilder yyyy(){
        return new DateFormatBuilder(strings,"yyyy");
    }

    /**
     * e.g. 2018-01-02 == "01"
     * @return {date string}+"MM"
     */
    public DateFormatBuilder MM(){
        return new DateFormatBuilder(strings,"MM");
    }

    /**
     * e.g. 2018-01-02 == "02"
     * @return {date string}+"dd"
     */
    public DateFormatBuilder dd(){
        return new DateFormatBuilder(strings,"dd");
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "03"
     * @return {date string}+"HH"
     */
    public DateFormatBuilder HH(){
        return new DateFormatBuilder(strings,"HH");
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "04"
     * @return {date string}+"mm"
     */
    public DateFormatBuilder mm(){
        return new DateFormatBuilder(strings,"mm");
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "05"
     * @return {date string}+"ss"
     */
    public DateFormatBuilder ss(){
        return new DateFormatBuilder(strings,"ss");
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "444"
     * @return {date string}+"SSS"
     */
    public DateFormatBuilder SSS(){
        return new DateFormatBuilder(strings,"SSS");
    }

    /**
     * e.g. 2018-01-02T03:04:05.444+0800 == "+0800"
     * @return {date string}+"Z"
     */
    public DateFormatBuilder Z(){
        return new DateFormatBuilder(strings,"Z");
    }

    /**
     * e.g. HELLO 2018-01-02T03:04:05.444+0800 == "HELLO"
     * @return {date string}+"'HELLO '"
     */
    public DateFormatBuilder pad(String string){
        return new DateFormatBuilder(strings,"'"+string+"'");
    }

    public DateFormatBuilder space(){
        return new DateFormatBuilder(strings," ");
    }
    public DateFormatBuilder colen(){
        return new DateFormatBuilder(strings,":");
    }
    public DateFormatBuilder underLine(){
        return new DateFormatBuilder(strings,"_");
    }
    public SimpleDateFormat build(){
        String s = "";
        for(String ss:strings)
            s+=ss;
        return new SimpleDateFormat(s);
    }
}
