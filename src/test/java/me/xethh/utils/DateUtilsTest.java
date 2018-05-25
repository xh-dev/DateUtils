package me.xethh.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class DateUtilsTest
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals(sdf.format(DateBuilder.raw().build()),"1970-01-01T00:00:00.000+0800");
    }

    @Test
    public void timeSetup(){
        assertEquals(sdf.format(DateBuilder.raw().maxMs().build()),"1970-01-01T00:00:00.999+0800");
        assertEquals(sdf.format(DateBuilder.raw().minMs().minMs().build()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().maxSecond().build()),"1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DateBuilder.raw().maxSecond().minSecond().build()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().maxHour().build()),"1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.raw().maxHour().minHour().build()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().ms(444).second(23).hour(14).minute(40).day(2).month(Month.APR).year(2008).build()),"2008-04-02T14:40:23.444+0800");
    }
}
