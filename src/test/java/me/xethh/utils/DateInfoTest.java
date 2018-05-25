package me.xethh.utils;

import org.junit.Test;

import static me.xethh.utils.Month.NOV;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateInfoTest
{

    @Test
    public void extractDate(){
        DateInfo dateInfo =
                DateBuilder.get()
                        .hours(13).minutes(23).seconds(34).ms(666)
                        .day(20).month(NOV).year(2078).info();
        assertEquals(2078,dateInfo.year().intValue());
        assertEquals(11,dateInfo.month().toNumber());
        assertEquals(20,dateInfo.day().intValue());
        assertEquals(666,dateInfo.ms().intValue());
        assertEquals(34,dateInfo.second().intValue());
        assertEquals(23,dateInfo.min().intValue());
        assertEquals(13,dateInfo.hour().intValue());
    }

}
