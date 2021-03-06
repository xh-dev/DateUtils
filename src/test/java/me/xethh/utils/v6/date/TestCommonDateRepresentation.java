package me.xethh.utils.v6.date;

import me.xethh.utils.dateUtils.baseInterface.CommonDateRepresentation;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TestCommonDateRepresentation {
    public static <T extends CommonDateRepresentation> void test(T db, Date d) {

        try {
            assertTrue(db.asDate().getTime() == d.getTime());
            assertTrue(db.asCalendar().getTimeInMillis() == d.getTime());
            assertTrue(db.asLong() == d.getTime());
            assertTrue(db.asSqlDate().getTime() == d.getTime());
            assertTrue(db.asSqlTime().getTime() == d.getTime());
            assertTrue(db.asSqlTimestamp().getTime() == d.getTime());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
