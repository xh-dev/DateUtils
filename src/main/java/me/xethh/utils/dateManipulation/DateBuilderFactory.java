package me.xethh.utils.dateManipulation;

import me.xethh.utils.rangeManipulation.DatetimeRange;

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

    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Date date, E parent){
        if(parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Date date, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.getBuilds(),build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T raw(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new ArrayList(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(List<Build> builds, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(builds,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(List<Build> builds, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(builds,build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T now(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Calendar calendar, E parent){
        return (T) from(calendar.getTime(),parent);
    }
    public static <T extends DateBuilder<T> & BuilderWrapper<E>,E extends BuilderContainer<F>,F extends Object> T from(Long longDate, E parent){
        return (T) from(new Date(longDate),parent);
    }
}
