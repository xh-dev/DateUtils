package me.xethh.utils.dateManipulation.dateFactory;

import java.util.Map;
import java.util.TimeZone;
import java.util.WeakHashMap;

public class DateFactoryData {
    static DateFactory _instance = null;
    static Map<TimeZone, DateFactory> factoryMap = new WeakHashMap<>();
}
