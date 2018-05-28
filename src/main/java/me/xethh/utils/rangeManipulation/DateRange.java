package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.DateFormatBuilder;

import java.util.Date;
import java.util.Objects;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class DateRange {

    protected Date start,end;
    private DateRange(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public static DateRange of(Date start, Date end){
        return new DateRange(start,end);
    }

    public boolean isValid(){
        return start.getTime()<end.getTime();
    }

    public DateRange swrap(){
        return new DateRange(end,start);
    }

    public PointComparing compareToPoint(){
        return PointComparing.of(DateRange.of(start,end));
    }

    public RangeComparing compareToRange(){
        return RangeComparing.inclusiveDate(DateRange.of(start,end));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateRange dateRange = (DateRange) o;
        return Objects.equals(start, dateRange.start) &&
                Objects.equals(end, dateRange.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return String.format("DateRange[%s to %s]", DateFormatBuilder.ISO8601.format(start),DateFormatBuilder.ISO8601.format(end));
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
