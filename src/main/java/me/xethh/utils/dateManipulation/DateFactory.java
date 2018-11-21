package me.xethh.utils.dateManipulation;

import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.*;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DateFactory {
    public static TimeZone defaultTimezone(){
        return TimeZone.getDefault();
    }
    public static DateBuilderImpl from(Date date){
        return new DateBuilderImpl(date);
    }
    public static DateBuilderImpl from(Date date, Build build){
        DateBuilderImpl builder = new DateBuilderImpl(date);
        return DateFactory.from(builder.asCalendar(),build);
    }
    public static DateBuilderImpl raw(){
        return new DateBuilderImpl();
    }
    public static DateBuilderImpl from(Calendar cal){
        return new DateBuilderImpl(cal);
    }
    public static DateBuilderImpl from(Calendar cal, Build build){
        return new DateBuilderImpl(cal,build);
    }
    public static DateBuilderImpl now(){
        return new DateBuilderImpl(new Date());
    }
    public static DateBuilderImpl from(Long longDate){
        return from(new Date(longDate));
    }

    public static DateFormatBuilder format(){
        return DateFormatBuilder.get();
    }

    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Date date, E parent){
        if(parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Date date, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(),build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T raw(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(DateFactory.raw().asCalendar(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Calendar cal, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Calendar cal, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T now(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Long longDate, E parent){
        return (T) from(new Date(longDate),parent);
    }
}
