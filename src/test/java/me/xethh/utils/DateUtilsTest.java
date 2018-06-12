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
    }

    @Test
    public void testToRange(){
        DateBuilder b1 = DateBuilder.raw().day(1);
        DatetimeRange r1 = b1.operate().addDays(10).asBuilder().rangeTo(b1);
        DatetimeRange r2 = b1.rangeTo(b1.operate().addDays(10).asBuilder());
        assertEquals(r1,DatetimeRange.of(b1.operate().addDays(10).asDate(),b1.asDate()));
        assertEquals(r1.isValid(),false);
        assertEquals(r2,DatetimeRange.of(b1.asDate(),b1.operate().addDays(10).asDate()));
        assertEquals(r2.isValid(),true);
        assertNotEquals(r1,r2);
        assertEquals(r1.swrap(),r2);
        assertEquals(r1,r2.swrap());
    }
}
