package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.DateBuilderFactory;
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

    public DatetimeRange editStartEndDate(RangeEditByBuilder start, RangeEditByBuilder end){
       return DatetimeRange.of(start.oper(DateBuilderFactory.from(getStart())).asDate(),end.oper(DateBuilderFactory.from(getEnd())).asDate());
    }

    public DatetimeRange editStartDate(RangeEditByBuilder start){
        return DatetimeRange.of(start.oper(DateBuilderFactory.from(getStart())).asDate(),getEnd());
    }
    public DatetimeRange editStartAddYear(int year){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addYear(year).asDate(),getEnd());
    }
    public DatetimeRange editStartAddMonth(int month){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addMonths(month).asDate(),getEnd());
    }
    public DatetimeRange editStartAddDay(int day){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addDays(day).asDate(),getEnd());
    }
    public DatetimeRange editStartAddHour(int hour){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addHours(hour).asDate(),getEnd());
    }
    public DatetimeRange editStartAddMinute(int minute){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addMins(minute).asDate(),getEnd());
    }
    public DatetimeRange editStartAddSecond(int second){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addSecond(second).asDate(),getEnd());
    }
    public DatetimeRange editStartAddMS(int ms){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addMS(ms).asDate(),getEnd());
    }
    public DatetimeRange editStartAddTime(long time){
        return DatetimeRange.of(DateBuilderFactory.from(getStart()).addTime(time).asDate(),getEnd());
    }

    public DatetimeRange editEndDate(RangeEditByBuilder end){
        return DatetimeRange.of(getStart(),end.oper(DateBuilderFactory.from(getEnd())).asDate());
    }
    public DatetimeRange editEndAddYear(int year){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addYear(year).asDate());
    }
    public DatetimeRange editEndAddMonth(int month){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addMonths(month).asDate());
    }
    public DatetimeRange editEndAddDay(int day){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addDays(day).asDate());
    }
    public DatetimeRange editEndAddHour(int hour){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addHours(hour).asDate());
    }
    public DatetimeRange editEndAddMinute(int minute){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addMins(minute).asDate());
    }
    public DatetimeRange editEndAddSecond(int second){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addSecond(second).asDate());
    }
    public DatetimeRange editEndAddMS(int ms){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addMS(ms).asDate());
    }
    public DatetimeRange editEndAddTime(long time){
        return DatetimeRange.of(getStart(),DateBuilderFactory.from(getEnd()).addTime(time).asDate());
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
