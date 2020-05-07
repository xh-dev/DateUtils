package me.xethh.utils.v6.date;

import me.xethh.utils.dateUtils.timeUnit.TimeUnit;
import me.xethh.utils.dateUtils.interfaces.CalendarDateBuilder;
import me.xethh.utils.dateUtils.interfaces.CommonDateRepresentation;
import me.xethh.utils.dateUtils.interfaces.TimeUnitConverter;

import static org.junit.Assert.assertEquals;

public class TestFormatterBuilder {
    public static <T extends TimeUnitConverter & CalendarDateBuilder<T> & CommonDateRepresentation> void test(T db){
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
