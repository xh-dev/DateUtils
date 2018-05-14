package me.xethh.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateUtilsTestTimeExtractor
{

    @Test
    public void extractDate(){
        DateTimeExtractor extractor =
                DateBuilder.get()
                        .hours(13).minutes(23).seconds(34).ms(666)
                        .days(20).months(11).year(2078).extract();
        assertEquals(2078,extractor.year().intValue());
        assertEquals(11,extractor.month().toNumber());
        assertEquals(20,extractor.day().intValue());
        assertEquals(666,extractor.ms().intValue());
        assertEquals(34,extractor.second().intValue());
        assertEquals(23,extractor.min().intValue());
        assertEquals(13,extractor.hour().intValue());
    }

}
