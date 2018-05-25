package me.xethh.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateUtilsTestTimeOperation
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals(sdf.format(DateBuilder.get().build()),"1970-01-01T00:00:00.000+0800");
    }

    @Test
    public void addMs(){
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(200).builder().build()),"1970-01-01T00:00:00.200+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(1001).builder().build()),"1970-01-01T00:00:01.001+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(60*1000+1).builder().build()),"1970-01-01T00:01:00.001+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(60*1000).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(60*60*1000).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMS(24*60*60*1000).builder().build()),"1970-01-02T00:00:00.000+0800");
    }

    @Test
    public void addSec(){
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(1).builder().build()),"1970-01-01T00:00:01.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(59).builder().build()),"1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(60).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(60*60).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addSecond(24*60*60).builder().build()),"1970-01-02T00:00:00.000+0800");
    }

    @Test
    public void addMin(){
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(1).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(59).builder().build()),"1970-01-01T00:59:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(60).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(61).builder().build()),"1970-01-01T01:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(119).builder().build()),"1970-01-01T01:59:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(120).builder().build()),"1970-01-01T02:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(1440).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(2880).builder().build()),"1970-01-03T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(3000).builder().build()),"1970-01-03T02:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMins(Integer.MAX_VALUE).builder().build()),"6053-01-23T02:07:00.000+0800");
    }

    @Test
    public void addHour(){
        assertEquals(sdf.format(DateBuilder.get().operate().addHours(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addHours(1).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addHours(23).builder().build()),"1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addHours(24).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addHours(48).builder().build()),"1970-01-03T00:00:00.000+0800");
    }

    @Test
    public void addDay(){
        assertEquals(sdf.format(DateBuilder.get().operate().addDays(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addDays(1).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addDays(2).builder().build()),"1970-01-03T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addDays(30).builder().build()),"1970-01-31T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addDays(31).builder().build()),"1970-02-01T00:00:00.000+0800");
    }

    @Test
    public void addMonth(){
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(1).builder().build()),"1970-02-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(2).builder().build()),"1970-03-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(3).builder().build()),"1970-04-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(11).builder().build()),"1970-12-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(12).builder().build()),"1971-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addMonths(24).builder().build()),"1972-01-01T00:00:00.000+0800");
    }

    @Test
    public void addYear(){
        assertEquals(sdf.format(DateBuilder.get().operate().addYear(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addYear(1).builder().build()),"1971-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addYear(2).builder().build()),"1972-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().operate().addYear(10).builder().build()),"1980-01-01T00:00:00.000+0800");
    }
}
