package me.xethh.utils.v6.range;

import me.xethh.utils.dateManipulation.date.DateFactory;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.v6.date.TestCalendarDateBuilder;
import me.xethh.utils.v6.date.TestCommonDateRepresentation;
import me.xethh.utils.v6.date.TestFormatBuilder;
import me.xethh.utils.v6.date.TestTimeUnitConverter;
import me.xethh.utils.v6.datetime.TestCalendarTimeBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.JUN;
import static me.xethh.utils.dateManipulation.Month.MAY;

public class DatetimeRange_DatetimeBuilderTest {
    @Test
    public void testFormatterBuilder() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestFormatBuilder.test(range.editStart());
        TestFormatBuilder.test(range.editEnd());
    }

    @Test
    public void testTimeUnitConverter() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestTimeUnitConverter.test(range.editStart());
        TestTimeUnitConverter.test(range.editEnd());
    }

    @Test
    public void testCommonDateRepresentation() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 2);
        cal.set(Calendar.SECOND, 3);
        cal.set(Calendar.MILLISECOND, 4);
        Date d = cal.getTime();
        TestCommonDateRepresentation.test(range.editStart(),d);
        TestCommonDateRepresentation.test(range.editEnd(),d);
    }

    @Test
    public void testCalendarDateBuilder() {
        DatetimeBuilderImpl db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone());
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestCalendarDateBuilder.test(range.editStart());
        TestCalendarDateBuilder.test(range.editEnd());
    }

    @Test
    public void testCalendarTimeBuilder(){
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2021, JUN, 22).hmsms(7,8,9,10);
        DatetimeRange range = DatetimeFactory.rangeOf(db.asDate(), db.asDate());
        TestCalendarTimeBuilder.test(range.editStart());
        TestCalendarTimeBuilder.test(range.editEnd());
    }
}
