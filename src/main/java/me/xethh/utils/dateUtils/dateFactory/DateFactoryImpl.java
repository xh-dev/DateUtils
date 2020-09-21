package me.xethh.utils.dateUtils.dateFactory;

import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DateFactoryImpl implements DateFactory {
    private TimeZone timeZone;

    protected DateFactoryImpl(TimeZone timezone) {
        this.timeZone = timezone;
    }

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
    public <X extends DatetimeBuilder> DateBuilder from(X date) {
        return new DateBuilder(date);
    }

    @Override
    public <X extends DateBuilder> DateBuilder from(X date) {
        return new DateBuilder(date.asDatetimeBuilder());
    }

    @Override
    public DateBuilder from(Date date) {
        return new DateBuilder(date);
    }

    @Override
    public DateBuilder from(Date date, Build build) {
        return new DateBuilder(date, build);
    }

    @Override
    public DateBuilder now() {
        return new DateBuilder(DatetimeFactory.instance().now());
    }

    @Override
    public DateBuilder raw() {
        return new DateBuilder();
    }

    @Override
    public DateBuilder from(Calendar cal) {
        return new DateBuilder(cal);
    }

    @Override
    public DateBuilder from(Calendar cal, Build build) {
        return new DateBuilder(cal, build);
    }

    @Override
    public DateBuilder from(Long longDate, Build build) {
        return new DateBuilder(new Date(longDate), build);
    }

    @Override
    public DateBuilder today() {
        return new DateBuilder(DatetimeFactory.instance().now());
    }

    @Override
    public DatetimeRange rangeOnNow() {
        return DatetimeFactory.instance().now().minDayTime().rangeTo(DatetimeFactory.instance().now().maxDayTime());
    }

    @Override
    public DatetimeRange rangeOn(DateBuilderInterface dateBuilder) {
        return dateBuilder.rangeToSelf();
    }

    public DatetimeRange rangeOn(DatetimeBuilderInterface datetimeBuilder) {
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
