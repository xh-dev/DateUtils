package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateComparatorTest
{
    @Test
    public void sameDate(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        System.out.println("d3 ==> "+d3.toString());
        assertEquals(false,d1.asComparator().sameDay(d2));
        assertEquals(true,d1.asComparator().sameDay(d3));

        assertEquals(false,d1.asComparator().sameDay(d2.asLong()));
        assertEquals(true,d1.asComparator().sameDay(d3.asLong()));

        assertEquals(false,d1.asComparator().sameDay(d2.asCalendar()));
        assertEquals(true,d1.asComparator().sameDay(d3.asCalendar()));

        assertEquals(false,d1.asComparator().sameDay(d2.build()));
        assertEquals(true,d1.asComparator().sameDay(d3.build()));
    }

    @Test
    public void sameTime(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.hour(3).minute(21).second(56).ms(221);
        System.out.println("d3 ==> "+d3.toString());
        assertEquals(true,d1.asComparator().sameTime(d2));
        assertEquals(false,d1.asComparator().sameTime(d3));

        assertEquals(true,d1.asComparator().sameTime(d2.asLong()));
        assertEquals(false,d1.asComparator().sameTime(d3.asLong()));

        assertEquals(true,d1.asComparator().sameTime(d2.asCalendar()));
        assertEquals(false,d1.asComparator().sameTime(d3.asCalendar()));

        assertEquals(true,d1.asComparator().sameTime(d2.build()));
        assertEquals(false,d1.asComparator().sameTime(d3.build()));
    }

    @Test
    public void sameHMS(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(20).second(1);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.day(2).hour(10).minute(11).second(23);
        System.out.println("d3 ==> "+d3.toString());
        DateBuilder d4 = d1.day(2).hour(11).minute(20).second(23);
        System.out.println("d4 ==> "+d4.toString());
        DateBuilder d5 = d1.day(2).hour(10).minute(20).second(23);
        System.out.println("d5 ==> "+d5.toString());
        assertEquals(false,d1.asComparator().sameHMS(d2));
        assertEquals(false,d1.asComparator().sameHMS(d3));
        assertEquals(false,d1.asComparator().sameHMS(d4));
        assertEquals(true,d1.asComparator().sameHMS(d5));

        assertEquals(false,d1.asComparator().sameHMS(d2.build()));
        assertEquals(false,d1.asComparator().sameHMS(d3.build()));
        assertEquals(false,d1.asComparator().sameHMS(d4.build()));
        assertEquals(true,d1.asComparator().sameHMS(d5.build()));

        assertEquals(false,d1.asComparator().sameHMS(d2.asLong()));
        assertEquals(false,d1.asComparator().sameHMS(d3.asLong()));
        assertEquals(false,d1.asComparator().sameHMS(d4.asLong()));
        assertEquals(true,d1.asComparator().sameHMS(d5.asLong()));

        assertEquals(false,d1.asComparator().sameHMS(d2.asCalendar()));
        assertEquals(false,d1.asComparator().sameHMS(d3.asCalendar()));
        assertEquals(false,d1.asComparator().sameHMS(d4.asCalendar()));
        assertEquals(true,d1.asComparator().sameHMS(d5.asCalendar()));
    }

    @Test
    public void sameHM(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.day(2).hour(11).minute(20).second(23);
        System.out.println("d3 ==> "+d3.toString());
        DateBuilder d5 = d1.day(2).hour(10).minute(20).second(3);
        System.out.println("d5 ==> "+d5.toString());
        assertEquals(false,d1.asComparator().sameHM(d2));
        assertEquals(false,d1.asComparator().sameHM(d3));
        assertEquals(true,d1.asComparator().sameHM(d5));

        assertEquals(false,d1.asComparator().sameHM(d2.build()));
        assertEquals(false,d1.asComparator().sameHM(d3.build()));
        assertEquals(true,d1.asComparator().sameHM(d5.build()));

        assertEquals(false,d1.asComparator().sameHM(d2.asLong()));
        assertEquals(false,d1.asComparator().sameHM(d3.asLong()));
        assertEquals(true,d1.asComparator().sameHM(d5.asLong()));

        assertEquals(false,d1.asComparator().sameHM(d2.asCalendar()));
        assertEquals(false,d1.asComparator().sameHM(d3.asCalendar()));
        assertEquals(true,d1.asComparator().sameHM(d5.asCalendar()));
    }

    @Test
    public void laterThan(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> "+d2.toString());

        assertEquals(false,d1.asComparator().laterThan(d2));
        assertEquals(true,d2.asComparator().laterThan(d1));
        assertEquals(false,d1.asComparator().laterThan(d2.build()));
        assertEquals(true,d2.asComparator().laterThan(d1.build()));
        assertEquals(false,d1.asComparator().laterThan(d2.asLong()));
        assertEquals(true,d2.asComparator().laterThan(d1.asLong()));
        assertEquals(false,d1.asComparator().laterThan(d2.asCalendar()));
        assertEquals(true,d2.asComparator().laterThan(d1.asCalendar()));
        assertEquals(false,d1.asComparator().laterThan(new Date()));
        assertEquals(false,d2.asComparator().laterThan(new Date()));
    }

    @Test
    public void before(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> "+d2.toString());

        assertEquals(true,d1.asComparator().before(d2));
        assertEquals(false,d2.asComparator().before(d1));
        assertEquals(true,d1.asComparator().before(d2.build()));
        assertEquals(false,d2.asComparator().before(d1.build()));
        assertEquals(true,d1.asComparator().before(d2.asLong()));
        assertEquals(false,d2.asComparator().before(d1.asLong()));
        assertEquals(true,d1.asComparator().before(d2.asCalendar()));
        assertEquals(false,d2.asComparator().before(d1.asCalendar()));
        assertEquals(true,d1.asComparator().before(new Date()));
        assertEquals(true,d2.asComparator().before(new Date()));
    }

    @Test
    public void laterEqualThan(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d3 ==> "+d3.toString());

        assertEquals(false,d1.asComparator().laterEqualThan(d2));
        assertEquals(true,d2.asComparator().laterEqualThan(d1));
        assertEquals(true,d3.asComparator().laterEqualThan(d2));

        assertEquals(false,d1.asComparator().laterEqualThan(d2.asLong()));
        assertEquals(true,d2.asComparator().laterEqualThan(d1.asLong()));
        assertEquals(true,d3.asComparator().laterEqualThan(d2.asLong()));

        assertEquals(false,d1.asComparator().laterEqualThan(d2.asCalendar()));
        assertEquals(true,d2.asComparator().laterEqualThan(d1.asCalendar()));
        assertEquals(true,d3.asComparator().laterEqualThan(d2.asCalendar()));

        assertEquals(false,d1.asComparator().laterEqualThan(d2.build()));
        assertEquals(true,d2.asComparator().laterEqualThan(d1.build()));
        assertEquals(true,d3.asComparator().laterEqualThan(d2.build()));
    }

    @Test
    public void beforeEqual(){
        DateBuilder d1 = DateBuilder.raw().hour(10).minute(20).second(23).ms(345);
        System.out.println("d1 ==> "+d1.toString());
        DateBuilder d2 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d2 ==> "+d2.toString());
        DateBuilder d3 = d1.day(2).hour(10).minute(21).second(1);
        System.out.println("d3 ==> "+d3.toString());

        assertEquals(true,d1.asComparator().beforeEqual(d2));
        assertEquals(false,d2.asComparator().beforeEqual(d1));
        assertEquals(true,d3.asComparator().beforeEqual(d2));

        assertEquals(true,d1.asComparator().beforeEqual(d2.asLong()));
        assertEquals(false,d2.asComparator().beforeEqual(d1.asLong()));
        assertEquals(true,d3.asComparator().beforeEqual(d2.asLong()));

        assertEquals(true,d1.asComparator().beforeEqual(d2.asCalendar()));
        assertEquals(false,d2.asComparator().beforeEqual(d1.asCalendar()));
        assertEquals(true,d3.asComparator().beforeEqual(d2.asCalendar()));

        assertEquals(true,d1.asComparator().beforeEqual(d2.build()));
        assertEquals(false,d2.asComparator().beforeEqual(d1.build()));
        assertEquals(true,d3.asComparator().beforeEqual(d2.build()));
    }
}