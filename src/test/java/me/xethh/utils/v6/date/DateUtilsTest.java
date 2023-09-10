package me.xethh.utils.v6.date;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class DateUtilsTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }

    private static Supplier<SimpleDateFormat> sdfSupplier = () -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static Supplier<SimpleDateFormat> sdf2Supplier = () -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Test
    public void rawDate() {
        var sdf = sdfSupplier.get();
        assertEquals("1970-01-01T00:00:00.000+0000", sdf.format(DatetimeFactory.instance().raw().asDate()));
    }

    @Test
    public void timeSetupV2() {
        var sdf2 = sdf2Supplier.get();
        assertEquals("2018-01-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().y(2018).asDate()));
        assertEquals("2018-01-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.JAN).asDate()));
        assertEquals("2018-02-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.FEB).asDate()));
        assertEquals("2018-03-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.MAR).asDate()));
        assertEquals("2018-04-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.APR).asDate()));
        assertEquals("2018-05-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.MAY).asDate()));
        assertEquals("2018-06-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.JUN).asDate()));
        assertEquals("2018-07-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.JUL).asDate()));
        assertEquals("2018-08-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.AUG).asDate()));
        assertEquals("2018-09-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.SEP).asDate()));
        assertEquals("2018-10-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.OCT).asDate()));
        assertEquals("2018-11-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.NOV).asDate()));
        assertEquals("2018-12-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ym(2018, Month.DEC).asDate()));
        assertEquals("1970-12-12T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().md(Month.DEC, 12).asDate()));
        assertEquals("1970-12-13T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().md(Month.DEC, 13).asDate()));
        assertEquals("1970-08-23T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().md(Month.AUG, 23).asDate()));
        //assertEquals("1970-10-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().md(Month.SEP, 31).asDate()));
        assertThrows(DateTimeException.class, ()->sdf2.format(DatetimeFactory.instance().raw().md(Month.SEP, 31).asDate()));
        assertEquals("2018-12-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ymd(2018, Month.DEC, 1).asDate()));
        assertEquals("2018-12-31T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ymd(2018, Month.DEC, 31).asDate()));
        //assertEquals("2019-01-01T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().ymd(2018, Month.DEC, 32).asDate()));
        assertThrows(DateTimeException.class, ()->sdf2.format(DatetimeFactory.instance().raw().ymd(2018, Month.DEC, 32).asDate()));
        assertEquals("1970-01-01T12:00:00.000", sdf2.format(DatetimeFactory.instance().raw().h(12).asDate()));
        //assertEquals("1970-01-02T00:00:00.000", sdf2.format(DatetimeFactory.instance().raw().h(24).asDate()));
        assertThrows(DateTimeException.class, ()->sdf2.format(DatetimeFactory.instance().raw().h(24).asDate()));

        assertEquals("1970-01-01T23:50:00.000", sdf2.format(DatetimeFactory.instance().raw().hm(23, 50).asDate()));
        assertEquals("1970-01-01T23:59:00.000", sdf2.format(DatetimeFactory.instance().raw().hm(23, 59).asDate()));
        assertEquals("1970-01-01T23:59:01.000", sdf2.format(DatetimeFactory.instance().raw().hms(23, 59, 1).asDate()));
        assertEquals("1970-01-01T23:59:59.000", sdf2.format(DatetimeFactory.instance().raw().hms(23, 59, 59).asDate()));
        assertEquals("1970-01-01T23:59:59.100", sdf2.format(DatetimeFactory.instance().raw().hmsms(23, 59, 59, 100).asDate()));
        assertEquals("1970-01-01T23:59:59.999", sdf2.format(DatetimeFactory.instance().raw().hmsms(23, 59, 59, 999).asDate()));
    }

    @Test
    public void timeSetup() {
        var sdf = sdfSupplier.get();
        assertEquals(sdf.format(DatetimeFactory.instance().raw().maxMs().asDate()), "1970-01-01T00:00:00.999+0000");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().minMs().minMs().asDate()), "1970-01-01T00:00:00.000+0000");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().maxSecond().asDate()), "1970-01-01T00:00:59.000+0000");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().maxSecond().minSecond().asDate()), "1970-01-01T00:00:00.000+0000");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().maxHour().asDate()), "1970-01-01T23:00:00.000+0000");
        assertEquals(sdf.format(DatetimeFactory.instance().raw().maxHour().minHour().asDate()), "1970-01-01T00:00:00.000+0000");

        assertEquals(sdf.format(DatetimeFactory.instance().raw().ms(444).second(23).hour(14).minute(40).day(2).month(Month.APR).year(2008).asDate()), "2008-04-02T14:40:23.444+0000");

        assertEquals("2008-04-02T00:00:12.000+0000", sdf.format(DatetimeFactory.instance().raw().second(12).ymd(2008, Month.APR, 02).asDate()));
        assertEquals("2008-04-02T14:23:00.000+0000", sdf.format(DatetimeFactory.instance().raw().ymd(2008, Month.APR, 02).hm(14, 23).asDate()));
        assertEquals("2008-04-02T14:23:45.000+0000", sdf.format(DatetimeFactory.instance().raw().ymd(2008, Month.APR, 02).hms(14, 23, 45).asDate()));
        assertEquals("2008-04-02T14:23:45.777+0000", sdf.format(DatetimeFactory.instance().raw().ymd(2008, Month.APR, 02).hmsms(14, 23, 45, 777).asDate()));
    }

    @Test
    public void testToRange() {
        DatetimeBuilder b1 = DatetimeFactory.instance().raw().day(1);
        DatetimeRange r1 = b1.addDays(10).rangeTo(b1);
        DatetimeRange r2 = b1.rangeTo(b1.addDays(10));
        assertEquals(r1, DatetimeFactory.rangeOf(b1.addDays(10).asDate(), b1.asDate()));
        assertEquals(r1.isValid(), false);
        assertEquals(r2, DatetimeFactory.rangeOf(b1.asDate(), b1.addDays(10).asDate()));
        assertEquals(r2.isValid(), true);
        assertNotEquals(r1, r2);
        assertEquals(r1.swrap(), r2);
        assertEquals(r1, r2.swrap());
    }

    @Test
    public void firstDayTest() {
        DatetimeBuilderInterface b1 = DatetimeFactory.instance().raw().ymd(2018, Month.JAN, 23);
        SimpleDateFormat sdf2 = DateFormatBuilder.get().year4Digit().month2Digit().day2Digit().build();
        assertEquals("20180101", sdf2.format(b1.firstDayOfMonth().asDate()));
        assertEquals("20280101", sdf2.format(b1.addYear(10).firstDayOfMonth().asDate()));
        assertEquals("20280201", sdf2.format(b1.addYear(10).nextMonth().firstDayOfMonth().asDate()));
    }

    @Test
    public void endDateTest() {
        DatetimeBuilderInterface b1 = DatetimeFactory.instance().raw().ymd(2018, Month.JAN, 23);
        SimpleDateFormat sdf2 = DateFormatBuilder.get().year4Digit().month2Digit().day2Digit().build();
        assertEquals("20180131", sdf2.format(b1.endDayOfMonth().asDate()));
        assertEquals("20280229", sdf2.format(b1.addYear(10).addMonths(1).endDayOfMonth().asDate()));
        assertEquals("20280331", sdf2.format(b1.addYear(10).addMonths(2).endDayOfMonth().asDate()));
        assertEquals("20280430", sdf2.format(b1.addYear(10).addMonths(3).endDayOfMonth().asDate()));
        assertEquals("20280531", sdf2.format(b1.addYear(10).addMonths(4).endDayOfMonth().asDate()));
        assertEquals("20280630", sdf2.format(b1.addYear(10).addMonths(5).endDayOfMonth().asDate()));
        assertEquals("20280731", sdf2.format(b1.addYear(10).addMonths(6).endDayOfMonth().asDate()));
        assertEquals("20280831", sdf2.format(b1.addYear(10).addMonths(7).endDayOfMonth().asDate()));
        assertEquals("20280930", sdf2.format(b1.addYear(10).addMonths(8).endDayOfMonth().asDate()));
        assertEquals("20281031", sdf2.format(b1.addYear(10).addMonths(9).endDayOfMonth().asDate()));
        assertEquals("20281130", sdf2.format(b1.addYear(10).addMonths(10).endDayOfMonth().asDate()));
        assertEquals("20281231", sdf2.format(b1.addYear(10).addMonths(11).endDayOfMonth().asDate()));
        assertEquals("20290131", sdf2.format(b1.addYear(10).addMonths(12).endDayOfMonth().asDate()));
        assertEquals("20180228", sdf2.format(b1.addMonths(1).endDayOfMonth().asDate()));
    }
}
