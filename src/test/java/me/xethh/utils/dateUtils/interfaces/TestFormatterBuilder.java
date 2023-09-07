package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;
import org.junit.Test;

import static me.xethh.utils.dateUtils.month.Month.MAY;

public class TestFormatterBuilder {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilder db = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        me.xethh.utils.v6.date.TestFormatterBuilder.test(db);
    }

    @Test
    public void testDateBuilder() {
        DateBuilder db = new DateBuilder().ymd(2020, MAY, 12);
        me.xethh.utils.v6.date.TestFormatterBuilder.test(db);
    }

    @Test
    public void testDatetimeRange() {
        DatetimeBuilder db = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        me.xethh.utils.v6.date.TestFormatterBuilder.test(range.editStart());
        me.xethh.utils.v6.date.TestFormatterBuilder.test(range.editEnd());
    }
}
