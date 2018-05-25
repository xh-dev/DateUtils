package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static me.xethh.utils.dateManipulation.Month.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateOperationTest
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().build()));
    }

    @Test
    public void addMs(){
        assertEquals("1970-01-01T00:00:00.200+0800",sdf.format(DateBuilder.raw().operate().addMS(200).asBuilder().build()));
        assertEquals("1970-01-01T00:00:01.001+0800",sdf.format(DateBuilder.raw().operate().addMS(1001).asBuilder().build()));
        assertEquals("1970-01-01T00:01:00.001+0800",sdf.format(DateBuilder.raw().operate().addMS(60*1000+1).asBuilder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().operate().addMS(60*1000).asBuilder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMS(60*60*1000).asBuilder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMS(24*60*60*1000).asBuilder().build()));
    }

    @Test
    public void addSec(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(0).asBuilder().build()));
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(1).asBuilder().build()));
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(59).asBuilder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(60).asBuilder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(60*60).asBuilder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addSecond(24*60*60).asBuilder().build()));
    }

    @Test
    public void addMin(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(0).asBuilder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(1).asBuilder().build()));
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(59).asBuilder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(60).asBuilder().build()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(61).asBuilder().build()));
        assertEquals("1970-01-01T01:59:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(119).asBuilder().build()));
        assertEquals("1970-01-01T02:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(120).asBuilder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(1440).asBuilder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(2880).asBuilder().build()));
        assertEquals("1970-01-03T02:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(3000).asBuilder().build()));
        assertEquals("6053-01-23T02:07:00.000+0800",sdf.format(DateBuilder.raw().operate().addMins(Integer.MAX_VALUE).asBuilder().build()));
    }

    @Test
    public void addHour(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addHours(0).asBuilder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addHours(1).asBuilder().build()));
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addHours(23).asBuilder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addHours(24).asBuilder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addHours(48).asBuilder().build()));
    }

    @Test
    public void addDay(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addDays(0).asBuilder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addDays(1).asBuilder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addDays(2).asBuilder().build()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addDays(30).asBuilder().build()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addDays(31).asBuilder().build()));
    }

    @Test
    public void addMonth(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(0).asBuilder().build()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(1).asBuilder().build()));
        assertEquals("1970-03-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(2).asBuilder().build()));
        assertEquals("1970-04-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(3).asBuilder().build()));
        assertEquals("1970-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(11).asBuilder().build()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(12).asBuilder().build()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addMonths(24).asBuilder().build()));
    }

    @Test
    public void addYear(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addYear(0).asBuilder().build()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addYear(1).asBuilder().build()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addYear(2).asBuilder().build()));
        assertEquals("1980-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().operate().addYear(10).asBuilder().build()));
    }
    @Test
    public void lastYear(){
        assertEquals("2017-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).operate().lastYear().asBuilder().build()));
    }
    @Test
    public void nextYear(){
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).operate().nextYear().asBuilder().build()));
    }
    @Test
    public void nextMonth(){
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).operate().nextMonth().asBuilder().build()));
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(DEC).operate().nextMonth().asBuilder().build()));
        assertEquals("2018-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(NOV).operate().nextMonth().asBuilder().build()));
    }
    @Test
    public void lastMonth(){
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).operate().lastMonth().asBuilder().build()));
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).operate().lastMonth().asBuilder().build()));
        assertEquals("2018-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(FEB).operate().lastMonth().asBuilder().build()));
    }
    @Test
    public void yesterday(){
        assertEquals("2017-12-31T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(1).operate().yesterday().asDate()));
        assertEquals("2017-12-12T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2017).month(DEC).day(13).operate().yesterday().asDate()));
        assertEquals("2018-01-30T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(31).operate().yesterday().asDate()));
    }
    @Test
    public void tomorrow(){
        assertEquals("2018-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(1).operate().tomorrow().asDate()));
        assertEquals("2017-12-14T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2017).month(DEC).day(13).operate().tomorrow().asDate()));
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(31).operate().tomorrow().asDate()));
        assertEquals("2018-03-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(FEB).day(28).operate().tomorrow().asDate()));
    }
}
