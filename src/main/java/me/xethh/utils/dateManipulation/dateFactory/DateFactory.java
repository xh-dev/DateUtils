package me.xethh.utils.dateManipulation.dateFactory;

import me.xethh.utils.dateManipulation.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeBackWrapper;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static me.xethh.utils.dateManipulation.dateFactory.DateFactoryData._instance;

public interface DateFactory extends
        DateBuilderGenerator,
        DateRangeBuilderGenerator {
    TimeZone getTimezone();

    static DateFormatBuilder format() {
        return DateFormatBuilderImpl.get();
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Date date, E parent) {
        if (parent instanceof DatetimeRange)
            return (T) new DatetimeRangeContainedBuilder(date, (DatetimeRange) parent);
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Date date, Build build, E parent) {
        if (parent instanceof DatetimeRange) {
            DatetimeRangeContainedBuilder builder = new DatetimeRangeContainedBuilder(date, (DatetimeRange) parent);
            return (T) new DatetimeRangeContainedBuilder(builder.asCalendar(), build, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T raw(E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(DateFactory.instance().raw().asCalendar(), (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Calendar cal, E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Calendar cal, Build build, E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(cal, build, (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T now(E parent) {
        if (parent instanceof DatetimeRange) {
            return (T) new DatetimeRangeContainedBuilder(new Date(), (DatetimeRange) parent);
        }
        return null;
    }

    static <T extends DatetimeBuilder<T> & DatetimeBackWrapper<T, E>, E extends EditModeStatus<F>, F extends Object> T from(Long longDate, E parent) {
        return (T) from(new Date(longDate), parent);
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
}
