package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import me.xethh.utils.rangeManipulation.OverlapType;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class testDatetimeRange
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void baseTest(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DatetimeRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]",DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).toString());
        assertEquals("DatetimeRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]",DatetimeRange.of(builder.operate().addDays(30).asDate(),builder.asDate()).toString());
    }

    @Test
    public void testIsValid(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.operate().addDays(-30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).isInvalid());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.operate().addDays(-30).asDate()).isInvalid());
    }

    @Test
    public void testTimeRange(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.operate().addDays(-30).asDate()).isValid());
    }

    @Test
    public void testTimeRangeOperateDaytime(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(builder.rangeTo(builder.operate().addDays(2).asBuilder()),DatetimeRange.of(builder.asDate(),builder.operate().addDays(2).asDate()));
        assertNotEquals(builder.rangeTo(builder.operate().addDays(2).asBuilder()),DatetimeRange.of(builder.asDate(),builder.operate().addDays(2).addMins(2).asDate()));
    }

    @Test
    public void testOverlap(){
        DateBuilder start11 = DateBuilder.raw().year(2018).month(Month.JAN).day(10).minDayTime();
        DateBuilder start12 = start11.operate().addDays(5).asBuilder();
        DateBuilder start21 = start11.operate().addDays(5).addDays(3).asBuilder();
        DateBuilder start22 = start11.operate().addDays(5).addDays(3).addDays(3).asBuilder();
        assertEquals(false,start11.rangeTo(start12.asDate()).overlapping(null));
        assertEquals(true,start11.rangeTo(start12.asDate()).overlappingPattern(null)==OverlapType.TargetIsNull);

        assertEquals(false,start11.rangeTo(start12.asDate()).swrap().overlapping(start21.rangeTo(start22.asDate())));
        assertEquals(true,start11.rangeTo(start12.asDate()).swrap().overlappingPattern(start21.rangeTo(start22.asDate()))==OverlapType.Invalid);

        assertEquals(false,start11.rangeTo(start12.asDate()).overlapping(start21.rangeTo(start22.asDate()).swrap()));
        assertEquals(true,start11.rangeTo(start12.asDate()).overlappingPattern(start21.rangeTo(start22.asDate()).swrap())==OverlapType.TargetInvalid);

        assertEquals(false,start11.rangeTo(start12.asDate()).overlapping(start21.rangeTo(start22.asDate())));
        assertEquals(true,start11.rangeTo(start12.asDate()).overlappingPattern(start21.rangeTo(start22.asDate()))==OverlapType.ComesFirst);

        assertEquals(false,start21.rangeTo(start22.asDate()).overlapping(start11.rangeTo(start12.asDate())));
        assertEquals(true,start21.rangeTo(start22.asDate()).overlappingPattern(start11.rangeTo(start12.asDate()))==OverlapType.ComesLater);

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(-2).asBuilder().rangeTo(start12.operate().addDays(2).asBuilder().asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.operate().addDays(-2).asBuilder().rangeTo(start12.operate().addDays(2).asBuilder().asDate()))==OverlapType.CoveredBy
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(-2).asBuilder().rangeTo(start12.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.operate().addDays(-2).asBuilder().rangeTo(start12.asDate()))==OverlapType.CoveredOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.operate().addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.rangeTo(start12.operate().addDays(2).asDate()))==OverlapType.CoveredOnLeft
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(1).asBuilder().rangeTo(start12.asDate())));
        assertEquals(true,start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.operate().addDays(1).asBuilder().rangeTo(start12.asDate()))==OverlapType.CoveringOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.operate().addDays(-1).asBuilder().asDate())));
        assertEquals(true,start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.rangeTo(start12.operate().addDays(-1).asBuilder().asDate()))==OverlapType.CoveringOnLeft
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(2).asBuilder().rangeTo(start12.operate().addDays(-2).asBuilder().asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.operate().addDays(2).asBuilder().rangeTo(start12.operate().addDays(-2).asBuilder().asDate()))==OverlapType.Covering
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start12.rangeTo(start12.operate().addDays(2).asBuilder().asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.rangeTo(start12.operate().addDays(2).asBuilder().asDate()))==OverlapType.JoinOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start12.operate().addDays(-1).asBuilder().rangeTo(start12.operate().addDays(2).asBuilder().asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.operate().addDays(-1).asBuilder().rangeTo(start12.operate().addDays(2).asBuilder().asDate()))==OverlapType.OverLapOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(-1).asBuilder().rangeTo(start11.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.operate().addDays(-1).asBuilder().rangeTo(start11.asDate()))==OverlapType.JoinOnLeft);

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.operate().addDays(-1).asBuilder().rangeTo(start11.operate().addDays(1).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.operate().addDays(-1).asBuilder().rangeTo(start11.operate().addDays(1).asDate()))==OverlapType.OverlapOnLeft);

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12)));
        assertEquals(true,start11.rangeTo(start12.asDate()).overlappingPattern(start11.rangeTo(start12))==OverlapType.Same);
    }
}
