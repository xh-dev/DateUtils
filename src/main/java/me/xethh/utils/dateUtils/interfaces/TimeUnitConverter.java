package me.xethh.utils.dateUtils.interfaces;

import me.xethh.utils.dateUtils.timeUnit.TimeUnit;

import java.util.Calendar;
import java.util.Date;

public interface TimeUnitConverter {
    TimeUnit diffFrom(Date date);
    TimeUnit diffTo(Date date);
    TimeUnit diffFrom(long date);
    TimeUnit diffTo(long date);
    TimeUnit diffFrom(Calendar date);
    TimeUnit diffTo(Calendar date);
}
