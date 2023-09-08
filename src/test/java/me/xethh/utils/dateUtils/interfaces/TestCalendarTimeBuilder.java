package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static me.xethh.utils.dateUtils.month.Month.JUN;

public class TestCalendarTimeBuilder {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilder builder = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7, 8, 9, 10);
        Date d2 = builder.now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(builder);
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d, d2);
    }

    @Test
    public void testDatetimeRange() {
        DatetimeBuilder db = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7, 8, 9, 10);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(range.editStart());
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.test(range.editEnd());

        Date d2 = range.editStart().now().asDate();
        Date d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d, d2);

        d2 = range.editEnd().now().ms(0).asDate();
        d = new Date();
        me.xethh.utils.v6.datetime.TestCalendarTimeBuilder.testNow(d, d2);
    }
}
