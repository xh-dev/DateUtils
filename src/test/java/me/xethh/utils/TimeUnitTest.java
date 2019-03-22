package me.xethh.utils;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.Month;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class TimeUnitTest
{

    @Test
    public void baseDiffTest(){
        DatetimeBuilder start = DatetimeFactory.instance().raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end = start.addDays(8).addHours(7).addMins(12).addSecond(34).addMS(333);
        TimeUnit tu = start.diffTo(end);

        assertEquals("Ms comparing eliminate second",333,tu.msOnly());
        assertEquals("Ms comparing no eliminate",
                8*24*60*60*1000
                        +7*60*60*1000
                        +12*60*1000
                        +34*1000
                        +333,tu.numberOfMS());
        assertEquals("Second comparing eliminate minutes",34,tu.secOnly());
        assertEquals("Second comparing no eliminate",
                8*24*60*60
                        +7*60*60
                        +12*60
                        +34,tu.numberOfSecond());
        assertEquals("Min comparing eliminate day",12,tu.minOnly());
        assertEquals("Min comparing no eliminate",
                8*24*60
                        +7*60
                        +12,tu.numberOfMin());
        assertEquals("Hour comparing eliminate minutes",7,tu.hoursOnly());
        assertEquals("Hour comparing no eliminate",
                8*24
                        +7,tu.numberOfHour());
        assertEquals("Hour comparing eliminate minutes",8,tu.dayOnly());
        assertEquals("Hour comparing no eliminate",
                8,tu.numberOfDays());


    }

    @Test
    public void roundUpTest(){
        DatetimeBuilder start = DatetimeFactory.instance().raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end1 = start.addDays(8).addHours(12).addMins(30).addSecond(30).addMS(500);
        DatetimeBuilder end2 = start.addDays(8).addHours(13).addMins(31).addSecond(31).addMS(501);
        TimeUnit tu1 = start.diffTo(end1);
        TimeUnit tu2 = start.diffTo(end2);
        assertEquals("Round Up Day: ",false,tu1.roundUpDay());
        assertEquals("Round Up Hours: ",false,tu1.roundUpHour());
        assertEquals("Round Up Minutes: ",false,tu1.roundUpMin());
        assertEquals("Round Up Second: ",false,tu1.roundUpSecond());

        assertEquals("Round Up Day: ",true,tu2.roundUpDay());
        assertEquals("Round Up Hours: ",true,tu2.roundUpHour());
        assertEquals("Round Up Minutes: ",true,tu2.roundUpMin());
        assertEquals("Round Up Second: ",true,tu2.roundUpSecond());
    }

    @Test
    public void weekTest(){
        DatetimeBuilder start = DatetimeFactory.instance().raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end1 = start.addDays(300).addHours(12).addMins(30).addSecond(30).addMS(500);
        TimeUnit tu = start.diffTo(end1);
        assertEquals("Weeeks between",42,tu.numberOfWeeks());
        assertEquals("Weeeks day remind",6,tu.remindOfWeeks());
        assertEquals("Weeeks between",42,TimeUnit.numberByBase(tu.dayOnly(),7));
        assertEquals("Weeeks day remind",6,TimeUnit.eliminateByBase(tu.dayOnly(),7));
    }

    @Test
    public void rangeTest(){
        DatetimeBuilder start = DatetimeFactory.instance().raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end = start.addDays(8).addHours(7).addMins(12).addSecond(34).addMS(333);
        TimeUnit tu = start.rangeTo(DatetimeFactory.instance().raw()).editStart().diffTo(end);
        assertEquals("Ms comparing eliminate second",333,tu.msOnly());
        assertEquals("Ms comparing no eliminate",
                8*24*60*60*1000
                        +7*60*60*1000
                        +12*60*1000
                        +34*1000
                        +333,tu.numberOfMS());
        assertEquals("Second comparing eliminate minutes",34,tu.secOnly());
        assertEquals("Second comparing no eliminate",
                8*24*60*60
                        +7*60*60
                        +12*60
                        +34,tu.numberOfSecond());
        assertEquals("Min comparing eliminate day",12,tu.minOnly());
        assertEquals("Min comparing no eliminate",
                8*24*60
                        +7*60
                        +12,tu.numberOfMin());
        assertEquals("Hour comparing eliminate minutes",7,tu.hoursOnly());
        assertEquals("Hour comparing no eliminate",
                8*24
                        +7,tu.numberOfHour());
        assertEquals("Hour comparing eliminate minutes",8,tu.dayOnly());
        assertEquals("Hour comparing no eliminate",
                8,tu.numberOfDays());
    }

    @Test
    public void testTimeUnit(){
        TimeUnit d = TimeUnit.day();
        assertEquals(1,d.numberOfDays());
        assertEquals(24,d.numberOfHour());
        assertEquals(1440,d.numberOfMin());
        assertEquals(86400,d.numberOfSecond());
        assertEquals(86400000,d.numberOfMS());

        d = TimeUnit.day(7);
        assertEquals(7,d.numberOfDays());
        assertEquals(1,d.numberOfWeeks());
        d = TimeUnit.day(9);
        assertEquals(9,d.numberOfDays());
        assertEquals(1,d.numberOfWeeks());
        d = TimeUnit.day(14);
        assertEquals(14,d.numberOfDays());
        assertEquals(2,d.numberOfWeeks());
        d = TimeUnit.day(15);
        assertEquals(15,d.numberOfDays());
        assertEquals(2,d.numberOfWeeks());

        d=TimeUnit.hour();
        assertEquals(1,d.numberOfHour());
        assertEquals(60,d.numberOfMin());
        assertEquals(3600,d.numberOfSecond());
        assertEquals(3600000,d.numberOfMS());

        d=TimeUnit.hour(10);
        assertEquals(10,d.numberOfHour());
        assertEquals(600,d.numberOfMin());
        assertEquals(36000,d.numberOfSecond());
        assertEquals(36000000,d.numberOfMS());

        d=TimeUnit.hour(168);
        assertEquals(168,d.numberOfHour());
        assertEquals(10080,d.numberOfMin());
        assertEquals(604800,d.numberOfSecond());
        assertEquals(604800000,d.numberOfMS());
        assertEquals(1,d.numberOfWeeks());

        d=TimeUnit.minute(1);
        assertEquals(1,d.numberOfMin());
        assertEquals(60,d.numberOfSecond());
        assertEquals(60000,d.numberOfMS());

        d=TimeUnit.second(1);
        assertEquals(1,d.numberOfSecond());
        assertEquals(1000,d.numberOfMS());

        d=TimeUnit.ms(1);
        assertEquals(1,d.numberOfMS());

    }

    @Test
    public void testToString(){
        TimeUnit d = TimeUnit.day();
        assertEquals("TimeUnit[1 days | 24 hours | 1440 minutes | 86400 seconds | 86400000 ms]",d.toString());
        d = TimeUnit.day().addDay(1);
        assertEquals("TimeUnit[2 days | 48 hours | 2880 minutes | 172800 seconds | 172800000 ms]",d.toString());
        d = TimeUnit.day().addHour(24);
        assertEquals("TimeUnit[2 days | 48 hours | 2880 minutes | 172800 seconds | 172800000 ms]",d.toString());
        d = TimeUnit.day().addMinute(1440);
        assertEquals("TimeUnit[2 days | 48 hours | 2880 minutes | 172800 seconds | 172800000 ms]",d.toString());
        d = TimeUnit.day().addSecond(86400);
        assertEquals("TimeUnit[2 days | 48 hours | 2880 minutes | 172800 seconds | 172800000 ms]",d.toString());
        d = TimeUnit.day().addMS(86400000);
        assertEquals("TimeUnit[2 days | 48 hours | 2880 minutes | 172800 seconds | 172800000 ms]",d.toString());
    }
}
