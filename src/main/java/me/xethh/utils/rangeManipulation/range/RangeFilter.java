package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.rangeManipulation.OverlapType;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

import java.util.Collection;

/**
 * @author xethhung
 * Created on 8/30/2018
 */
public interface RangeFilter<Filter extends RangeFilter<Filter>> {
    Filter item(OverlapType type);
    Filter items(Collection<OverlapType> types);
    Filter items(OverlapType[] types);
    boolean isAccepted(DatetimeRange newRange);
    boolean isRejected(DatetimeRange newRange);
}
