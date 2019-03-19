package me.xethh.utils;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.*;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DateOperationTest_Range
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().asDate()));
    }

    @Test
    public void addMs(){
        assertEquals("1970-01-01T00:00:00.200+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(200).asDate()));
        assertEquals("1970-01-01T00:00:01.001+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(1001).asDate()));
        assertEquals("1970-01-01T00:01:00.001+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(60*1000+1).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(60*1000).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(60*60*1000).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMS(24*60*60*1000).asDate()));
    }

    @Test
    public void addSec(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(0).asDate()));
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(1).asDate()));
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(59).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(60).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(60*60).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addSecond(24*60*60).asDate()));
    }

    @Test
    public void addMin(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(0).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(1).asDate()));
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(59).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(60).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(61).asDate()));
        assertEquals("1970-01-01T01:59:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(119).asDate()));
        assertEquals("1970-01-01T02:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(120).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(1440).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(2880).asDate()));
        assertEquals("1970-01-03T02:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(3000).asDate()));
        assertEquals("6053-01-23T02:07:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMins(Integer.MAX_VALUE).asDate()));
    }

    @Test
    public void addHour(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addHours(0).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addHours(1).asDate()));
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addHours(23).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addHours(24).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addHours(48).asDate()));
    }

    @Test
    public void addDay(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addDays(0).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addDays(1).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addDays(2).asDate()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addDays(30).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addDays(31).asDate()));
    }

    @Test
    public void addMonth(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(0).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(1).asDate()));
        assertEquals("1970-03-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(2).asDate()));
        assertEquals("1970-04-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(3).asDate()));
        assertEquals("1970-12-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(11).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(12).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addMonths(24).asDate()));
    }

    @Test
    public void addYear(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addYear(0).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addYear(1).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addYear(2).asDate()));
        assertEquals("1980-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().addYear(10).asDate()));
    }
    @Test
    public void lastYear(){
        assertEquals("2017-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).lastYear().asDate()));
    }
    @Test
    public void nextYear(){
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).nextYear().asDate()));
    }
    @Test
    public void nextMonth(){
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).nextMonth().asDate()));
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(DEC).nextMonth().asDate()));
        assertEquals("2018-12-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(NOV).nextMonth().asDate()));
    }
    @Test
    public void lastMonth(){
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).lastMonth().asDate()));
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(JAN).lastMonth().asDate()));
        assertEquals("2018-01-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(FEB).lastMonth().asDate()));
    }
    @Test
    public void yesterday(){
        assertEquals("2017-12-31T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(1).yesterday().asDate()));
        assertEquals("2017-12-12T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2017).month(DEC).day(13).yesterday().asDate()));
        assertEquals("2018-01-30T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(31).yesterday().asDate()));
    }
    @Test
    public void tomorrow(){
        assertEquals("2018-01-02T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(1).tomorrow().asDate()));
        assertEquals("2017-12-14T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2017).month(DEC).day(13).tomorrow().asDate()));
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(JAN).day(31).tomorrow().asDate()));
        assertEquals("2018-03-01T00:00:00.000+0800",sdf.format(DatetimeFactory.raw().rangeTo(new Date()).editStart().year(2018).month(FEB).day(28).tomorrow().asDate()));
    }

    @Test
    public void nextWeekday(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("2018-07-22T00:00:00.000+0800",sdf.format(d.nextWeekday(Sunday).asDate()));
        assertEquals("2018-07-23T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-24T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-18T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-19T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-20T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-21T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Saturday).asDate()));

        d = DatetimeFactory.raw().ymd(2018, JUL, 18).rangeTo(new Date()).editStart();
        assertEquals("2018-07-22T00:00:00.000+0800",sdf.format(d.nextWeekday(Sunday).asDate()));
        assertEquals("2018-07-23T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-24T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-25T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-19T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-20T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-21T00:00:00.000+0800",sdf.format(d.nextWeekday(Weekday.Saturday).asDate()));
    }

    @Test
    public void prevWeekday(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("2018-07-15T00:00:00.000+0800",sdf.format(d.prevWeekday(Sunday).asDate()));
        assertEquals("2018-07-16T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-10T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-11T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-12T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-13T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-14T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Saturday).asDate()));

        d = DatetimeFactory.raw().ymd(2018, JUL, 18).rangeTo(new Date()).editStart();
        assertEquals("2018-07-15T00:00:00.000+0800",sdf.format(d.prevWeekday(Sunday).asDate()));
        assertEquals("2018-07-16T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("2018-07-17T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Tuesday).asDate()));
        assertEquals("2018-07-11T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Wednesday).asDate()));
        assertEquals("2018-07-12T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Thursday).asDate()));
        assertEquals("2018-07-13T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Friday).asDate()));
        assertEquals("2018-07-14T00:00:00.000+0800",sdf.format(d.prevWeekday(Weekday.Saturday).asDate()));
    }

    @Test
    public void testStartOfWeek(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        DatetimeBuilder d2 = d.addDays(-2);
        assertEquals(d2.asLong(),d.startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(-1).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(1).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(2).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(3).startOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(4).startOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(),d.addDays(5).startOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(),d.addDays(6).startOfWeek(Sunday).asLong());

    }

    @Test
    public void testEndOfWeek(){
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        DatetimeBuilder d2 = d.addDays(4);
        assertEquals(d2.asLong(),d.endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(-1).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(1).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(2).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(3).endOfWeek(Sunday).asLong());
        assertEquals(d2.asLong(),d.addDays(4).endOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(),d.addDays(5).endOfWeek(Sunday).asLong());
        assertEquals(d2.addDays(7).asLong(),d.addDays(6).endOfWeek(Sunday).asLong());

    }

    @Test
    public void testAddTime(){
        SimpleDateFormat sdfx = DateFormatBuilderImpl.get().year4Digit().month2Digit().day2Digit().v1().hourInDay24().minute().second().ms().v1("-").build();
        DatetimeBuilder d = DatetimeFactory.raw().ymd(2018, JUL, 17).rangeTo(new Date()).editStart();
        assertEquals("20180717-000000001",sdfx.format(d.addTime(1).asDate()));
        assertEquals("20180717-000000002",sdfx.format(d.addTime(2).asDate()));
        assertEquals("20180717-000001000",sdfx.format(d.addTime(1000).asDate()));
        assertEquals("20180717-000101000",sdfx.format(d.addTime(61000).asDate()));
    }

    public void testDateFactoryRangeMethod(){
        DatetimeRange range = DatetimeFactory.rangeOnNow()
                .editStart().ymd(1988, JAN, 01).back()
                .editEnd().ymd(1987, JAN, 01).back();
        assertFalse(range.isValid());
        assertFalse(range.swrap().isValid());

        range = DatetimeFactory.rangeOnNow();
        assertTrue(range.startAsDate().equals(range.endAsDate()));

        range = DatetimeFactory.rangeOn(DatetimeFactory.raw().ymd(2022,FEB, 18).maxDayTime());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.endAsDate()));

        range = DatetimeFactory.rangeOn(DatetimeFactory.raw().ymd(2022,FEB, 18).maxDayTime().asDate());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.endAsDate()));

        range = DatetimeFactory.rangeOn(DatetimeFactory.raw().ymd(2022,FEB, 18).maxDayTime().asLong());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.endAsDate()));

        range = DatetimeFactory.rangeOn(DatetimeFactory.raw().ymd(2022,FEB, 18).maxDayTime().asCalendar());
        assertTrue(range.startAsDate().equals(range.endAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.startAsDate()));
        assertEquals("2022-02-18T23:59:59.999",sdf.format(range.endAsDate()));

        SimpleDateFormat sdfx = DateFormatBuilderImpl.get().year4Digit().month2Digit().day2Digit().v1().hourInDay24().minute().second().ms().v1("-").build();
        DatetimeRangeContainedBuilder dStart = DatetimeFactory.rangeOnNow()
                .editStart().ymd(2018, JUL, 17);
        assertEquals("20180717-000000001",sdfx.format(dStart.addTime(1).asDate()));
        assertEquals("20180717-000000002",sdfx.format(dStart.addTime(2).asDate()));
        assertEquals("20180717-000001000",sdfx.format(dStart.addTime(1000).asDate()));
        assertEquals("20180717-000101000",sdfx.format(dStart.addTime(61000).asDate()));
    }
}
