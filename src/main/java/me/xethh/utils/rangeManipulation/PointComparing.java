package me.xethh.utils.rangeManipulation;

import me.xethh.utils.wrapper.Optional;
import me.xethh.utils.wrapper.Tuple2;

import java.util.Date;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class PointComparing {
    private DateRange range;
    private PointComparing(DateRange range){
        this.range = range;
    }

    public static PointComparing of(DateRange range){
        return new PointComparing(range);
    }

    public boolean onRange(Date point){
        return range.start.getTime()<=point.getTime() && range.end.getTime()>=point.getTime();
    }

    public boolean onStartingPoint(Date point){
        return range.start.getTime()==point.getTime();
    }

    public boolean onEndPoint(Date point){
        return range.end.getTime()==point.getTime();
    }

    public boolean onSide(Date point){
        return onStartingPoint(point) || onEndPoint(point);
    }

    public Tuple2<Optional<DateRange>,Optional<DateRange>> split(Date point){
        if(onRange(point)){
            if(onStartingPoint(point))
                return Tuple2.<Optional<DateRange>,Optional<DateRange>>of(Optional.EMPTY,Optional.of(DateRange.of(range.start,range.end)));
            else if(onEndPoint(point))
                return Tuple2.<Optional<DateRange>,Optional<DateRange>>of(Optional.of(DateRange.of(range.start,range.end)),Optional.EMPTY);
            else
                return Tuple2.of(Optional.of(DateRange.of(range.start,point)),Optional.of(DateRange.of(point,range.end)));
        }
        else
            return Tuple2.<Optional<DateRange>,Optional<DateRange>>of(Optional.EMPTY,Optional.EMPTY);
    }

    public DateRange getRange() {
        return range;
    }
}
