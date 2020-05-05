package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.datetimeFactory.DatetimeFactory;

import java.util.Date;

public interface RangeValidator {
    boolean singlePointRange();

    boolean isValid();

    default boolean isInvalid() {
        return !isValid();
    }


}
