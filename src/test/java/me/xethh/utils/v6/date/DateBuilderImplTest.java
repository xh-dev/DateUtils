package me.xethh.utils.v6.date;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DateBuilderImplTest {
    @Test
    public void normalTest(){
        DateBuilderImpl db = new DateBuilderImpl();
        SimpleDateFormat sdf = DateFormatBuilderImpl.ISO8601();
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(db.addYear(1).asDate()));
        assertEquals("2970-01-01T00:00:00.000+0800",sdf.format(db.addYear(1000).asDate()));
        assertEquals("0970-01-01T00:00:00.000+0800",sdf.format(db.addYear(-1000).asDate()));
        assertEquals("1969-01-01T00:00:00.000+0800",sdf.format(db.addYear(-1).asDate()));

        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.addMonths(1).asDate()));
        assertEquals("1973-01-01T00:00:00.000+0800",sdf.format(db.addMonths(36).asDate()));
        assertEquals("1969-12-01T00:00:00.000+0800",sdf.format(db.addMonths(-1).asDate()));
        assertEquals("1967-01-01T00:00:00.000+0800",sdf.format(db.addMonths(-36).asDate()));

        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(db.addDays(1).asDate()));
        assertEquals("1971-01-02T00:00:00.000+0800",sdf.format(db.addDays(366).asDate()));
        assertEquals("1969-12-31T00:00:00.000+0800",sdf.format(db.addDays(-1).asDate()));
        assertEquals("1968-12-31T00:00:00.000+0800",sdf.format(db.addDays(-366).asDate()));


        assertEquals("1971-02-02T00:00:00.000+0800",sdf.format(db.addYear(1).addMonths(1).addDays(1).asDate()));


        assertEquals("0001-01-01T00:00:00.000+0800",sdf.format(db.y(1).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.month(Month.FEB).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(db.day(3).asDate()));
        assertEquals("1970-02-02T00:00:00.000+0800",sdf.format(db.day(33).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ym(1,Month.FEB).asDate()));
        assertEquals("1970-09-13T00:00:00.000+0800",sdf.format(db.md(Month.SEP,13).asDate()));
        assertEquals("0001-02-20T00:00:00.000+0800",sdf.format(db.ymd(1,Month.FEB,20).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).asDate()));
        assertEquals("2007-01-02T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).day(2).month(Month.JAN).year(2007).asDate()));

        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.year(2009).minYear().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.month(Month.SEP).minMonth().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addDays(23).minDay().asDate()));

        assertEquals("1969-01-01T00:00:00.000+0800",sdf.format(db.lastYear().asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(db.nextYear().asDate()));
        assertEquals("1969-12-01T00:00:00.000+0800",sdf.format(db.lastMonth().asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.nextMonth().asDate()));
        assertEquals("1969-12-31T00:00:00.000+0800",sdf.format(db.yesterday().asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(db.tomorrow().asDate()));

        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("1970-01-05T00:00:00.000+0800",sdf.format(db.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.startOfWeek(Weekday.Monday).asDate()));
        assertEquals("1970-01-04T00:00:00.000+0800",sdf.format(db.endOfWeek(Weekday.Monday).asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.day(21).firstDayOfMonth().asDate()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(db.day(21).endDayOfMonth().asDate()));

        Date d1 = db.now().asDate();
        Date d2 = new Date();
        assertEquals(DateFormatBuilderImpl.get().year4Digit().hyphen().month2Digit().hyphen().day2Digit().build().format(d2)+"T00:00:00.000+0800",sdf.format(d1));

        //Test if the db object is immutable
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));
    }
}
