package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.dateManipulation.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.EditModeStatus;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

public abstract class Range implements
        EditModeStatus<Range.EDITING>,
        RangeValidator,
        TimeRangeOperation,
        BackWrapper<DatetimeRangeContainedBuilder, DatetimeRange>,
        DatetimeRangeRepresentation
{
    public enum EDITING{
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
