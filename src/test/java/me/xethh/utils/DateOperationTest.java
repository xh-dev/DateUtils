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
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().asDate()));
    }

    @Test
    public void addMs(){
        assertEquals("1970-01-01T00:00:00.200+0800",sdf.format(DateBuilder.raw().addMS(200).asDate()));
        assertEquals("1970-01-01T00:00:01.001+0800",sdf.format(DateBuilder.raw().addMS(1001).asDate()));
        assertEquals("1970-01-01T00:01:00.001+0800",sdf.format(DateBuilder.raw().addMS(60*1000+1).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().addMS(60*1000).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().addMS(60*60*1000).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMS(24*60*60*1000).asDate()));
    }

    @Test
    public void addSec(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addSecond(0).asDate()));
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(DateBuilder.raw().addSecond(1).asDate()));
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(DateBuilder.raw().addSecond(59).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().addSecond(60).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().addSecond(60*60).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().addSecond(24*60*60).asDate()));
    }

    @Test
    public void addMin(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(0).asDate()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.raw().addMins(1).asDate()));
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(DateBuilder.raw().addMins(59).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(60).asDate()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(DateBuilder.raw().addMins(61).asDate()));
        assertEquals("1970-01-01T01:59:00.000+0800",sdf.format(DateBuilder.raw().addMins(119).asDate()));
        assertEquals("1970-01-01T02:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(120).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(1440).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(2880).asDate()));
        assertEquals("1970-01-03T02:00:00.000+0800",sdf.format(DateBuilder.raw().addMins(3000).asDate()));
        assertEquals("6053-01-23T02:07:00.000+0800",sdf.format(DateBuilder.raw().addMins(Integer.MAX_VALUE).asDate()));
    }

    @Test
    public void addHour(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addHours(0).asDate()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.raw().addHours(1).asDate()));
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(DateBuilder.raw().addHours(23).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().addHours(24).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().addHours(48).asDate()));
    }

    @Test
    public void addDay(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addDays(0).asDate()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().addDays(1).asDate()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.raw().addDays(2).asDate()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(DateBuilder.raw().addDays(30).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addDays(31).asDate()));
    }

    @Test
    public void addMonth(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(0).asDate()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(1).asDate()));
        assertEquals("1970-03-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(2).asDate()));
        assertEquals("1970-04-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(3).asDate()));
        assertEquals("1970-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(11).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(12).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addMonths(24).asDate()));
    }

    @Test
    public void addYear(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addYear(0).asDate()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addYear(1).asDate()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addYear(2).asDate()));
        assertEquals("1980-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().addYear(10).asDate()));
    }
    @Test
    public void lastYear(){
        assertEquals("2017-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).lastYear().asDate()));
    }
    @Test
    public void nextYear(){
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).nextYear().asDate()));
    }
    @Test
    public void nextMonth(){
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).nextMonth().asDate()));
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(DEC).nextMonth().asDate()));
        assertEquals("2018-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(NOV).nextMonth().asDate()));
    }
    @Test
    public void lastMonth(){
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).lastMonth().asDate()));
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).lastMonth().asDate()));
        assertEquals("2018-01-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(FEB).lastMonth().asDate()));
    }
    @Test
    public void yesterday(){
        assertEquals("2017-12-31T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(1).yesterday().asDate()));
        assertEquals("2017-12-12T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2017).month(DEC).day(13).yesterday().asDate()));
        assertEquals("2018-01-30T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(31).yesterday().asDate()));
    }
    @Test
    public void tomorrow(){
        assertEquals("2018-01-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(1).tomorrow().asDate()));
        assertEquals("2017-12-14T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2017).month(DEC).day(13).tomorrow().asDate()));
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(JAN).day(31).tomorrow().asDate()));
        assertEquals("2018-03-01T00:00:00.000+0800",sdf.format(DateBuilder.raw().year(2018).month(FEB).day(28).tomorrow().asDate()));
    }
}
