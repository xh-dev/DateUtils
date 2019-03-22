package me.xethh.utils.v6.datetime;

import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class DatetimeBuilderImplTest {
    @Test
    public void normalTest(){
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(TimeZone.getDefault());
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

        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.addHours(1).asDate()));
        assertEquals("1970-01-02T01:00:00.000+0800",sdf.format(db.addHours(25).asDate()));
        assertEquals("1969-12-30T23:00:00.000+0800",sdf.format(db.addHours(-25).asDate()));
        assertEquals("1969-12-31T23:00:00.000+0800",sdf.format(db.addHours(-1).asDate()));

        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(db.addMins(1).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(db.addMins(61).asDate()));
        assertEquals("1969-12-31T22:59:00.000+0800",sdf.format(db.addMins(-61).asDate()));
        assertEquals("1969-12-31T23:59:00.000+0800",sdf.format(db.addMins(-1).asDate()));

        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(db.addSecond(1).asDate()));
        assertEquals("1970-01-01T00:01:01.000+0800",sdf.format(db.addSecond(61).asDate()));
        assertEquals("1969-12-31T23:58:59.000+0800",sdf.format(db.addSecond(-61).asDate()));
        assertEquals("1969-12-31T23:59:59.000+0800",sdf.format(db.addSecond(-1).asDate()));

        assertEquals("1970-01-01T00:00:00.001+0800",sdf.format(db.addMS(1).asDate()));
        assertEquals("1970-01-01T00:00:00.010+0800",sdf.format(db.addMS(10).asDate()));
        assertEquals("1970-01-01T00:00:01.010+0800",sdf.format(db.addMS(1010).asDate()));
        assertEquals("1969-12-31T23:59:58.990+0800",sdf.format(db.addMS(-1010).asDate()));
        assertEquals("1969-12-31T23:59:59.990+0800",sdf.format(db.addMS(-10).asDate()));
        assertEquals("1969-12-31T23:59:59.999+0800",sdf.format(db.addMS(-1).asDate()));

        assertEquals("1971-02-02T01:01:01.001+0800",sdf.format(db.addYear(1).addMonths(1).addDays(1).addHours(1).addMins(1).addSecond(1).addMS(1).asDate()));


        assertEquals("0001-01-01T00:00:00.000+0800",sdf.format(db.y(1).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.month(Month.FEB).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(db.day(3).asDate()));
        assertEquals("1970-02-02T00:00:00.000+0800",sdf.format(db.day(33).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ym(1,Month.FEB).asDate()));
        assertEquals("1970-09-13T00:00:00.000+0800",sdf.format(db.md(Month.SEP,13).asDate()));
        assertEquals("0001-02-20T00:00:00.000+0800",sdf.format(db.ymd(1,Month.FEB,20).asDate()));
        assertEquals("0001-02-01T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).asDate()));
        assertEquals("2007-01-02T00:00:00.000+0800",sdf.format(db.ymd(1,Month.JAN,32).day(2).month(Month.JAN).year(2007).asDate()));

        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.hour(1).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(db.minute(1).asDate()));
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(db.second(1).asDate()));
        assertEquals("1970-01-01T00:00:00.001+0800",sdf.format(db.ms(1).asDate()));

        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(db.h(1).asDate()));
        assertEquals("1970-01-01T22:11:00.000+0800",sdf.format(db.hm(22,11).asDate()));
        assertEquals("1970-01-01T02:03:05.000+0800",sdf.format(db.hms(2,3,5).asDate()));
        assertEquals("1970-01-01T04:05:06.088+0800",sdf.format(db.hmsms(4,5,6,88).asDate()));

        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addMS(1).minMs().asDate()));
        assertEquals("1970-01-01T00:00:00.999+0800",sdf.format(db.maxMs().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addSecond(1).minSecond().asDate()));
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(db.maxSecond().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addMins(1).minMinute().asDate()));
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(db.maxMinute().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addHours(1).minHour().asDate()));
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(db.maxHour().asDate()));


        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.hmsms(23,34,55,999).minDayTime().asDate()));
        assertEquals("1970-01-01T23:59:59.999+0800",sdf.format(db.maxDayTime().asDate()));
        assertEquals("1970-01-01T23:59:00.000+0800",sdf.format(db.maxDayTimeMin().asDate()));
        assertEquals("1970-01-01T23:59:59.000+0800",sdf.format(db.maxDayTimeSec().asDate()));
        assertEquals("1970-01-01T12:33:55.999+0800",sdf.format(db.y(2999).day(30).hmsms(12,33,55,999).timePartOnly().asDate()));

        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.year(2009).minYear().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.month(Month.SEP).minMonth().asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.addDays(23).minDay().asDate()));

        assertEquals("1969-01-01T00:00:00.000+0800",sdf.format(db.lastYear().asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(db.nextYear().asDate()));
        assertEquals("1969-12-01T00:00:00.000+0800",sdf.format(db.lastMonth().asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(db.nextMonth().asDate()));
        assertEquals("1969-12-31T00:00:00.000+0800",sdf.format(db.yesterday().asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(db.tomorrow().asDate()));

        assertEquals("1970-01-01T00:00:00.012+0800",sdf.format(db.addTime(12).asDate()));

        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.prevWeekday(Weekday.Monday).asDate()));
        assertEquals("1970-01-05T00:00:00.000+0800",sdf.format(db.nextWeekday(Weekday.Monday).asDate()));
        assertEquals("1969-12-29T00:00:00.000+0800",sdf.format(db.startOfWeek(Weekday.Monday).asDate()));
        assertEquals("1970-01-04T00:00:00.000+0800",sdf.format(db.endOfWeek(Weekday.Monday).asDate()));
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.day(21).firstDayOfMonth().asDate()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(db.day(21).endDayOfMonth().asDate()));

        Date d1 = db.now().asDate();
        Date d2 = new Date();
        assertEquals(sdf.format(d1),sdf.format(d2));

        //Test if the db object is immutable
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(db.asDate()));
    }
}
