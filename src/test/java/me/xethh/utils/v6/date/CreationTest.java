package me.xethh.utils.v6.date;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;
import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CreationTest {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }

    @Test
    public void createDatetimeFactoryTest() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df = DateFactory.instance();
        assertEquals(BaseTimeZone.Asia_Hong_Kong.timeZone(), df.getTimezone());
        TimeZone.setDefault(BaseTimeZone.Asia_Seoul.timeZone());
        df = DateFactory.instance();
        assertEquals(BaseTimeZone.Asia_Seoul.timeZone(), df.getTimezone());
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df2 = DateFactory.instance();
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromBaseTimeZone() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df2 = DateFactory.instance(BaseTimeZone.Asia_Hong_Kong);
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromTimeZone() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df2 = DateFactory.instance(BaseTimeZone.Asia_Hong_Kong.timeZone());
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }


}
