package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.DateComparator;
import me.xethh.utils.dateManipulation.DateFormatBuilder;

import java.util.Date;
import java.util.Objects;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class DatetimeRange {

    protected Date start,end;
    private DatetimeRange(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public static DatetimeRange of(Date start, Date end){
        return new DatetimeRange(start,end);
    }

    public boolean isValid(){
        return start.getTime()<end.getTime();
    }

    public boolean isInvalid(){
        return !isValid();
    }

    public DatetimeRange swrap(){
        return new DatetimeRange(end,start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatetimeRange datetimeRange = (DatetimeRange) o;
        return Objects.equals(start, datetimeRange.start) &&
                Objects.equals(end, datetimeRange.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return String.format("DatetimeRange[%s to %s]", DateFormatBuilder.ISO8601.format(start),DateFormatBuilder.ISO8601.format(end));
    }

    public boolean timeInRange(Date date){
        return start.getTime()<=date.getTime() && end.getTime()>=date.getTime();
    }

    public boolean timeAfterRange(Date date){
        return start.getTime()<date.getTime() && end.getTime()<date.getTime();
    }

    public boolean timeBeforeRange(Date date){
        return start.getTime()>date.getTime() && end.getTime()>date.getTime();
    }

    public boolean dateInRange(Date date){
        return minStart().minEnd().timeInRange(DateBuilder.from(date).minDayTime().asDate());
    }

    public boolean dateAfterRange(Date date){
        return minStart().minEnd().timeAfterRange(DateBuilder.from(date).minDayTime().asDate());
    }

    public boolean dateBeforeRange(Date date){
        return minStart().minEnd().timeBeforeRange(DateBuilder.from(date).minDayTime().asDate());
    }

    public DatetimeRange asDateRange(){
        return minStart().minEnd();
    }

    public DatetimeRange minStart(){
        return DatetimeRange.of(DateBuilder.from(start).minDayTime().asDate(),end);
    }

    public DatetimeRange maxStart(){
        return DatetimeRange.of(DateBuilder.from(start).maxDayTime().asDate(),end);
    }

    public DatetimeRange minEnd(){
        return DatetimeRange.of(start,DateBuilder.from(end).minDayTime().asDate());
    }

    public DatetimeRange maxEnd(){
        return DatetimeRange.of(start,DateBuilder.from(end).maxDayTime().asDate());
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public boolean overlapping(DatetimeRange range){
        if(range==null || range.isInvalid() || isInvalid())
            return false;
        if(DateBuilder.from(start).asComparator().beforeEqual(range.start) && DateBuilder.from(end).asComparator().laterEqualThan(range.end))
            return true;
        if(DateBuilder.from(range.start).asComparator().beforeEqual(start) && DateBuilder.from(range.end).asComparator().laterEqualThan(end))
            return true;
        if(DateBuilder.from(start).asComparator().beforeEqual(range.start) && DateBuilder.from(end).asComparator().laterEqualThan(range.start))
            return true;
        if(DateBuilder.from(range.start).asComparator().beforeEqual(start) && DateBuilder.from(range.end).asComparator().laterEqualThan(start))
            return true;
        return false;
    }

    public OverlapType overlappingPattern(DatetimeRange range){
        if(range==null)
            return OverlapType.TargetIsNull;

        DateComparator startComparator = DateBuilder.from(start).asComparator();
        DateComparator endComparator = DateBuilder.from(end).asComparator();

        DateComparator targetStartComparator = DateBuilder.from(range.start).asComparator();
        DateComparator targetEndComparator = DateBuilder.from(range.end).asComparator();

        if(range.isInvalid())
            return OverlapType.TargetInvalid;
        else if(isInvalid())
            return OverlapType.Invalid;
        else if(startComparator.sameDatetime(range.start) && endComparator.sameDatetime(range.end))
            return OverlapType.Same;
        else if(startComparator.beforeEqual(range.start) && endComparator.laterEqualThan(range.end)) {
            if(startComparator.sameDatetime(range.start))
                return OverlapType.CoveringOnLeft;
            else if(endComparator.sameDatetime(range.end))
                return OverlapType.CoveringOnRight;
            else return OverlapType.Covering;
        }
        else if(targetStartComparator.beforeEqual(start) && targetEndComparator.laterEqualThan(end)) {
            if(targetStartComparator.sameDatetime(start))
                return OverlapType.CoveredOnLeft;
            else if(targetEndComparator.sameDatetime(end))
                return OverlapType.CoveredOnRight;
            else return OverlapType.CoveredBy;
        }
        else if(startComparator.beforeEqual(range.start) && endComparator.laterEqualThan(range.start)) {
            if (end.getTime() == range.start.getTime())
                return OverlapType.JoinOnRight;
            else
                return OverlapType.OverLapOnRight;
        }
        else if(targetStartComparator.beforeEqual(start) && targetEndComparator.laterEqualThan(start)){
            if(start.getTime()==range.end.getTime())
                return OverlapType.JoinOnLeft;
            else
                return OverlapType.OverlapOnLef;
        }
        else if(startComparator.laterThan(range.end))
            return OverlapType.ComesLater;
        else
            return OverlapType.ComesFirst;

    }

}
