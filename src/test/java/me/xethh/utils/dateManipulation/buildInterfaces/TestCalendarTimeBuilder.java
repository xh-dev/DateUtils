package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.JUN;

public class TestCalendarTimeBuilder {
    @Test
    public void testDatetimeBuilder(){
        DatetimeBuilder builder = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7,8,9,10);
        Date d2 = builder.now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(builder);
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);
    }
    @Test
    public void testDatetimeRange(){
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7,8,9,10);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(range.editStart());
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(range.editEnd());

        Date d2 = range.editStart().now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);

        d2 = range.editEnd().now().asDate();
        d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d,d2);
    }
}
