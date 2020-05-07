package me.xethh.utils.dateManipulation;

import me.xethh.utils.dateManipulation.dateFactory.DateFactory;
import me.xethh.utils.datetimeFactory.DatetimeFactory;

public class DFactory {
    public static DatetimeFactory datetime(){
        return DatetimeFactory.instance();
    }
    public static DateFactory date(){
        return DateFactory.instance();
    }
}
