package me.xethh.utils.v6.date;

import me.xethh.utils.Config;
import me.xethh.utils.dateUtils.baseInterface.CommonDateRepresentation;
import me.xethh.utils.dateUtils.baseInterface.FormatterBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class TestTimeUnitConverter {
    @Before
    public void setup() {
        Config.CentralizeTimeZone();
    }
    public static <T extends FormatterBuilder & CommonDateRepresentation> void test(T db) {
        SimpleDateFormat sdf = DateFormatBuilderFactory.ISO8601();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        assertEquals(sdf.format(db.asDate()), db.format("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        assertEquals(sdf.format(db.asDate()), db.format(DateFormatBuilderInterface.Format.ISO8601));
        assertEquals(sdf1.format(db.asDate()), db.format(DateFormatBuilderFactory.get()
                        .year4Digit().hyphen().month2Digit().hyphen().day2Digit()
                        .space()
                        .hourInDay24().colon().minute().colon().second().dot().ms()
                )
        );
        assertEquals(sdf.format(db.asDate()), db.format(sdf));
        assertEquals(sdf1.format(db.asDate()), db.format()
                .year4Digit().hyphen().month2Digit().hyphen().day2Digit()
                .space()
                .hourInDay24().colon().minute().colon().second().dot().ms().format()
        );


        assertEquals(sdf.format(db.asDate()), db.format(BaseTimeZone.UTC.timeZone(), "yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        assertEquals(sdf.format(db.asDate()), db.format(BaseTimeZone.UTC.timeZone(), DateFormatBuilderInterface.Format.ISO8601));
        assertEquals(sdf1.format(db.asDate()), db.format(BaseTimeZone.UTC.timeZone(), db.format(DateFormatBuilderFactory.get()
                .year4Digit().hyphen().month2Digit().hyphen().day2Digit()
                .space()
                .hourInDay24().colon().minute().colon().second().dot().ms()
        )));
        assertEquals(sdf.format(db.asDate()), db.format(BaseTimeZone.UTC.timeZone(), sdf));
    }
}
