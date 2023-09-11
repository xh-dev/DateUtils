package me.xethh.utils.date;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.xethh.utils.dateUtils.month.Month.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DateTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }

    @Test
    public void extractDate() {
        DateBuilder builder = new DateBuilder();
        DatetimeBuilder nowTime = DatetimeFactory.instance().from(new Date());
        DateBuilder nowDate = builder.now();
        assertEquals(nowTime.view().year(), nowDate.view().year());
        assertEquals(nowTime.view().month(), nowDate.view().month());
        assertEquals(nowTime.view().day(), nowDate.view().day());
        assertEquals(Integer.valueOf(0), nowDate.view().hour());
        assertEquals(Integer.valueOf(0), nowDate.view().min());
        assertEquals(Integer.valueOf(0), nowDate.view().second());

        DateInfo dateView = builder.ymd(2018, SEP, 2).view();

        assertEquals(Integer.valueOf(2018), dateView.year());
        assertEquals(SEP, dateView.month());
        assertEquals(Integer.valueOf(2), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());
    }

    @Test
    public void testRawMethod() {
        DateInfo dateView;

        DateBuilder date = DateFactory.instance().raw().ymd(2033, OCT, 17);
        dateView = date.view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.y(2077).view();
        assertEquals(Integer.valueOf(2077), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ym(2077, JAN).view();
        assertEquals(Integer.valueOf(2077), dateView.year());
        assertEquals(JAN, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.md(DEC, 18).view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(DEC, dateView.month());
        assertEquals(Integer.valueOf(18), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(3000, NOV, 8).view();
        assertEquals(Integer.valueOf(3000), dateView.year());
        assertEquals(NOV, dateView.month());
        assertEquals(Integer.valueOf(8), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.minYear().view();
        assertEquals(Integer.valueOf(1970), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.year(2011).view();
        assertEquals(Integer.valueOf(2011), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.minMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(JAN, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.month(JUL).view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(JUL, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.minDay().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.day(10).view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(10), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.firstDayOfMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.endDayOfMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(31), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.month(FEB).endDayOfMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(28), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ym(2020, FEB).endDayOfMonth().view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(29), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addYear(1).view();
        assertEquals(Integer.valueOf(2034), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addYear(-1).view();
        assertEquals(Integer.valueOf(2032), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addYear(-200).view();
        assertEquals(Integer.valueOf(1833), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addYear(1000).view();
        assertEquals(Integer.valueOf(3033), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.lastMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(SEP, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.nextYear().view();
        assertEquals(Integer.valueOf(2034), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.nextMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(NOV, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.nextMonth().nextMonth().nextMonth().view();
        assertEquals(Integer.valueOf(2034), dateView.year());
        assertEquals(JAN, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.month(FEB).lastMonth().lastMonth().view();
        assertEquals(Integer.valueOf(2032), dateView.year());
        assertEquals(DEC, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.month(FEB).lastMonth().view();
        assertEquals(Integer.valueOf(2033), dateView.year());
        assertEquals(JAN, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addMonths(11).view();
        assertEquals(Integer.valueOf(2034), dateView.year());
        assertEquals(SEP, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.addMonths(-11).view();
        assertEquals(Integer.valueOf(2032), dateView.year());
        assertEquals(NOV, dateView.month());
        assertEquals(Integer.valueOf(17), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 1).addDays(28).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(29), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 1).addDays(29).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 1).addDays(-31).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(JAN, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).yesterday().view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(27), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).yesterday().yesterday().view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(26), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).tomorrow().view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(29), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).tomorrow().tomorrow().view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).nextWeekday(Weekday.Saturday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(29), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).nextWeekday(Weekday.Saturday).nextWeekday(Weekday.Saturday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(7), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).nextWeekday(Weekday.Saturday).nextWeekday(Weekday.Sunday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(1), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).nextWeekday(Weekday.Friday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(6), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).prevWeekday(Weekday.Friday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(21), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).prevWeekday(Weekday.Friday).prevWeekday(Weekday.Friday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(14), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).startOfWeek(Weekday.Sunday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(23), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).startOfWeek(Weekday.Friday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(28), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).endOfWeek(Weekday.Sunday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(FEB, dateView.month());
        assertEquals(Integer.valueOf(29), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());

        dateView = date.ymd(2020, FEB, 28).endOfWeek(Weekday.Friday).view();
        assertEquals(Integer.valueOf(2020), dateView.year());
        assertEquals(MAR, dateView.month());
        assertEquals(Integer.valueOf(5), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());
    }

    @Test
    public void testView() {
        DateInfo dateView = DateFactory.instance().now().ymd(2122, OCT, 7).view();
        assertEquals(Integer.valueOf(2122), dateView.year());
        assertEquals(OCT, dateView.month());
        assertEquals(Integer.valueOf(7), dateView.day());
        assertEquals(Integer.valueOf(0), dateView.hour());
        assertEquals(Integer.valueOf(0), dateView.min());
        assertEquals(Integer.valueOf(0), dateView.second());
    }

    @Test
    public void testRange() {
        DatetimeRange dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeTo(DateFactory.instance().now().ymd(2019, JAN, 1).addDays(10));
        assertTrue(dr.isValid());
        SimpleDateFormat fmt = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.endAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeTo(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10));
        assertTrue(dr.isValid());
        fmt = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.endAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeTo(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asDate());
        assertTrue(dr.isValid());
        fmt = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.endAsDate()));

//        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeTo(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asCalendar());
//        assertTrue(dr.isValid());
//        fmt = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
//        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
//        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.endAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeTo(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asLong());
        assertTrue(dr.isValid());
        fmt = DateFormatBuilderInterface.Format.FULL_DATETIME.getFormatter();
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.endAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeFrom(DateFactory.instance().now().ymd(2019, JAN, 1).addDays(10));
        assertTrue(dr.isInvalid());
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.endAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.startAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeFrom(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10));
        assertTrue(dr.isInvalid());
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.endAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.startAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeFrom(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asDate());
        assertTrue(dr.isInvalid());
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.endAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.startAsDate()));

//        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeFrom(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asCalendar());
//        assertTrue(dr.isInvalid());
//        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.endAsDate()));
//        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.startAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeFrom(DatetimeFactory.instance().raw().ymd(2019, JAN, 1).addDays(10).asLong());
        assertTrue(dr.isInvalid());
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.endAsDate()));
        assertEquals("2019-01-11 00:00:00.000", fmt.format(dr.startAsDate()));

        dr = DateFactory.instance().now().ymd(2019, JAN, 1).rangeToSelf();
        assertTrue(dr.isValid());
        assertEquals("2019-01-01 00:00:00.000", fmt.format(dr.startAsDate()));
        assertEquals("2019-01-01 23:59:59.999", fmt.format(dr.endAsDate()));
    }

    @Test
    public void testComparison() {
        DateBuilder d1 = DateFactory.instance().raw().ymd(2019, FEB, 1);
        DateBuilder d2 = DateFactory.instance().raw().ymd(2079, FEB, 13);
        DateBuilder  d3 = DateFactory.instance().raw().ymd(2019, OCT, 12);
        DatetimeBuilder d4 = DatetimeFactory.instance().raw().ymd(2079, FEB, 13);
        DatetimeBuilder d5 = DatetimeFactory.instance().raw().ymd(2019, APR, 17);
        DateBuilder d6 = DateFactory.instance().raw().ymd(2019, FEB, 1);
        DatetimeBuilder d7 = DatetimeFactory.instance().raw().ymd(2019, FEB, 1);

        assertFalse(d1.sameYear(d2));
        assertTrue(d1.sameYear(d3));
        assertFalse(d1.sameYear(d4));
        assertTrue(d1.sameYear(d5));
        assertTrue(d1.sameYear(d5.asLong()));
        assertTrue(d1.sameYear(d5.asDate()));
//        assertTrue(d1.sameYear(d5.asCalendar()));

        assertTrue(d1.sameMonth(d2));
        assertFalse(d1.sameMonth(d3));
        assertTrue(d1.sameMonth(d4));
        assertFalse(d1.sameMonth(d5));
        assertTrue(d1.sameMonth(d4.asLong()));
        assertTrue(d1.sameMonth(d4.asDate()));
//        assertTrue(d1.sameMonth(d4.asCalendar()));

        assertFalse(d1.sameDay(d2));
        assertTrue(d1.sameDay(d6));
        assertFalse(d1.sameDay(d4));
        assertTrue(d1.sameDay(d7));
        assertTrue(d1.sameDay(d7.asLong()));
        assertTrue(d1.sameDay(d7.asDate()));
//        assertTrue(d1.sameDay(d7.asCalendar()));

        assertFalse(d1.laterThan(d2));
        assertFalse(d1.laterEqualThan(d2));
        assertTrue(d1.before(d2));
        assertTrue(d1.beforeEqual(d2));
        assertFalse(d1.laterThan(d1));
        assertTrue(d1.laterEqualThan(d1));
        assertFalse(d1.before(d1));
        assertTrue(d1.beforeEqual(d1));

        assertFalse(d1.laterThan(d4));
        assertFalse(d1.laterEqualThan(d4));
        assertTrue(d1.before(d4));
        assertTrue(d1.beforeEqual(d4));
        assertFalse(d1.laterThan(d1.asDatetimeBuilder()));
        assertTrue(d1.laterEqualThan(d1.asDatetimeBuilder()));
        assertFalse(d1.before(d1.asDatetimeBuilder()));
        assertTrue(d1.beforeEqual(d1.asDatetimeBuilder()));

    }

    @Test
    public void testTimeUnit() {
        DateBuilder d1 = DateFactory.instance().raw().ymd(2000, OCT, 3);
        DateBuilder d2 = DateFactory.instance().raw().ymd(2000, OCT, 3).addDays(1);
        DatetimeBuilder d3 = DatetimeFactory.instance().raw().ymd(2000, NOV, 5);
        assertEquals(1, d1.diffTo(d2).numberOfDays());
        assertEquals(24, d1.diffTo(d2).numberOfHour());
        assertEquals(33, d1.diffTo(d3).numberOfDays());
        assertEquals(33 * 24, d1.diffTo(d3).numberOfHour());

        assertEquals(-1, d1.diffFrom(d2).numberOfDays());
        assertEquals(-24, d1.diffFrom(d2).numberOfHour());
        assertEquals(-33, d1.diffFrom(d3).numberOfDays());
        assertEquals(-33 * 24, d1.diffFrom(d3).numberOfHour());
    }
}
