package me.xethh.utils;

import me.xethh.utils.dateManipulation.Weekday;
import org.junit.Test;

import static me.xethh.utils.dateManipulation.Weekday.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class WeekdayTest
{

    @Test
    public void nextDay(){
        assertEquals(Weekday.Monday,Sunday.nextDay());
        assertEquals(Weekday.Tuesday,Weekday.Monday.nextDay());
        assertEquals(Weekday.Wednesday,Weekday.Tuesday.nextDay());
        assertEquals(Weekday.Thursday,Weekday.Wednesday.nextDay());
        assertEquals(Weekday.Friday,Weekday.Thursday.nextDay());
        assertEquals(Weekday.Saturday,Weekday.Friday.nextDay());
        assertEquals(Sunday,Weekday.Saturday.nextDay());

    }

    @Test
    public void prevDay(){
        assertEquals(Weekday.Saturday,Sunday.prevDay());
        assertEquals(Sunday,Weekday.Monday.prevDay());
        assertEquals(Weekday.Monday,Weekday.Tuesday.prevDay());
        assertEquals(Weekday.Tuesday,Weekday.Wednesday.prevDay());
        assertEquals(Weekday.Wednesday,Weekday.Thursday.prevDay());
        assertEquals(Weekday.Thursday,Weekday.Friday.prevDay());
        assertEquals(Weekday.Friday,Weekday.Saturday.prevDay());
    }

    @Test
    public void getCalWeekday(){
        assertEquals(7,Sunday.getCalWeekDay());
        assertEquals(1,Weekday.Monday.getCalWeekDay());
        assertEquals(2,Weekday.Tuesday.getCalWeekDay());
        assertEquals(3,Weekday.Wednesday.getCalWeekDay());
        assertEquals(4,Weekday.Thursday.getCalWeekDay());
        assertEquals(5,Weekday.Friday.getCalWeekDay());
        assertEquals(6,Weekday.Saturday.getCalWeekDay());
    }

    @Test
    public void getByCalWeekday(){
        assertEquals(Sunday,Sunday.getByCalWeekday(7));
        assertEquals(Monday,Weekday.getByCalWeekday(1));
        assertEquals(Tuesday,Weekday.getByCalWeekday(2));
        assertEquals(Wednesday,Weekday.getByCalWeekday(3));
        assertEquals(Thursday,Weekday.getByCalWeekday(4));
        assertEquals(Friday,Weekday.getByCalWeekday(5));
        assertEquals(Saturday,Weekday.getByCalWeekday(6));
    }

    @Test
    public void getByOrdinal(){
        assertEquals(Sunday,Sunday.getByOrdinal(0));
        assertEquals(Monday,Weekday.getByOrdinal(1));
        assertEquals(Tuesday,Weekday.getByOrdinal(2));
        assertEquals(Wednesday,Weekday.getByOrdinal(3));
        assertEquals(Thursday,Weekday.getByOrdinal(4));
        assertEquals(Friday,Weekday.getByOrdinal(5));
        assertEquals(Saturday,Weekday.getByOrdinal(6));
    }

}
