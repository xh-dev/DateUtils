package me.xethh.utils.v6.range;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import me.xethh.utils.dateUtils.range.OverlapType;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.xethh.utils.dateUtils.month.Month.*;
import static me.xethh.utils.dateUtils.weekday.Weekday.Sunday;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DateUtilsTest_Range {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Test
    public void rawDate() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().asDate()));
    }

    @Test
    public void addMs() {
        assertEquals("1970-01-01T00:00:00.200+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(200).asDate()));
        assertEquals("1970-01-01T00:00:01.001+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(1001).asDate()));
        assertEquals("1970-01-01T00:01:00.001+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(60 * 1000 + 1).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(60 * 1000).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(60 * 60 * 1000).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMS(24 * 60 * 60 * 1000).asDate()));
        DatetimeBuilder db = DatetimeFactory.instance().raw().ymd(2087, JAN, 5).hmsms(1, 2, 3, 4);

        DatetimeRange range = DatetimeFactory.instance().rangeOn(db.asDate());
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.startAsDate()));
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.endAsDate()));
        assertEquals(true, range.isValid());

        range = DatetimeFactory.instance().rangeOn(db.asCalendar());
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.startAsDate()));
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.endAsDate()));
        assertEquals(true, range.isValid());

        range = DatetimeFactory.instance().rangeOn(db);
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.startAsDate()));
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.endAsDate()));
        assertEquals(true, range.isValid());

        range = DatetimeFactory.instance().rangeOn(db.asLong());
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.startAsDate()));
        assertEquals("2087-01-05T01:02:03.004+0800", sdf.format(range.endAsDate()));
        assertEquals(true, range.isValid());

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().asDate()), "1970-01-01T00:00:00.000+0800");
    }

    @Test
    public void editStartTest() {
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().y(2018).asDate()), "2018-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, JAN).asDate()), "2018-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.FEB).asDate()), "2018-02-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, MAR).asDate()), "2018-03-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, APR).asDate()), "2018-04-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.MAY).asDate()), "2018-05-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.JUN).asDate()), "2018-06-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.JUL).asDate()), "2018-07-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.AUG).asDate()), "2018-08-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.SEP).asDate()), "2018-09-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.OCT).asDate()), "2018-10-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.NOV).asDate()), "2018-11-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018, Month.DEC).asDate()), "2018-12-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018, Month.DEC, 1).asDate()), "2018-12-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018, Month.DEC, 31).asDate()), "2018-12-31T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018, Month.DEC, 32).asDate()), "2019-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().h(12).asDate()), "1970-01-01T12:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().h(24).asDate()), "1970-01-02T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hm(24, 50).asDate()), "1970-01-02T00:50:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hm(24, 60).asDate()), "1970-01-02T01:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hms(24, 60, 1).asDate()), "1970-01-02T01:00:01.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hms(24, 60, 60).asDate()), "1970-01-02T01:01:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hmsms(24, 60, 60, 100).asDate()), "1970-01-02T01:01:00.100");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hmsms(24, 60, 60, 1000).asDate()), "1970-01-02T01:01:01.000");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxMs().asDate()), "1970-01-01T00:00:00.999+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().minMs().minMs().asDate()), "1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxSecond().asDate()), "1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxSecond().minSecond().asDate()), "1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxHour().asDate()), "1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxHour().minHour().asDate()), "1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ms(444).second(23).hour(14).minute(40).day(2).month(APR).year(2008).asDate()), "2008-04-02T14:40:23.444+0800");

        assertEquals("2008-04-02T00:00:12.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().second(12).ymd(2008, APR, 02).asDate()));
        assertEquals("2008-04-02T14:23:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008, APR, 02).hm(14, 23).asDate()));
        assertEquals("2008-04-02T14:23:45.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008, APR, 02).hms(14, 23, 45).asDate()));
        assertEquals("2008-04-02T14:23:45.777+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008, APR, 02).hmsms(14, 23, 45, 777).asDate()));
    }

    @Test
    public void baseTest() {
        DatetimeBuilderInterface builder = DatetimeFactory.instance().now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DatetimeRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]", DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(30).asDate()).toString());
        assertEquals("DatetimeRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]", DatetimeFactory.rangeOf(builder.addDays(30).asDate(), builder.asDate()).toString());
    }

    @Test
    public void testIsValid() {
        DatetimeBuilderInterface builder = DatetimeFactory.instance().now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(30).asDate()).isValid());
        assertEquals(false, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(-30).asDate()).isValid());
        assertEquals(false, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(30).asDate()).isInvalid());
        assertEquals(true, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(-30).asDate()).isInvalid());
        assertEquals(true, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(30).asDate()).isValid());
        assertEquals(false, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(-30).asDate()).isValid());
        assertEquals(true, DatetimeFactory.rangeOf(builder.asDate(), builder.asDate()).isValid());
    }

    @Test
    public void testTimeRangeSinglePoint() {
        DatetimeBuilderInterface builder = DatetimeFactory.instance().raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(false, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(30).asDate()).singlePointRange());
        assertEquals(false, DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(-30).asDate()).singlePointRange());
        assertEquals(true, DatetimeFactory.rangeOf(builder.asDate(), builder.asDate()).singlePointRange());
    }

    @Test
    public void testTimeRangeOperateDaytime() {
        DatetimeBuilder builder = DatetimeFactory.instance().raw().year(2018).month(JAN).day(18).minDayTime();
        assertEquals(builder.rangeTo(builder.addDays(2).asDate()), DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(2).asDate()));
        assertNotEquals(builder.rangeTo(builder.addDays(2).asDate()), DatetimeFactory.rangeOf(builder.asDate(), builder.addDays(2).addMins(2).asDate()));
    }

    @Test
    public void testOverlap() {
        DatetimeBuilder start11 = DatetimeFactory.instance().raw().year(2018).month(JAN).day(10).minDayTime();
        DatetimeBuilder start12 = start11.addDays(5);
        DatetimeBuilder start21 = start11.addDays(5).addDays(3);
        DatetimeBuilder start22 = start11.addDays(5).addDays(3).addDays(3);
        assertEquals(false, start11.rangeTo(start12.asDate()).overlapping(null));
        assertEquals(true, start11.rangeTo(start12.asDate()).overlappingPattern(null) == OverlapType.TargetIsNull);

        assertEquals(false, start11.rangeTo(start12.asDate()).swrap().overlapping(start21.rangeTo(start22.asDate())));
        assertEquals(true, start11.rangeTo(start12.asDate()).swrap().overlappingPattern(start21.rangeTo(start22.asDate())) == OverlapType.Invalid);

        assertEquals(false, start11.rangeTo(start12.asDate()).overlapping(start21.rangeTo(start22.asDate()).swrap()));
        assertEquals(true, start11.rangeTo(start12.asDate()).overlappingPattern(start21.rangeTo(start22.asDate()).swrap()) == OverlapType.TargetInvalid);

        assertEquals(false, start11.rangeTo(start12.asDate()).overlapping(start21.rangeTo(start22.asDate())));
        assertEquals(true, start11.rangeTo(start12.asDate()).overlappingPattern(start21.rangeTo(start22.asDate())) == OverlapType.ComesFirst);

        assertEquals(false, start21.rangeTo(start22.asDate()).overlapping(start11.rangeTo(start12.asDate())));
        assertEquals(true, start21.rangeTo(start22.asDate()).overlappingPattern(start11.rangeTo(start12.asDate())) == OverlapType.ComesLater);

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-2).rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeTo(start12.addDays(2).asDate())) == OverlapType.CoveredBy
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-2).rangeTo(start12.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-2).rangeTo(start12.asDate())) == OverlapType.CoveredOnRight
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.rangeTo(start12.addDays(2).asDate())) == OverlapType.CoveredOnLeft
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(1).rangeTo(start12.asDate())));
        assertEquals(true, start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.addDays(1).rangeTo(start12.asDate())) == OverlapType.CoveringOnRight
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12.addDays(-1).asDate())));
        assertEquals(true, start11.rangeTo(
                start12.asDate()).overlappingPattern(start11.rangeTo(start12.addDays(-1).asDate())) == OverlapType.CoveringOnLeft
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(2).rangeTo(start12.addDays(-2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(2).rangeTo(start12.addDays(-2).asDate())) == OverlapType.Covering
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start12.rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.rangeTo(start12.addDays(2).asDate())) == OverlapType.JoinOnRight
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start12.addDays(-1).rangeTo(start12.addDays(2).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start12.addDays(-1).rangeTo(start12.addDays(2).asDate())) == OverlapType.OverLapOnRight
        );

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-1).rangeTo(start11.asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeTo(start11.asDate())) == OverlapType.JoinOnLeft);

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.addDays(-1).rangeTo(start11.addDays(1).asDate())));
        assertEquals(true,
                start11.rangeTo(start12.asDate()).overlappingPattern(
                        start11.addDays(-1).rangeTo(start11.addDays(1).asDate())) == OverlapType.OverlapOnLeft);

        assertEquals(true, start11.rangeTo(start12.asDate()).overlapping(start11.rangeTo(start12)));
        assertEquals(true, start11.rangeTo(start12.asDate()).overlappingPattern(start11.rangeTo(start12)) == OverlapType.Same);
    }

    @Test
    public void testEditWithStartAneEnd() {
        DatetimeBuilder d = DatetimeFactory.instance().raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20880622-000000000", ymdhhmmssSSS.format(range.endAsDate()));

        range = range
                .editStart().addDays(-1).addMS(333).back()
                .editEnd().addDays(3).addYear(2).addMonths(2).addMS(222).back();

        assertEquals("20880421-000000333", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20900825-000000222", ymdhhmmssSSS.format(range.endAsDate()));

        range = range
                .editStart().addDays(-1).addMS(333).back()
                .editEnd().addDays(1).addMS(222).back();

        assertEquals("20880420-000000666", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20900826-000000444", ymdhhmmssSSS.format(range.endAsDate()));
    }

    @Test
    public void testEditStartAndEndV2() {
        DatetimeBuilder d = DatetimeFactory.instance().raw().ymd(2088, APR, 22);
        DatetimeRange range = d.rangeTo(d.addMonths(2));
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        assertEquals("20880422-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20880622-000000000", ymdhhmmssSSS.format(range.endAsDate()));

        range = range
                .editStart().addYear(1).addMonths(1).addDays(1).addMins(1).addHours(1).addSecond(1).addMS(1).back()
                .editEnd().addYear(2).addMonths(2).addDays(2).addMins(2).addHours(2).addSecond(2).addMS(2).back();

        assertEquals("20890523-010101001", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20900824-020202002", ymdhhmmssSSS.format(range.endAsDate()));

        range = range
                .editStart().addTime(2000).back()
                .editEnd().addTime(4000).back()
        ;

        assertEquals("20890523-010103001", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20900824-020206002", ymdhhmmssSSS.format(range.endAsDate()));

    }

    @Test
    public void testRangeTo() {
        SimpleDateFormat ymdhhmmssSSS = DateFormatBuilder.get()
                .year4Digit().month2Digit().day2Digit().v1()
                .hourInDay24().minute().second().ms().v1("-").build();
        DatetimeRange range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.endAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.startAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asDate());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.endAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.startAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asLong());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.endAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.startAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeFrom(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asCalendar());
        assertTrue(range.isInvalid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.endAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.startAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.endAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asDate());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.endAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asLong());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.endAsDate()));

        range = DatetimeFactory.instance().now().ymd(2018, MAR, 15).minDayTime().rangeTo(DatetimeFactory.instance().now().ymd(2018, APR, 15).minDayTime().asCalendar());
        assertTrue(range.isValid());
        assertEquals("20180315-000000000", ymdhhmmssSSS.format(range.startAsDate()));
        assertEquals("20180415-000000000", ymdhhmmssSSS.format(range.endAsDate()));
    }

    @Test
    public void testDateRange() {
        DatetimeRange range = DatetimeFactory.instance().raw().ymd(2018, NOV, 3).hmsms(22, 23, 44, 888).rangeToSelf()
                .editEnd()
                .addYear(2)
                .addMonths(13)
                .addDays(6)
                .addHours(6)
                .addMins(7)
                .addSecond(24)
                .addMS(10)
                .back();
        SimpleDateFormat formatter = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
        assertEquals("2018-11-03 22:23:44.888", formatter.format(range.startAsDate()));
        assertEquals("2018-11-03 22:23:44.888", range.startAsDTBuilder().format(DateFormatBuilderInterface.Format.FULL_DATETIME));
        assertEquals("2018-11-03 00:00:00.000", range.startAsDateBuilder().format(DateFormatBuilderInterface.Format.FULL_DATETIME));

        // assertEquals("2020-11-03 22:23:44.888",formatter.format(range.endAsDate()));
        assertEquals("2021-12-10 04:31:08.898", formatter.format(range.endAsDate()));
        // assertEquals("2022-01-10 02:23:44.888",range.startAsDTBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));
        // assertEquals("2022-01-10 00:00:00.000",range.startAsDateBuilder().format(DateFormatBuilder.Format.FULL_DATETIME));

    }


    @Test
    public void addSec() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(0).asDate()));
        assertEquals("1970-01-01T00:00:01.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(1).asDate()));
        assertEquals("1970-01-01T00:00:59.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(59).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(60).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(60 * 60).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addSecond(24 * 60 * 60).asDate()));
    }

    @Test
    public void addMin() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(0).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(1).asDate()));
        assertEquals("1970-01-01T00:59:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(59).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(60).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(61).asDate()));
        assertEquals("1970-01-01T01:59:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(119).asDate()));
        assertEquals("1970-01-01T02:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(120).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(1440).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(2880).asDate()));
        assertEquals("1970-01-03T02:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(3000).asDate()));
        assertEquals("6053-01-23T02:07:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMins(Integer.MAX_VALUE).asDate()));
    }

    @Test
    public void addHour() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addHours(0).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addHours(1).asDate()));
        assertEquals("1970-01-01T23:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addHours(23).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addHours(24).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addHours(48).asDate()));
    }

    @Test
    public void addDay() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addDays(0).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addDays(1).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addDays(2).asDate()));
        assertEquals("1970-01-31T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addDays(30).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addDays(31).asDate()));
    }

    @Test
    public void addMonth() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(0).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(1).asDate()));
        assertEquals("1970-03-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(2).asDate()));
        assertEquals("1970-04-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(3).asDate()));
        assertEquals("1970-12-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(11).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(12).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addMonths(24).asDate()));
    }

    @Test
    public void addYear() {
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addYear(0).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addYear(1).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addYear(2).asDate()));
        assertEquals("1980-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().addYear(10).asDate()));
    }

    @Test
    public void lastYear() {
        assertEquals("2017-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).lastYear().asDate()));
    }

    @Test
    public void nextYear() {
        assertEquals("2019-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).nextYear().asDate()));
    }

    @Test
    public void nextMonth() {
        assertEquals("2018-02-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).nextMonth().asDate()));
        assertEquals("2019-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(DEC).nextMonth().asDate()));
        assertEquals("2018-12-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(NOV).nextMonth().asDate()));
    }

    @Test
    public void lastMonth() {
        assertEquals("2017-12-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).lastMonth().asDate()));
        assertEquals("2017-12-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(JAN).lastMonth().asDate()));
        assertEquals("2018-01-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(FEB).lastMonth().asDate()));
    }

    @Test
    public void yesterday() {
        assertEquals("2017-12-31T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(1).yesterday().asDate()));
        assertEquals("2017-12-12T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2017).month(DEC).day(13).yesterday().asDate()));
        assertEquals("2018-01-30T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(31).yesterday().asDate()));
    }

    @Test
    public void tomorrow() {
        assertEquals("2018-01-02T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(1).tomorrow().asDate()));
        assertEquals("2017-12-14T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2017).month(DEC).day(13).tomorrow().asDate()));
        assertEquals("2018-02-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(31).tomorrow().asDate()));
        assertEquals("2018-03-01T00:00:00.000+0800", sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().year(2018).month(FEB).day(28).tomorrow().asDate()));
    }

    @Test
    public void nextWeekday() {
        DatetimeBuilderInterface d = DatetimeFactory.instance().raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("2018-07-22T00:00:00.000+0800", sdf.format(d.nextWeekday(Sunday).asDate()));
        assertEquals("2018-07-23T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-24T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-18T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-19T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-20T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-21T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Saturday).asDate()));

        d = DatetimeFactory.instance().raw().ymd(2018, JUL, 18).rangeTo(new Date()).editStart();
        assertEquals("2018-07-22T00:00:00.000+0800", sdf.format(d.nextWeekday(Sunday).asDate()));
        assertEquals("2018-07-23T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-24T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-25T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-19T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-20T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-21T00:00:00.000+0800", sdf.format(d.nextWeekday(Weekday.Saturday).asDate()));
    }

    @Test
    public void prevWeekday() {
        DatetimeBuilderInterface d = DatetimeFactory.instance().raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("2018-07-15T00:00:00.000+0800", sdf.format(d.prevWeekday(Sunday).asDate()));
        assertEquals("2018-07-16T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-10T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-11T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-12T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-13T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-14T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Saturday).asDate()));

        d = DatetimeFactory.instance().raw().ymd(2018, JUL, 18).rangeTo(new Date()).editStart();
        assertEquals("2018-07-15T00:00:00.000+0800", sdf.format(d.prevWeekday(Sunday).asDate()));
        assertEquals("2018-07-16T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-17T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-11T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-12T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-13T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-14T00:00:00.000+0800", sdf.format(d.prevWeekday(Weekday.Saturday).asDate()));
    }

    @Test
    public void testStartOfWeek() {
        DatetimeRangeContainedBuilder d = DatetimeFactory.instance().raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        DatetimeBuilderInterface d2 = d.addDays(-2);
        assertEquals(d2.asLong(), d.startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(-1).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(1).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(2).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(3).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(4).startOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(), d.addDays(5).startOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(), d.addDays(6).startOfWeek(Sunday).asLong());

    }

    @Test
    public void testEndOfWeek() {
        DatetimeRangeContainedBuilder d = DatetimeFactory.instance().raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        DatetimeRangeContainedBuilder d2 = d.addDays(4);
        assertEquals(d2.asLong(), d.endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(-1).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(1).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(2).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(3).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(), d.addDays(4).endOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(), d.addDays(5).endOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(), d.addDays(6).endOfWeek(Sunday).asLong());

    }

    @Test
    public void testAddTime() {
        SimpleDateFormat sdfx = DateFormatBuilder.get().year4Digit().month2Digit().day2Digit().v1().hourInDay24().minute().second().ms().v1("-").build();
        DatetimeRangeContainedBuilder d = DatetimeFactory.instance().raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("20180717-000000001", sdfx.format(d.addTime(1).asDate()));
        assertEquals("20180717-000000002", sdfx.format(d.addTime(2).asDate()));
        assertEquals("20180717-000001000", sdfx.format(d.addTime(1000).asDate()));
        assertEquals("20180717-000101000", sdfx.format(d.addTime(61000).asDate()));
    }

    public void testDateFactoryRangeMethod() {
        DatetimeRange range = DatetimeFactory.instance().rangeOnNow()
                .editStart().ymd(1988, JAN, 01).back()
                .editEnd().ymd(1987, JAN, 01).back();
        assertFalse(range.isValid());
        assertFalse(range.swrap().isValid());

        range = DatetimeFactory.instance().rangeOnNow();
        assertTrue(range.startAsDate().equals(range.endAsDate()));

        range = DatetimeFactory.instance().rangeOn(DatetimeFactory.instance().raw().ymd(2022, FEB, 18).maxDayTime());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.endAsDate()));

        range = DatetimeFactory.instance().rangeOn(DatetimeFactory.instance().raw().ymd(2022, FEB, 18).maxDayTime().asDate());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.endAsDate()));

        range = DatetimeFactory.instance().rangeOn(DatetimeFactory.instance().raw().ymd(2022, FEB, 18).maxDayTime().asLong());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.endAsDate()));

        range = DatetimeFactory.instance().rangeOn(DatetimeFactory.instance().raw().ymd(2022, FEB, 18).maxDayTime().asCalendar());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999", sdf.format(range.endAsDate()));

        SimpleDateFormat sdfx = DateFormatBuilder.get().year4Digit().month2Digit().day2Digit().v1().hourInDay24().minute().second().ms().v1("-").build();
        DatetimeRangeContainedBuilder dStart = DatetimeFactory.instance().rangeOnNow()
                .editStart().ymd(2018, JUL, 17);
        assertEquals("20180717-000000001", sdfx.format(dStart.addTime(1).asDate()));
        assertEquals("20180717-000000002", sdfx.format(dStart.addTime(2).asDate()));
        assertEquals("20180717-000001000", sdfx.format(dStart.addTime(1000).asDate()));
        assertEquals("20180717-000101000", sdfx.format(dStart.addTime(61000).asDate()));
    }
}
