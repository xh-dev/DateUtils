package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.*;

import java.util.Date;
import java.util.Objects;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class DatetimeRange implements BuilderContainer<DatetimeRange.EDITING> {
    @Override
    public EDITING getEditingMode() {
        return editing;
    }
    @Override
    public EDITING clearEditingModo() {
        this.editing=EDITING.NONE;
        return editing;
    }
    public static enum EDITING{
        NONE,START,END
    }
    private EDITING editing;

    protected Date start,end;
    private DatetimeRange(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public static DatetimeRange of(Date start, Date end){
        return new DatetimeRange(start,end);
    }

    public boolean singlePointRange(){
        return start.getTime()==end.getTime();
    }

    public boolean isValid(){
        return start.getTime()<=end.getTime();
    }

    public boolean isInvalid(){
        return !isValid();
    }

    public DatetimeRange swrap(){
        return new DatetimeRange(end,start);
    }

    public DatetimeRangeContainedBuilder editStart(){
        this.editing=EDITING.START;
        return DateBuilderFactory.from(getStart(),this);
    }
    public DatetimeRangeContainedBuilder editEnd(){
        this.editing=EDITING.END;
        return DateBuilderFactory.from(getEnd(),this);
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
        return minStart().minEnd().timeInRange(DateBuilderFactory.from(date).minDayTime().asDate());
    }

    public boolean dateAfterRange(Date date){
        return minStart().minEnd().timeAfterRange(DateBuilderFactory.from(date).minDayTime().asDate());
    }

    public boolean dateBeforeRange(Date date){
        return minStart().minEnd().timeBeforeRange(DateBuilderFactory.from(date).minDayTime().asDate());
    }

    public DatetimeRange asDateRange(){
        return minStart().minEnd();
    }

    public DatetimeRange minStart(){
        return DatetimeRange.of(DateBuilderFactory.from(start).minDayTime().asDate(),end);
    }

    public DatetimeRange maxStart(){
        return DatetimeRange.of(DateBuilderFactory.from(start).maxDayTime().asDate(),end);
    }

    public DatetimeRange minEnd(){
        return DatetimeRange.of(start,DateBuilderFactory.from(end).minDayTime().asDate());
    }

    public DatetimeRange maxEnd(){
        return DatetimeRange.of(start,DateBuilderFactory.from(end).maxDayTime().asDate());
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
        if(DateBuilderFactory.from(start).beforeEqual(range.start) && DateBuilderFactory.from(end).laterEqualThan(range.end))
            return true;
        if(DateBuilderFactory.from(range.start).beforeEqual(start) && DateBuilderFactory.from(range.end).laterEqualThan(end))
            return true;
        if(DateBuilderFactory.from(start).beforeEqual(range.start) && DateBuilderFactory.from(end).laterEqualThan(range.start))
            return true;
        if(DateBuilderFactory.from(range.start).beforeEqual(start) && DateBuilderFactory.from(range.end).laterEqualThan(start))
            return true;
        return false;
    }

    public OverlapType overlappingPattern(DatetimeRange range){
        if(range==null)
            return OverlapType.TargetIsNull;

        DateBuilder startComparator = DateBuilderFactory.from(start);
        DateBuilder endComparator = DateBuilderFactory.from(end);

        DateBuilder targetStartComparator = DateBuilderFactory.from(range.start);
        DateBuilder targetEndComparator = DateBuilderFactory.from(range.end);

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
                return OverlapType.OverlapOnLeft;
        }
        else if(startComparator.laterThan(range.end))
            return OverlapType.ComesLater;
        else
            return OverlapType.ComesFirst;

    }

}
