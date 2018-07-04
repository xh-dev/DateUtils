package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.DateFormatBuilder;
import me.xethh.utils.dateManipulation.Month;
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
        Date date = DateBuilder.raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("Hello 2088 - 11-10T21:56:58.888===+0800",format.format(date));
        assertEquals("Hello 2088 - 11-10T21:56:58.888===+0800",sdf.format(date));
    }

    @Test
    public void test01(){
        SimpleDateFormat format = DateFormatBuilder.get().v1().v2().v3().v4().v5().v6().v7().v8().v9().v10().v("XXX").v("yyyy")
                .v1("V1").v2("V2").v3("V3").v4("V4").v5("V5")
                .v6("V6").v7("V7").v8("V8").v9("V9").v10("V10").v("yyyy","4Y").build();
        Date date = DateBuilder.raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("V1V2V3V4V5V6V7V8V9V104Y",format.format(date));
    }
    @Test
    public void test02(){
        SimpleDateFormat format = DateFormatBuilder.get().yyyy().v1().MM().v1().dd().v2().HH().v3().mm().v3().ss()
                .v1("-").v2("T").v3(":").build();
        Date date = DateBuilder.raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("2088-11-10T21:56:58",format.format(date));
    }

}
