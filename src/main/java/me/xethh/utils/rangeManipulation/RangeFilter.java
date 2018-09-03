package me.xethh.utils.rangeManipulation;

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
