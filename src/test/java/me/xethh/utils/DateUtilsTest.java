package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class DateUtilsTest
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void rawDate(){
        assertEquals(sdf.format(DateBuilder.raw().asDate()),"1970-01-01T00:00:00.000+0800");
    }

    @Test
    public void timeSetup(){
        assertEquals(sdf.format(DateBuilder.raw().maxMs().asDate()),"1970-01-01T00:00:00.999+0800");
        assertEquals(sdf.format(DateBuilder.raw().minMs().minMs().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().maxSecond().asDate()),"1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DateBuilder.raw().maxSecond().minSecond().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().maxHour().asDate()),"1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DateBuilder.raw().maxHour().minHour().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DateBuilder.raw().ms(444).second(23).hour(14).minute(40).day(2).month(Month.APR).year(2008).asDate()),"2008-04-02T14:40:23.444+0800");

        assertEquals("2008-04-02T00:00:00.000+0800",sdf.format(DateBuilder.raw().ymd(2008,Month.APR,02).asDate()));
        assertEquals("2008-04-02T14:23:00.000+0800",sdf.format(DateBuilder.raw().ymd(2008,Month.APR,02).hm(14,23).asDate()));
        assertEquals("2008-04-02T14:23:45.000+0800",sdf.format(DateBuilder.raw().ymd(2008,Month.APR,02).hms(14,23,45).asDate()));
        assertEquals("2008-04-02T14:23:45.777+0800",sdf.format(DateBuilder.raw().ymd(2008,Month.APR,02).hmss(14,23,45,777).asDate()));
    }

    @Test
    public void testToRange(){
        DateBuilder b1 = DateBuilder.raw().day(1);
        DatetimeRange r1 = b1.addDays(10).rangeTo(b1);
        DatetimeRange r2 = b1.rangeTo(b1.addDays(10));
        assertEquals(r1,DatetimeRange.of(b1.addDays(10).asDate(),b1.asDate()));
        assertEquals(r1.isValid(),false);
        assertEquals(r2,DatetimeRange.of(b1.asDate(),b1.addDays(10).asDate()));
        assertEquals(r2.isValid(),true);
        assertNotEquals(r1,r2);
        assertEquals(r1.swrap(),r2);
        assertEquals(r1,r2.swrap());
    }
}
