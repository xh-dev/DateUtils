package me.xethh.utils.dateUtils.datetimeFactory;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.interfaces.DatetimeBackWrapper;
import me.xethh.utils.dateUtils.interfaces.EditModeStatus;
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

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Date date, E parent) {
        if (parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date, (DatetimeRange) parent);
        return null;
    }

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Date date, Build build, E parent) {
        if (parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date, (DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(), build, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Calendar cal, E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Calendar cal, Build build, E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal, build, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T now(E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(), (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Long longDate, E parent) {
        return (T) from(new Date(longDate), parent);
    }

    static void addDatetimeMap(DatetimeFactory factory) {
        if (factoryMap.get(factory.getTimezone()) == null)
            factoryMap.put(factory.getTimezone(), factory);
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

    <T extends DatetimeBuilderInterface<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T raw(E parent);

}
