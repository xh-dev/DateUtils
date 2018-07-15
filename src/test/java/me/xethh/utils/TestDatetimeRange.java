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
public class TestDatetimeRange
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void baseTest(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DatetimeRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]",DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).toString());
        assertEquals("DatetimeRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]",DatetimeRange.of(builder.addDays(30).asDate(),builder.asDate()).toString());
    }

    @Test
    public void testIsValid(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isInvalid());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isInvalid());
    }

    @Test
    public void testTimeRange(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isValid());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.asDate()).isValid());
    }

    @Test
    public void testTimeRangeSinglePoint(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).singlePointRange());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).singlePointRange());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.asDate()).singlePointRange());
    }

    @Test
    public void testTimeRangeOperateDaytime(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(builder.rangeTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).asDate()));
        assertNotEquals(builder.rangeTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).addMins(2).asDate()));
    }

    @Test
    public void testOverlap(){
        DateBuilder start11 = DateBuilder.raw().year(2018).month(Month.JAN).day(10).minDayTime();
        DateBuilder start12 = start11.addDays(5);
        DateBuilder start21 = start11.addDays(5).addDays(3);
        DateBuilder start22 = start11.addDays(5).addDays(3).addDays(3);
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

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-2).rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeTo(start12.addDays(2).asDate()))==OverlapType.CoveredBy
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-2).rangeTo(start12.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeTo(start12.asDate()))==OverlapType.CoveredOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.rangeTo(start12.addDays(2).asDate()))==OverlapType.CoveredOnLeft
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(1).rangeTo(start12.asDate())));
        assertEquals(true,start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.addDays(1).rangeTo(start12.asDate()))==OverlapType.CoveringOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.addDays(-1).asDate())));
        assertEquals(true,start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.rangeTo(start12.addDays(-1).asDate()))==OverlapType.CoveringOnLeft
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(2).rangeTo(start12.addDays(-2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(2).rangeTo(start12.addDays(-2).asDate()))==OverlapType.Covering
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start12.rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.rangeTo(start12.addDays(2).asDate()))==OverlapType.JoinOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start12.addDays(-1).rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.addDays(-1).rangeTo(start12.addDays(2).asDate()))==OverlapType.OverLapOnRight
        );

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-1).rangeTo(start11.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeTo(start11.asDate()))==OverlapType.JoinOnLeft);

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-1).rangeTo(start11.addDays(1).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeTo(start11.addDays(1).asDate()))==OverlapType.OverlapOnLeft);

        assertEquals(true,start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12)));
        assertEquals(true,start11.rangeTo(start12.asDate()).overlappingPattern(start11.rangeTo(start12))==OverlapType.Same);
    }
}