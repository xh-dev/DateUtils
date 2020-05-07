package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public interface DatetimeBackWrapper<X extends DatetimeBackWrapper<X, T>, T extends EditModeStatus> extends
        DatetimeBuilder<X>,
        BackWrapper<T> {
}
