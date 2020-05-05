package me.xethh.utils.dateManipulation.date;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeBackWrapper;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.*;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DateFactory {
    protected DateFactory(TimeZone timezone){
        this.timeZone = timezone;
    }
    public static DateFactory _instance;
    private TimeZone timeZone;
    private static Map<TimeZone, DateFactory> factoryMap = new WeakHashMap<>();
    public static DateFactory instance(BaseTimeZone baseTimezone){
        return instance(baseTimezone.timeZone());
    }
    public static DateFactory instance(TimeZone timezone){
        return new DateFactory(timezone);
    }
    public static DateFactory instance(){
        if(_instance==null){
            return new DateFactory(TimeZone.getDefault());
        }
        else if(!_instance.getTimeZone().equals(TimeZone.getDefault())){
            _instance = instance(TimeZone.getDefault());
        }
        return _instance;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateFactory that = (DateFactory) o;
        return timeZone.equals(that.timeZone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeZone);
    }

    public static DateBuilder from(DatetimeBuilder date){
        return new DateBuilderImpl(date);
    }
    public static DateBuilder from(DateBuilder date){
        return new DateBuilderImpl(date.asDatetimeBuilder());
    }
    public static DateBuilder from(Date date){
        return new DateBuilderImpl(date);
    }
    public static DateBuilder from(Date date, Build build){
        return new DateBuilderImpl(date,build);
    }
    public static DateBuilder now(){
        return new DateBuilderImpl(DatetimeFactory.instance().now());
    }
    public static DateBuilder raw(){
        return new DateBuilderImpl();
    }
    public static DateBuilder from(Calendar cal){
        return new DateBuilderImpl(cal);
    }
    public static DateBuilder from(Calendar cal, Build build){
        return new DateBuilderImpl(cal,build);
    }
    public static DateBuilder today(){
        return new DateBuilderImpl(DatetimeFactory.instance().now());
    }
    public static DateBuilder from(Long longDate){
        return from(DatetimeFactory.instance().from(longDate));
    }

    public static DatetimeRange rangeOnNow(){
        return DatetimeFactory.instance().now().minDayTime().rangeTo(DatetimeFactory.instance().now().maxDayTime());
    }
    public static DatetimeRange rangeOn(DateBuilder dateBuilder){
        return dateBuilder.rangeToSelf();
    }
    public static DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder){
        return datetimeBuilder.rangeToSelf();
    }
    public static DatetimeRange rangeOn(Date date){
        return rangeOn(DateFactory.from(date));
    }
    public static DatetimeRange rangeOn(Long dateLong){
        return rangeOn(DateFactory.from(dateLong));
    }
    public static DatetimeRange rangeOn(Calendar cal){
        return rangeOn(DateFactory.from(cal));
    }

    public static DateFormatBuilder format(){
        return DateFormatBuilderImpl.get();
    }

    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, E parent){
        if(parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Date date, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date,(DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(),build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T raw(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(DateFactory.raw().asCalendar(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Calendar cal, Build build, E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal,build,(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T,E>,E extends EditModeStatus<F>,F extends Object> T now(E parent){
        if(parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(),(DatetimeRange) parent);
        }
        return null;
    }
    public static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>,E extends EditModeStatus<F>,F extends Object> T from(Long longDate, E parent){
        return (T) from(new Date(longDate),parent);
    }
}
