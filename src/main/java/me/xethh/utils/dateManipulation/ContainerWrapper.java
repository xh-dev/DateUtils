package me.xethh.utils.dateManipulation;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public interface ContainerWrapper<X extends ContainerWrapper<X, T>, T extends EditModeStatus> extends DateBuilder<X>{
    T back();
}
