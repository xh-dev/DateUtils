package me.xethh.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static me.xethh.utils.Month.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateOperationTest
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().build()));
    }

    @Test
    public void addMs(){
        assertEquals("1970-01-01T00:00:00.200+0800",sdf.format(DateBuilder.get().operate().addMS(200).builder().build()));
        assertEquals("1970-01-01T00:00:01.001+0800",sdf.format(DateBuilder.get().operate().addMS(1001).builder().build()));
        assertEquals("1970-01-01T00:01:00.001+0800",sdf.format(DateBuilder.get().operate().addMS(60*1000+1).builder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.get().operate().addMS(60*1000).builder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMS(60*60*1000).builder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMS(24*60*60*1000).builder().build()));
    }

    @Test
    public void addSec(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addSecond(0).builder().build()));
        assertEquals("1970-01-01T00:00:01.000+0800",sdf.format(DateBuilder.get().operate().addSecond(1).builder().build()));
        assertEquals("1970-01-01T00:00:59.000+0800",sdf.format(DateBuilder.get().operate().addSecond(59).builder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.get().operate().addSecond(60).builder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.get().operate().addSecond(60*60).builder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addSecond(24*60*60).builder().build()));
    }

    @Test
    public void addMin(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(0).builder().build()));
        assertEquals("1970-01-01T00:01:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(1).builder().build()));
        assertEquals("1970-01-01T00:59:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(59).builder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(60).builder().build()));
        assertEquals("1970-01-01T01:01:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(61).builder().build()));
        assertEquals("1970-01-01T01:59:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(119).builder().build()));
        assertEquals("1970-01-01T02:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(120).builder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(1440).builder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(2880).builder().build()));
        assertEquals("1970-01-03T02:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(3000).builder().build()));
        assertEquals("6053-01-23T02:07:00.000+0800",sdf.format(DateBuilder.get().operate().addMins(Integer.MAX_VALUE).builder().build()));
    }

    @Test
    public void addHour(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addHours(0).builder().build()));
        assertEquals("1970-01-01T01:00:00.000+0800",sdf.format(DateBuilder.get().operate().addHours(1).builder().build()));
        assertEquals("1970-01-01T23:00:00.000+0800",sdf.format(DateBuilder.get().operate().addHours(23).builder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addHours(24).builder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addHours(48).builder().build()));
    }

    @Test
    public void addDay(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addDays(0).builder().build()));
        assertEquals("1970-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addDays(1).builder().build()));
        assertEquals("1970-01-03T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addDays(2).builder().build()));
        assertEquals("1970-01-31T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addDays(30).builder().build()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addDays(31).builder().build()));
    }

    @Test
    public void addMonth(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(0).builder().build()));
        assertEquals("1970-02-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(1).builder().build()));
        assertEquals("1970-03-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(2).builder().build()));
        assertEquals("1970-04-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(3).builder().build()));
        assertEquals("1970-12-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(11).builder().build()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(12).builder().build()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addMonths(24).builder().build()));
    }

    @Test
    public void addYear(){
        assertEquals("1970-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addYear(0).builder().build()));
        assertEquals("1971-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addYear(1).builder().build()));
        assertEquals("1972-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addYear(2).builder().build()));
        assertEquals("1980-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().operate().addYear(10).builder().build()));
    }
    @Test
    public void lastYear(){
        assertEquals("2017-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).operate().lastYear().builder().build()));
    }
    @Test
    public void nextYear(){
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).operate().nextYear().builder().build()));
    }
    @Test
    public void nextMonth(){
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).operate().nextMonth().builder().build()));
        assertEquals("2019-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(DEC).operate().nextMonth().builder().build()));
        assertEquals("2018-12-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(NOV).operate().nextMonth().builder().build()));
    }
    @Test
    public void lastMonth(){
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).operate().lastMonth().builder().build()));
        assertEquals("2017-12-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(JAN).operate().lastMonth().builder().build()));
        assertEquals("2018-01-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(FEB).operate().lastMonth().builder().build()));
    }
    @Test
    public void yesterday(){
        assertEquals("2017-12-31T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(JAN).day(1).operate().yesterday().asDate()));
        assertEquals("2017-12-12T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2017).month(DEC).day(13).operate().yesterday().asDate()));
        assertEquals("2018-01-30T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(JAN).day(31).operate().yesterday().asDate()));
    }
    @Test
    public void tomorrow(){
        assertEquals("2018-01-02T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(JAN).day(1).operate().tomorrow().asDate()));
        assertEquals("2017-12-14T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2017).month(DEC).day(13).operate().tomorrow().asDate()));
        assertEquals("2018-02-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(JAN).day(31).operate().tomorrow().asDate()));
        assertEquals("2018-03-01T00:00:00.000+0800",sdf.format(DateBuilder.get().year(2018).month(FEB).day(28).operate().tomorrow().asDate()));
    }
}
