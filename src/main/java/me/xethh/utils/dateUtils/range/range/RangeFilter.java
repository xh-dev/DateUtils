package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.range.OverlapType;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;

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
