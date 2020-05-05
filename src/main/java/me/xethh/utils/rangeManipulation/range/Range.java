package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.rangeManipulation.DatetimeRange;

public abstract class Range implements EditModeStatus<DatetimeRange.EDITING> {
    public static enum EDITING{
        NONE,START,END
    }
    @Override
    public EDITING getEditingMode() {
        return editing;
    }
    @Override
    public EDITING clearEditingMode() {
        this.editing=EDITING.NONE;
        return editing;
    }
    protected EDITING editing;
}
