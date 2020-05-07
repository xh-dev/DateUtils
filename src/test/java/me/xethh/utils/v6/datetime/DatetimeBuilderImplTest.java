package me.xethh.utils.v6.datetime;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.v6.date.TestCalendarDateBuilder;
import me.xethh.utils.v6.date.TestCommonDateRepresentation;
import me.xethh.utils.v6.date.TestFormatBuilder;
import me.xethh.utils.v6.date.TestTimeUnitConverter;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static me.xethh.utils.dateManipulation.Month.*;
import static org.junit.Assert.*;

public class DatetimeBuilderImplTest {
    /**
     * Test calendar date builder interface
     */
    @Test
    public void normalTest(){
        DatetimeBuilder db = new DatetimeBuilderImpl(TimeZone.getDefault());
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));
        assertEquals("1971-02-02T00:00:00.000+0800",sdf.format(db.addYear(1).addMonths(1).addDays(1).asDate()));

        // T y(int year);
        assertEquals("0001-01-01T00:00:00.000+0800",sdf.format(db.y(1).asDate()));
        // T ym(int year, Month month);
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ym(1,Month.FEB).asDate()));
        // T md(Month month, int day);
        assertEquals("1970-09-13T00:00:00.000+0800",sdf.format(db.md(SEP,13).asDate()));
        // T ymd(int year, Month month, int day);
        assertEquals("0001-02-20T00:00:00.000+0800",sdf.format(db.ymd(1,Month.FEB,20).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).asDate()));
        assertEquals("2007-01-02T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).day(2).month(Month.JAN).year(2007).asDate()));
        // T minYear();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.year(2009).minYear().asDate()));
        // T year(final int year);
        assertEquals("2011-01-01T00:00:00.000+0800",sdf.format(db.y(2011).asDate()));
        // T minMonth();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.month(SEP).minMonth().asDate()));
        // T month(final Month month);
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.month(Month.FEB).asDate()));
        // T minDay();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addDays(23).minDay().asDate()));
        // T day(final int date);
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(db.day(3).asDate()));
        assertEquals("1970-02-02T00:00:00.000+0800",sdf.format(db.day(33).asDate()));
        // T firstDayOfMonth();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.day(21).firstDayOfMonth().asDate()));
        // T endDayOfMonth();
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(db.day(21).endDayOfMonth().asDate()));
        // T addYear(final int years);
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(db.addYear(1).asDate()));
        assertEquals("2970-01-01T00:00:00.000+0800",sdf.format(db.addYear(1000).asDate()));
        assertEquals("0970-01-01T00:00:00.000+0800",sdf.format(db.addYear(-1000).asDate()));
        assertEquals("1969-01-01T00:00:00.000+0800",sdf.format(db.addYear(-1).asDate()));
        // T lastYear();
        assertEquals("1969-01-01T00:00:00.000+0800",sdf.format(db.lastYear().asDate()));
        // T nextYear();
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(db.nextYear().asDate()));
        // T lastMonth();
        assertEquals("1969-12-01T00:00:00.000+0800",sdf.format(db.lastMonth().asDate()));
        // T nextMonth();
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.nextMonth().asDate()));
        // T addMonths(final int months);
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.addMonths(1).asDate()));
        assertEquals("1973-01-01T00:00:00.000+0800",sdf.format(db.addMonths(36).asDate()));
        assertEquals("1969-12-01T00:00:00.000+0800",sdf.format(db.addMonths(-1).asDate()));
        assertEquals("1967-01-01T00:00:00.000+0800",sdf.format(db.addMonths(-36).asDate()));
        // T addDays(final int days);
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(db.addDays(1).asDate()));
        assertEquals("1971-01-02T00:00:00.000+0800",sdf.format(db.addDays(366).asDate()));
        assertEquals("1969-12-31T00:00:00.000+0800",sdf.format(db.addDays(-1).asDate()));
        assertEquals("1968-12-31T00:00:00.000+0800",sdf.format(db.addDays(-366).asDate()));
        // T yesterday();
        assertEquals("1969-12-31T00:00:00.000+0800",sdf.format(db.yesterday().asDate()));
        // T tomorrow();
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(db.tomorrow().asDate()));
        // T nextWeekday(Weekday day);
        assertEquals("1970-01-05T00:00:00.000+0800",sdf.format(db.nextWeekday(Weekday.Monday).asDate()));
        // T prevWeekday(Weekday day);
        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.prevWeekday(Weekday.Monday).asDate()));
        // T startOfWeek(Weekday startDay);
        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.startOfWeek(Weekday.Monday).asDate()));
        // T endOfWeek(Weekday startDay);
        assertEquals("1970-01-04T00:00:00.000+0800",sdf.format(db.endOfWeek(Weekday.Monday).asDate()));
        // boolean sameYear(Long longDate);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC,20).asLong()));
        // boolean sameYear(Date date);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC,20).asDate()));
        // boolean sameYear(Calendar cal);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC,20).asCalendar()));
        // boolean sameMonth(Long longDate);
        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asLong()));
        // boolean sameMonth(Date date);
        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asDate()));
        // boolean sameMonth(Calendar cal);
        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asCalendar()));
        // boolean sameDay(Long longDate);
        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asLong()));
        // boolean sameDay(Date date);
        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asDate()));
        // boolean sameDay(Calendar cal);
        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asCalendar()));

        // boolean sameDate(Long longDate);
        assertTrue(db.md(JUL,23).sameDate(db.md(JUL,23).asLong()));
        assertFalse(db.md(JUL,21).sameDate(db.md(JUL,23).asLong()));
        // boolean sameDate(Date date);
        assertTrue(db.md(JUL,23).sameDate(db.md(JUL,23).asLong()));
        assertFalse(db.md(JUL,21).sameDate(db.md(JUL,23).asLong()));
        // boolean sameDate(Calendar cal);
        assertTrue(db.md(JUL,23).sameDate(db.md(JUL,23).asLong()));
        assertFalse(db.md(JUL,21).sameDate(db.md(JUL,23).asLong()));

        assertTrue(db.md(JUL,23).sameDate(db.md(JUL,23)));
        assertFalse(db.md(JUL,21).sameDate(db.md(JUL,23)));

        db = new DatetimeBuilderImpl(TimeZone.getDefault()).ymd(1970, JUL, 23);
        // boolean laterThan(Date date);
        assertTrue(db.month(Month.AUG).laterThan(db.asDate()));
        // boolean laterThan(Long longDate);
        assertTrue(db.month(Month.AUG).laterThan(db.asLong()));
        // boolean laterThan(Calendar calendar);
        assertTrue(db.month(Month.AUG).laterThan(db.asCalendar()));
        assertTrue(db.month(Month.AUG).laterThan(db));

        // boolean laterEqualThan(Date date);
        assertTrue(db.md(JUL,23).laterEqualThan(db.asDate()));
        // boolean laterEqualThan(Long longDate);
        assertTrue(db.md(JUL,23).laterEqualThan(db.asLong()));
        // boolean laterEqualThan(Calendar calendar);
        assertTrue(db.md(JUL,23).laterEqualThan(db.asCalendar()));
        assertTrue(db.md(JUL,23).laterEqualThan(db));

        // boolean before(Date date);
        assertTrue(db.month(Month.JUN).before(db.asDate()));
        // boolean before(Long longDate);
        assertTrue(db.month(Month.JUN).before(db.asLong()));
        // boolean before(Calendar calendar);
        assertTrue(db.month(Month.JUN).before(db.asCalendar()));
        assertTrue(db.month(Month.JUN).before(db));

        // boolean beforeEqual(Date date);
        assertTrue(db.md(JUL,23).beforeEqual(db.asDate()));
        // boolean beforeEqual(Long longDate);
        assertTrue(db.md(JUL,23).beforeEqual(db.asLong()));
        // boolean beforeEqual(Calendar calendar);
        assertTrue(db.md(JUL,23).beforeEqual(db.asCalendar()));
        assertTrue(db.md(JUL,23).beforeEqual(db));

    }
    @Test
    public void normalTest_Time(){
        DatetimeBuilder db = new DatetimeBuilderImpl(TimeZone.getDefault());
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));


        // T hmsms(int hour, int minute, int second, int mSecond);
        assertEquals("1970-01-01T04:05:06.088+0800",sdf.format(db.hmsms(4,5,6,88).asDate()));
        // T hms(int hour, int minute, int second);
        assertEquals("1970-01-01T02:03:05.000+0800",sdf.format(db.hms(2,3,5).asDate()));
        // T hm(int hour, int minute);
        assertEquals("1970-01-01T22:11:00.000+0800",sdf.format(db.hm(22,11).asDate()));
        // T h(int hour);
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.h(1).asDate()));


        // T minHour();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addHours(1).minHour().asDate()));
        // T maxHour();
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(db.maxHour().asDate()));
        // T hour(final int hour);
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.hour(1).asDate()));
        // T minMinute();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addMins(1).minMinute().asDate()));
        // T maxMinute();
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(db.maxMinute().asDate()));
        // T minute(final int min);
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(db.minute(1).asDate()));
        // T minSecond();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addSecond(1).minSecond().asDate()));
        // T maxSecond();
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(db.maxSecond().asDate()));
        // T second(final int second);
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(db.second(1).asDate()));
        // T minMs();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addMS(1).minMs().asDate()));
        // T maxMs();
        assertEquals("1970-01-01T00:00:00.999+0800",sdf.format(db.maxMs().asDate()));
        // T ms(final int ms);
        assertEquals("1970-01-01T00:00:00.001+0800",sdf.format(db.ms(1).asDate()));
        // T maxDayTime();
        assertEquals("1970-01-01T23:59:59.999+0800",sdf.format(db.maxDayTime().asDate()));
        // T maxDayTimeSec();
        assertEquals("1970-01-01T23:59:59.000+0800",sdf.format(db.maxDayTimeSec().asDate()));
        // T maxDayTimeMin();
        assertEquals("1970-01-01T23:59:00.000+0800",sdf.format(db.maxDayTimeMin().asDate()));
        // T minDayTime();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.hmsms(23,34,55,999).minDayTime().asDate()));

        sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));
        // boolean sameDatetime(Long longDate);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameDatetime(Date date);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameDatetime(Calendar cal);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameTime(Long dateLong);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameTime(Date date);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameTime(Calendar calendar);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG,24).hmsms(1,20,30,500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameHMS(Long dateLong);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameHMS(Date date);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameHMS(Calendar calendar);
        assertTrue(db.md(AUG,24).hmsms(1,20,30,700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG,24).hmsms(1,20,30,700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameHM(Long dateLong);
        assertTrue(db.md(AUG,24).hmsms(1,20,40,700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameHM(Date date);
        assertTrue(db.md(AUG,24).hmsms(1,20,40,700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameHM(Calendar calendar);
        assertTrue(db.md(AUG,24).hmsms(1,20,40,700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG,24).hmsms(1,20,40,700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean laterThan(Date date);
        assertTrue(db.month(Month.AUG).laterThan(db.asDate()));
        // boolean laterThan(Long longDate);
        assertTrue(db.month(Month.AUG).laterThan(db.asLong()));
        // boolean laterThan(Calendar calendar);
        assertTrue(db.month(Month.AUG).laterThan(db.asCalendar()));
        assertTrue(db.month(Month.AUG).laterThan(db));

        // boolean laterEqualThan(Date date);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).laterEqualThan(db.asDate()));
        // boolean laterEqualThan(Long longDate);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).laterEqualThan(db.asLong()));
        // boolean laterEqualThan(Calendar calendar);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).laterEqualThan(db.asCalendar()));
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).laterEqualThan(db));

        // boolean before(Date date);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asDate()));
        // boolean before(Long longDate);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asLong()));
        // boolean before(Calendar calendar);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asCalendar()));
        assertTrue(db.month(Month.JUN).before(db.month(AUG)));

        // boolean beforeEqual(Date date);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).beforeEqual(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean beforeEqual(Long longDate);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).beforeEqual(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean beforeEqual(Calendar calendar);
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).beforeEqual(db.month(AUG).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).beforeEqual(db.month(AUG).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // T addTime(final long time);
        assertEquals("1970-01-01T00:00:00.012+0800",sdf.format(db.addTime(12).asDate()));
        // T addHours(final int hours);
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.addHours(1).asDate()));
        assertEquals("1970-01-02T01:00:00.000+0800",sdf.format(db.addHours(25).asDate()));
        assertEquals("1969-12-30T23:00:00.000+0800",sdf.format(db.addHours(-25).asDate()));
        assertEquals("1969-12-31T23:00:00.000+0800",sdf.format(db.addHours(-1).asDate()));
        // T addMins(final int mins);
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(db.addMins(1).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(db.addMins(61).asDate()));
        assertEquals("1969-12-31T22:59:00.000+0800",sdf.format(db.addMins(-61).asDate()));
        assertEquals("1969-12-31T23:59:00.000+0800",sdf.format(db.addMins(-1).asDate()));
        // T addSecond(final int sec);
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(db.addSecond(1).asDate()));
        assertEquals("1970-01-01T00:01:01.000+0800",sdf.format(db.addSecond(61).asDate()));
        assertEquals("1969-12-31T23:58:59.000+0800",sdf.format(db.addSecond(-61).asDate()));
        assertEquals("1969-12-31T23:59:59.000+0800",sdf.format(db.addSecond(-1).asDate()));
        // T addMS(final int ms);
        assertEquals("1970-01-01T00:00:00.001+0800",sdf.format(db.addMS(1).asDate()));
        assertEquals("1970-01-01T00:00:00.010+0800",sdf.format(db.addMS(10).asDate()));
        assertEquals("1970-01-01T00:00:01.010+0800",sdf.format(db.addMS(1010).asDate()));
        assertEquals("1969-12-31T23:59:58.990+0800",sdf.format(db.addMS(-1010).asDate()));
        assertEquals("1969-12-31T23:59:59.990+0800",sdf.format(db.addMS(-10).asDate()));
        assertEquals("1969-12-31T23:59:59.999+0800",sdf.format(db.addMS(-1).asDate()));
        // T timeZone(final BaseTimeZone timeZone);
        // Extract time on time UTC instead of HKD or default timezone, and the +0800 is from dateformat
        assertEquals("1970-01-01T08:00:00.000+0800",sdf.format(db.timeZone(BaseTimeZone.UTC).asDate()));
        // T timeZone(final TimeZone timeZone);
        assertEquals("1970-01-01T08:00:00.000+0800",sdf.format(db.timeZone(TimeZone.getTimeZone("UTC")).asDate()));

        // T swrapTimeZone(final BaseTimeZone timeZone);
        // Extract time on Hong Kong timezone first and then swrap to UTC, and the +0800 is from dateformat
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.timeZone(BaseTimeZone.Hongkong).swapTimeZone(BaseTimeZone.UTC).asDate()));
        // T timeZone(final TimeZone timeZone);
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.timeZone(BaseTimeZone.Hongkong).swapTimeZone(TimeZone.getTimeZone("UTC")).asDate()));
        // T timePartOnly();
        assertEquals("1970-01-01T12:33:55.999+0800",sdf.format(db.y(2999).day(30).hmsms(12,33,55,999).timePartOnly().asDate()));
        assertEquals("1971-02-02T01:01:01.001+0800",sdf.format(db.addYear(1).addMonths(1).addDays(1).addHours(1).addMins(1).addSecond(1).addMS(1).asDate()));

        Date d1 = db.now().asDate();
        Date d2 = new Date();
        assertEquals(sdf.format(d1),sdf.format(d2));

        //Test if the db object is immutable
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));

        assertTrue(db.md(JUL,23).hmsms(1,20,30,500).equals(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));
        assertFalse(db.md(JUL,24).hmsms(1,20,30,500).equals(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));
    }


    @Test
    public void testFormatterBuilder() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        TestFormatBuilder.test(db);
    }

    @Test
    public void testTimeUnitConverter() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        TestTimeUnitConverter.test(db);
    }

    @Test
    public void testCommonDateRepresentation() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 2);
        cal.set(Calendar.SECOND, 3);
        cal.set(Calendar.MILLISECOND, 4);
        Date d = cal.getTime();
        TestCommonDateRepresentation.test(db,d);
    }

}
