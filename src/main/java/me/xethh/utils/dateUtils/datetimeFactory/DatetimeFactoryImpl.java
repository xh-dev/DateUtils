package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeFactoryImpl implements DatetimeFactory {
    private final TimeZone timeZone;

    public DatetimeFactoryImpl(TimeZone timeZone) {
        this.timeZone = timeZone;
        DatetimeFactory.addDatetimeMap(this);
    }

    @Override
    public DatetimeBuilder from(Date date) {
        return new DatetimeBuilder(timeZone, date);
    }

    @Override
    public DatetimeBuilder from(Date date, Build build) {
        DatetimeBuilder builder = new DatetimeBuilder(timeZone, date);
        return from(builder.asCalendar(), build);
    }

    @Override
    public DatetimeBuilder raw() {
        return new DatetimeBuilder(timeZone);
    }

    @Override
    public DatetimeBuilder now() {
        return new DatetimeBuilder(timeZone, new Date());
    }

    @Override
    public DatetimeBuilder from(Calendar cal) {
        return new DatetimeBuilder(timeZone, cal);
    }

    @Override
    public DatetimeBuilder from(ZonedDateTime cal) {
        return new DatetimeBuilder(cal);
    }

    @Override
    public DatetimeBuilder from(Calendar cal, Build build) {
        return new DatetimeBuilder(timeZone, cal, build);
    }

    @Override
    public DatetimeBuilder from(ZonedDateTime cal, Build build) {
        return new DatetimeBuilder(cal, build);
    }

    @Override
    public DatetimeBuilder from(Long longDate, Build build) {
        return new DatetimeBuilder(timeZone, from(longDate).asCalendar(), build);
    }

    @Override
    public <X extends DatetimeBuilder> DatetimeBuilder from(X db) {
        return new DatetimeBuilder(db.getTimeZone(), db.asCalendar());
    }

    @Override
    public <X extends DateBuilder> DatetimeBuilder from(X db) {
        return new DatetimeBuilder(db.getTimeZone(), db.asCalendar());
    }

    @Override
    public <X extends DatetimeBuilder> DatetimeRange rangeOn(X datetimeBuilder) {
        return datetimeBuilder.rangeToSelf();
    }

    @Override
    public DatetimeRangeContainedBuilder raw(DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(raw().asZonedDateTime(), parent);
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
