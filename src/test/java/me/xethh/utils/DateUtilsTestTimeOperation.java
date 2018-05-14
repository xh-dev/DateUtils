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
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(200).builder().build()),"1970-01-01T00:00:00.200+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(1001).builder().build()),"1970-01-01T00:00:01.001+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(60*1000+1).builder().build()),"1970-01-01T00:01:00.001+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(60*1000).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(60*60*1000).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMS(24*60*60*1000).builder().build()),"1970-01-02T00:00:00.000+0800");
    }

    @Test
    public void addSec(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(1).builder().build()),"1970-01-01T00:00:01.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(59).builder().build()),"1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(60).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(60*60).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addSecond(24*60*60).builder().build()),"1970-01-02T00:00:00.000+0800");
    }

    @Test
    public void addMin(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(1).builder().build()),"1970-01-01T00:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(59).builder().build()),"1970-01-01T00:59:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(60).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(61).builder().build()),"1970-01-01T01:01:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(119).builder().build()),"1970-01-01T01:59:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(120).builder().build()),"1970-01-01T02:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(1440).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(2880).builder().build()),"1970-01-03T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(3000).builder().build()),"1970-01-03T02:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMins(Integer.MAX_VALUE).builder().build()),"6053-01-23T02:07:00.000+0800");
    }

    @Test
    public void addHour(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addHours(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addHours(1).builder().build()),"1970-01-01T01:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addHours(23).builder().build()),"1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addHours(24).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addHours(48).builder().build()),"1970-01-03T00:00:00.000+0800");
    }

    @Test
    public void addDay(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addDays(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addDays(1).builder().build()),"1970-01-02T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addDays(2).builder().build()),"1970-01-03T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addDays(30).builder().build()),"1970-01-31T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addDays(31).builder().build()),"1970-02-01T00:00:00.000+0800");
    }

    @Test
    public void addMonth(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(1).builder().build()),"1970-02-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(2).builder().build()),"1970-03-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(3).builder().build()),"1970-04-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(11).builder().build()),"1970-12-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(12).builder().build()),"1971-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addMonths(24).builder().build()),"1972-01-01T00:00:00.000+0800");
    }

    @Test
    public void addYear(){
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addYear(0).builder().build()),"1970-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addYear(1).builder().build()),"1971-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addYear(2).builder().build()),"1972-01-01T00:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.get().toTimeOperator().addYear(10).builder().build()),"1980-01-01T00:00:00.000+0800");
    }
}
