package me.xethh.utils.v6.date;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.buildInterfaces.CalendarDateBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.CommonDateRepresentation;
import me.xethh.utils.dateManipulation.buildInterfaces.TimeUnitConverter;

import java.util.Calendar;
import java.util.Date;

import static me.xethh.utils.dateManipulation.Month.MAY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCommonDateRepresentation {
    public static <T extends CommonDateRepresentation> void test(T db){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, MAY.toJavaCalNumber());
        cal.set(Calendar.DAY_OF_MONTH, 12);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d = cal.getTime();

        assertTrue(db.asDate().getTime() == d.getTime());
        assertTrue(db.asCalendar().getTimeInMillis() == d.getTime());
        assertTrue(db.asLong() == d.getTime());
        assertTrue(db.asSqlDate().getTime() == d.getTime());
        assertTrue(db.asSqlTime().getTime() == d.getTime());
        assertTrue(db.asSqlTimestamp().getTime() == d.getTime());
    }
}
