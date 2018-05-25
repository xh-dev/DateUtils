package me.xethh.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateFormatTest
{
    @Test
    public void test(){
        SimpleDateFormat format = DateFormatBuilder.get()
                .pad("Hello ")
                .yyyy().pad(" - ").MM().pad("-").dd().pad("T")
                .HH().pad(":").mm().pad(":").ss().pad(".").SSS().pad("===").Z().build();
        SimpleDateFormat sdf = new SimpleDateFormat("'Hello' yyyy - MM-dd'T'HH:mm:ss.SSS===Z");
        Date date = DateBuilder.get().year(2088).month(Month.NOV).day(10).hours(21).minutes(56).seconds(58).ms(888).build();
        assertEquals("Hello 2088 - 11-10T21:56:58.888===+0800",format.format(date));
        assertEquals("Hello 2088 - 11-10T21:56:58.888===+0800",sdf.format(date));
    }

}
