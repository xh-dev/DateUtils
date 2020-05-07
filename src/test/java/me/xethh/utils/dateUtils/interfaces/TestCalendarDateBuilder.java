package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.date.DateBuilderImpl;
import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class TestCalendarDateBuilder {
    @Test
    public void testDateBuilderImpl() {
        DateBuilderImpl db = new DateBuilderImpl();
        me.xethh.utils.v6.date.TestCalendarDateBuilder.test(db);

        Date d2 = db.now().asDate();
        Date d = new Date();
        Calendar cal = Calendar.getInstance(DateFactory.instance().getTimezone());
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        d = cal.getTime();

        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);
    }
    @Test
    public void testDatetimeBuilderImpl() {
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone());
        me.xethh.utils.v6.date.TestCalendarDateBuilder.test(db);

        Date d2 = db.now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);
    }
    @Test
    public void testDatetimeRange() {
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone());
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        me.xethh.utils.v6.date.TestCalendarDateBuilder.test(range.editStart());
        me.xethh.utils.v6.date.TestCalendarDateBuilder.test(range.editEnd());

        Date d2 = range.editStart().now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);

        d2 = range.editEnd().now().asDate();
        d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);
    }
}
