package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.date.DateBuilderInterface;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateUtils.month.Month.MAY;

public class TestCommonDateRepresentation {
    @Test
    public void testDatetimeBuilder() {
        DatetimeBuilderInterface db = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.MINUTE, 2);
        cal.set(Calendar.SECOND, 3);
        cal.set(Calendar.MILLISECOND, 4);
        Date d = cal.getTime();
        me.xethh.utils.v6.date.TestCommonDateRepresentation.test(db, d);
    }

    @Test
    public void testDateBuilder() {
        DateBuilderInterface db = new DateBuilder().ymd(2020, MAY, 12);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d = cal.getTime();
        me.xethh.utils.v6.date.TestCommonDateRepresentation.test(db, d);
    }

    @Test
    public void testDatetimeRange() {
        DatetimeBuilderInterface db = new DatetimeBuilder(BaseTimeZone.Hongkong.timeZone()).ymd(2020, MAY, 12).hmsms(1, 2, 3, 4);
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
        me.xethh.utils.v6.date.TestCommonDateRepresentation.test(range.editStart(), d);
        me.xethh.utils.v6.date.TestCommonDateRepresentation.test(range.editEnd(), d);
    }
}
