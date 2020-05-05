package me.xethh.utils;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for simple App.
 */
public class DateUtilsTest_Range
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Test
    public void rawDate(){
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().asDate()),"1970-01-01T00:00:00.000+0800");
    }

    @Test
    public void timeSetupV2(){
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().y(2018).asDate()),"2018-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.JAN).asDate()),"2018-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.FEB).asDate()),"2018-02-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.MAR).asDate()),"2018-03-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.APR).asDate()),"2018-04-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.MAY).asDate()),"2018-05-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.JUN).asDate()),"2018-06-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.JUL).asDate()),"2018-07-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.AUG).asDate()),"2018-08-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.SEP).asDate()),"2018-09-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.OCT).asDate()),"2018-10-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.NOV).asDate()),"2018-11-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ym(2018,Month.DEC).asDate()),"2018-12-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018,Month.DEC,1).asDate()),"2018-12-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018,Month.DEC,31).asDate()),"2018-12-31T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2018,Month.DEC,32).asDate()),"2019-01-01T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().h(12).asDate()),"1970-01-01T12:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().h(24).asDate()),"1970-01-02T00:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hm(24,50).asDate()),"1970-01-02T00:50:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hm(24,60).asDate()),"1970-01-02T01:00:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hms(24,60,1).asDate()),"1970-01-02T01:00:01.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hms(24,60,60).asDate()),"1970-01-02T01:01:00.000");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hmsms(24,60,60,100).asDate()),"1970-01-02T01:01:00.100");
        assertEquals(sdf2.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().hmsms(24,60,60,1000).asDate()),"1970-01-02T01:01:01.000");
    }
    @Test
    public void timeSetup(){
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxMs().asDate()),"1970-01-01T00:00:00.999+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().minMs().minMs().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxSecond().asDate()),"1970-01-01T00:00:59.000+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxSecond().minSecond().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxHour().asDate()),"1970-01-01T23:00:00.000+0800");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().maxHour().minHour().asDate()),"1970-01-01T00:00:00.000+0800");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ms(444).second(23).hour(14).minute(40).day(2).month(Month.APR).year(2008).asDate()),"2008-04-02T14:40:23.444+0800");

        assertEquals("2008-04-02T00:00:12.000+0800",sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().second(12).ymd(2008,Month.APR,02).asDate()));
        assertEquals("2008-04-02T14:23:00.000+0800",sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008,Month.APR,02).hm(14,23).asDate()));
        assertEquals("2008-04-02T14:23:45.000+0800",sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008,Month.APR,02).hms(14,23,45).asDate()));
        assertEquals("2008-04-02T14:23:45.777+0800",sdf.format(DatetimeFactory.instance().raw().rangeTo(new Date()).editStart().ymd(2008,Month.APR,02).hmsms(14,23,45,777).asDate()));
    }

    @Test
    public void firstDayTest(){
        DatetimeBuilder b1 = DatetimeFactory.instance().raw().ymd(2018,Month.JAN,23).rangeTo(new Date()).editStart();
        SimpleDateFormat sdf2 = DateFormatBuilderImpl.get().year4Digit().month2Digit().day2Digit().build();
        assertEquals("20180101",sdf2.format(b1.firstDayOfMonth().asDate()));
        assertEquals("20280101",sdf2.format(b1.addYear(10).firstDayOfMonth().asDate()));
        assertEquals("20280201",sdf2.format(b1.addYear(10).nextMonth().firstDayOfMonth().asDate()));
    }

    @Test
    public void endDateTest(){
        DatetimeBuilder b1 = DatetimeFactory.instance().raw().ymd(2018,Month.JAN,23).rangeTo(new Date()).editStart();
        SimpleDateFormat sdf2 = DateFormatBuilderImpl.get().year4Digit().month2Digit().day2Digit().build();
        assertEquals("20180131",sdf2.format(b1.endDayOfMonth().asDate()));
        assertEquals("20280229",sdf2.format(b1.addYear(10).addMonths(1).endDayOfMonth().asDate()));
        assertEquals("20280331",sdf2.format(b1.addYear(10).addMonths(2).endDayOfMonth().asDate()));
        assertEquals("20280430",sdf2.format(b1.addYear(10).addMonths(3).endDayOfMonth().asDate()));
        assertEquals("20280531",sdf2.format(b1.addYear(10).addMonths(4).endDayOfMonth().asDate()));
        assertEquals("20280630",sdf2.format(b1.addYear(10).addMonths(5).endDayOfMonth().asDate()));
        assertEquals("20280731",sdf2.format(b1.addYear(10).addMonths(6).endDayOfMonth().asDate()));
        assertEquals("20280831",sdf2.format(b1.addYear(10).addMonths(7).endDayOfMonth().asDate()));
        assertEquals("20280930",sdf2.format(b1.addYear(10).addMonths(8).endDayOfMonth().asDate()));
        assertEquals("20281031",sdf2.format(b1.addYear(10).addMonths(9).endDayOfMonth().asDate()));
        assertEquals("20281130",sdf2.format(b1.addYear(10).addMonths(10).endDayOfMonth().asDate()));
        assertEquals("20281231",sdf2.format(b1.addYear(10).addMonths(11).endDayOfMonth().asDate()));
        assertEquals("20290131",sdf2.format(b1.addYear(10).addMonths(12).endDayOfMonth().asDate()));
        assertEquals("20180228",sdf2.format(b1.addMonths(1).endDayOfMonth().asDate()));
    }
}
