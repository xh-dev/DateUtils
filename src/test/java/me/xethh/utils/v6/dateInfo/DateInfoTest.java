package me.xethh.utils.v6.dateInfo;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.weekday.Weekday;
import org.junit.Test;

import static me.xethh.utils.dateUtils.month.Month.*;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class DateInfoTest
{

    @Test
    public void extractDate(){
        DateInfo dateInfo =
                DatetimeFactory.instance().raw()
                        .hour(13).minute(23).second(34).ms(666)
                        .day(20).month(NOV).year(2078).view();
        assertEquals(2078,dateInfo.year().intValue());
        assertEquals(11,dateInfo.month().toCalNumber());
        assertEquals(20,dateInfo.day().intValue());
        assertEquals(666,dateInfo.ms().intValue());
        assertEquals(34,dateInfo.second().intValue());
        assertEquals(23,dateInfo.min().intValue());
        assertEquals(13,dateInfo.hour().intValue());
    }
    @Test
    public void weekdayTest(){
        DatetimeBuilder d20180506 = DatetimeFactory.instance().raw().year(2018).month(MAY).day(6);
        assertEquals(Weekday.Sunday,d20180506.view().weekday());
        assertEquals(Weekday.Monday,d20180506.addDays(1).view().weekday());
        assertEquals(Weekday.Tuesday,d20180506.addDays(2).view().weekday());
        assertEquals(Weekday.Wednesday,d20180506.addDays(3).view().weekday());
        assertEquals(Weekday.Thursday,d20180506.addDays(4).view().weekday());
        assertEquals(Weekday.Friday,d20180506.addDays(5).view().weekday());
        assertEquals(Weekday.Saturday,d20180506.addDays(6).view().weekday());
        assertEquals(Weekday.Sunday,d20180506.addDays(7).view().weekday());

        DatetimeBuilder d20180101 = d20180506.ymd(2018, JAN, 1);
        assertEquals(new Integer(1),d20180101.view().dayOfYear());
        assertEquals(new Integer(2),d20180101.addDays(1).view().dayOfYear());
        assertEquals(new Integer(365),d20180101.addDays(-1).view().dayOfYear());
        assertEquals(new Integer(365),d20180101.addYear(1).addDays(-1).view().dayOfYear());
        assertEquals(new Integer(365),d20180101.addYear(2).addDays(-1).view().dayOfYear());
        assertEquals(new Integer(366),d20180101.addYear(3).addDays(-1).view().dayOfYear());

        assertEquals(new Integer(1),d20180101.view().weekOfYear());
        assertEquals(new Integer(1),d20180101.md(JAN,2).view().weekOfYear());
        assertEquals(new Integer(1),d20180101.md(JAN,3).view().weekOfYear());
        assertEquals(new Integer(1),d20180101.md(JAN,4).view().weekOfYear());
        assertEquals(new Integer(1),d20180101.md(JAN,5).view().weekOfYear());
        assertEquals(new Integer(1),d20180101.md(JAN,6).view().weekOfYear());
        assertEquals(new Integer(2),d20180101.md(JAN,7).view().weekOfYear());
        assertEquals(new Integer(2),d20180101.md(JAN,8).view().weekOfYear());
        assertEquals(new Integer(51),d20180101.ymd(2019,DEC,18).view().weekOfYear());
        assertEquals(new Integer(51),d20180101.ymd(2019,DEC,19).view().weekOfYear());
        assertEquals(new Integer(52),d20180101.ymd(2019,DEC,22).view().weekOfYear());

        assertEquals(new Integer(1),d20180101.view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(JAN,2).view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(JAN,3).view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(JAN,4).view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(JAN,5).view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(JAN,6).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,7).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,8).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,9).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,10).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,11).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,12).view().weekOfMonth());
        assertEquals(new Integer(2),d20180101.md(JAN,13).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,14).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,15).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,16).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,17).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,18).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,19).view().weekOfMonth());
        assertEquals(new Integer(3),d20180101.md(JAN,20).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,21).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,22).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,23).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,24).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,25).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,26).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,26).view().weekOfMonth());
        assertEquals(new Integer(4),d20180101.md(JAN,27).view().weekOfMonth());
        assertEquals(new Integer(5),d20180101.md(JAN,28).view().weekOfMonth());
        assertEquals(new Integer(5),d20180101.md(JAN,29).view().weekOfMonth());
        assertEquals(new Integer(5),d20180101.md(JAN,30).view().weekOfMonth());
        assertEquals(new Integer(5),d20180101.md(JAN,31).view().weekOfMonth());
        assertEquals(new Integer(1),d20180101.md(FEB,1).view().weekOfMonth());
    }


}
