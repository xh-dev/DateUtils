package me.xethh.utils.v6.date;

import me.xethh.utils.dateUtils.baseInterface.CalendarDateBuilder;
import me.xethh.utils.dateUtils.baseInterface.CommonDateRepresentation;
import me.xethh.utils.dateUtils.baseInterface.TimeUnitConverter;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestFormatterBuilder {
    public static <T extends TimeUnitConverter & CalendarDateBuilder<T> & CommonDateRepresentation> void test(T db) {
        TimeUnit unit;
        unit = db.diffFrom(db.addDays(1).asDate());
        assertEquals(-1, unit.numberOfDays());
        unit = db.diffFrom(db.addDays(1).asLong());
        assertEquals(-1, unit.numberOfDays());
        unit = db.diffFrom(db.addDays(1).asCalendar());
        assertEquals(-1, unit.numberOfDays());

        unit = db.diffTo(db.addDays(1).asDate());
        assertEquals(1, unit.numberOfDays());
        unit = db.diffTo(db.addDays(1).asLong());
        assertEquals(1, unit.numberOfDays());
        unit = db.diffTo(db.addDays(1).asCalendar());
        assertEquals(1, unit.numberOfDays());
    }
}
