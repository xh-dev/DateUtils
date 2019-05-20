package me.xethh.utils.v6.date;

import me.xethh.utils.dateManipulation.date.DateFactory;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import org.junit.Test;

import java.sql.Time;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CreationTest {

    @Test
    public void createDatetimeFactoryTest(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df = DateFactory.instance();
        assertEquals(BaseTimeZone.Asia_Hong_Kong.timeZone(),df.getTimeZone());
        TimeZone.setDefault(BaseTimeZone.Asia_Seoul.timeZone());
        df = DateFactory.instance();
        assertEquals(BaseTimeZone.Asia_Seoul.timeZone(),df.getTimeZone());
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df2 = DateFactory.instance();
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromBaseTimeZone(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df2 = DateFactory.instance(BaseTimeZone.Asia_Hong_Kong);
        assertEquals(df1,df2);
        TimeZone.setDefault(defaultTimezone);
    }
    @Test
    public void createDatetimeFactoryFromTimeZone(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DateFactory df1 = DateFactory.instance();
        DateFactory df2 = DateFactory.instance(BaseTimeZone.Asia_Hong_Kong.timeZone());
        assertEquals(df1,df2);
        TimeZone.setDefault(defaultTimezone);
    }


}
