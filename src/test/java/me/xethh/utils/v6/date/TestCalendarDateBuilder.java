package me.xethh.utils.v6.date;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.baseInterface.CalendarDateBuilder;
import me.xethh.utils.dateUtils.baseInterface.CommonDateRepresentation;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Before;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateUtils.month.Month.*;
import static org.junit.Assert.*;

public class TestCalendarDateBuilder {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    public static <T extends CalendarDateBuilder<T> & CommonDateRepresentation> void test(T db) {
        Calendar cal = Calendar.getInstance();
        Date date = null;

        date = db.y(2011).asDate();
        cal.setTime(date);
        assertEquals(cal.get(Calendar.YEAR), 2011);

        date = db.ym(2012, FEB).asDate();
        cal.setTime(date);
        assertEquals(2012, cal.get(Calendar.YEAR));
        assertEquals(FEB.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.md(MAR, 11).asDate();
        cal.setTime(date);
        assertEquals(MAR.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(11, cal.get(Calendar.DAY_OF_MONTH));

        date = db.d(11).asDate();
        cal.setTime(date);
        assertEquals(11, cal.get(Calendar.DAY_OF_MONTH));

        date = db.ymd(2900, MAR, 11).asDate();
        cal.setTime(date);
        assertEquals(2900, cal.get(Calendar.YEAR));
        assertEquals(MAR.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(11, cal.get(Calendar.DAY_OF_MONTH));

        date = db.minYear().asDate();
        cal.setTime(date);
        assertEquals(1970, cal.get(Calendar.YEAR));

        date = db.year(1000).asDate();
        cal.setTime(date);
        assertEquals(1000, cal.get(Calendar.YEAR));

        date = db.minMonth().asDate();
        cal.setTime(date);
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.month(NOV).asDate();
        cal.setTime(date);
        assertEquals(NOV.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.maxMonth().asDate();
        cal.setTime(date);
        assertEquals(DEC.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.minDay().asDate();
        cal.setTime(date);
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));

        date = db.day(10).asDate();
        cal.setTime(date);
        assertEquals(10, cal.get(Calendar.DAY_OF_MONTH));

        date = db.firstDayOfMonth().asDate();
        cal.setTime(date);
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));

        date = db.ym(2020, APR).endDayOfMonth().asDate();
        cal.setTime(date);
        assertEquals(30, cal.get(Calendar.DAY_OF_MONTH));

        date = db.ym(2020, MAY).endDayOfMonth().asDate();
        cal.setTime(date);
        assertEquals(31, cal.get(Calendar.DAY_OF_MONTH));

        date = db.y(2020).addYear(1).asDate();
        cal.setTime(date);
        assertEquals(2021, cal.get(Calendar.YEAR));

        date = db.y(2020).lastYear().asDate();
        cal.setTime(date);
        assertEquals(2019, cal.get(Calendar.YEAR));

        date = db.y(2020).nextYear().asDate();
        cal.setTime(date);
        assertEquals(2021, cal.get(Calendar.YEAR));

        date = db.m(JAN).lastMonth().asDate();
        cal.setTime(date);
        assertEquals(DEC.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.m(JAN).nextMonth().asDate();
        cal.setTime(date);
        assertEquals(FEB.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.m(JAN).addMonths(14).nextMonth().asDate();
        cal.setTime(date);
        assertEquals(APR.toJavaCalNumber(), cal.get(Calendar.MONTH));

        date = db.ymd(2020, JAN, 1).addDays(40).asDate();
        cal.setTime(date);
        assertEquals(10, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(FEB.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).yesterday().asDate();
        cal.setTime(date);
        assertEquals(31, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(DEC.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2019, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).tomorrow().asDate();
        cal.setTime(date);
        assertEquals(2, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).nextWeekday(Weekday.Tuesday).asDate();
        cal.setTime(date);
        assertEquals(7, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).nextWeekday(Weekday.Wednesday).asDate();
        cal.setTime(date);
        assertEquals(8, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).prevWeekday(Weekday.Wednesday).asDate();
        cal.setTime(date);
        assertEquals(25, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(DEC.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2019, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).startOfWeek(Weekday.Wednesday).asDate();
        cal.setTime(date);
        assertEquals(1, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).startOfWeek(Weekday.Sunday).asDate();
        cal.setTime(date);
        assertEquals(29, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(DEC.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2019, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).endOfWeek(Weekday.Wednesday).asDate();
        cal.setTime(date);
        assertEquals(7, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.ymd(2020, JAN, 1).endOfWeek(Weekday.Sunday).asDate();
        cal.setTime(date);
        assertEquals(4, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(JAN.toJavaCalNumber(), cal.get(Calendar.MONTH));
        assertEquals(2020, cal.get(Calendar.YEAR));

        date = db.y(2022).asDate();
        assertTrue(db.ymd(2022, FEB, 3).sameYear(date.getTime()));
        assertTrue(db.ymd(2022, FEB, 4).sameYear(date));
        cal.setTime(date);
        assertTrue(db.ymd(2022, MAR, 8).sameYear(cal));

        date = db.m(JAN).asDate();
        assertTrue(db.ymd(2012, JAN, 7).sameMonth(date.getTime()));
        assertTrue(db.ymd(2013, JAN, 8).sameMonth(date));
        cal.setTime(date);
        assertTrue(db.ymd(2011, JAN, 9).sameMonth(cal));

        date = db.d(7).asDate();
        assertTrue(db.ymd(2012, JAN, 7).sameDay(date.getTime()));
        assertTrue(db.ymd(2013, JAN, 7).sameDay(date));
        cal.setTime(date);
        assertTrue(db.ymd(2011, JAN, 7).sameDay(cal));
        assertFalse(db.ymd(2011, JAN, 9).sameDay(cal));

        date = db.ymd(2016, JAN, 7).asDate();
        assertTrue(db.ymd(2016, JAN, 7).sameDate(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 7).sameDate(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 7).sameDate(cal));
        assertFalse(db.ymd(2011, FEB, 8).sameDate(date));

        date = db.ymd(2016, JAN, 7).asDate();
        assertTrue(db.ymd(2016, JAN, 8).laterThan(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 8).laterThan(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 8).laterThan(cal));
        assertFalse(db.ymd(2011, FEB, 8).laterThan(date));

        date = db.ymd(2016, JAN, 7).asDate();
        assertTrue(db.ymd(2016, JAN, 8).laterEqualThan(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 8).laterEqualThan(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 8).laterEqualThan(cal));
        assertFalse(db.ymd(2011, FEB, 8).laterEqualThan(date));

        assertTrue(db.ymd(2016, JAN, 7).laterEqualThan(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 7).laterEqualThan(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 7).laterEqualThan(cal));
        assertFalse(db.ymd(2011, FEB, 8).laterEqualThan(date));

        date = db.ymd(2016, JAN, 7).asDate();
        assertTrue(db.ymd(2016, JAN, 6).before(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 6).before(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 6).before(cal));
        assertFalse(db.ymd(2016, JAN, 7).before(date));
        assertFalse(db.ymd(2016, JAN, 8).before(date));

        date = db.ymd(2016, JAN, 7).asDate();
        assertTrue(db.ymd(2016, JAN, 7).beforeEqual(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 7).beforeEqual(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 7).beforeEqual(cal));
        assertFalse(db.ymd(2016, JAN, 8).beforeEqual(date));

        assertTrue(db.ymd(2016, JAN, 6).beforeEqual(date.getTime()));
        assertTrue(db.ymd(2016, JAN, 6).beforeEqual(date));
        cal.setTime(date);
        assertTrue(db.ymd(2016, JAN, 6).beforeEqual(cal));

        date = new Date();
        Date d = db.now().asDate();
        cal.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d);
        assertEquals(cal.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
        assertEquals(cal.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), cal2.get(Calendar.DAY_OF_MONTH));
    }
}
