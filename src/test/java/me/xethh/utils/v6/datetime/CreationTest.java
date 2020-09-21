package me.xethh.utils.v6.datetime;

import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CreationTest {

    @Test
    public void equaltyOfTimezone() {
        TimeZone tz1 = TimeZone.getTimeZone("Asia/Hong_Kong");
        TimeZone tz2 = TimeZone.getTimeZone("Asia/Hong_Kong");
        assertEquals(tz1, tz2);
    }

    @Test
    public void createDatetimeFactoryTest() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df = DatetimeFactory.instance();
        assertEquals(BaseTimeZone.Asia_Hong_Kong.timeZone(), df.getTimezone());
        TimeZone.setDefault(BaseTimeZone.Asia_Seoul.timeZone());
        df = DatetimeFactory.instance();
        assertEquals(BaseTimeZone.Asia_Seoul.timeZone(), df.getTimezone());
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df2 = DatetimeFactory.instance();
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromBaseTimeZone() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df2 = DatetimeFactory.instance(BaseTimeZone.Asia_Hong_Kong);
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeFactoryFromTimeZone() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        DatetimeFactory df1 = DatetimeFactory.instance();
        DatetimeFactory df2 = DatetimeFactory.instance(BaseTimeZone.Asia_Hong_Kong.timeZone());
        assertEquals(df1, df2);
        TimeZone.setDefault(defaultTimezone);
    }

    @Test
    public void createDatetimeBuilder() {
        TimeZone defaultTimezone = TimeZone.getDefault();
        TimeZone.setDefault(BaseTimeZone.Asia_Hong_Kong.timeZone());
        Date nowDate = new Date();
        DatetimeBuilder db0 = DatetimeFactory.instance().now();
        assertEquals((Long) (nowDate.getTime() / 1000 * 1000), db0.ms(0).asLong());
        Date d = new Date(-1000l * 60 * 60 * 8);
        DatetimeBuilder db1 = DatetimeFactory.instance().raw();
        assertEquals(d, db1.asDate());
        DatetimeBuilderInterface db2 = DatetimeFactory.instance().from(-1000L * 60 * 60 * 8);
        assertEquals(db1, db2);
        DatetimeBuilderInterface db3 = DatetimeFactory.instance().from(d);
        assertEquals(db1, db3);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        DatetimeBuilderInterface db4 = DatetimeFactory.instance().from(cal);
        assertEquals(db1, db4);
        cal = Calendar.getInstance(BaseTimeZone.Japan.timeZone());
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        DatetimeBuilderInterface db5 = DatetimeFactory.instance().from(cal);
        assertEquals(db1, db5);

        DatetimeBuilder db6 = DatetimeFactory.instance().from(db1);
        assertEquals(db1, db6);

        DatetimeBuilderInterface db7 = db1.minDayTime();
        DateBuilderInterface db8 = DateFactory.instance().raw();
        assertEquals(db7.asDate(), db8.asDate());

        TimeZone.setDefault(defaultTimezone);
    }


}
