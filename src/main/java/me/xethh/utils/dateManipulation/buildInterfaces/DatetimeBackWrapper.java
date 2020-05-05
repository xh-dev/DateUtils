package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public interface DatetimeBackWrapper<X extends DatetimeBackWrapper<X, T>, T extends EditModeStatus> extends
        DatetimeBuilder<X>,
        BackWrapper<T> {
}
