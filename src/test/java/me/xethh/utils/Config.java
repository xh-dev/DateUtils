package me.xethh.utils;

import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import org.junit.Before;

import java.util.TimeZone;

public class Config {
    public static void CentralizeTimeZone() {
        TimeZone.setDefault(BaseTimeZone.Hongkong.timeZone());
    }
}
