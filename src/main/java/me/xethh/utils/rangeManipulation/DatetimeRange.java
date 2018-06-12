package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.DateBuilder;
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
}
