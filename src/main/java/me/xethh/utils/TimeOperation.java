package me.xethh.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeOperation {
    private DateBuilder dateBuilder;

    private TimeOperation(DateBuilder dateBuilder){
        this.dateBuilder = dateBuilder;
    }

    public static TimeOperation get(){
        return new TimeOperation(DateBuilder.get());
    }
    public static TimeOperation get(Date date){
        return new TimeOperation(DateBuilder.get(date));
    }
    public static TimeOperation get(DateBuilder builder){
        return new TimeOperation(builder);
    }

    public DateBuilder builder(){
        return dateBuilder;
    }

    public TimeOperation addYear(final int years){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return this;
            }
        }));
    }

    public TimeOperation addMonths(final int months){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return this;
            }
        }));
    }

    public TimeOperation addDays(final int days){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return this;
            }
        }));
    }

    public TimeOperation addHours(final int hours){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return this;
            }
        }));
    }

    public TimeOperation addMins(final int mins){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return this;
            }
        }));
    }

    public TimeOperation addSecond(final int sec){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return this;
            }
        }));
    }

    public TimeOperation addMS(final int ms){
        return new TimeOperation(DateBuilder.get(dateBuilder.getBuilds(),new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return this;
            }
        }));
    }
}
