package me.xethh.utils.v6.datetime;

import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import org.junit.Test;

import java.sql.Time;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CreationTest {

    @Test
    public void equaltyOfTimezone(){
        TimeZone tz1 = TimeZone.getTimeZone("Asia/Hong_Kong");
        TimeZone tz2 = TimeZone.getTimeZone("Asia/Hong_Kong");
        assertEquals(tz1,tz2);
    }
    @Test
    public void createDatetimeFactoryTest(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df = DatetimeFactory.instance();
        assertEquals(BaseTimeZone.Asia_Hong_Kong.timeZone(),df.getTimeZone());
        TimeZone.setDefault(BaseTimeZone.Asia_Seoul.timeZone());
        df = DatetimeFactory.instance();
        assertEquals(BaseTimeZone.Asia_Seoul.timeZone(),df.getTimeZone());
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df2 = DatetimeFactory.instance();
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromBaseTimeZone(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df2 = DatetimeFactory.instance(BaseTimeZone.Asia_Hong_Kong);
        assertEquals(df1,df2);
        TimeZone.setDefault(defaultTimezone);
    }
    @Test
    public void createDatetimeFactoryFromTimeZone(){
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df2 = DatetimeFactory.instance(BaseTimeZone.Asia_Hong_Kong.timeZone());
        assertEquals(df1,df2);
        TimeZone.setDefault(defaultTimezone);
    }


}
