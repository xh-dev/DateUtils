package me.xethh.utils.v6.month;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class MonthTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    @Test
    public void monthTest() {
        Month month = null;

        month = Month.JAN;
        assertEquals(1, month.toCalNumber());
        assertEquals(0, month.toJavaCalNumber());
        assertEquals(Month.DEC, month.previous());
        assertEquals(Month.FEB, month.next());

        month = Month.FEB;
        assertEquals(2, month.toCalNumber());
        assertEquals(1, month.toJavaCalNumber());
        assertEquals(Month.JAN, month.previous());
        assertEquals(Month.MAR, month.next());

        month = Month.MAR;
        assertEquals(3, month.toCalNumber());
        assertEquals(2, month.toJavaCalNumber());
        assertEquals(Month.FEB, month.previous());
        assertEquals(Month.APR, month.next());

        month = Month.APR;
        assertEquals(4, month.toCalNumber());
        assertEquals(3, month.toJavaCalNumber());
        assertEquals(Month.MAR, month.previous());
        assertEquals(Month.MAY, month.next());

        month = Month.MAY;
        assertEquals(5, month.toCalNumber());
        assertEquals(4, month.toJavaCalNumber());
        assertEquals(Month.APR, month.previous());
        assertEquals(Month.JUN, month.next());

        month = Month.JUN;
        assertEquals(6, month.toCalNumber());
        assertEquals(5, month.toJavaCalNumber());
        assertEquals(Month.MAY, month.previous());
        assertEquals(Month.JUL, month.next());

        month = Month.JUL;
        assertEquals(7, month.toCalNumber());
        assertEquals(6, month.toJavaCalNumber());
        assertEquals(Month.JUN, month.previous());
        assertEquals(Month.AUG, month.next());

        month = Month.AUG;
        assertEquals(8, month.toCalNumber());
        assertEquals(7, month.toJavaCalNumber());
        assertEquals(Month.JUL, month.previous());
        assertEquals(Month.SEP, month.next());

        month = Month.SEP;
        assertEquals(9, month.toCalNumber());
        assertEquals(8, month.toJavaCalNumber());
        assertEquals(Month.AUG, month.previous());
        assertEquals(Month.OCT, month.next());

        month = Month.OCT;
        assertEquals(10, month.toCalNumber());
        assertEquals(9, month.toJavaCalNumber());
        assertEquals(Month.SEP, month.previous());
        assertEquals(Month.NOV, month.next());

        month = Month.NOV;
        assertEquals(11, month.toCalNumber());
        assertEquals(10, month.toJavaCalNumber());
        assertEquals(Month.OCT, month.previous());
        assertEquals(Month.DEC, month.next());

        month = Month.DEC;
        assertEquals(12, month.toCalNumber());
        assertEquals(11, month.toJavaCalNumber());
        assertEquals(Month.NOV, month.previous());
        assertEquals(Month.JAN, month.next());
    }
}
