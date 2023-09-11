package me.xethh.utils.v6.datetime;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.D;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static me.xethh.utils.dateUtils.month.Month.*;
import static org.junit.Assert.*;

public class DatetimeBuilderImplTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    @Test
    public void Demo() {
        //create date of current time
        Date dateNow = D.dt().now().asDate();
        //create date of 2020-04-21 23:11:08.777 under Japan timezone
        System.out.println(dateNow);

        Date dateJp = D.dt().now().ymd(2020, APR, 21).hmsms(23, 11, 8, 777).asDate();
        //Tue Apr 21 23:11:08 CST 2020
        System.out.println(dateJp);

        //Modifiable date builder object
        DatetimeBuilder db = D.dt().now().ymd(2020, APR, 21).hmsms(23, 11, 8, 777);
        System.out.println(db);
        // DatetimeBuilder[2020-04-21T23:11:08.777+0800]

        //add day
        db = db.addDays(3);
        System.out.println(db);
        // DatetimeBuilder[2020-04-24T23:11:08.777+0800]

        // add hour
        db = db.addHours(1);
        System.out.println(db);
        // DatetimeBuilder[2020-04-25T00:11:08.777+0800]

        //View the date info wit DateInfo object
        DateInfo view = db.view();

        //year: 2020
        System.out.println("year: " + view.year());
        // month: APR
        System.out.println("month: " + view.month());
        // day: 25
        System.out.println("day: " + view.day());
        // hour: 0
        System.out.println("hour: " + view.hour());
        // minute: 11
        System.out.println("minute: " + view.min());
        // second: 8
        System.out.println("second: " + view.second());
        // millisecond: 777
        System.out.println("millisecond: " + view.ms());

        //Date range

        //Date range from 2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800
        DatetimeRange range = db.rangeTo(db.addDays(4).addHours(4));
        //DatetimeRange[2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800]
        System.out.println(range);

        //Date range from 2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800
        range = db.rangeToSelf()
                .editEnd().addDays(4).addHours(4).back();
        //DatetimeRange[2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800]
        System.out.println(range);

        //Is 2019-04-24T00:11:08.777+0800 in side range: false
        System.out.println("Is 2019-04-24T00:11:08.777+0800 in side range: " + range.timeInRange(db.addDays(-1).asDate()));
        // Is 2019-04-25T00:11:08.777+0800 in side range: true
        System.out.println("Is 2019-04-25T00:11:08.777+0800 in side range: " + range.timeInRange(db.asDate()));
        // Is 2019-04-26T00:11:08.777+0800 in side range: true
        System.out.println("Is 2019-04-26T00:11:08.777+0800 in side range: " + range.timeInRange(db.addDays(1).asDate()));

        //Create SimpleDateFormat of format ISO8601
        SimpleDateFormat sdf = DateFormatBuilderInterface.Format.ISO8601.getFormatter();
        //2020-04-25T00:11:08.777+0800
        System.out.println(sdf.format(db.asDate()));

        sdf = D.f()
                .year4Digit().hyphen().month2Digit().hyphen().day2Digit().v1().v1("T")
                .hourInDay24().colon().minute().colon().second().dot().ms().TimeZoneRFC822()
                .build();
        // 2020-04-25T00:11:08.777+0800
        System.out.println(sdf.format(db.asDate()));


    }

    @Test
    public void t() {

        DatetimeBuilder db = D.dt().now().timeZone(BaseTimeZone.Hongkong).ymd(2020, MAY, 7).hms(18, 1, 1);
        System.out.println(db.format(DateFormatBuilderInterface.Format.ISO8601));
        System.out.println(db.timeZone(BaseTimeZone.Japan).format(DateFormatBuilderInterface.Format.ISO8601.getFormatter(BaseTimeZone.Japan.timeZone())));
        System.out.println(db.swapTimeZone(BaseTimeZone.Japan).format(DateFormatBuilderInterface.Format.ISO8601.getFormatter(BaseTimeZone.Japan.timeZone())));

    }

    /**
     * Test calendar date builder interface
     */
    @Test
    public void normalTest() {
        DatetimeBuilder db = new DatetimeBuilder(TimeZone.getDefault());
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.asDate()));
        assertEquals("1971-02-02T00:00:00.000+0000", sdf.format(db.addYear(1).addMonths(1).addDays(1).asDate()));

        // T y(int year);
        // TODO fail test
        //  assertEquals("0001-01-01T00:00:00.000+0800", sdf.format(db.y(1).asDate()));
        // T ym(int year, Month month);

        // TODO fail test
        //   assertEquals("0001-02-01T00:00:00.000+0800", sdf.format(db.ym(1, Month.FEB).asDate()));

        // T md(Month month, int day);
        assertEquals("1970-09-13T00:00:00.000+0000", sdf.format(db.md(SEP, 13).asDate()));

        // T ymd(int year, Month month, int day);
        // TODO fail test
        // assertEquals("0001-02-20T00:00:00.000+0800", sdf.format(db.ymd(1, Month.FEB, 20).asDate()));
        // TODO fail test
        // assertEquals("0001-02-01T00:00:00.000+0800", sdf.format(db.ymd(1, Month.JAN, 32).asDate()));
        // TODO fail test
        //  assertEquals("2007-01-02T00:00:00.000+0800", sdf.format(db.ymd(1, Month.JAN, 32).day(2).month(Month.JAN).year(2007).asDate()));
        // T minYear();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.year(2009).minYear().asDate()));
        // T year(final int year);
        assertEquals("2011-01-01T00:00:00.000+0000", sdf.format(db.y(2011).asDate()));
        // T minMonth();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.month(SEP).minMonth().asDate()));
        // T month(final Month month);
        assertEquals("1970-02-01T00:00:00.000+0000", sdf.format(db.month(Month.FEB).asDate()));
        // T minDay();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.addDays(23).minDay().asDate()));
        // T day(final int date);
        assertEquals("1970-01-03T00:00:00.000+0000", sdf.format(db.day(3).asDate()));
        // TODO fail test
        //  assertEquals("1970-02-02T00:00:00.000+0800", sdf.format(db.day(33).asDate()));
        // T firstDayOfMonth();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.day(21).firstDayOfMonth().asDate()));
        // T endDayOfMonth();
        assertEquals("1970-01-31T00:00:00.000+0000", sdf.format(db.day(21).endDayOfMonth().asDate()));
        // T addYear(final int years);
        assertEquals("1971-01-01T00:00:00.000+0000", sdf.format(db.addYear(1).asDate()));
        assertEquals("2970-01-01T00:00:00.000+0000", sdf.format(db.addYear(1000).asDate()));
        // TODO fail test offset issue
        //  assertEquals("0970-01-01T00:00:00.000+0800", sdf.format(db.addYear(-1000).asDate()));
        assertEquals("1969-01-01T00:00:00.000+0000", sdf.format(db.addYear(-1).asDate()));
        // T lastYear();
        assertEquals("1969-01-01T00:00:00.000+0000", sdf.format(db.lastYear().asDate()));
        // T nextYear();
        assertEquals("1971-01-01T00:00:00.000+0000", sdf.format(db.nextYear().asDate()));
        // T lastMonth();
        assertEquals("1969-12-01T00:00:00.000+0000", sdf.format(db.lastMonth().asDate()));
        // T nextMonth();
        assertEquals("1970-02-01T00:00:00.000+0000", sdf.format(db.nextMonth().asDate()));
        // T addMonths(final int months);
        assertEquals("1970-02-01T00:00:00.000+0000", sdf.format(db.addMonths(1).asDate()));
        assertEquals("1973-01-01T00:00:00.000+0000", sdf.format(db.addMonths(36).asDate()));
        assertEquals("1969-12-01T00:00:00.000+0000", sdf.format(db.addMonths(-1).asDate()));
        assertEquals("1967-01-01T00:00:00.000+0000", sdf.format(db.addMonths(-36).asDate()));
        // T addDays(final int days);
        assertEquals("1970-01-02T00:00:00.000+0000", sdf.format(db.addDays(1).asDate()));
        assertEquals("1971-01-02T00:00:00.000+0000", sdf.format(db.addDays(366).asDate()));
        assertEquals("1969-12-31T00:00:00.000+0000", sdf.format(db.addDays(-1).asDate()));
        assertEquals("1968-12-31T00:00:00.000+0000", sdf.format(db.addDays(-366).asDate()));
        // T yesterday();
        assertEquals("1969-12-31T00:00:00.000+0000", sdf.format(db.yesterday().asDate()));
        // T tomorrow();
        assertEquals("1970-01-02T00:00:00.000+0000", sdf.format(db.tomorrow().asDate()));
        // T nextWeekday(Weekday day);
        assertEquals("1970-01-05T00:00:00.000+0000", sdf.format(db.nextWeekday(Weekday.Monday).asDate()));
        // T prevWeekday(Weekday day);
        assertEquals("1969-12-29T00:00:00.000+0000", sdf.format(db.prevWeekday(Weekday.Monday).asDate()));
        // T startOfWeek(Weekday startDay);
        assertEquals("1969-12-29T00:00:00.000+0000", sdf.format(db.startOfWeek(Weekday.Monday).asDate()));
        // T endOfWeek(Weekday startDay);
        assertEquals("1970-01-04T00:00:00.000+0000", sdf.format(db.endOfWeek(Weekday.Monday).asDate()));
        // boolean sameYear(Long longDate);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asLong()));
        // boolean sameYear(Date date);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asDate()));
        // boolean sameYear(Calendar cal);
//        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asCalendar()));
        // boolean sameMonth(Long longDate);
        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asLong()));
        // boolean sameMonth(Date date);
        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asDate()));
        // boolean sameMonth(Calendar cal);
//        assertTrue(db.month(SEP).sameMonth(db.month(SEP).year(1022).day(22).asCalendar()));
        // boolean sameDay(Long longDate);
        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asLong()));
        // boolean sameDay(Date date);
        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asDate()));
        // boolean sameDay(Calendar cal);
//        assertTrue(db.day(13).sameMonth(db.day(13).y(1000).asCalendar()));

        // boolean sameDate(Long longDate);
        assertTrue(db.md(JUL, 23).sameDate(db.md(JUL, 23).asLong()));
        assertFalse(db.md(JUL, 21).sameDate(db.md(JUL, 23).asLong()));
        // boolean sameDate(Date date);
        assertTrue(db.md(JUL, 23).sameDate(db.md(JUL, 23).asLong()));
        assertFalse(db.md(JUL, 21).sameDate(db.md(JUL, 23).asLong()));
        // boolean sameDate(Calendar cal);
        assertTrue(db.md(JUL, 23).sameDate(db.md(JUL, 23).asLong()));
        assertFalse(db.md(JUL, 21).sameDate(db.md(JUL, 23).asLong()));

        assertTrue(db.md(JUL, 23).sameDate(db.md(JUL, 23)));
        assertFalse(db.md(JUL, 21).sameDate(db.md(JUL, 23)));

        db = new DatetimeBuilder(TimeZone.getDefault()).ymd(1970, JUL, 23);
        // boolean laterThan(Date date);
        assertTrue(db.month(Month.AUG).laterThan(db.asDate()));
        // boolean laterThan(Long longDate);
        assertTrue(db.month(Month.AUG).laterThan(db.asLong()));
        // boolean laterThan(Calendar calendar);
//        assertTrue(db.month(Month.AUG).laterThan(db.asCalendar()));
        assertTrue(db.month(Month.AUG).laterThan(db));

        // boolean laterEqualThan(Date date);
        assertTrue(db.md(JUL, 23).laterEqualThan(db.asDate()));
        // boolean laterEqualThan(Long longDate);
        assertTrue(db.md(JUL, 23).laterEqualThan(db.asLong()));
        // boolean laterEqualThan(Calendar calendar);
//        assertTrue(db.md(JUL, 23).laterEqualThan(db.asCalendar()));
        assertTrue(db.md(JUL, 23).laterEqualThan(db));

        // boolean before(Date date);
        assertTrue(db.month(Month.JUN).before(db.asDate()));
        // boolean before(Long longDate);
        assertTrue(db.month(Month.JUN).before(db.asLong()));
        // boolean before(Calendar calendar);
//        assertTrue(db.month(Month.JUN).before(db.asCalendar()));
        assertTrue(db.month(Month.JUN).before(db));

        // boolean beforeEqual(Date date);
        assertTrue(db.md(JUL, 23).beforeEqual(db.asDate()));
        // boolean beforeEqual(Long longDate);
        assertTrue(db.md(JUL, 23).beforeEqual(db.asLong()));
        // boolean beforeEqual(Calendar calendar);
//        assertTrue(db.md(JUL, 23).beforeEqual(db.asCalendar()));
        assertTrue(db.md(JUL, 23).beforeEqual(db));

    }

    @Test
    public void normalTest_Time() {
        DatetimeBuilder db = new DatetimeBuilder(TimeZone.getDefault());
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.asDate()));


        // T hmsms(int hour, int minute, int second, int mSecond);
        assertEquals("1970-01-01T04:05:06.088+0000", sdf.format(db.hmsms(4, 5, 6, 88).asDate()));
        // T hms(int hour, int minute, int second);
        assertEquals("1970-01-01T02:03:05.000+0000", sdf.format(db.hms(2, 3, 5).asDate()));
        // T hm(int hour, int minute);
        assertEquals("1970-01-01T22:11:00.000+0000", sdf.format(db.hm(22, 11).asDate()));
        // T h(int hour);
        assertEquals("1970-01-01T01:00:00.000+0000", sdf.format(db.h(1).asDate()));


        // T minHour();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.addHours(1).minHour().asDate()));
        // T maxHour();
        assertEquals("1970-01-01T23:00:00.000+0000", sdf.format(db.maxHour().asDate()));
        // T hour(final int hour);
        assertEquals("1970-01-01T01:00:00.000+0000", sdf.format(db.hour(1).asDate()));
        // T minMinute();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.addMins(1).minMinute().asDate()));
        // T maxMinute();
        assertEquals("1970-01-01T00:59:00.000+0000", sdf.format(db.maxMinute().asDate()));
        // T minute(final int min);
        assertEquals("1970-01-01T00:01:00.000+0000", sdf.format(db.minute(1).asDate()));
        // T minSecond();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.addSecond(1).minSecond().asDate()));
        // T maxSecond();
        assertEquals("1970-01-01T00:00:59.000+0000", sdf.format(db.maxSecond().asDate()));
        // T second(final int second);
        assertEquals("1970-01-01T00:00:01.000+0000", sdf.format(db.second(1).asDate()));
        // T minMs();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.addMS(1).minMs().asDate()));
        // T maxMs();
        assertEquals("1970-01-01T00:00:00.999+0000", sdf.format(db.maxMs().asDate()));
        // T ms(final int ms);
        assertEquals("1970-01-01T00:00:00.001+0000", sdf.format(db.ms(1).asDate()));
        // T maxDayTime();
        assertEquals("1970-01-01T23:59:59.999+0000", sdf.format(db.maxDayTime().asDate()));
        // T maxDayTimeSec();
        assertEquals("1970-01-01T23:59:59.000+0000", sdf.format(db.maxDayTimeSec().asDate()));
        // T maxDayTimeMin();
        assertEquals("1970-01-01T23:59:00.000+0000", sdf.format(db.maxDayTimeMin().asDate()));
        // T minDayTime();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.hmsms(23, 34, 55, 999).minDayTime().asDate()));

        sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.asDate()));
        // boolean sameDatetime(Long longDate);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameDatetime(Date date);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameDatetime(Calendar cal);
//        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).sameDatetime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameTime(Long dateLong);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameTime(Date date);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameTime(Calendar calendar);
//        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 500).sameTime(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameHMS(Long dateLong);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameHMS(Date date);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameHMS(Calendar calendar);
//        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 30, 700).sameHMS(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean sameHM(Long dateLong);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 40, 700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean sameHM(Date date);
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 40, 700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean sameHM(Calendar calendar);
//        assertTrue(db.md(AUG, 24).hmsms(1, 20, 40, 700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(AUG, 24).hmsms(1, 20, 40, 700).sameHM(db.addMonths(6).addDays(22).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // boolean laterThan(Date date);
        assertTrue(db.month(Month.AUG).laterThan(db.asDate()));
        // boolean laterThan(Long longDate);
        assertTrue(db.month(Month.AUG).laterThan(db.asLong()));
        // boolean laterThan(Calendar calendar);
//        assertTrue(db.month(Month.AUG).laterThan(db.asCalendar()));
        assertTrue(db.month(Month.AUG).laterThan(db));

        // boolean laterEqualThan(Date date);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).laterEqualThan(db.asDate()));
        // boolean laterEqualThan(Long longDate);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).laterEqualThan(db.asLong()));
        // boolean laterEqualThan(Calendar calendar);
//        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).laterEqualThan(db.asCalendar()));
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).laterEqualThan(db));

        // boolean before(Date date);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asDate()));
        // boolean before(Long longDate);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asLong()));
        // boolean before(Calendar calendar);
//        assertTrue(db.month(Month.JUN).before(db.month(AUG).asCalendar()));
        assertTrue(db.month(Month.JUN).before(db.month(AUG)));

        // boolean beforeEqual(Date date);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).beforeEqual(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asDate()));
        // boolean beforeEqual(Long longDate);
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).beforeEqual(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asLong()));
        // boolean beforeEqual(Calendar calendar);
//        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).beforeEqual(db.month(AUG).day(23).addHours(1).addMins(20).addSecond(30).addMS(500).asCalendar()));
        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).beforeEqual(db.month(AUG).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));

        // T addTime(final long time);
        assertEquals("1970-01-01T00:00:00.012+0000", sdf.format(db.addTime(12).asDate()));
        // T addHours(final int hours);
        assertEquals("1970-01-01T01:00:00.000+0000", sdf.format(db.addHours(1).asDate()));
        assertEquals("1970-01-02T01:00:00.000+0000", sdf.format(db.addHours(25).asDate()));
        assertEquals("1969-12-30T23:00:00.000+0000", sdf.format(db.addHours(-25).asDate()));
        assertEquals("1969-12-31T23:00:00.000+0000", sdf.format(db.addHours(-1).asDate()));
        // T addMins(final int mins);
        assertEquals("1970-01-01T00:01:00.000+0000", sdf.format(db.addMins(1).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0000", sdf.format(db.addMins(61).asDate()));
        assertEquals("1969-12-31T22:59:00.000+0000", sdf.format(db.addMins(-61).asDate()));
        assertEquals("1969-12-31T23:59:00.000+0000", sdf.format(db.addMins(-1).asDate()));
        // T addSecond(final int sec);
        assertEquals("1970-01-01T00:00:01.000+0000", sdf.format(db.addSecond(1).asDate()));
        assertEquals("1970-01-01T00:01:01.000+0000", sdf.format(db.addSecond(61).asDate()));
        assertEquals("1969-12-31T23:58:59.000+0000", sdf.format(db.addSecond(-61).asDate()));
        assertEquals("1969-12-31T23:59:59.000+0000", sdf.format(db.addSecond(-1).asDate()));
        // T addMS(final int ms);
        assertEquals("1970-01-01T00:00:00.001+0000", sdf.format(db.addMS(1).asDate()));
        assertEquals("1970-01-01T00:00:00.010+0000", sdf.format(db.addMS(10).asDate()));
        assertEquals("1970-01-01T00:00:01.010+0000", sdf.format(db.addMS(1010).asDate()));
        assertEquals("1969-12-31T23:59:58.990+0000", sdf.format(db.addMS(-1010).asDate()));
        assertEquals("1969-12-31T23:59:59.990+0000", sdf.format(db.addMS(-10).asDate()));
        assertEquals("1969-12-31T23:59:59.999+0000", sdf.format(db.addMS(-1).asDate()));
        // T timeZone(final BaseTimeZone timeZone);
        // Extract time on time UTC instead of HKT or default timezone, and the +0800 is from dateformat
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.timeZone(BaseTimeZone.UTC).asDate()));
        // T timeZone(final TimeZone timeZone);
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.timeZone(TimeZone.getTimeZone("UTC")).asDate()));

        // TODO not a valid test
        // T swrapTimeZone(final BaseTimeZone timeZone);
        // Extract time on Hong Kong timezone first and then swrap to UTC, and the +0800 is from dateformat
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.timeZone(BaseTimeZone.Hongkong).swapTimeZone(BaseTimeZone.UTC).asDate()));
        // TODO not a valid test
        // T timeZone(final TimeZone timeZone);
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.timeZone(BaseTimeZone.Hongkong).swapTimeZone(TimeZone.getTimeZone("UTC")).asDate()));
        // T timePartOnly();
        assertEquals("1970-01-01T12:33:55.999+0000", sdf.format(db.y(2999).day(30).hmsms(12, 33, 55, 999).timePartOnly().asDate()));
        assertEquals("1971-02-02T01:01:01.001+0000", sdf.format(db.addYear(1).addMonths(1).addDays(1).addHours(1).addMins(1).addSecond(1).addMS(1).asDate()));

        // the set millis second to zero operation because the date generated for two operation
        // is different, so we need to set the millis second to zero
        Date d1 = db.now().ms(0).asDate();
        Date d2 = new Date();
        d2.setTime(d2.getTime()/1000*1000);
        assertEquals(sdf.format(d1), sdf.format(d2));

        //Test if the db object is immutable
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(db.asDate()));

        assertTrue(db.md(JUL, 23).hmsms(1, 20, 30, 500).equals(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));
        assertFalse(db.md(JUL, 24).hmsms(1, 20, 30, 500).equals(db.month(JUL).day(23).addHours(1).addMins(20).addSecond(30).addMS(500)));
    }


}
