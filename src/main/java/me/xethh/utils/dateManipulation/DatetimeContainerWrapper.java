package me.xethh.utils.dateManipulation;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public interface DatetimeContainerWrapper<X extends DatetimeContainerWrapper<X, T>, T extends EditModeStatus> extends DatetimeBuilder<X>, ContainerWrapper<T>{
}
