package me.xethh.utils;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import me.xethh.utils.rangeManipulation.OverlapType;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static me.xethh.utils.dateManipulation.Month.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestDatetimeRange
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void baseTest(){
        DatetimeBuilder builder = DatetimeFactory.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DatetimeRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]",DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).toString());
        assertEquals("DatetimeRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]",DatetimeRange.of(builder.addDays(30).asDate(),builder.asDate()).toString());
    }

    @Test
    public void testIsValid(){
        DatetimeBuilder builder = DatetimeFactory.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isInvalid());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isInvalid());
    }

    @Test
    public void testTimeRange(){
        DatetimeBuilder builder = DatetimeFactory.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).isValid());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.asDate()).isValid());
    }

    @Test
    public void testTimeRangeSinglePoint(){
        DatetimeBuilder builder = DatetimeFactory.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(30).asDate()).singlePointRange());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.addDays(-30).asDate()).singlePointRange());
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.asDate()).singlePointRange());
    }

    @Test
    public void testTimeRangeOperateDaytime(){
        DatetimeBuilder builder = DatetimeFactory.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(builder.rangeTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).asDate()));
        assertNotEquals(builder.rangeTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).addMins(2).asDate()));
    }

    @Test
    public void testOverlap(){
        DatetimeBuilder start11 = DatetimeFactory.raw().year(2018).month(Month.JAN).day(10).minDayTime();
        DatetimeBuilder start12 = start11.addDays(5);
        DatetimeBuilder start21 = start11.addDays(5).addDays(3);
        DatetimeBuilder start22 = start11.addDays(5).addDays(3).addDays(3);
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

    @Test
    public void testEditWithStartAneEnd(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilderImpl.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20880622-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = range
                .editStart().addDays(-1).addMS(333).back()
                .editEnd().addDays(3).addYear(2).addMonths(2).addMS(222).back();

        assertEquals("20880421-000000333",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900825-000000222",ymdhhmmssSSS.format(range.getEnd()));

        range = range
                .editStart().addDays(-1).addMS(333).back()
                .editEnd().addDays(1).addMS(222).back();

        assertEquals("20880420-000000666",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900826-000000444",ymdhhmmssSSS.format(range.getEnd()));
    }

    @Test
    public void testEditStartAndEndV2(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilderImpl.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20880622-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = range
                .editStart().addYear(1).addMonths(1).addDays(1).addMins(1).addHours(1).addSecond(1).addMS(1).back()
                .editEnd().addYear(2).addMonths(2).addDays(2).addMins(2).addHours(2).addSecond(2).addMS(2).back();

        assertEquals("20890523-010101001",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900824-020202002",ymdhhmmssSSS.format(range.getEnd()));

        range = range
                .editStart().addTime(2000).back()
                .editEnd().addTime(4000).back()
        ;

        assertEquals("20890523-010103001",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900824-020206002",ymdhhmmssSSS.format(range.getEnd()));

    }

    @Test
    public void testRangeTo(){
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilderImpl.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        DatetimeRange range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getEnd()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getStart()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asDate());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getEnd()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getStart()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asLong());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getEnd()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getStart()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asCalendar());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getEnd()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getStart()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asDate());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asLong());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = DatetimeFactory.now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.now().ymd(2018, APR, 15).minDayTime().asCalendar());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20180415-000000000",ymdhhmmssSSS.format(range.getEnd()));
    }

    @Test
    public void testDateRange(){
        DatetimeRange range = DatetimeFactory.raw().ymd(2018, NOV, 3).hmsms(22, 23, 44, 888).rangeToSelf()
                .editEnd()
                .addYear(2)
                .addMonths(13)
                .addDays(6)
                .addHours(6)
                .addMins(7)
                .addSecond(24)
                .addMS(10)
                .back();
        SimpleDateFormat formatter = DateFormatBuilder.Format.FULL_DATETIME.getFormatter();
        assertEquals("2018-11-03 22:23:44.888",formatter.format(range.getStart()));
        assertEquals("2018-11-03 22:23:44.888",range.startAsDTBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-11-03 00:00:00.000",range.startAsDateBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));

        // assertEquals("2020-11-03 22:23:44.888",formatter.format(range.getEnd()));
        assertEquals("2021-12-10 04:31:08.898",formatter.format(range.getEnd()));
        // assertEquals("2022-01-10 02:23:44.888",range.startAsDTBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));
        // assertEquals("2022-01-10 00:00:00.000",range.startAsDateBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));

    }
}
