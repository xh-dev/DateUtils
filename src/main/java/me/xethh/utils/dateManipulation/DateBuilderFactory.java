package me.xethh.utils.dateManipulation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xethhung
 * @date 7/19/2018
 */
public class DateBuilderFactory {
    public static DateBuilderImpl from(Date date){
        return new DateBuilderImpl(date);
    }
    public static DateBuilderImpl from(Date date, Build build){
        DateBuilderImpl builder = new DateBuilderImpl(date);
        return DateBuilderFactory.from(builder.getBuilds(),build);
    }
    public static DateBuilderImpl raw(){
        return new DateBuilderImpl(new ArrayList());
    }
    public static DateBuilderImpl from(List<Build> builds){
        return new DateBuilderImpl(builds);
    }
    public static DateBuilderImpl from(List<Build> builds, Build build){
        return new DateBuilderImpl(builds,build);
    }
    public static DateBuilderImpl now(){
        return new DateBuilderImpl(new Date());
    }
    public static DateBuilderImpl from(Calendar calendar){
        return from(calendar.getTime());
    }
    public static DateBuilderImpl from(Long longDate){
        return from(new Date(longDate));
    }

    public static <T extends DateBuilder<T>> T from(Date date, Class<T> clazz){
        if(clazz == DateBuilderImpl.class)
            return (T) from(date);
        return null;
    }
    public static <T extends DateBuilder<T>> T from(Date date, Build build, Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            DateBuilderImpl builder = new DateBuilderImpl(date);
            return (T) DateBuilderFactory.from(builder.getBuilds(), build);
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T raw(Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) new DateBuilderImpl(new ArrayList());
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T from(List<Build> builds, Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) new DateBuilderImpl(builds);
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T from(List<Build> builds, Build build, Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) new DateBuilderImpl(builds,build);
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T now(Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) new DateBuilderImpl(new Date());
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T from(Calendar calendar, Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) from(calendar.getTime());
        }
        return null;
    }
    public static <T extends DateBuilder<T>> T from(Long longDate, Class<T> clazz){
        if(clazz == DateBuilderImpl.class) {
            return (T) from(new Date(longDate));
        }
        return null;
    }
}
