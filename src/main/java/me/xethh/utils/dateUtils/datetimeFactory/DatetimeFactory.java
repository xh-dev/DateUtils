package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import static me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactoryData.*;

public interface DatetimeFactory extends
        DatetimeBuilderGenerator,
        DatetimeRangeBuilderGenerator,
        FormatBuilderProvider {

    static DatetimeRange rangeOf(Date start, Date end) {
        return new DatetimeRange(start, end);
    }

    static DatetimeRangeContainedBuilder from(Date date, DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(date, parent);
    }

    static DatetimeRangeContainedBuilder from(Date date, Build build, DatetimeRange parent) {
        DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date, parent);
        return new DatetimeRangeContainedBuilder(builder.asCalendar(), build, parent);
    }

    static DatetimeRangeContainedBuilder from(Calendar cal, DatetimeRange parent) {
        return new DatetimeRangeContainedBuilder(cal, parent);
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

    static void addDatetimeMap(DatetimeFactory factory) {
        factoryMap.putIfAbsent(factory.getTimezone(), factory);
    }

    static DatetimeFactory instance(BaseTimeZone baseTimeZone) {
        return instance(baseTimeZone.timeZone());
    }

    static DatetimeFactory instance(TimeZone timeZone) {
        if (factoryMap.get(timeZone) == null) {
            return new DatetimeFactoryImpl(timeZone);
        } else return factoryMap.get(timeZone);
    }

    static DatetimeFactory instance() {
        if (_instance == null)
            _instance = new DatetimeFactoryImpl(defaultTimezone);
        else if (!_instance.getTimezone().equals(TimeZone.getDefault())) {
            _instance = instance(TimeZone.getDefault());
        }
        return _instance;
    }

    static DatetimeFactory get_instance() {
        return _instance;
    }

    static Map<TimeZone, DatetimeFactory> getFactoryMap() {
        return factoryMap;
    }

    TimeZone getTimezone();

    DatetimeRangeContainedBuilder raw(DatetimeRange parent);

}
