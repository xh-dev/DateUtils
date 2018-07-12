package me.xethh.utils;

import me.xethh.utils.dateManipulation.BaseTimeZone;
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
                .year4Digit().pad(" - ").month2Digit().pad("-").day2Digit().pad("T")
                .hourInDay24().pad(":").minute().pad(":").second().pad(".").ms().pad("===").TimeZoneRFC822().build();
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
        SimpleDateFormat format = DateFormatBuilder.get().year4Digit().v1().month2Digit().v1().day2Digit().v2().hourInDay24().v3().minute().v3().second()
                .v1("-").v2("T").v3(":").build();
        Date date = DateBuilder.raw().year(2088).month(Month.NOV).day(10).hour(21).minute(56).second(58).ms(888).asDate();
        assertEquals("2088-11-10T21:56:58",format.format(date));
    }

    @Test
    public void testTimeZone(){
        DateFormatBuilder format = DateFormatBuilder.get()
                // General timezone is not available for testing
                .GeneralTimeZone().v1()
                .TimeZoneRFC822().v1()
                .TimeZoneISO8601OneDigit().v1()
                .TimeZoneISO8601TwoDigit().v1()
                .TimeZoneISO8601ThreeDigit().v1().year4Digit().month2Digit().day2Digit().hourInDay24().minute().second().v1("||").timeZone(BaseTimeZone.Hongkong);
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(10).hour(1).minute(23).second(34).timeZone(BaseTimeZone.Hongkong);
        assertEquals("HKT||+0800||+08||+0800||+08:00||20880110012334",format.build().format(date.asDate()));
        assertEquals("GMT||+0000||Z||Z||Z||20880109172334",format.timeZone(BaseTimeZone.GMT).build().format(date.asDate()));
        assertEquals("GMT-08:00||-0800||-08||-0800||-08:00||20880109092334",format.timeZone(BaseTimeZone.Etc_GMT_P8).build().format(date.asDate()));
        assertEquals("GMT+08:00||+0800||+08||+0800||+08:00||20880110012334",format.timeZone(BaseTimeZone.Etc_GMT_M8).build().format(date.asDate()));
        assertEquals("UTC||+0000||Z||Z||Z||20880109172334",format.timeZone(BaseTimeZone.UTC).build().format(date.asDate()));
        date=date.timeZone(BaseTimeZone.Japan);
        assertEquals("HKT||+0800||+08||+0800||+08:00||20880110002334",format.build().format(date.asDate()));
        assertEquals("GMT||+0000||Z||Z||Z||20880109162334",format.timeZone(BaseTimeZone.GMT).build().format(date.asDate()));
        assertEquals("GMT-08:00||-0800||-08||-0800||-08:00||20880109082334",format.timeZone(BaseTimeZone.Etc_GMT_P8).build().format(date.asDate()));
        assertEquals("GMT+08:00||+0800||+08||+0800||+08:00||20880110002334",format.timeZone(BaseTimeZone.Etc_GMT_M8).build().format(date.asDate()));
        assertEquals("UTC||+0000||Z||Z||Z||20880109162334",format.timeZone(BaseTimeZone.UTC).build().format(date.asDate()));
    }
    @Test
    public void testAPM(){
        SimpleDateFormat format = DateFormatBuilder.get().apm().v1("||").build();
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(10).hour(0);
        assertEquals("AM",format.format(date.asDate()));
        assertEquals("AM",format.format(date.operate().addHours(1).asDate()));
        assertEquals("AM",format.format(date.operate().addHours(11).asDate()));
        assertEquals("PM",format.format(date.operate().addHours(12).asDate()));
        assertEquals("PM",format.format(date.operate().addHours(13).asDate()));
        assertEquals("PM",format.format(date.operate().addHours(23).asDate()));
        assertEquals("AM",format.format(date.operate().addHours(24).asDate()));
    }

    @Test
    public void testHour(){
        SimpleDateFormat format = DateFormatBuilder.get().hourInDay12().v1().hourInDay24().v1("||").build();
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(10).hour(0);
        assertEquals("12||00",format.format(date.asDate()));
        assertEquals("01||01",format.format(date.operate().addHours(1).asDate()));
        assertEquals("11||11",format.format(date.operate().addHours(11).asDate()));
        assertEquals("12||12",format.format(date.operate().addHours(12).asDate()));
        assertEquals("01||13",format.format(date.operate().addHours(13).asDate()));
        assertEquals("11||23",format.format(date.operate().addHours(23).asDate()));
        assertEquals("12||00",format.format(date.operate().addHours(24).asDate()));
    }

    @Test
    public void testYear(){
        SimpleDateFormat format = DateFormatBuilder.get().year2Digit().v1().year4Digit().v1("||").build();
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(10);
        assertEquals("88||2088",format.format(date.asDate()));
        assertEquals("90||2090",format.format(date.operate().addYear(2).asDate()));
    }

    @Test
    public void testMonth(){
        SimpleDateFormat format = DateFormatBuilder.get().month2Digit().v1().month3Letters().v1().monthFullName().v1("||").build();
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(10);
        assertEquals("01||Jan||January",format.format(date.asDate()));
        assertEquals("02||Feb||February",format.format(date.operate().addMonths(1).asDate()));
        assertEquals("03||Mar||March",format.format(date.operate().addMonths(2).asDate()));
        assertEquals("04||Apr||April",format.format(date.operate().addMonths(3).asDate()));
        assertEquals("05||May||May",format.format(date.operate().addMonths(4).asDate()));
        assertEquals("06||Jun||June",format.format(date.operate().addMonths(5).asDate()));
        assertEquals("07||Jul||July",format.format(date.operate().addMonths(6).asDate()));
        assertEquals("08||Aug||August",format.format(date.operate().addMonths(7).asDate()));
        assertEquals("09||Sep||September",format.format(date.operate().addMonths(8).asDate()));
        assertEquals("10||Oct||October",format.format(date.operate().addMonths(9).asDate()));
        assertEquals("11||Nov||November",format.format(date.operate().addMonths(10).asDate()));
        assertEquals("12||Dec||December",format.format(date.operate().addMonths(11).asDate()));
    }


    @Test
    public void testDay(){
        SimpleDateFormat format = DateFormatBuilder.get().day1Digit().v1().day2Digit().v1().dayWithDigit(5).v1().day2Digit().dayWithDigit(4).v1("||").build();
        DateBuilder date = DateBuilder.raw().year(2088).month(Month.JAN).day(7);
        assertEquals("7||07||00007||000007",format.format(date.asDate()));
        assertEquals("11||11||00011||000011",format.format(date.operate().addDays(4).asDate()));
    }
}
