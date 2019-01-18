package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateFactory;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilderImpl;
import me.xethh.utils.rangeManipulation.AcceptingFilter;
import me.xethh.utils.rangeManipulation.DatetimeRange;
import me.xethh.utils.rangeManipulation.OverlapType;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author xethhung
 * Created on 8/30/2018
 */
public class RangeFilterTest {
    @Test
    public void testAcceptingFilter(){
        DatetimeBuilderImpl db1 = DateFactory.now();

        // 0 to 2
        DatetimeRange dbSame = db1.rangeTo(db1.addDays(2));
        // 0.1 to 1.1
        DatetimeRange dbCovering = db1.addHours(1).rangeTo(db1.addDays(1).addHours(1));
        // -0.1 to 3.1
        DatetimeRange dbCovered = db1.addHours(-1).rangeTo(db1.addDays(3).addHours(1));
        // 1 to 2
        DatetimeRange coveringOnRight = db1.addDays(1).rangeTo(db1.addDays(2));
        // -1 to 2
        DatetimeRange coveredOnRight = db1.addDays(-1).rangeTo(db1.addDays(2));
        // 1 to 3
        DatetimeRange overlapOnRight = db1.addDays(1).rangeTo(db1.addDays(3));
        // 1 to 2
        DatetimeRange coveringOnLeft = db1.rangeTo(db1.addDays(1));
        // -1 to 2
        DatetimeRange coveredOnLeft = db1.rangeTo(db1.addDays(3));
        // 1 to 3
        DatetimeRange overlapOnLeft = db1.addDays(-1).rangeTo(db1.addDays(1));
        // -1 to 0
        DatetimeRange joinOnLeft = db1.addDays(-1).rangeTo(db1);
        // 2 to 3
        DatetimeRange joinOnRight = db1.addDays(2).rangeTo(db1.addDays(3));
        // 2.1 to 3
        DatetimeRange comeFirst = db1.addDays(2).addHours(1).rangeTo(db1.addDays(3));
        // -1 to -0.1
        DatetimeRange comeLater = db1.addDays(-1).rangeTo(db1.addHours(-1));
        // 0 to 2
        AcceptingFilter acceptingFilter = db1.rangeTo(db1.addDays(2)).accepting();
        assertEquals(true,acceptingFilter.item(OverlapType.Same).isAccepted(dbSame));
        assertEquals(true,acceptingFilter.item(OverlapType.Same).isRejected(dbCovering));

        assertEquals(true,acceptingFilter
                .item(OverlapType.Same)
                .item(OverlapType.Covering)
                .isAccepted(dbCovering));

        assertEquals(true,acceptingFilter
                .items(new OverlapType[]{OverlapType.Same,OverlapType.Covering})
                .isAccepted(dbCovering));

        assertEquals(true,acceptingFilter
                .items(Arrays.asList(new OverlapType[]{OverlapType.Same,OverlapType.Covering}))
                .isAccepted(dbCovering));

        assertEquals(false,acceptingFilter
                .item(OverlapType.Same)
                .item(OverlapType.Covering)
                .isRejected(dbCovering));

        assertEquals(true,acceptingFilter
                .item(OverlapType.ComesLater)
                .item(OverlapType.ComesFirst)
                .isRejected(dbCovering));

        assertEquals(true,acceptingFilter
                .item(OverlapType.Covering)
                .isAccepted(dbCovering));

        assertEquals(true,acceptingFilter
                .item(OverlapType.CoveredBy)
                .isAccepted(dbCovered));

        assertEquals(true,acceptingFilter
                .item(OverlapType.CoveringOnRight)
                .isAccepted(coveringOnRight));

        assertEquals(true,acceptingFilter
                .item(OverlapType.CoveredOnRight)
                .isAccepted(coveredOnRight));

        assertEquals(true,acceptingFilter
                .item(OverlapType.OverLapOnRight)
                .isAccepted(overlapOnRight));

        assertEquals(true,acceptingFilter
                .item(OverlapType.CoveringOnLeft)
                .isAccepted(coveringOnLeft));

        assertEquals(true,acceptingFilter
                .item(OverlapType.CoveredOnLeft)
                .isAccepted(coveredOnLeft));

        assertEquals(true,acceptingFilter
                .item(OverlapType.OverlapOnLeft)
                .isAccepted(overlapOnLeft));

        assertEquals(true,acceptingFilter
                .item(OverlapType.JoinOnLeft)
                .isAccepted(joinOnLeft));

        assertEquals(true,acceptingFilter
                .item(OverlapType.JoinOnRight)
                .isAccepted(joinOnRight));

        assertEquals(true,acceptingFilter
                .item(OverlapType.ComesFirst)
                .isAccepted(comeFirst));

        assertEquals(true,acceptingFilter
                .item(OverlapType.ComesLater)
                .isAccepted(comeLater));

        assertEquals(true,db1.rangeTo(db1.addDays(1)).swrap().accepting()
                .item(OverlapType.Invalid)
                .isAccepted(null));
        assertEquals(true,db1.rangeTo(db1.addDays(1)).accepting()
                .item(OverlapType.TargetIsNull)
                .isAccepted(null));
        assertEquals(true,db1.rangeTo(db1.addDays(1)).accepting()
                .item(OverlapType.TargetInvalid)
                .isAccepted(comeLater.swrap()));
    }

    @Test
    public void testRejectingFilter(){
        DatetimeBuilderImpl db1 = DateFactory.now();

        // 0.1 to 1.1
        DatetimeRange dbCovering = db1.addHours(1).rangeTo(db1.addDays(1).addHours(1));
        // -1 to -0.1
        DatetimeRange comeLater = db1.addDays(-1).rangeTo(db1.addHours(-1));
        assertEquals(true,db1.rangeTo(db1.addDays(2)).rejecting()
                .item(OverlapType.Invalid)
                .item(OverlapType.TargetInvalid)
                .item(OverlapType.TargetIsNull)
                .isAccepted(dbCovering));

        assertEquals(true,db1.rangeTo(db1.addDays(2)).swrap().rejecting()
                .item(OverlapType.Invalid)
                .isRejected(null));
        assertEquals(true,db1.rangeTo(db1.addDays(1)).rejecting()
                .item(OverlapType.TargetIsNull)
                .isRejected(null));
        assertEquals(true,db1.rangeTo(db1.addDays(1)).rejecting()
                .item(OverlapType.TargetInvalid)
                .isRejected(comeLater.swrap()));
    }
}
