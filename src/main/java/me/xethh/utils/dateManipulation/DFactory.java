package me.xethh.utils.dateManipulation;

import me.xethh.utils.dateManipulation.date.DateFactory;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;

public class DFactory {
    public static DatetimeFactory datetime(){
        return DatetimeFactory.instance();
    }
    public static DateFactory date(){
        return DateFactory.instance();
    }
}
