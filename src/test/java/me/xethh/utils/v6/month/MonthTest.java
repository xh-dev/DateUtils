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
        assertEquals(Month.JAN, Month.ofTimeMonth(java.time.Month.JANUARY));
        assertEquals(Month.DEC, month.previous());
        assertEquals(Month.FEB, month.next());

        month = Month.FEB;
        assertEquals(2, month.toCalNumber());
        assertEquals(1, month.toJavaCalNumber());
        assertEquals(Month.FEB, Month.ofTimeMonth(java.time.Month.FEBRUARY));
        assertEquals(Month.JAN, month.previous());
        assertEquals(Month.MAR, month.next());

        month = Month.MAR;
        assertEquals(3, month.toCalNumber());
        assertEquals(2, month.toJavaCalNumber());
        assertEquals(Month.MAR, Month.ofTimeMonth(java.time.Month.MARCH));
        assertEquals(Month.FEB, month.previous());
        assertEquals(Month.APR, month.next());

        month = Month.APR;
        assertEquals(4, month.toCalNumber());
        assertEquals(3, month.toJavaCalNumber());
        assertEquals(Month.APR, Month.ofTimeMonth(java.time.Month.APRIL));
        assertEquals(Month.MAR, month.previous());
        assertEquals(Month.MAY, month.next());

        month = Month.MAY;
        assertEquals(5, month.toCalNumber());
        assertEquals(4, month.toJavaCalNumber());
        assertEquals(Month.MAY, Month.ofTimeMonth(java.time.Month.MAY));
        assertEquals(Month.APR, month.previous());
        assertEquals(Month.JUN, month.next());

        month = Month.JUN;
        assertEquals(6, month.toCalNumber());
        assertEquals(5, month.toJavaCalNumber());
        assertEquals(Month.JUN, Month.ofTimeMonth(java.time.Month.JUNE));
        assertEquals(Month.MAY, month.previous());
        assertEquals(Month.JUL, month.next());

        month = Month.JUL;
        assertEquals(7, month.toCalNumber());
        assertEquals(6, month.toJavaCalNumber());
        assertEquals(Month.JUL, Month.ofTimeMonth(java.time.Month.JULY));
        assertEquals(Month.JUN, month.previous());
        assertEquals(Month.AUG, month.next());

        month = Month.AUG;
        assertEquals(8, month.toCalNumber());
        assertEquals(7, month.toJavaCalNumber());
        assertEquals(Month.AUG, Month.ofTimeMonth(java.time.Month.AUGUST));
        assertEquals(Month.JUL, month.previous());
        assertEquals(Month.SEP, month.next());

        month = Month.SEP;
        assertEquals(9, month.toCalNumber());
        assertEquals(8, month.toJavaCalNumber());
        assertEquals(Month.SEP, Month.ofTimeMonth(java.time.Month.SEPTEMBER));
        assertEquals(Month.AUG, month.previous());
        assertEquals(Month.OCT, month.next());

        month = Month.OCT;
        assertEquals(10, month.toCalNumber());
        assertEquals(9, month.toJavaCalNumber());
        assertEquals(Month.OCT, Month.ofTimeMonth(java.time.Month.OCTOBER));
        assertEquals(Month.SEP, month.previous());
        assertEquals(Month.NOV, month.next());

        month = Month.NOV;
        assertEquals(11, month.toCalNumber());
        assertEquals(10, month.toJavaCalNumber());
        assertEquals(Month.NOV, Month.ofTimeMonth(java.time.Month.NOVEMBER));
        assertEquals(Month.OCT, month.previous());
        assertEquals(Month.DEC, month.next());

        month = Month.DEC;
        assertEquals(12, month.toCalNumber());
        assertEquals(11, month.toJavaCalNumber());
        assertEquals(Month.DEC, Month.ofTimeMonth(java.time.Month.DECEMBER));
        assertEquals(Month.NOV, month.previous());
        assertEquals(Month.JAN, month.next());
    }

    @Test
    public void testTimeMonth(){
        assertEquals(java.time.Month.JANUARY, Month.JAN.asTimeMonth());
        assertEquals(java.time.Month.FEBRUARY, Month.FEB.asTimeMonth());
        assertEquals(java.time.Month.MARCH, Month.MAR.asTimeMonth());
        assertEquals(java.time.Month.APRIL, Month.APR.asTimeMonth());
        assertEquals(java.time.Month.MAY, Month.MAY.asTimeMonth());
        assertEquals(java.time.Month.JUNE, Month.JUN.asTimeMonth());
        assertEquals(java.time.Month.JULY, Month.JUL.asTimeMonth());
        assertEquals(java.time.Month.AUGUST, Month.AUG.asTimeMonth());
        assertEquals(java.time.Month.SEPTEMBER, Month.SEP.asTimeMonth());
        assertEquals(java.time.Month.OCTOBER, Month.OCT.asTimeMonth());
        assertEquals(java.time.Month.NOVEMBER, Month.NOV.asTimeMonth());
        assertEquals(java.time.Month.DECEMBER, Month.DEC.asTimeMonth());
    }

}
