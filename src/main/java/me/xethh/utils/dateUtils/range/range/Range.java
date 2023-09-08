package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.interfaces.EDITING;
import me.xethh.utils.dateUtils.interfaces.EditModeStatus;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

public abstract class Range implements
        EditModeStatus<EDITING>,
        RangeValidator,
        TimeRangeOperation,
        BackWrapper<DatetimeRangeContainedBuilder, DatetimeRange>,
        DatetimeRangeRepresentation {
    protected EDITING editing;

    @Override
    public EDITING getEditingMode() {
        return editing;
    }

    @Override
    public EDITING clearEditingMode() {
        this.editing = EDITING.NONE;
        return editing;
    }

}
