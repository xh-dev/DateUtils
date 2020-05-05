package me.xethh.utils.v6.timezone;

import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestTimeZone
{

    @Test
    public void testTimezone(){
        DateFormatBuilder dfBuilder = DateFormatBuilderImpl.get().custFormat(DateFormatBuilder.Format.ISO8601.format());
        DatetimeBuilder db = DatetimeFactory.instance().raw().ymd(1987, Month.FEB, 9).hmsms(12, 12, 44, 777);
        //Test with time diff
        assertEquals(db.timeZone(BaseTimeZone.UTC).asLong().longValue(),db.timeZone(BaseTimeZone.Hongkong).asLong()+(28800000l));

        assertEquals(28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Etc_GMT_P8).asLong().longValue());
        assertEquals(0l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.GMT).asLong().longValue());
        assertEquals(0l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.UTC).asLong().longValue());
        assertEquals(0l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Greenwich).asLong().longValue());
        assertEquals(-28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Etc_GMT_M8).asLong().longValue());
        assertEquals(-28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Hongkong).asLong().longValue());
        assertEquals(-28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Asia_Hong_Kong).asLong().longValue());
        assertEquals(-28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Asia_Taipei).asLong().longValue());
        assertEquals(-28800000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Asia_Shanghai).asLong().longValue());
        //Singapore changed timezone from 1982-01-01 from +07:00 to +08:00
        assertEquals(-27000000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Singapore).asLong().longValue());
        assertEquals(-27000000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Asia_Singapore).asLong().longValue());
        assertEquals(-32400000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Asia_Seoul).asLong().longValue());
        assertEquals(-32400000l, DatetimeFactory.instance().raw().timeZone(BaseTimeZone.Japan).asLong().longValue());

        //Test dateformat
        DatetimeBuilder t2 = DatetimeFactory.instance().raw().ymd(2018, Month.JAN, 01).hmsms(13, 21, 33, 789);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(Calendar.YEAR,2018);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,13);
        cal.set(Calendar.MINUTE,21);
        cal.set(Calendar.SECOND,33);
        cal.set(Calendar.MILLISECOND,789);
        long gmt0inMS = 1514812893789l;
        //Ensure millisecond in calendar
        assertEquals(cal.getTimeInMillis(),gmt0inMS);
        long offset8h = 28800000l;
        long offset9h = 3600000l+offset8h;
        assertEquals(gmt0inMS+offset8h, t2.timeZone(BaseTimeZone.Etc_GMT_P8).asLong().longValue());
        assertEquals(gmt0inMS, t2.timeZone(BaseTimeZone.GMT).asLong().longValue());
        assertEquals(gmt0inMS, t2.timeZone(BaseTimeZone.UTC).asLong().longValue());
        assertEquals(gmt0inMS, t2.timeZone(BaseTimeZone.Greenwich).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Etc_GMT_M8).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Hongkong).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Asia_Hong_Kong).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Asia_Shanghai).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Asia_Taipei).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Singapore).asLong().longValue());
        assertEquals(gmt0inMS-offset8h, t2.timeZone(BaseTimeZone.Asia_Singapore).asLong().longValue());
        assertEquals(gmt0inMS-offset9h, t2.timeZone(BaseTimeZone.Asia_Seoul).asLong().longValue());
        assertEquals(gmt0inMS-offset9h, t2.timeZone(BaseTimeZone.Japan).asLong().longValue());


        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Etc_GMT_P8.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.UTC.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.GMT.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Greenwich.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Etc_GMT_M8.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Hongkong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Hong_Kong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Shanghai.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Taipei.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 22:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Seoul.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 22:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Japan.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));

        assertEquals("2017-12-31 21:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Etc_GMT_P8.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.UTC.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.GMT.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Greenwich.timeZone(),DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Etc_GMT_M8.timeZone(), DateFormatBuilderFactory.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Hongkong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Hong_Kong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Shanghai.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Taipei.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 14:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Seoul.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 14:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Japan.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));

    }

    @Test
    public void testTimeZone(){
        Calendar cal = Calendar.getInstance(BaseTimeZone.Hongkong.timeZone());
        DatetimeBuilder nowTime = DatetimeFactory.instance().now().ymd(2019, Month.FEB, 27).hmsms(13, 34, 44, 888).timeZone(BaseTimeZone.Hongkong);
        cal.set(Calendar.YEAR, nowTime.view().year());
        cal.set(Calendar.MONTH, nowTime.view().month().toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, nowTime.view().day());
        cal.set(Calendar.HOUR_OF_DAY, nowTime.view().hour());
        cal.set(Calendar.MINUTE, nowTime.view().min());
        cal.set(Calendar.SECOND, nowTime.view().second());
        cal.set(Calendar.MILLISECOND, nowTime.view().ms());

        assertTrue(nowTime.equals(cal.getTime()));
        //cal.setTimeZone will not trigger time update
        cal.setTimeZone(BaseTimeZone.Japan.timeZone());
        assertTrue(nowTime.equals(cal.getTime()));
        //cal.set() will trigger time update
        cal.set(Calendar.HOUR_OF_DAY, nowTime.view().hour());
        assertFalse(nowTime.equals(cal.getTime()));
        //cal.set() will trigger time update
        cal.set(Calendar.HOUR_OF_DAY, nowTime.view().hour()+1);
        assertTrue(nowTime.equals(cal.getTime()));
    }


}
