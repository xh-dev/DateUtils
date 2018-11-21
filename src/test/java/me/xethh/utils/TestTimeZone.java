package me.xethh.utils;

import me.xethh.utils.dateManipulation.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class TestTimeZone
{

    @Test
    public void testTimezone(){
        DateFormatBuilder dfBuilder = DateFormatBuilder.get().custFormat(DateFormatBuilder.Format.ISO8601.format());
        DateBuilderImpl db = DateFactory.raw().ymd(1987, Month.FEB, 9).hmsms(12, 12, 44, 777);
        //Test with time diff
        assertEquals(db.timeZone(BaseTimeZone.UTC).asLong().longValue(),db.timeZone(BaseTimeZone.Hongkong).asLong()+(28800000l));

        assertEquals(28800000l,DateFactory.raw().timeZone(BaseTimeZone.Etc_GMT_P8).asLong().longValue());
        assertEquals(0l,DateFactory.raw().timeZone(BaseTimeZone.GMT).asLong().longValue());
        assertEquals(0l,DateFactory.raw().timeZone(BaseTimeZone.UTC).asLong().longValue());
        assertEquals(0l,DateFactory.raw().timeZone(BaseTimeZone.Greenwich).asLong().longValue());
        assertEquals(-28800000l,DateFactory.raw().timeZone(BaseTimeZone.Etc_GMT_M8).asLong().longValue());
        assertEquals(-28800000l,DateFactory.raw().timeZone(BaseTimeZone.Hongkong).asLong().longValue());
        assertEquals(-28800000l,DateFactory.raw().timeZone(BaseTimeZone.Asia_Hong_Kong).asLong().longValue());
        assertEquals(-28800000l,DateFactory.raw().timeZone(BaseTimeZone.Asia_Taipei).asLong().longValue());
        assertEquals(-28800000l,DateFactory.raw().timeZone(BaseTimeZone.Asia_Shanghai).asLong().longValue());
        //Singapore changed timezone from 1982-01-01 from +07:00 to +08:00
        assertEquals(-27000000l,DateFactory.raw().timeZone(BaseTimeZone.Singapore).asLong().longValue());
        assertEquals(-27000000l,DateFactory.raw().timeZone(BaseTimeZone.Asia_Singapore).asLong().longValue());
        assertEquals(-32400000l,DateFactory.raw().timeZone(BaseTimeZone.Asia_Seoul).asLong().longValue());
        assertEquals(-32400000l,DateFactory.raw().timeZone(BaseTimeZone.Japan).asLong().longValue());

        //Test dateformat
        DateBuilder t2 = DateFactory.raw().ymd(2018, Month.JAN, 01).hmsms(13, 21, 33, 789);
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


        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Etc_GMT_P8.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.UTC.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.GMT.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Greenwich.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Etc_GMT_M8.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Hongkong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Hong_Kong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Shanghai.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Taipei.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 21:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 22:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Asia_Seoul.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 22:21:33.789", t2.timeZone(BaseTimeZone.UTC).format(BaseTimeZone.Japan.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));

        assertEquals("2017-12-31 21:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Etc_GMT_P8.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.UTC.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.GMT.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 05:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Greenwich.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Etc_GMT_M8.timeZone(),DateFormatBuilder.FULL_DATETIME()));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Hongkong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Hong_Kong.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Shanghai.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Taipei.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 13:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Singapore.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 14:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Asia_Seoul.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));
        assertEquals("2018-01-01 14:21:33.789", t2.timeZone(BaseTimeZone.Hongkong).format(BaseTimeZone.Japan.timeZone(),DateFormatBuilder.Format.FULL_DATETIME));

    }


}