package me.xethh.utils.rangeManipulation.range;

import java.util.Date;

public interface TimeRangeOperation {

    boolean timeInRange(Date date);

    boolean timeAfterRange(Date date);

    boolean timeBeforeRange(Date date);

}
