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
    public static <T extends CommonDateRepresentation> void test(T db, Date d){

        assertTrue(db.asDate().getTime() == d.getTime());
        assertTrue(db.asCalendar().getTimeInMillis() == d.getTime());
        assertTrue(db.asLong() == d.getTime());
        assertTrue(db.asSqlDate().getTime() == d.getTime());
        assertTrue(db.asSqlTime().getTime() == d.getTime());
        assertTrue(db.asSqlTimestamp().getTime() == d.getTime());
    }
}
