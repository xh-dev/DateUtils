package me.xethh.utils;

import me.xethh.utils.dateManipulation.DatetimeBuilder;
import me.xethh.utils.dateManipulation.DateFactory;
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
        DatetimeBuilder start = DateFactory.raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
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
        DatetimeBuilder start = DateFactory.raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
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
        DatetimeBuilder start = DateFactory.raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end1 = start.addDays(300).addHours(12).addMins(30).addSecond(30).addMS(500);
        TimeUnit tu = start.diffTo(end1);
        assertEquals("Weeeks between",42,tu.numberOfWeeks());
        assertEquals("Weeeks day remind",6,tu.remindOfWeeks());
        assertEquals("Weeeks between",42,TimeUnit.numberByBase(tu.dayOnly(),7));
        assertEquals("Weeeks day remind",6,TimeUnit.eliminateByBase(tu.dayOnly(),7));
    }

    @Test
    public void rangeTest(){
        DatetimeBuilder start = DateFactory.raw().year(1988).month(Month.AUG).day(11).hour(18).minute(34).second(29).ms(111);
        DatetimeBuilder end = start.addDays(8).addHours(7).addMins(12).addSecond(34).addMS(333);
        TimeUnit tu = start.rangeTo(DateFactory.raw()).editStart().diffTo(end);
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
}
