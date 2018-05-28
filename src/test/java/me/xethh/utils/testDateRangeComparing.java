package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DateRange;
import me.xethh.utils.rangeManipulation.OverlapType;
import me.xethh.utils.rangeManipulation.PointComparing;
import me.xethh.utils.wrapper.Optional;
import me.xethh.utils.wrapper.Tuple2;
import me.xethh.utils.wrapper.Tuple4;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class testDateRangeComparing
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void testPointComparing(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        DateRange range1 = DateRange.of(builder.build(),builder.operate().addDays(10).asDate());
        DateRange range2 = DateRange.of(builder.operate().addDays(-3).asDate(),builder.operate().addDays(3).asDate());
        DateRange range3 = DateRange.of(builder.build(),builder.operate().addDays(13).asDate());
        DateRange range4 = DateRange.of(builder.operate().addDays(10).asDate(),builder.operate().addDays(18).asDate());
        DateRange range5 = DateRange.of(builder.operate().addDays(-2).asDate(),builder.build());
        DateRange range6 = DateRange.of(builder.operate().addDays(-2).asDate(),builder.operate().addDays(12).asDate());
        DateRange range7 = DateRange.of(builder.operate().addDays(2).asDate(),builder.operate().addDays(10).asDate());
        DateRange range8 = DateRange.of(builder.operate().addDays(-10).asDate(),builder.operate().addMS(-1).asDate());
        DateRange range9 = DateRange.of(builder.build(),builder.operate().addDays(10).asDate());

        assertEquals(true,range1.compareToRange().arrivedLater(range2));
        assertEquals(false,range1.compareToRange().arrivedFirst(range2));
        assertEquals(false,range1.compareToRange().arrivedSameTime(range2));

        assertEquals(false,range1.compareToRange().arrivedFirst(range3));
        assertEquals(false,range1.compareToRange().arrivedLater(range3));
        assertEquals(true,range1.compareToRange().arrivedSameTime(range3));

        assertEquals(true,range1.compareToRange().connecting(range4));
        assertEquals(true,range1.compareToRange().connecting(range5));
        assertEquals(false,range1.compareToRange().connecting(range3));

        assertEquals(true,range1.compareToRange().coveredBy(range6));
        assertEquals(false,range1.compareToRange().coveredBy(range2));
        assertEquals(true,range1.compareToRange().coveredBy(range3));
        assertEquals(false,range1.compareToRange().coveredBy(range4));

        assertEquals(true,range6.compareToRange().covering(range1));
        assertEquals(false,range1.compareToRange().covering(range2));
        assertEquals(true,range3.compareToRange().covering(range1));
        assertEquals(false,range1.compareToRange().covering(range4));
        assertEquals(true,range1.compareToRange().covering(range7));

        assertEquals(true,range1.compareToRange().overlapping(range2));
        assertEquals(true,range1.compareToRange().overlapping(range3));
        assertEquals(true,range1.compareToRange().overlapping(range4));
        assertEquals(true,range1.compareToRange().overlapping(range5));
        assertEquals(true,range1.compareToRange().overlapping(range6));
        assertEquals(true,range1.compareToRange().overlapping(range7));
        assertEquals(false,range1.compareToRange().overlapping(range8));

        assertEquals(true,range1.compareToRange().sameEndPoint(range7));
        assertEquals(false,range1.compareToRange().sameEndPoint(range3));

        assertEquals(true,range1.compareToRange().sameStartPoint(range3));
        assertEquals(false,range1.compareToRange().sameStartPoint(range5));

        assertEquals(OverlapType.Separated,range1.compareToRange().overlapType(range8));
        assertEquals(OverlapType.Connected,range1.compareToRange().overlapType(range4));
        assertEquals(OverlapType.Connected,range1.compareToRange().overlapType(range5));
        assertEquals(OverlapType.Same,range1.compareToRange().overlapType(range9));
        assertEquals(OverlapType.Overlap,range1.compareToRange().overlapType(range2));
        assertEquals(OverlapType.OverlapOnLeft,range1.compareToRange().overlapType(range3));
        assertEquals(OverlapType.OverlapOnRight,range1.compareToRange().overlapType(range7));
        assertEquals(OverlapType.Covered,range7.compareToRange().overlapType(range6));
        assertEquals(OverlapType.Covering,range6.compareToRange().overlapType(range7));

        assertEquals(Tuple4.of(OverlapType.Separated,Optional.EMPTY,Optional.EMPTY,Optional.EMPTY),range1.compareToRange().split(range8));
        assertEquals(Tuple4.of(OverlapType.Connected,Optional.of(range1),Optional.EMPTY,Optional.of(range4)),range1.compareToRange().split(range4));
        assertEquals(Tuple4.of(OverlapType.Connected,Optional.of(range5),Optional.EMPTY,Optional.of(range1)),range1.compareToRange().split(range5));
        assertEquals(Tuple4.of(OverlapType.Same,Optional.EMPTY,Optional.of(range1),Optional.EMPTY),range1.compareToRange().split(range9));
        assertEquals(Tuple4.of(OverlapType.Same,Optional.EMPTY,Optional.of(range9),Optional.EMPTY),range1.compareToRange().split(range9));
        assertEquals(Tuple4.of(
                OverlapType.Overlap,
                Optional.of(DateRange.of(range2.getStart(),range1.getStart())),
                Optional.of(DateRange.of(range1.getStart(),range2.getEnd())),
                Optional.of(DateRange.of(range2.getEnd(),range1.getEnd())))
                ,range1.compareToRange().split(range2));
        assertEquals(Tuple4.of(
                OverlapType.Overlap,
                Optional.of(DateRange.of(range2.getStart(),range1.getStart())),
                Optional.of(DateRange.of(range1.getStart(),range2.getEnd())),
                Optional.of(DateRange.of(range2.getEnd(),range1.getEnd())))
                ,range2.compareToRange().split(range1));
        assertEquals(Tuple4.of(
                OverlapType.OverlapOnLeft,
                Optional.EMPTY,
                Optional.of(DateRange.of(range1.getStart(),range1.getEnd())),
                Optional.of(DateRange.of(range1.getEnd(),range3.getEnd())))
                ,range1.compareToRange().split(range3));
        assertEquals(Tuple4.of(
                OverlapType.OverlapOnLeft,
                Optional.EMPTY,
                Optional.of(DateRange.of(range1.getStart(),range1.getEnd())),
                Optional.of(DateRange.of(range1.getEnd(),range3.getEnd())))
                ,range3.compareToRange().split(range1));
        assertEquals(Tuple4.of(
                OverlapType.OverlapOnRight,
                Optional.of(DateRange.of(range1.getStart(),range7.getStart())),
                Optional.of(DateRange.of(range7.getStart(),range7.getEnd())),
                Optional.EMPTY
                )
                ,range1.compareToRange().split(range7));
        assertEquals(Tuple4.of(
                OverlapType.OverlapOnRight,
                Optional.of(DateRange.of(range1.getStart(),range7.getStart())),
                Optional.of(DateRange.of(range7.getStart(),range1.getEnd())),
                Optional.EMPTY
                )
                ,range7.compareToRange().split(range1));
        assertEquals(Tuple4.of(
                OverlapType.Covered,
                Optional.of(DateRange.of(range6.getStart(),range7.getStart())),
                Optional.of(DateRange.of(range7.getStart(),range7.getEnd())),
                Optional.of(DateRange.of(range7.getEnd(),range6.getEnd()))
                )
                ,range7.compareToRange().split(range6));
        assertEquals(Tuple4.of(
                OverlapType.Covering,
                Optional.of(DateRange.of(range6.getStart(),range7.getStart())),
                Optional.of(DateRange.of(range7.getStart(),range7.getEnd())),
                Optional.of(DateRange.of(range7.getEnd(),range6.getEnd()))
                )
                ,range6.compareToRange().split(range7));
    }

}
