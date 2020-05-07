package me.xethh.utils.rangeManipulation.datetime;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.dateFactory.DateFactory;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.rangeManipulation.OverlapType;
import me.xethh.utils.rangeManipulation.range.Range;

import java.util.Date;
import java.util.Objects;

/**
 * @author xethhung
 * Created on 5/25/2018
 */
public class DatetimeRange extends Range {

    protected Date start, end;

    public DatetimeRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean singlePointRange() {
        return start.getTime() == end.getTime();
    }

    @Override
    public boolean isValid() {
        return start.getTime() <= end.getTime();
    }

    @Override
    public DatetimeRange swrap() {
        return new DatetimeRange(end, start);
    }

    @Override
    public DatetimeRangeContainedBuilder editStart() {
        this.editing = EDITING.START;
        return DatetimeFactory.from(startAsDate(), this);
    }

    @Override
    public DatetimeRangeContainedBuilder editEnd() {
        this.editing = EDITING.END;
        return DatetimeFactory.from(endAsDate(), this);
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
        return String.format("DatetimeRange[%s to %s]", DateFormatBuilderFactory.ISO8601().format(start), DateFormatBuilderFactory.ISO8601().format(end));
    }


    @Override
    public boolean timeInRange(Date date) {
        return start.getTime() <= date.getTime() && end.getTime() >= date.getTime();
    }

    @Override
    public boolean timeAfterRange(Date date) {
        return start.getTime() < date.getTime() && end.getTime() < date.getTime();
    }

    @Override
    public boolean timeBeforeRange(Date date) {
        return start.getTime() > date.getTime() && end.getTime() > date.getTime();
    }

    @Override
    public boolean dateInRange(Date date) {
        return asDateRange().timeInRange(DatetimeFactory.instance().from(date).minDayTime().asDate());
    }

    @Override
    public boolean dateAfterRange(Date date) {
        return asDateRange().timeAfterRange(DatetimeFactory.instance().from(date).minDayTime().asDate());
    }

    @Override
    public boolean dateBeforeRange(Date date) {
        return asDateRange().timeBeforeRange(DatetimeFactory.instance().from(date).minDayTime().asDate());
    }

    @Override
    public DatetimeRange asDateRange() {
        return
                editStart()
                        .minDayTime()
                        .back()
                        .editEnd().minDayTime()
                        .back();
    }

    @Override
    public Date startAsDate() {
        return start;
    }

    @Override
    public Date endAsDate() {
        return end;
    }

    @Override
    public DatetimeBuilder startAsDTBuilder() {
        return DatetimeFactory.instance().from(start);
    }

    @Override
    public DatetimeBuilder endAsDTBuilder() {
        return DatetimeFactory.instance().from(end);
    }

    @Override
    public DateBuilder startAsDateBuilder() {
        return DateFactory.instance().from(start);
    }

    @Override
    public DateBuilder endAsDateBuilder() {
        return DateFactory.instance().from(end);
    }

    @Override
    public boolean overlapping(DatetimeRange range) {
        if (range == null || range.isInvalid() || isInvalid())
            return false;
        if (DatetimeFactory.instance().from(start).beforeEqual(range.start) && DatetimeFactory.instance().from(end).laterEqualThan(range.end))
            return true;
        if (DatetimeFactory.instance().from(range.start).beforeEqual(start) && DatetimeFactory.instance().from(range.end).laterEqualThan(end))
            return true;
        if (DatetimeFactory.instance().from(start).beforeEqual(range.start) && DatetimeFactory.instance().from(end).laterEqualThan(range.start))
            return true;
        if (DatetimeFactory.instance().from(range.start).beforeEqual(start) && DatetimeFactory.instance().from(range.end).laterEqualThan(start))
            return true;
        return false;
    }

    @Override
    public OverlapType overlappingPattern(DatetimeRange range) {
        if (isInvalid())
            return OverlapType.Invalid;
        else if (range == null)
            return OverlapType.TargetIsNull;
        if (range.isInvalid())
            return OverlapType.TargetInvalid;

        DatetimeBuilder startComparator = DatetimeFactory.instance().from(start);
        DatetimeBuilder endComparator = DatetimeFactory.instance().from(end);

        DatetimeBuilder targetStartComparator = DatetimeFactory.instance().from(range.start);
        DatetimeBuilder targetEndComparator = DatetimeFactory.instance().from(range.end);

        if (startComparator.sameDatetime(range.start) && endComparator.sameDatetime(range.end))
            return OverlapType.Same;
        else if (startComparator.beforeEqual(range.start) && endComparator.laterEqualThan(range.end)) {
            if (startComparator.sameDatetime(range.start))
                return OverlapType.CoveringOnLeft;
            else if (endComparator.sameDatetime(range.end))
                return OverlapType.CoveringOnRight;
            else return OverlapType.Covering;
        } else if (targetStartComparator.beforeEqual(start) && targetEndComparator.laterEqualThan(end)) {
            if (targetStartComparator.sameDatetime(start))
                return OverlapType.CoveredOnLeft;
            else if (targetEndComparator.sameDatetime(end))
                return OverlapType.CoveredOnRight;
            else return OverlapType.CoveredBy;
        } else if (startComparator.beforeEqual(range.start) && endComparator.laterEqualThan(range.start)) {
            if (end.getTime() == range.start.getTime())
                return OverlapType.JoinOnRight;
            else
                return OverlapType.OverLapOnRight;
        } else if (targetStartComparator.beforeEqual(start) && targetEndComparator.laterEqualThan(start)) {
            if (start.getTime() == range.end.getTime())
                return OverlapType.JoinOnLeft;
            else
                return OverlapType.OverlapOnLeft;
        } else if (startComparator.laterThan(range.end))
            return OverlapType.ComesLater;
        else
            return OverlapType.ComesFirst;

    }

    @Override
    public RejectingFilter rejecting() {
        return new RejectingFilter(this);
    }

    @Override
    public AcceptingFilter accepting() {
        return new AcceptingFilter(this);
    }

}
