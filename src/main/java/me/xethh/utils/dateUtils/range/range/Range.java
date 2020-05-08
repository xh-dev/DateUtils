package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.interfaces.EditModeStatus;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;

public abstract class Range implements
        EditModeStatus<Range.EDITING>,
        RangeValidator,
        TimeRangeOperation,
        BackWrapper<DatetimeRangeContainedBuilder, DatetimeRange>,
        DatetimeRangeRepresentation {
    public enum EDITING {
        NONE, START, END
    }

    @Override
    public EDITING getEditingMode() {
        return editing;
    }

    @Override
    public EDITING clearEditingMode() {
        this.editing = EDITING.NONE;
        return editing;
    }

    protected EDITING editing;
}
