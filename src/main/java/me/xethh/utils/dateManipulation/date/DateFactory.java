package me.xethh.utils.dateManipulation.date;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeContainerWrapper;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DateFactory {

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
        return DatetimeFactory.instance().now().rangeTo(DatetimeFactory.instance().now());
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
            return (T) new DatetimeRangeContainedBuilder(DateFactory.raw().asCalendar(),(DatetimeRange) parent);
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
