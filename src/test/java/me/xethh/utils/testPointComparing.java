package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.rangeManipulation.DateRange;
import me.xethh.utils.rangeManipulation.PointComparing;
import me.xethh.utils.wrapper.Optional;
import me.xethh.utils.wrapper.Tuple2;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for simple App.
 */
public class testPointComparing
{
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Test
    public void testPointComparing(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        Date testDate = builder.operate().addDays(3).asDate();
        PointComparing comparing = DateRange.of(builder.build(), builder.operate().addDays(10).asDate()).compareToPoint();
        assertEquals(true,comparing.onRange(testDate));
        assertEquals(false,comparing.onSide(testDate));
        assertEquals(false,comparing.onStartingPoint(testDate));
        assertEquals(false,comparing.onEndPoint(testDate));

        comparing = DateRange.of(builder.build(), builder.operate().addDays(10).asDate()).compareToPoint();
        testDate = builder.build();
        assertEquals(true,comparing.onRange(testDate));
        assertEquals(true,comparing.onSide(testDate));
        assertEquals(true,comparing.onStartingPoint(testDate));
        assertEquals(false,comparing.onEndPoint(testDate));

        comparing = DateRange.of(builder.build(), builder.operate().addDays(10).asDate()).compareToPoint();
        testDate = builder.operate().addDays(10).asDate();
        assertEquals(true,comparing.onRange(testDate));
        assertEquals(true,comparing.onSide(testDate));
        assertEquals(false,comparing.onStartingPoint(testDate));
        assertEquals(true,comparing.onEndPoint(testDate));

        comparing = DateRange.of(builder.build(), builder.operate().addDays(10).asDate()).compareToPoint();
        testDate = builder.operate().addDays(10).addMins(1).asDate();
        assertEquals(false,comparing.onRange(testDate));
        assertEquals(false,comparing.onSide(testDate));
        assertEquals(false,comparing.onStartingPoint(testDate));
        assertEquals(false,comparing.onEndPoint(testDate));
    }

    @Test
    public void testPointSplit(){
        DateBuilder builder = DateBuilder.now().year(2018).month(Month.JAN).day(18).minDayTime();
        PointComparing comparing = DateRange.of(builder.build(), builder.operate().addDays(10).asDate()).compareToPoint();
        Date testDate = builder.operate().addDays(3).asDate();
        Tuple2<Optional<DateRange>, Optional<DateRange>> rs = comparing.split(testDate);
        assertEquals(true,rs.getV1().isPresent());
        assertEquals(true,rs.getV2().isPresent());
        assertEquals(DateRange.of(comparing.getRange().getStart(),testDate),rs.getV1().get());
        assertEquals(DateRange.of(testDate,comparing.getRange().getEnd()),rs.getV2().get());

        testDate = builder.build();
        rs = comparing.split(testDate);
        assertEquals(false,rs.getV1().isPresent());
        assertEquals(true,rs.getV2().isPresent());
        assertNull(rs.getV1().get());
        assertEquals(DateRange.of(testDate,comparing.getRange().getEnd()),rs.getV2().get());

        testDate = builder.operate().addDays(10).asDate();
        rs = comparing.split(testDate);
        assertEquals(true,rs.getV1().isPresent());
        assertEquals(false,rs.getV2().isPresent());
        assertEquals(comparing.getRange(),rs.getV1().get());
        assertNull(rs.getV2().get());

        testDate = builder.operate().addDays(400).asDate();
        rs = comparing.split(testDate);
        assertEquals(false,rs.getV1().isPresent());
        assertEquals(false,rs.getV2().isPresent());
        assertNull(rs.getV1().get());
        assertNull(rs.getV2().get());
    }
}
