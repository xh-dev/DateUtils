package me.xethh.utils.v6;

import org.junit.Test;

import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class TimeZoneTest {

    /**
     * This test prove the timezone quality
     */
    @Test
    public void testTimeZone(){
        TimeZone zone1 = TimeZone.getTimeZone("Europe/Copenhagen");
        TimeZone zone2 = TimeZone.getTimeZone("Europe/Copenhagen");
        assertEquals("Assert two timezone from same string",zone1,zone2);
    }
}
