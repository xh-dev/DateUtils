package me.xethh.utils.v6.datetime;

import me.xethh.utils.dateUtils.CalendarTimeBuilder;
import me.xethh.utils.dateUtils.CommonDateRepresentation;
import me.xethh.utils.dateUtils.FormatterBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestCalendarTimeBuilder {
    public static <T extends FormatterBuilder & CalendarTimeBuilder<T> & CommonDateRepresentation> void test(T builder){
        SimpleDateFormat sdf = DateFormatBuilder.Format.ISO8601.getFormatter();
        assertEquals("2021-06-22T07:08:09.010+0800",builder.format(sdf));
        assertEquals("2021-06-22T19:01:22.888+0800",builder.hmsms(19, 1, 22, 888).format(sdf));
        assertEquals("2021-06-22T19:01:22.000+0800",builder.hms(19, 1, 22).format(sdf));
        assertEquals("2021-06-22T19:01:00.000+0800",builder.hm(19, 1).format(sdf));
        assertEquals("2021-06-22T19:00:00.000+0800",builder.h(19).format(sdf));

        assertEquals("2021-06-22T00:08:09.010+0800",builder.minHour().format(sdf));
        assertEquals("2021-06-22T23:08:09.010+0800",builder.maxHour().format(sdf));
        assertEquals("2021-06-22T17:08:09.010+0800",builder.hour(17).format(sdf));

        assertEquals("2021-06-22T07:00:09.010+0800",builder.minMinute().format(sdf));
        assertEquals("2021-06-22T07:59:09.010+0800",builder.maxMinute().format(sdf));
        assertEquals("2021-06-22T07:33:09.010+0800",builder.minute(33).format(sdf));

        assertEquals("2021-06-22T07:08:00.010+0800",builder.minSecond().format(sdf));
        assertEquals("2021-06-22T07:08:59.010+0800",builder.maxSecond().format(sdf));
        assertEquals("2021-06-22T07:08:05.010+0800",builder.second(5).format(sdf));

        assertEquals("2021-06-22T07:08:09.000+0800",builder.minMs().format(sdf));
        assertEquals("2021-06-22T07:08:09.999+0800",builder.maxMs().format(sdf));
        assertEquals("2021-06-22T07:08:09.005+0800",builder.ms(5).format(sdf));

        assertEquals("2021-06-22T23:59:59.999+0800",builder.maxDayTime().format(sdf));
        assertEquals("2021-06-22T23:59:59.000+0800",builder.maxDayTimeSec().format(sdf));
        assertEquals("2021-06-22T23:59:00.000+0800",builder.maxDayTimeMin().format(sdf));
        assertEquals("2021-06-22T00:00:00.000+0800",builder.minDayTime().format(sdf));
    }

    public static void testNow(Date dFromNewDate, Date builderDate){
        SimpleDateFormat sdf = DateFormatBuilder.Format.ISO8601.getFormatter();
        assertEquals(sdf.format(dFromNewDate),sdf.format(builderDate));
    }
}
