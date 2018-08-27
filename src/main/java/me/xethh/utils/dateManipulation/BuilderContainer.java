package me.xethh.utils.dateManipulation;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public interface BuilderContainer<O extends Object>{
    O getEditingMode();
    O clearEditingModo();
}
