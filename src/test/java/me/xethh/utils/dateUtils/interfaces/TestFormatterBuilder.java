package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.date.DateBuilderImpl;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import org.junit.Test;

import static me.xethh.utils.dateUtils.month.Month.MAY;

public class TestFormatterBuilder {
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        me.xethh.utils.v6.date.TestFormatterBuilder.test(db);
    }

    @Test
    public void testDateBuilder() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        me.xethh.utils.v6.date.TestFormatterBuilder.test(db);
    }

    @Test
    public void testDatetimeRange() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        me.xethh.utils.v6.date.TestFormatterBuilder.test(range.editStart());
        me.xethh.utils.v6.date.TestFormatterBuilder.test(range.editEnd());
    }
}
