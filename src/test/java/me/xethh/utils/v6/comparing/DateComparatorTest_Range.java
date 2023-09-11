package me.xethh.utils.v6.comparing;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.DatetimeRangeContainedBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class DateComparatorTest_Range {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    @Test
    public void sameDatetime() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        DatetimeRangeContainedBuilder d2 = d1.addYear(1).addYear(-1);
        DatetimeRangeContainedBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        assertEquals(true, d1.sameDatetime(d2));
        assertEquals(false, d1.sameDatetime(d3));

        assertEquals(true, d1.sameDatetime(d2.asLong()));
        assertEquals(false, d1.sameDatetime(d3.asLong()));

//        assertEquals(true, d1.sameDatetime(d2.asCalendar()));
//        assertEquals(false, d1.sameDatetime(d3.asCalendar()));

        assertEquals(true, d1.sameDatetime(d2.asDate()));
        assertEquals(false, d1.sameDatetime(d3.asDate()));
    }

    @Test
    public void sameYear() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        DatetimeRangeContainedBuilder d2 = d1.addYear(1);
        DatetimeRangeContainedBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        assertEquals(false, d1.sameYear(d2));
        assertEquals(true, d1.sameYear(d3));

        assertEquals(false, d1.sameYear(d2.asLong()));
        assertEquals(true, d1.sameYear(d3.asLong()));

//        assertEquals(false, d1.sameYear(d2.asCalendar()));
//        assertEquals(true, d1.sameYear(d3.asCalendar()));

        assertEquals(false, d1.sameYear(d2.asDate()));
        assertEquals(true, d1.sameYear(d3.asDate()));
    }

    @Test
    public void sameMonth() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        DatetimeRangeContainedBuilder d2 = d1.month(Month.JUL);
        DatetimeRangeContainedBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        assertEquals(false, d1.sameMonth(d2));
        assertEquals(true, d1.sameMonth(d3));

        assertEquals(false, d1.sameMonth(d2.asLong()));
        assertEquals(true, d1.sameMonth(d3.asLong()));

//        assertEquals(false, d1.sameMonth(d2.asCalendar()));
//        assertEquals(true, d1.sameMonth(d3.asCalendar()));

        assertEquals(false, d1.sameMonth(d2.asDate()));
        assertEquals(true, d1.sameMonth(d3.asDate()));
    }

    @Test
    public void sameDate() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        DatetimeRangeContainedBuilder d2 = d1.day(2);
        DatetimeRangeContainedBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        assertEquals(false, d1.sameDay(d2));
        assertEquals(true, d1.sameDay(d3));

        assertEquals(false, d1.sameDay(d2.asLong()));
        assertEquals(true, d1.sameDay(d3.asLong()));

//        assertEquals(false, d1.sameDay(d2.asCalendar()));
//        assertEquals(true, d1.sameDay(d3.asCalendar()));

        assertEquals(false, d1.sameDay(d2.asDate()));
        assertEquals(true, d1.sameDay(d3.asDate()));
    }

    @Test
    public void sameTime() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2);
        System.out.println("d2 ==> " + d2.toString());
        DatetimeRangeContainedBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        System.out.println("d3 ==> " + d3.toString());
        assertEquals(true, d1.sameTime(d2));
        assertEquals(false, d1.sameTime(d3));

        assertEquals(true, d1.sameTime(d2.asLong()));
        assertEquals(false, d1.sameTime(d3.asLong()));

//        assertEquals(true, d1.sameTime(d2.asCalendar()));
//        assertEquals(false, d1.sameTime(d3.asCalendar()));

        assertEquals(true, d1.sameTime(d2.asDate()));
        assertEquals(false, d1.sameTime(d3.asDate()));
    }

    @Test
    public void sameHMS() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(20).second(1);
        System.out.println("d2 ==> " + d2.toString());
        DatetimeRangeContainedBuilder d3 = d1.day(2).hour(10).minute(11).second(23);
        System.out.println("d3 ==> " + d3.toString());
        DatetimeRangeContainedBuilder d4 = d1.day(2).hour(11).minute(20).second(23);
        System.out.println("d4 ==> " + d4.toString());
        DatetimeRangeContainedBuilder d5 = d1.day(2).hour(10).minute(20).second(23);
        System.out.println("d5 ==> " + d5.toString());
        assertEquals(false, d1.sameHMS(d2));
        assertEquals(false, d1.sameHMS(d3));
        assertEquals(false, d1.sameHMS(d4));
        assertEquals(true, d1.sameHMS(d5));

        assertEquals(false, d1.sameHMS(d2.asDate()));
        assertEquals(false, d1.sameHMS(d3.asDate()));
        assertEquals(false, d1.sameHMS(d4.asDate()));
        assertEquals(true, d1.sameHMS(d5.asDate()));

        assertEquals(false, d1.sameHMS(d2.asLong()));
        assertEquals(false, d1.sameHMS(d3.asLong()));
        assertEquals(false, d1.sameHMS(d4.asLong()));
        assertEquals(true, d1.sameHMS(d5.asLong()));

//        assertEquals(false, d1.sameHMS(d2.asCalendar()));
//        assertEquals(false, d1.sameHMS(d3.asCalendar()));
//        assertEquals(false, d1.sameHMS(d4.asCalendar()));
//        assertEquals(true, d1.sameHMS(d5.asCalendar()));
    }

    @Test
    public void sameHM() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> " + d2.toString());
        DatetimeRangeContainedBuilder d3 = d1.day(2).hour(11).minute(20).second(23);
        System.out.println("d3 ==> " + d3.toString());
        DatetimeRangeContainedBuilder d5 = d1.day(2).hour(10).minute(20).second(3);
        System.out.println("d5 ==> " + d5.toString());
        assertEquals(false, d1.sameHM(d2));
        assertEquals(false, d1.sameHM(d3));
        assertEquals(true, d1.sameHM(d5));

        assertEquals(false, d1.sameHM(d2.asDate()));
        assertEquals(false, d1.sameHM(d3.asDate()));
        assertEquals(true, d1.sameHM(d5.asDate()));

        assertEquals(false, d1.sameHM(d2.asLong()));
        assertEquals(false, d1.sameHM(d3.asLong()));
        assertEquals(true, d1.sameHM(d5.asLong()));

//        assertEquals(false, d1.sameHM(d2.asCalendar()));
//        assertEquals(false, d1.sameHM(d3.asCalendar()));
//        assertEquals(true, d1.sameHM(d5.asCalendar()));
    }

    @Test
    public void laterThan() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> " + d2.toString());

        assertEquals(false, d1.laterThan(d2));
        assertEquals(true, d2.laterThan(d1));
        assertEquals(false, d1.laterThan(d2.asDate()));
        assertEquals(true, d2.laterThan(d1.asDate()));
        assertEquals(false, d1.laterThan(d2.asLong()));
        assertEquals(true, d2.laterThan(d1.asLong()));
//        assertEquals(false, d1.laterThan(d2.asCalendar()));
//        assertEquals(true, d2.laterThan(d1.asCalendar()));
        assertEquals(false, d1.laterThan(new Date()));
        assertEquals(false, d2.laterThan(new Date()));
    }

    @Test
    public void before() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> " + d2.toString());

        assertEquals(true, d1.before(d2));
        assertEquals(false, d2.before(d1));
        assertEquals(true, d1.before(d2.asDate()));
        assertEquals(false, d2.before(d1.asDate()));
        assertEquals(true, d1.before(d2.asLong()));
        assertEquals(false, d2.before(d1.asLong()));
//        assertEquals(true, d1.before(d2.asCalendar()));
//        assertEquals(false, d2.before(d1.asCalendar()));
        assertEquals(true, d1.before(new Date()));
        assertEquals(true, d2.before(new Date()));
    }

    @Test
    public void laterEqualThan() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> " + d2.toString());
        DatetimeRangeContainedBuilder d3 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d3 ==> " + d3.toString());

        assertEquals(false, d1.laterEqualThan(d2));
        assertEquals(true, d2.laterEqualThan(d1));
        assertEquals(true, d3.laterEqualThan(d2));

        assertEquals(false, d1.laterEqualThan(d2.asLong()));
        assertEquals(true, d2.laterEqualThan(d1.asLong()));
        assertEquals(true, d3.laterEqualThan(d2.asLong()));

//        assertEquals(false, d1.laterEqualThan(d2.asCalendar()));
//        assertEquals(true, d2.laterEqualThan(d1.asCalendar()));
//        assertEquals(true, d3.laterEqualThan(d2.asCalendar()));

        assertEquals(false, d1.laterEqualThan(d2.asDate()));
        assertEquals(true, d2.laterEqualThan(d1.asDate()));
        assertEquals(true, d3.laterEqualThan(d2.asDate()));
    }

    @Test
    public void beforeEqual() {
        DatetimeRangeContainedBuilder d1 = DatetimeFactory.instance().raw().hour(10).minute(20).second(23).ms(345).rangeTo(DatetimeFactory.instance().raw()).editStart();
        System.out.println("d1 ==> " + d1.toString());
        DatetimeRangeContainedBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> " + d2.toString());
        DatetimeRangeContainedBuilder d3 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d3 ==> " + d3.toString());

        assertEquals(true, d1.beforeEqual(d2));
        assertEquals(false, d2.beforeEqual(d1));
        assertEquals(true, d3.beforeEqual(d2));

        assertEquals(true, d1.beforeEqual(d2.asLong()));
        assertEquals(false, d2.beforeEqual(d1.asLong()));
        assertEquals(true, d3.beforeEqual(d2.asLong()));

//        assertEquals(true, d1.beforeEqual(d2.asCalendar()));
//        assertEquals(false, d2.beforeEqual(d1.asCalendar()));
//        assertEquals(true, d3.beforeEqual(d2.asCalendar()));

        assertEquals(true, d1.beforeEqual(d2.asDate()));
        assertEquals(false, d2.beforeEqual(d1.asDate()));
        assertEquals(true, d3.beforeEqual(d2.asDate()));
    }
}
