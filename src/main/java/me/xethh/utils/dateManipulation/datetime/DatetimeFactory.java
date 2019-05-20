package me.xethh.utils.dateManipulation.datetime;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeContainerWrapper;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.*;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeFactory {
    private static DatetimeFactory _instance;
    private TimeZone timeZone;
    private static Map<TimeZone, DatetimeFactory> factoryMap = new WeakHashMap<>();

    private static void addDatetimeMap(DatetimeFactory factory){
        if(factoryMap.get(factory.timeZone)==null)
            factoryMap.put(factory.timeZone, factory);
    }
    public DatetimeFactory(){
        this(TimeZone.getDefault());
    }
    public DatetimeFactory(TimeZone timeZone){
        this.timeZone = TimeZone.getDefault();
        addDatetimeMap(this);
    }
    public static DatetimeFactory instance(TimeZone timeZone){
        if(factoryMap.get(timeZone)==null){
            return new DatetimeFactory(timeZone);
        }
        else return factoryMap.get(timeZone);
    }

    public TimeZone defaultTimezone(){
        return timeZone;
    }

    public static DatetimeFactory instance(){
        if(_instance==null)
            _instance = new DatetimeFactory();
        return _instance;
    }

    public DatetimeBuilder from(Date date){
        return new DatetimeBuilderImpl(timeZone, date);
    }
    public DatetimeBuilder from(Date date, Build build){
        DatetimeBuilderImpl builder = new DatetimeBuilderImpl(timeZone,date);
        return from(builder.asCalendar(),build);
    }
    public DatetimeBuilder raw(){
        return new DatetimeBuilderImpl(timeZone);
    }
    public DatetimeBuilder from(Calendar cal){
        return new DatetimeBuilderImpl(cal);
    }
    public DatetimeBuilder from(Calendar cal, Build build){
        return new DatetimeBuilderImpl(cal,build);
    }
    public DatetimeBuilder from(Long longDate, Build build){
        return new DatetimeBuilderImpl(from(longDate).asCalendar(),build);
    }
    public DatetimeBuilder now(){
        return new DatetimeBuilderImpl(timeZone, new Date());
    }
    public DatetimeBuilder from(Long longDate){
        return from(new Date(longDate));
    }

    public DatetimeRange rangeOnNow(){
        return rangeOn(now());
    }
    public DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder){
        return datetimeBuilder.rangeToSelf();
    }
    public DatetimeRange rangeOn(Date date){
        return rangeOn(from(date));
    }
    public DatetimeRange rangeOn(Long dateLong){
        return rangeOn(from(dateLong));
    }
    public DatetimeRange rangeOn(Calendar cal){
        return rangeOn(from(cal));
    }

    public DateFormatBuilder format(){
        return DateFormatBuilderImpl.get();
    }

    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, E parent){
        if(parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(),build,(DatetimeRange) parent);
        }
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T raw(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(raw().asCalendar(),(DatetimeRange) parent);
        }
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,(DatetimeRange) parent);
        }
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,build,(DatetimeRange) parent);
        }
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T,E>,E extends EditModeStatus<F>,F extends Object> T now(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(),(DatetimeRange) parent);
        }
        return null;
    }
    public <T extends DatetimeBuilder<T> & DatetimeContainerWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Long longDate, E parent){
        return (T) from(new Date(longDate),parent);
    }
}
