package me.xethh.utils.v6;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.TimeZone;

import static me.xethh.utils.dateUtils.weekday.Weekday.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class WeekdayTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }

    @Test
    public void nextDay() {
        assertEquals(Weekday.Monday, Sunday.nextDay());
        assertEquals(Weekday.Tuesday, Weekday.Monday.nextDay());
        assertEquals(Weekday.Wednesday, Weekday.Tuesday.nextDay());
        assertEquals(Weekday.Thursday, Weekday.Wednesday.nextDay());
        assertEquals(Weekday.Friday, Weekday.Thursday.nextDay());
        assertEquals(Weekday.Saturday, Weekday.Friday.nextDay());
        assertEquals(Sunday, Weekday.Saturday.nextDay());

    }

    @Test
    public void prevDay() {
        assertEquals(Weekday.Saturday, Sunday.prevDay());
        assertEquals(Sunday, Weekday.Monday.prevDay());
        assertEquals(Weekday.Monday, Weekday.Tuesday.prevDay());
        assertEquals(Weekday.Tuesday, Weekday.Wednesday.prevDay());
        assertEquals(Weekday.Wednesday, Weekday.Thursday.prevDay());
        assertEquals(Weekday.Thursday, Weekday.Friday.prevDay());
        assertEquals(Weekday.Friday, Weekday.Saturday.prevDay());
    }

    @Test
    public void getCalWeekday() {
        assertEquals(7, Sunday.getCalWeekDay());
        assertEquals(1, Weekday.Monday.getCalWeekDay());
        assertEquals(2, Weekday.Tuesday.getCalWeekDay());
        assertEquals(3, Weekday.Wednesday.getCalWeekDay());
        assertEquals(4, Weekday.Thursday.getCalWeekDay());
        assertEquals(5, Weekday.Friday.getCalWeekDay());
        assertEquals(6, Weekday.Saturday.getCalWeekDay());
    }

    @Test
    public void getByCalWeekday() {
        assertEquals(Sunday, Sunday.getByCalWeekday(7));
        assertEquals(Monday, Weekday.getByCalWeekday(1));
        assertEquals(Tuesday, Weekday.getByCalWeekday(2));
        assertEquals(Wednesday, Weekday.getByCalWeekday(3));
        assertEquals(Thursday, Weekday.getByCalWeekday(4));
        assertEquals(Friday, Weekday.getByCalWeekday(5));
        assertEquals(Saturday, Weekday.getByCalWeekday(6));
    }

    @Test
    public void getByOrdinal() {
        assertEquals(Sunday, Sunday.getByOrdinal(0));
        assertEquals(Monday, Weekday.getByOrdinal(1));
        assertEquals(Tuesday, Weekday.getByOrdinal(2));
        assertEquals(Wednesday, Weekday.getByOrdinal(3));
        assertEquals(Thursday, Weekday.getByOrdinal(4));
        assertEquals(Friday, Weekday.getByOrdinal(5));
        assertEquals(Saturday, Weekday.getByOrdinal(6));
    }

    @Test
    public void asDayOfWeek(){
        assertEquals(DayOfWeek.SUNDAY, Sunday.asDayOfWeek());
        assertEquals(DayOfWeek.MONDAY, Monday.asDayOfWeek());
        assertEquals(DayOfWeek.TUESDAY, Tuesday.asDayOfWeek());
        assertEquals(DayOfWeek.WEDNESDAY, Wednesday.asDayOfWeek());
        assertEquals(DayOfWeek.THURSDAY, Thursday.asDayOfWeek());
        assertEquals(DayOfWeek.FRIDAY, Friday.asDayOfWeek());
        assertEquals(DayOfWeek.SATURDAY, Saturday.asDayOfWeek());
    }

}
