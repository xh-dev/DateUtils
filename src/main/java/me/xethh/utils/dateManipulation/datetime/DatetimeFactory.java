package me.xethh.utils.dateManipulation.datetime;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.*;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeFactory {
    public static TimeZone defaultTimezone(){
        return TimeZone.getDefault();
    }
    public static DatetimeBuilderImpl from(Date date){
        return new DatetimeBuilderImpl(date);
    }
    public static DatetimeBuilderImpl from(Date date, Build build){
        DatetimeBuilderImpl builder = new DatetimeBuilderImpl(date);
        return DatetimeFactory.from(builder.asCalendar(),build);
    }
    public static DatetimeBuilderImpl raw(){
        return new DatetimeBuilderImpl();
    }
    public static DatetimeBuilderImpl from(Calendar cal){
        return new DatetimeBuilderImpl(cal);
    }
    public static DatetimeBuilderImpl from(Calendar cal, Build build){
        return new DatetimeBuilderImpl(cal,build);
    }
    public static DatetimeBuilderImpl now(){
        return new DatetimeBuilderImpl(new Date());
    }
    public static DatetimeBuilderImpl from(Long longDate){
        return from(new Date(longDate));
    }

    public static DatetimeRange rangeOnNow(){
        return DatetimeFactory.now().rangeTo(now());
    }
    public static DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder){
        return datetimeBuilder.rangeToSelf();
    }
    public static DatetimeRange rangeOn(Date date){
        return rangeOn(DatetimeFactory.from(date));
    }
    public static DatetimeRange rangeOn(Long dateLong){
        return rangeOn(DatetimeFactory.from(dateLong));
    }
    public static DatetimeRange rangeOn(Calendar cal){
        return rangeOn(DatetimeFactory.from(cal));
    }

    public static DateFormatBuilder format(){
        return DateFormatBuilderImpl.get();
    }

    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, E parent){
        if(parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(),build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T raw(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(DatetimeFactory.raw().asCalendar(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T,E>,E extends EditModeStatus<F>,F extends Object> T now(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Long longDate, E parent){
        return (T) from(new Date(longDate),parent);
    }
}
