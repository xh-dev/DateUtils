package me.xethh.utils.datetimeFactory;

import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;

import java.util.Calendar;
import java.util.Date;

public interface DatetimeBuilderGenerator {
    DatetimeBuilder from(Date date);

    DatetimeBuilder from(Date date, Build build);

    DatetimeBuilder raw();

    DatetimeBuilder now();

    DatetimeBuilder from(Calendar cal);

    DatetimeBuilder from(Calendar cal, Build build);

    DatetimeBuilder from(Long longDate, Build build);

    default DatetimeBuilder from(Long longDate){
        return from(new Date(longDate));
    }

    DatetimeBuilder from(DatetimeBuilder db);

    DatetimeBuilder from(DateBuilder db);
}
