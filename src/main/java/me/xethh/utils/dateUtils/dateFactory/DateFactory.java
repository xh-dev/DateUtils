package me.xethh.utils.dateUtils.dateFactory;

import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static me.xethh.utils.dateUtils.dateFactory.DateFactoryData._instance;

public interface DateFactory extends
        DateBuilderGenerator,
        DateRangeBuilderGenerator {
    static DateFormatBuilder format() {
        return DateFormatBuilder.get();
    }

    static DatetimeRangeContainedBuilder from(Date date, DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(date, parent);
    }

    static DatetimeRangeContainedBuilder from(Date date, Build build, DatetimeRange parent) {
        DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date, parent);
        return new DatetimeRangeContainedBuilder(builder.asZonedDateTime(), build, parent);
    }

    static DatetimeRangeContainedBuilder raw(DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(DateFactory.instance().raw().asZonedDateTime(), parent);
    }

    static DatetimeRangeContainedBuilder from(Calendar cal, DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(ZonedDateTime.ofInstant(cal.getTime().toInstant(), cal.getTimeZone().toZoneId()), parent);
    }

    static DatetimeRangeContainedBuilder from(Calendar cal, Build build, DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(cal, build, parent);
    }

    static DatetimeRangeContainedBuilder now(DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(new Date(), parent);
    }

    static DatetimeRangeContainedBuilder from(Long longDate, DatetimeRange parent) {
        return from(new Date(longDate), parent);
    }

    static DateFactory instance(BaseTimeZone baseTimezone) {
        return instance(baseTimezone.timeZone());
    }

    static DateFactory instance(TimeZone timezone) {
        return new DateFactoryImpl(timezone);
    }

    static DateFactory instance() {
        if (_instance == null) {
            return new DateFactoryImpl(TimeZone.getDefault());
        } else if (!_instance.getTimezone().equals(TimeZone.getDefault())) {
            _instance = instance(TimeZone.getDefault());
        }
        return _instance;
    }

    TimeZone getTimezone();
}
