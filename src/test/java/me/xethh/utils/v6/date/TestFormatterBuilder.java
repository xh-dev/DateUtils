package me.xethh.utils.v6.date;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.buildInterfaces.CalendarDateBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.CommonDateRepresentation;
import me.xethh.utils.dateManipulation.buildInterfaces.FormatterBuilder;
import me.xethh.utils.dateManipulation.buildInterfaces.TimeUnitConverter;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;

import java.text.SimpleDateFormat;

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
