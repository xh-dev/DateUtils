package me.xethh.utils.v6.date;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.*;
import static org.junit.Assert.*;

public class DateBuilderImplTest {
    /**
     * Test calendar date builder interface
     */
    @Test
    public void normalTest() {
        DateBuilder db = new DateBuilderImpl();
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.asDate()));
        assertEquals("1971-02-02T00:00:00.000+0800", sdf.format(db.addYear(1).addMonths(1).addDays(1).asDate()));

        // T y(int year);
        assertEquals("0001-01-01T00:00:00.000+0800", sdf.format(db.y(1).asDate()));
        // T ym(int year, Month month);
        assertEquals("0001-02-01T00:00:00.000+0800", sdf.format(db.ym(1, Month.FEB).asDate()));
        // T md(Month month, int day);
        assertEquals("1970-09-13T00:00:00.000+0800", sdf.format(db.md(Month.SEP, 13).asDate()));
        // T ymd(int year, Month month, int day);
        assertEquals("0001-02-20T00:00:00.000+0800", sdf.format(db.ymd(1, Month.FEB, 20).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800", sdf.format(db.ymd(1, Month.JAN, 32).asDate()));
        assertEquals("2007-01-02T00:00:00.000+0800", sdf.format(db.ymd(1, Month.JAN, 32).day(2).month(Month.JAN).year(2007).asDate()));
        // T minYear();
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.year(2009).minYear().asDate()));
        // T year(final int year);
        assertEquals("2011-01-01T00:00:00.000+0800", sdf.format(db.y(2011).asDate()));
        // T minMonth();
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.month(Month.SEP).minMonth().asDate()));
        // T month(final Month month);
        assertEquals("1970-02-01T00:00:00.000+0800", sdf.format(db.month(Month.FEB).asDate()));
        // T minDay();
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.addDays(23).minDay().asDate()));
        // T day(final int date);
        assertEquals("1970-01-03T00:00:00.000+0800", sdf.format(db.day(3).asDate()));
        assertEquals("1970-02-02T00:00:00.000+0800", sdf.format(db.day(33).asDate()));
        // T firstDayOfMonth();
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.day(21).firstDayOfMonth().asDate()));
        // T endDayOfMonth();
        assertEquals("1970-01-31T00:00:00.000+0800", sdf.format(db.day(21).endDayOfMonth().asDate()));
        // T addYear(final int years);
        assertEquals("1971-01-01T00:00:00.000+0800", sdf.format(db.addYear(1).asDate()));
        assertEquals("2970-01-01T00:00:00.000+0800", sdf.format(db.addYear(1000).asDate()));
        assertEquals("0970-01-01T00:00:00.000+0800", sdf.format(db.addYear(-1000).asDate()));
        assertEquals("1969-01-01T00:00:00.000+0800", sdf.format(db.addYear(-1).asDate()));
        // T lastYear();
        assertEquals("1969-01-01T00:00:00.000+0800", sdf.format(db.lastYear().asDate()));
        // T nextYear();
        assertEquals("1971-01-01T00:00:00.000+0800", sdf.format(db.nextYear().asDate()));
        // T lastMonth();
        assertEquals("1969-12-01T00:00:00.000+0800", sdf.format(db.lastMonth().asDate()));
        // T nextMonth();
        assertEquals("1970-02-01T00:00:00.000+0800", sdf.format(db.nextMonth().asDate()));
        // T addMonths(final int months);
        assertEquals("1970-02-01T00:00:00.000+0800", sdf.format(db.addMonths(1).asDate()));
        assertEquals("1973-01-01T00:00:00.000+0800", sdf.format(db.addMonths(36).asDate()));
        assertEquals("1969-12-01T00:00:00.000+0800", sdf.format(db.addMonths(-1).asDate()));
        assertEquals("1967-01-01T00:00:00.000+0800", sdf.format(db.addMonths(-36).asDate()));
        // T addDays(final int days);
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(db.addDays(1).asDate()));
        assertEquals("1971-01-02T00:00:00.000+0800", sdf.format(db.addDays(366).asDate()));
        assertEquals("1969-12-31T00:00:00.000+0800", sdf.format(db.addDays(-1).asDate()));
        assertEquals("1968-12-31T00:00:00.000+0800", sdf.format(db.addDays(-366).asDate()));
        // T yesterday();
        assertEquals("1969-12-31T00:00:00.000+0800", sdf.format(db.yesterday().asDate()));
        // T tomorrow();
        assertEquals("1970-01-02T00:00:00.000+0800", sdf.format(db.tomorrow().asDate()));
        // T nextWeekday(Weekday day);
        assertEquals("1970-01-05T00:00:00.000+0800", sdf.format(db.nextWeekday(Weekday.Monday).asDate()));
        // T prevWeekday(Weekday day);
        assertEquals("1969-12-29T00:00:00.000+0800", sdf.format(db.prevWeekday(Weekday.Monday).asDate()));
        // T startOfWeek(Weekday startDay);
        assertEquals("1969-12-29T00:00:00.000+0800", sdf.format(db.startOfWeek(Weekday.Monday).asDate()));
        // T endOfWeek(Weekday startDay);
        assertEquals("1970-01-04T00:00:00.000+0800", sdf.format(db.endOfWeek(Weekday.Monday).asDate()));
        // boolean sameYear(Long longDate);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asLong()));
        // boolean sameYear(Date date);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asDate()));
        // boolean sameYear(Calendar cal);
        assertTrue(db.year(2099).sameYear(db.year(2099).md(DEC, 20).asCalendar()));
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

        db = new DateBuilderImpl().ymd(1970, JUL, 23);
        // boolean laterThan(Date date);
        assertTrue(db.month(Month.AUG).laterThan(db.asDate()));
        // boolean laterThan(Long longDate);
        assertTrue(db.month(Month.AUG).laterThan(db.asLong()));
        // boolean laterThan(Calendar calendar);
        assertTrue(db.month(Month.AUG).laterThan(db.asCalendar()));
        assertTrue(db.month(Month.AUG).laterThan(db));

        // boolean laterEqualThan(Date date);
        assertTrue(db.md(JUL, 23).laterEqualThan(db.asDate()));
        // boolean laterEqualThan(Long longDate);
        assertTrue(db.md(JUL, 23).laterEqualThan(db.asLong()));
        // boolean laterEqualThan(Calendar calendar);
        assertTrue(db.md(JUL, 23).laterEqualThan(db.asCalendar()));
        assertTrue(db.md(JUL, 23).laterEqualThan(db));

        // boolean before(Date date);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asDate()));
        // boolean before(Long longDate);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asLong()));
        // boolean before(Calendar calendar);
        assertTrue(db.month(Month.JUN).before(db.month(AUG).asCalendar()));
        assertTrue(db.month(Month.JUN).before(db.month(AUG)));

        // boolean beforeEqual(Date date);
        assertTrue(db.md(JUL, 23).beforeEqual(db.asDate()));
        // boolean beforeEqual(Long longDate);
        assertTrue(db.md(JUL, 23).beforeEqual(db.asLong()));
        // boolean beforeEqual(Calendar calendar);
        assertTrue(db.md(JUL, 23).beforeEqual(db.asCalendar()));
        assertTrue(db.md(JUL, 23).beforeEqual(db));

    }

    @Test
    public void testImutability() {
        DateBuilder db = new DateBuilderImpl();
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        Date d1 = db.now().asDate();
        Date d2 = new Date();
        assertEquals(DateFormatBuilderImpl.get().year4Digit().hyphen().month2Digit().hyphen().day2Digit().build().format(d2) + "T00:00:00.000+0800", sdf.format(d1));
        assertEquals("1970-01-01T00:00:00.000+0800", sdf.format(db.asDate()));
        assertTrue(db.md(JUL, 23).equals(db.md(JUL, 23)));
        assertFalse(db.md(AUG, 23).equals(db.md(JUL, 23)));
    }

    @Test
    public void testFormatterBuilder() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        TestFormatBuilder.test(db);

    }

    @Test
    public void testTimeUnitConverter() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        TestTimeUnitConverter.test(db);
    }

    @Test
    public void testCommonDateRepresentation() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        TestCommonDateRepresentation.test(db);
    }

    @Test
    public void testCalendarDateBuilder() {
        DateBuilderImpl db = new DateBuilderImpl();
        TestCalendarDateBuilder.test(db);
    }


}
