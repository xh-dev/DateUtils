package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateBuilderImpl;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;
import me.xethh.utils.v6.date.TestCommonDateRepresentation;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.MAY;

public class testCommonDateRepresentation {
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilder db = new DatetimeBuilderImpl(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1,2,3,4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 2);
        cal.set(Calendar.SECOND, 3);
        cal.set(Calendar.MILLISECOND, 4);
        Date d = cal.getTime();
        TestCommonDateRepresentation.test(db,d);
    }
    @Test
    public void testDateBuilder() {
        DateBuilder db = new DateBuilderImpl().ymd(2020, MAY, 12);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d = cal.getTime();
        TestCommonDateRepresentation.test(db, d);
    }
    @Test
    public void testDatetimeRange() {
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
}
