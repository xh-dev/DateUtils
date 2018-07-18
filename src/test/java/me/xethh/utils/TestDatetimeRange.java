package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.DateFormatBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.RangeEditByBuilder;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import me.xethh.utils.rangeManipulation.OverlapType;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static me.xethh.utils.dateManipulation.Month.APR;
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
        assertEquals(builder.rangeFromNowTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).asDate()));
        assertNotEquals(builder.rangeFromNowTo(builder.addDays(2).asDate()),DatetimeRange.of(builder.asDate(),builder.addDays(2).addMins(2).asDate()));
    }

    @Test
    public void testOverlap(){
        DateBuilder start11 = DateBuilder.raw().year(2018).month(Month.JAN).day(10).minDayTime();
        DateBuilder start12 = start11.addDays(5);
        DateBuilder start21 = start11.addDays(5).addDays(3);
        DateBuilder start22 = start11.addDays(5).addDays(3).addDays(3);
        assertEquals(false,start11.rangeFromNowTo(start12.asDate()).overlapping(null));
        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlappingPattern(null)==OverlapType.TargetIsNull);

        assertEquals(false,start11.rangeFromNowTo(start12.asDate()).swrap().overlapping(start21.rangeFromNowTo(start22.asDate())));
        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).swrap().overlappingPattern(start21.rangeFromNowTo(start22.asDate()))==OverlapType.Invalid);

        assertEquals(false,start11.rangeFromNowTo(start12.asDate()).overlapping(start21.rangeFromNowTo(start22.asDate()).swrap()));
        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlappingPattern(start21.rangeFromNowTo(start22.asDate()).swrap())==OverlapType.TargetInvalid);

        assertEquals(false,start11.rangeFromNowTo(start12.asDate()).overlapping(start21.rangeFromNowTo(start22.asDate())));
        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlappingPattern(start21.rangeFromNowTo(start22.asDate()))==OverlapType.ComesFirst);

        assertEquals(false,start21.rangeFromNowTo(start22.asDate()).overlapping(start11.rangeFromNowTo(start12.asDate())));
        assertEquals(true,start21.rangeFromNowTo(start22.asDate()).overlappingPattern(start11.rangeFromNowTo(start12.asDate()))==OverlapType.ComesLater);

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(-2).rangeFromNowTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeFromNowTo(start12.addDays(2).asDate()))==OverlapType.CoveredBy
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(-2).rangeFromNowTo(start12.asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeFromNowTo(start12.asDate()))==OverlapType.CoveredOnRight
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.rangeFromNowTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.rangeFromNowTo(start12.addDays(2).asDate()))==OverlapType.CoveredOnLeft
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(1).rangeFromNowTo(start12.asDate())));
        assertEquals(true,start11.rangeFromNowTo(
                start12.asDate()).overlappingPattern(start11.addDays(1).rangeFromNowTo(start12.asDate()))==OverlapType.CoveringOnRight
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.rangeFromNowTo(start12.addDays(-1).asDate())));
        assertEquals(true,start11.rangeFromNowTo(
                start12.asDate()).overlappingPattern(start11.rangeFromNowTo(start12.addDays(-1).asDate()))==OverlapType.CoveringOnLeft
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(2).rangeFromNowTo(start12.addDays(-2).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.addDays(2).rangeFromNowTo(start12.addDays(-2).asDate()))==OverlapType.Covering
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start12.rangeFromNowTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start12.rangeFromNowTo(start12.addDays(2).asDate()))==OverlapType.JoinOnRight
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start12.addDays(-1).rangeFromNowTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start12.addDays(-1).rangeFromNowTo(start12.addDays(2).asDate()))==OverlapType.OverLapOnRight
        );

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(-1).rangeFromNowTo(start11.asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeFromNowTo(start11.asDate()))==OverlapType.JoinOnLeft);

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.addDays(-1).rangeFromNowTo(start11.addDays(1).asDate())));
        assertEquals(true,
                start11.rangeFromNowTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeFromNowTo(start11.addDays(1).asDate()))==OverlapType.OverlapOnLeft);

        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlapping(start11.rangeFromNowTo(start12)));
        assertEquals(true,start11.rangeFromNowTo(start12.asDate()).overlappingPattern(start11.rangeFromNowTo(start12))==OverlapType.Same);
    }

    @Test
    public void testRangeWithBuilder(){
        final DateBuilder builder = DateBuilder.raw().ymd(2007, Month.MAR, 22).hm(22, 12);
        DatetimeRange range = builder.rangeWithBuilder(
                new BuilderOperation() {
                    @Override
                    public DateBuilder oper() {
                        return builder.addDays(-10);
                    }
                }
                ,
                new BuilderOperation() {
                    @Override
                    public DateBuilder oper() {
                        return builder.addDays(10);
                    }
                }
        );
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20070312-221200000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20070401-221200000",ymdhhmmssSSS.format(range.getEnd()));
    }

    @Test
    public void testEditWithStartAneEnd(){
        DateBuilder d = DateBuilder.raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeFromNowTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20880622-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = range.editStartEndDate(
                new RangeEditByBuilder() {
                    @Override
                    public DateBuilder oper(DateBuilder builder) {
                        return builder.addDays(-1).addMS(333);
                    }
                },
                new RangeEditByBuilder() {
                    @Override
                    public DateBuilder oper(DateBuilder builder) {
                        return builder.addDays(3).addYear(2).addMonths(2).addMS(222);
                    }
                });

        assertEquals("20880421-000000333",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900825-000000222",ymdhhmmssSSS.format(range.getEnd()));

        range = range.editStartDate(
                new RangeEditByBuilder() {
                    @Override
                    public DateBuilder oper(DateBuilder builder) {
                        return builder.addDays(-1).addMS(333);
                    }
                });
        range = range.editEndDate(
                new RangeEditByBuilder() {
                    @Override
                    public DateBuilder oper(DateBuilder builder) {
                        return builder.addDays(1).addMS(222);
                    }
                });

        assertEquals("20880420-000000666",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900826-000000444",ymdhhmmssSSS.format(range.getEnd()));
    }

    @Test
    public void testEditStartAndEndV2(){
        DateBuilder d = DateBuilder.raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeFromNowTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20880622-000000000",ymdhhmmssSSS.format(range.getEnd()));

        range = range.editStartAddYear(1).editStartAddMonth(1).editStartAddDay(1).editStartAddMinute(1).editStartAddHour(1).editStartAddSecond(1).editStartAddMS(1);
        range = range.editEndAddYear(2).editEndAddMonth(2).editEndAddDay(2).editEndAddMinute(2).editEndAddHour(2).editEndAddSecond(2).editEndAddMS(2);

        assertEquals("20890523-010101001",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900824-020202002",ymdhhmmssSSS.format(range.getEnd()));

        range = range.editStartAddTime(2000);
        range = range.editEndAddTime(4000);

        assertEquals("20890523-010103001",ymdhhmmssSSS.format(range.getStart()));
        assertEquals("20900824-020206002",ymdhhmmssSSS.format(range.getEnd()));

    }
}
