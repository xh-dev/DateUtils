package me.xethh.utils.rangeManipulation;

import me.xethh.utils.wrapper.Optional;
import me.xethh.utils.wrapper.Tuple4;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class RangeComparingInclusiveDateTimeImpl extends RangeComparing{
    private DateRange range;
    private RangeComparingInclusiveDateTimeImpl(DateRange range1){
        this.range = range1;
    }

    public static RangeComparing of(DateRange range){
        return new RangeComparingInclusiveDateTimeImpl(range);
    }

    public boolean overlapping(DateRange newRange){
        return
                range.compareToPoint().onRange(newRange.start) ||
                range.compareToPoint().onRange(newRange.end) ||
                newRange.compareToPoint().onRange(range.start) ||
                newRange.compareToPoint().onRange(range.end)
                ;
    }

    public boolean connecting(DateRange newRange){
        return overlapping(newRange) && (range.compareToPoint().onEndPoint(newRange.start) || newRange.compareToPoint().onEndPoint(range.start));
    }

    public boolean sameStartPoint(DateRange newRange){
        return range.start.getTime()==newRange.start.getTime();
    }

    public boolean sameEndPoint(DateRange newRange){
        return range.end.getTime()==newRange.end.getTime();
    }

    public boolean covering(DateRange newRange){
        return range.compareToPoint().onRange(newRange.start) && range.compareToPoint().onRange(newRange.end);
    }

    public boolean coveredBy(DateRange newRange){
        return newRange.compareToPoint().onRange(range.start) && newRange.compareToPoint().onRange(range.end);
    }

    public OverlapType overlapType(DateRange newRange){
        if(!overlapping(newRange))
            return OverlapType.Separated;
        else if(range.equals(newRange))
            return OverlapType.Same;
        else if(sameStartPoint(newRange))
            return OverlapType.OverlapOnLeft;
        else if(sameEndPoint(newRange))
            return OverlapType.OverlapOnRight;
        else if(covering(newRange))
            return OverlapType.Covering;
        else if(coveredBy(newRange))
            return OverlapType.Covered;
        else if(connecting(newRange))
            return OverlapType.Connected;
        else
            return OverlapType.Overlap;
    }

    public boolean arrivedFirst(DateRange newRange){
        return range.start.getTime()<newRange.start.getTime();
    }

    public boolean arrivedLater(DateRange newRange){
        return range.start.getTime()>newRange.start.getTime();
    }

    public boolean arrivedSameTime(DateRange newRange){
        return range.start.getTime()==newRange.start.getTime();
    }

    @Override
    public boolean endFirst(DateRange newRange) {
        return range.end.getTime()<newRange.end.getTime();
    }

    @Override
    public boolean endLater(DateRange newRange) {
        return range.end.getTime()>newRange.end.getTime();
    }

    @Override
    public boolean endSameTime(DateRange newRange) {
        return range.end.getTime()==newRange.end.getTime();
    }

    public Tuple4<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>> split(DateRange newRange){
        switch (overlapType(newRange)){
            case Separated:
                return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                        OverlapType.Separated,
                        Optional.EMPTY,
                        Optional.EMPTY,
                        Optional.EMPTY);
            case Connected:
                if(arrivedFirst(newRange))
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.Connected,
                            Optional.of(DateRange.of(range.start, range.end)),
                            Optional.EMPTY,
                            Optional.of(DateRange.of(newRange.start,newRange.end))
                            );
                else
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.Connected,
                            Optional.of(DateRange.of(newRange.start,newRange.end)),
                            Optional.EMPTY,
                            Optional.of(DateRange.of(range.start, range.end))
                    );
            case Same:
                return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                        OverlapType.Same,
                        Optional.EMPTY,
                        Optional.of(DateRange.of(range.start, range.end)),
                        Optional.EMPTY);
            case Overlap:
                if(arrivedFirst(newRange))
                    return Tuple4.of(
                            OverlapType.Overlap,
                            Optional.of(DateRange.of(range.start,newRange.start)),
                            Optional.of(DateRange.of(newRange.start, range.end)),
                            Optional.of(DateRange.of(range.end,newRange.end)));
                else
                    return Tuple4.of(
                            OverlapType.Overlap,
                            Optional.of(DateRange.of(newRange.start,range.start)),
                            Optional.of(DateRange.of(range.start, newRange.end)),
                            Optional.of(DateRange.of(newRange.end,range.end)));

            case OverlapOnLeft:
                if(endFirst(newRange))
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.OverlapOnLeft,
                            Optional.EMPTY,
                            Optional.of(DateRange.of(newRange.start, range.end)),
                            Optional.of(DateRange.of(range.end,newRange.end)));
                else
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.OverlapOnLeft,
                            Optional.EMPTY,
                            Optional.of(DateRange.of(newRange.start, newRange.end)),
                            Optional.of(DateRange.of(newRange.end,range.end)));

            case OverlapOnRight:
                if(arrivedFirst(newRange))
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.OverlapOnRight,
                            Optional.of(DateRange.of(range.start,newRange.start)),
                            Optional.of(DateRange.of(newRange.start, newRange.end)),
                            Optional.EMPTY);
                else
                    return Tuple4.<OverlapType,Optional<DateRange>,Optional<DateRange>,Optional<DateRange>>of(
                            OverlapType.OverlapOnRight,
                            Optional.of(DateRange.of(newRange.start,range.start)),
                            Optional.of(DateRange.of(range.start, range.end)),
                            Optional.EMPTY);
            case Covering:
                return Tuple4.of(
                        OverlapType.Covering,
                        Optional.of(DateRange.of(range.start,newRange.start)),
                        Optional.of(DateRange.of(newRange.start, newRange.end)),
                        Optional.of(DateRange.of(newRange.end,range.end)));
            case Covered:
                return Tuple4.of(
                        OverlapType.Covered,
                        Optional.of(DateRange.of(newRange.start,range.start)),
                        Optional.of(DateRange.of(range.start, range.end)),
                        Optional.of(DateRange.of(range.end,newRange.end)));
        }
        throw new RuntimeException("Error while splitting time range %s and %s");

    }
}
