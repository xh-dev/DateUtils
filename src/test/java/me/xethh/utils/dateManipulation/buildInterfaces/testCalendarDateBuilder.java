package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.v6.date.TestCalendarDateBuilder;
import org.junit.Test;

public class testCalendarDateBuilder {
    @Test
    public void testDateBuilderImpl() {
        DateBuilderImpl db = new DateBuilderImpl();
        TestCalendarDateBuilder.test(db);
    }
    @Test
    public void testDatetimeBuilderImpl() {
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone());
        TestCalendarDateBuilder.test(db);
    }
    @Test
    public void testDatetimeRange() {
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone());
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestCalendarDateBuilder.test(range.editStart());
        TestCalendarDateBuilder.test(range.editEnd());
    }
}
