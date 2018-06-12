package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class testDatetimeRange
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void baseTest(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DatetimeRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]",DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).toString());
        assertEquals("DatetimeRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]",DatetimeRange.of(builder.operate().addDays(30).asDate(),builder.asDate()).toString());
    }

    @Test
    public void testIsValid(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.operate().addDays(-30).asDate()).isValid());
    }

    @Test
    public void testTimeRange(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DatetimeRange.of(builder.asDate(),builder.operate().addDays(30).asDate()).isValid());
        assertEquals(false,DatetimeRange.of(builder.asDate(),builder.operate().addDays(-30).asDate()).isValid());
    }

    @Test
    public void testTimeRangeOperateDaytime(){
        DateBuilder builder = DateBuilder.raw().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(builder.rangeTo(builder.operate().addDays(2).asBuilder()),DatetimeRange.of(builder.asDate(),builder.operate().addDays(2).asDate()));
        assertNotEquals(builder.rangeTo(builder.operate().addDays(2).asBuilder()),DatetimeRange.of(builder.asDate(),builder.operate().addDays(2).addMins(2).asDate()));
    }
}
