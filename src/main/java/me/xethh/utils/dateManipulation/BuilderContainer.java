package me.xethh.utils.dateManipulation;

/**
 * @author xethhung
 * @date 7/19/2018
 */
public interface BuilderContainer<O extends Object>{
    O getEditingMode();
    O clearEditingModo();
}
