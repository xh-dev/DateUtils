package me.xethh.utils.dateUtils;

import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;

public class D {
    public static DatetimeFactory dt(){
        return DatetimeFactory.instance();
    }
    public static DateFactory d(){
        return DateFactory.instance();
    }
}
