package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DateRange;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class testDateRange
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void baseTest(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals("DateRange[2018-01-18T00:00:00.000+0800 to 2018-02-17T00:00:00.000+0800]",DateRange.of(builder.build(),builder.operate().addDays(30).asDate()).toString());
        assertEquals("DateRange[2018-02-17T00:00:00.000+0800 to 2018-01-18T00:00:00.000+0800]",DateRange.of(builder.operate().addDays(30).asDate(),builder.build()).toString());
    }

    @Test
    public void testIsValid(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        assertEquals(true,DateRange.of(builder.build(),builder.operate().addDays(30).asDate()).isValid());
        assertEquals(false,DateRange.of(builder.build(),builder.operate().addDays(-30).asDate()).isValid());
    }
}
