package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.v6.datetime.TestCalendarTimeBuilder;
import org.junit.Test;

import static me.xethh.utils.dateManipulation.Month.JUN;

public class testCalendarTimeBuilder {
    @Test
    public void testDatetimeBuilder(){
        DatetimeBuilder builder = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7,8,9,10);
        TestCalendarTimeBuilder.test(builder);
    }
    @Test
    public void testDatetimeRange(){
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7,8,9,10);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestCalendarTimeBuilder.test(range.editStart());
        TestCalendarTimeBuilder.test(range.editEnd());
    }
}
