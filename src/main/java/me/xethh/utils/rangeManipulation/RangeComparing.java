package me.xethh.utils.rangeManipulation;

import me.xethh.utils.wrapper.Optional;
import me.xethh.utils.wrapper.Tuple4;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public abstract class RangeComparing {
    public abstract boolean overlapping(DateRange newRange);
    public abstract boolean connecting(DateRange newRange);
    public abstract boolean sameStartPoint(DateRange newRange);
    public abstract boolean sameEndPoint(DateRange newRange);
    public abstract boolean covering(DateRange newRange);
    public abstract boolean coveredBy(DateRange newRange);

    public abstract boolean arrivedFirst(DateRange newRange);
    public abstract boolean arrivedLater(DateRange newRange);
    public abstract boolean arrivedSameTime(DateRange newRange);

    public abstract boolean endFirst(DateRange newRange);
    public abstract boolean endLater(DateRange newRange);
    public abstract boolean endSameTime(DateRange newRange);

    public abstract OverlapType overlapType(DateRange newRange);
    public abstract Tuple4<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>> split(DateRange newRange);

    public static RangeComparing inclusiveDate(DateRange range){
        return RangeComparingInclusiveDateTimeImpl.of(range);
    }
}
