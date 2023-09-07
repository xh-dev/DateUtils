package me.xethh.utils.v6.formatting;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.FormatBuilderWrapper;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Test;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class FormatBuilderWrapperTest {
    @Test
    public void simpleFormatBuilderTest() {
        FormatBuilderWrapper f = DatetimeFactory.instance().now().ymd(1988, Month.JAN, 01).hmsms(0, 0, 0, 0)
                .format().year2Digit().month3Letters().hyphen().hourInDay24().minute();
        assertEquals("88Jan-0000", f.format());
    }

    @Test
    public void testDateFormat() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().v1().v2().v3().v4().v5().v6().v7().v8().v9().v10().v("XXX").v("yyyy")
                .v1("V1").v2("V2").v3("V3").v4("V4").v5("V5")
                .v6("V6").v7("V7").v8("V8").v9("V9").v10("V10").v("yyyy", "4Y").build();
        Date date = DatetimeFactory.instance().raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("V1V2V3V4V5V6V7V8V9V104Y", format.format(date));
    }

    @Test
    public void testCustFormat() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().custFormat("yyyyMMdd").build();
        Date date = DatetimeFactory.instance().raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("20881110", format.format(date));
    }

    @Test
    public void test() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format()
                .pad("Hello ").dot().underLine().colon()
                .year4Digit().space().hyphen().space().month2Digit().hyphen().day2Digit().pad("T")
                .hourInDay24().colon().minute().colon().second().dot().ms().pad("===").TimeZoneRFC822().build();
        SimpleDateFormat sdf = new SimpleDateFormat("'Hello' ._:yyyy - MM-dd'T'HH:mm:ss.SSS===Z");
        Date date = DatetimeFactory.instance().raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("Hello ._:2088 - 11-10T21:56:58.888===+0800", format.format(date));
        assertEquals("Hello ._:2088 - 11-10T21:56:58.888===+0800", sdf.format(date));
    }

    @Test
    public void test01() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().v1().v2().v3().v4().v5().v6().v7().v8().v9().v10().v("XXX").v("yyyy")
                .v1("V1").v2("V2").v3("V3").v4("V4").v5("V5")
                .v6("V6").v7("V7").v8("V8").v9("V9").v10("V10").v("yyyy", "4Y").build();
        Date date = DatetimeFactory.instance().raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("V1V2V3V4V5V6V7V8V9V104Y", format.format(date));
    }

    @Test
    public void test02() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().year4Digit().v1().month2Digit().v1().day2Digit().v2().hourInDay24().v3().minute().v3().second()
                .v1("-").v2("T").v3(":").build();
        Date date = DatetimeFactory.instance().raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("2088-11-10T21:56:58", format.format(date));
    }

    @Test
    public void testTimeZone() {
        FormatBuilderWrapper format = DatetimeFactory.instance().now().format()
                // General timezone is not available for testing
                .GeneralTimeZone().v1()
                .TimeZoneRFC822().v1()
                .TimeZoneISO8601OneDigit().v1()
                .TimeZoneISO8601TwoDigit().v1()
                .TimeZoneISO8601ThreeDigit().v1().year4Digit().month2Digit().day2Digit().hourInDay24().minute().second().v1("||").timeZone(BaseTimeZone.Hongkong);
        DatetimeBuilder date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(10).hour(1).minute(23).second(34).timeZone(BaseTimeZone.Hongkong);
        assertEquals("HKT||+0800||+08||+0800||+08:00||20880110012334", format.build().format(date.asDate()));
        assertEquals("GMT||+0000||Z||Z||Z||20880109172334", format.timeZone(BaseTimeZone.GMT).build().format(date.asDate()));
        assertEquals("GMT-08:00||-0800||-08||-0800||-08:00||20880109092334", format.timeZone(BaseTimeZone.Etc_GMT_P8).build().format(date.asDate()));
        assertEquals("GMT+08:00||+0800||+08||+0800||+08:00||20880110012334", format.timeZone(BaseTimeZone.Etc_GMT_M8).build().format(date.asDate()));
        assertEquals("UTC||+0000||Z||Z||Z||20880109172334", format.timeZone(BaseTimeZone.UTC).build().format(date.asDate()));
        date = date.timeZone(BaseTimeZone.Japan);
        assertEquals("HKT||+0800||+08||+0800||+08:00||20880110002334", format.build().format(date.asDate()));
        assertEquals("GMT||+0000||Z||Z||Z||20880109162334", format.timeZone(BaseTimeZone.GMT).build().format(date.asDate()));
        assertEquals("GMT-08:00||-0800||-08||-0800||-08:00||20880109082334", format.timeZone(BaseTimeZone.Etc_GMT_P8).build().format(date.asDate()));
        assertEquals("GMT+08:00||+0800||+08||+0800||+08:00||20880110002334", format.timeZone(BaseTimeZone.Etc_GMT_M8).build().format(date.asDate()));
        assertEquals("UTC||+0000||Z||Z||Z||20880109162334", format.timeZone(BaseTimeZone.UTC).build().format(date.asDate()));
    }

    @Test
    public void testAPM() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().apm().v1("||").build();
        DatetimeBuilder date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(10).hour(0);
        /* TODO update for symbol change (7.0.0-RC1) */
        var dfs = new DateFormatSymbols(Locale.getDefault());
        dfs.setAmPmStrings(new String[]{"AM", "PM"});
        format.setDateFormatSymbols(dfs);
        assertEquals("AM", format.format(date.asDate()));
        assertEquals("AM", format.format(date.addHours(1).asDate()));
        assertEquals("AM", format.format(date.addHours(11).asDate()));
        assertEquals("PM", format.format(date.addHours(12).asDate()));
        assertEquals("PM", format.format(date.addHours(13).asDate()));
        assertEquals("PM", format.format(date.addHours(23).asDate()));
        assertEquals("AM", format.format(date.addHours(24).asDate()));
    }

    @Test
    public void testHour() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().hourInDay12().v1().hourInDay24().v1("||").build();
        DatetimeBuilder date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(10).hour(0);
        assertEquals("12||00", format.format(date.asDate()));
        assertEquals("01||01", format.format(date.addHours(1).asDate()));
        assertEquals("11||11", format.format(date.addHours(11).asDate()));
        assertEquals("12||12", format.format(date.addHours(12).asDate()));
        assertEquals("01||13", format.format(date.addHours(13).asDate()));
        assertEquals("11||23", format.format(date.addHours(23).asDate()));
        assertEquals("12||00", format.format(date.addHours(24).asDate()));
    }

    @Test
    public void testYear() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().year2Digit().v1().year4Digit().v1("||").build();
        DatetimeBuilderInterface date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(10);
        assertEquals("88||2088", format.format(date.asDate()));
        assertEquals("90||2090", format.format(date.addYear(2).asDate()));
    }

    @Test
    public void testMonth() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().month2Digit().v1().month3Letters().v1().monthFullName().v1("||").build();
        DatetimeBuilderInterface date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(10);
        assertEquals("01||Jan||January", format.format(date.asDate()));
        assertEquals("02||Feb||February", format.format(date.addMonths(1).asDate()));
        assertEquals("03||Mar||March", format.format(date.addMonths(2).asDate()));
        assertEquals("04||Apr||April", format.format(date.addMonths(3).asDate()));
        assertEquals("05||May||May", format.format(date.addMonths(4).asDate()));
        assertEquals("06||Jun||June", format.format(date.addMonths(5).asDate()));
        assertEquals("07||Jul||July", format.format(date.addMonths(6).asDate()));
        assertEquals("08||Aug||August", format.format(date.addMonths(7).asDate()));
        assertEquals("09||Sep||September", format.format(date.addMonths(8).asDate()));
        assertEquals("10||Oct||October", format.format(date.addMonths(9).asDate()));
        assertEquals("11||Nov||November", format.format(date.addMonths(10).asDate()));
        assertEquals("12||Dec||December", format.format(date.addMonths(11).asDate()));
    }


    @Test
    public void testDay() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().day1Digit().v1().day2Digit().v1().dayWithDigit(5).v1().day2Digit().dayWithDigit(4).v1("||").build();
        DatetimeBuilderInterface date = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(7);
        assertEquals("7||07||00007||000007", format.format(date.asDate()));
        assertEquals("11||11||00011||000011", format.format(date.addDays(4).asDate()));
    }

    @Test
    public void testTimeDiff() {
        SimpleDateFormat format = DatetimeFactory.instance().now().format().hourInDay24().v1().minute().v1().second().v2().ms().v1(":").v2(".").build();
        DatetimeBuilder builder = DatetimeFactory.instance().raw().year(2088).month(Month.JAN).day(7).minDayTime();
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        assertEquals("00:00:00.000", format.format(new Date(0l)));
        assertEquals("00:02:10.444", format.format(new Date(
                        builder.addMins(4).addSecond(50).addMS(555).asLong()
                                - builder.addMins(2).addSecond(40).addMS(111).asLong())
                )
        );
    }
}
