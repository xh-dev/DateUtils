package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.range.OverlapType;
import me.xethh.utils.dateUtils.range.datetime.AcceptingFilter;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.range.datetime.RejectingFilter;

import java.util.Date;

public interface TimeRangeOperation<Self extends TimeRangeOperation<Self>> {

    boolean timeInRange(Date date);

    boolean timeAfterRange(Date date);

    boolean timeBeforeRange(Date date);

    boolean dateInRange(Date date);

    boolean dateAfterRange(Date date);

    boolean dateBeforeRange(Date date);

    Self swrap();

    boolean overlapping(DatetimeRange range);

    OverlapType overlappingPattern(DatetimeRange range);

    RejectingFilter rejecting();

    AcceptingFilter accepting();

}
