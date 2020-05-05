package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.OverlapType;
import me.xethh.utils.rangeManipulation.datetime.AcceptingFilter;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.rangeManipulation.datetime.RejectingFilter;

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
