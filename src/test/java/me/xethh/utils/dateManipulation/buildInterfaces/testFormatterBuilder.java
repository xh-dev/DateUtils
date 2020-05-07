package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.v6.date.TestFormatterBuilder;
import org.junit.Test;

import static me.xethh.utils.dateManipulation.Month.MAY;

public class testFormatterBuilder {
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        TestFormatterBuilder.test(db);
    }

    @Test
    public void testDateBuilder() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        TestFormatterBuilder.test(db);
    }

    @Test
    public void testDatetimeRange() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestFormatterBuilder.test(range.editStart());
        TestFormatterBuilder.test(range.editEnd());
    }
}
