package me.xethh.utils.dateUtils.range.range;

public interface RangeValidator {
    boolean singlePointRange();

    boolean isValid();

    default boolean isInvalid() {
        return !isValid();
    }


}
