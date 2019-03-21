package me.xethh.utils.dateManipulation.buildInterfaces;

import me.xethh.utils.TimeUnit;

import java.util.Calendar;
import java.util.Date;

public interface TImeUnitConverter {
    TimeUnit diffFrom(Date date);
    TimeUnit diffTo(Date date);
    TimeUnit diffFrom(long date);
    TimeUnit diffTo(long date);
    TimeUnit diffFrom(Calendar date);
    TimeUnit diffTo(Calendar date);
}
