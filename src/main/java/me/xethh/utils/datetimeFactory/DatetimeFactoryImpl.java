package me.xethh.utils.datetimeFactory;

import me.xethh.utils.dateManipulation.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeBackWrapper;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.*;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeFactoryImpl implements DatetimeFactory {
    private static DatetimeFactory _instance;
    private TimeZone timeZone;
    private static Map<TimeZone, DatetimeFactory> factoryMap = new WeakHashMap<>();

    public DatetimeFactoryImpl(TimeZone timeZone) {
        this.timeZone = timeZone;
        DatetimeFactory.addDatetimeMap(this);
    }

    @Override
    public DatetimeBuilder from(Date date) {
        return new DatetimeBuilderImpl(timeZone, date);
    }

    @Override
    public DatetimeBuilder from(Date date, Build build) {
        DatetimeBuilderImpl builder = new DatetimeBuilderImpl(timeZone, date);
        return from(builder.asCalendar(), build);
    }

    @Override
    public DatetimeBuilder raw() {
        return new DatetimeBuilderImpl(timeZone);
    }

    @Override
    public DatetimeBuilder now() {
        return new DatetimeBuilderImpl(timeZone, new Date());
    }

    @Override
    public DatetimeBuilder from(Calendar cal) {
        return new DatetimeBuilderImpl(timeZone, cal);
    }

    @Override
    public DatetimeBuilder from(Calendar cal, Build build) {
        return new DatetimeBuilderImpl(timeZone, cal, build);
    }

    @Override
    public DatetimeBuilder from(Long longDate, Build build) {
        return new DatetimeBuilderImpl(timeZone, from(longDate).asCalendar(), build);
    }

    @Override
    public DatetimeBuilder from(DatetimeBuilder db) {
        return new DatetimeBuilderImpl(db.getTimeZone(), db.asCalendar());
    }

    @Override
    public DatetimeBuilder from(DateBuilder db) {
        return new DatetimeBuilderImpl(db.getTimeZone(), db.asCalendar());
    }

    @Override
    public DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder) {
        return datetimeBuilder.rangeToSelf();
    }

    @Override
    public <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T raw(E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(raw().asCalendar(), (DatetimeRange) parent);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatetimeFactory that = (DatetimeFactory) o;
        return timeZone.equals(that.getTimezone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeZone);
    }

    @Override
    public TimeZone getTimezone() {
        return timeZone;
    }
}
