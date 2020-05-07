package me.xethh.utils.dateManipulation.dateFactory;

import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DateFactoryImpl implements DateFactory {
    protected DateFactoryImpl(TimeZone timezone) {
        this.timeZone = timezone;
    }

    private TimeZone timeZone;

    public TimeZone getTimezone() {
        return timeZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateFactory that = (DateFactory) o;
        return timeZone.equals(that.getTimezone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeZone);
    }

    @Override
    public DateBuilder from(DatetimeBuilder date) {
        return new DateBuilderImpl(date);
    }

    @Override
    public DateBuilder from(DateBuilder date) {
        return new DateBuilderImpl(date.asDatetimeBuilder());
    }

    @Override
    public DateBuilder from(Date date) {
        return new DateBuilderImpl(date);
    }

    @Override
    public DateBuilder from(Date date, Build build) {
        return new DateBuilderImpl(date, build);
    }

    @Override
    public DateBuilder now() {
        return new DateBuilderImpl(DatetimeFactory.instance().now());
    }

    @Override
    public DateBuilder raw() {
        return new DateBuilderImpl();
    }

    @Override
    public DateBuilder from(Calendar cal) {
        return new DateBuilderImpl(cal);
    }

    @Override
    public DateBuilder from(Calendar cal, Build build) {
        return new DateBuilderImpl(cal, build);
    }

    @Override
    public DateBuilder from(Long longDate, Build build) {
        return new DateBuilderImpl(new Date(longDate),build);
    }

    @Override
    public DateBuilder today() {
        return new DateBuilderImpl(DatetimeFactory.instance().now());
    }

    @Override
    public DatetimeRange rangeOnNow() {
        return DatetimeFactory.instance().now().minDayTime().rangeTo(DatetimeFactory.instance().now().maxDayTime());
    }

    @Override
    public DatetimeRange rangeOn(DateBuilder dateBuilder) {
        return dateBuilder.rangeToSelf();
    }

    public DatetimeRange rangeOn(DatetimeBuilder datetimeBuilder) {
        return datetimeBuilder.rangeToSelf();
    }

    @Override
    public DatetimeRange rangeOn(Date date) {
        return rangeOn(DateFactory.instance().from(date));
    }

    @Override
    public DatetimeRange rangeOn(Long dateLong) {
        return rangeOn(DateFactory.instance().from(dateLong));
    }

    @Override
    public DatetimeRange rangeOn(Calendar cal) {
        return rangeOn(DateFactory.instance().from(cal));
    }

}
