package me.xethh.utils.dateUtils.datetimeFactory;

import java.util.Map;
import java.util.TimeZone;
import java.util.WeakHashMap;

public class DatetimeFactoryData {
    static TimeZone defaultTimezone = TimeZone.getDefault();
    static DatetimeFactory _instance = null;
    static Map<TimeZone, DatetimeFactory> factoryMap = new WeakHashMap<>();
}
