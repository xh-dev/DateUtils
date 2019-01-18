package me.xethh.utils;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.DatetimeFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xethhung
 * Created on 8/3/2018
 */
public class TimeUnit {
    private long diff;

    protected TimeUnit(long diff){
        this.diff = diff;
    }

    public static TimeUnit timeDiff(Date t1, Date t2){
        return timeDiff(t1.getTime(),t2.getTime());
    }
    public static TimeUnit timeDiff(Long t1, Long t2){
        return new TimeUnit(t2-t1);
    }
    public static TimeUnit from(Date date){
        return timeDiff(date,new Date());
    }
    public static TimeUnit from(long diff){
        return timeDiff(diff,new Date().getTime());
    }
    public static TimeUnit to(Date date){
        return timeDiff(new Date(),date);
    }
    public static TimeUnit to(long diff){
        return timeDiff(new Date().getTime(),diff);
    }

    public Date asDate(){
        return new Date(diff);
    }
    public long asLong(){
        return diff;
    }

    public DatetimeBuilder asBuilder(){
        return DatetimeFactory.from(diff);
    }

    public Calendar asCalendar(){
        Calendar d =Calendar.getInstance(DatetimeFactory.defaultTimezone());
        d.setTimeInMillis(diff);
        return d;
    }

    private static long MS_BASE=1000;
    private static long SECOND_BASE=60;
    private static long MIN_BASE=60;
    private static long HOUR_BASE=24;
    private static long WEEK_BASE=7;


    public long numberOfWeeks(){
        return numberOfWeeks(diff);
    }
    public long remindOfWeeks(){
        return remindOfWeeks(diff);
    }
    public long numberOfDays(){
        return numberOfDays(diff);
    }
    public long numberOfHour(){
        return numberOfHour(diff);
    }
    public long numberOfMin(){
        return numberOfMin(diff);
    }
    public long numberOfSecond(){
        return numberOfSecond(diff);
    }
    public long numberOfMS(){
        return diff;
    }

    public static long numberOfWeeks(long diff){
        return numberOfDays(diff)/WEEK_BASE;
    }
    public static long remindOfWeeks(long diff){
        return numberOfDays(diff)%WEEK_BASE;
    }
    public static long numberOfDays(long diff){
        return diff/(MS_BASE*SECOND_BASE*MIN_BASE*HOUR_BASE);
    }
    public static long numberOfHour(long diff){
        return diff/(MS_BASE*SECOND_BASE*MIN_BASE);
    }
    public static long numberOfMin(long diff){
        return diff/(MS_BASE*SECOND_BASE);
    }
    public static long numberOfSecond(long diff){
        return diff/(MS_BASE);
    }

    public static long eliminateByBase(long diff, long base){
        return diff%base;
    }
    public static long numberByBase(long diff, long base){
        return diff/base;
    }

    public static long eliminateDays(long diff){
        return diff%(MS_BASE*SECOND_BASE*MIN_BASE*HOUR_BASE);
    }
    public static long eliminateHours(long diff){
        return eliminateDays(diff)%(MS_BASE*SECOND_BASE*MIN_BASE);
    }
    public static long eliminateMin(long diff){
        return eliminateHours(diff)%(MS_BASE*SECOND_BASE);
    }
    public static long eliminateSecond(long diff){
        return eliminateMin(diff)%(MS_BASE);
    }

    public static long dayOnly(long diff){
        return numberOfDays(diff);
    }
    public static long hoursOnly(long diff){
        return numberOfHour(eliminateDays(diff));
    }
    public static long minOnly(long diff){
        return numberOfMin(eliminateHours(diff));
    }
    public static long secOnly(long diff){
        return numberOfSecond(eliminateMin(diff));
    }
    public static long msOnly(long diff){
        return eliminateSecond(diff);
    }

    public long dayOnly(){
        return dayOnly(diff);
    }
    public long hoursOnly(){
        return hoursOnly(diff);
    }
    public long minOnly(){
        return minOnly(diff);
    }
    public long secOnly(){
        return secOnly(diff);
    }
    public long msOnly(){
        return msOnly(diff);
    }

    public boolean roundUpDay(){
        return (hoursOnly()>HOUR_BASE/2)?true:false;
    }
    public boolean roundUpHour(){
        return (minOnly()>MIN_BASE/2)?true:false;
    }
    public boolean roundUpMin(){
        return (secOnly()>SECOND_BASE/2)?true:false;
    }
    public boolean roundUpSecond(){
        return (msOnly()>MS_BASE/2)?true:false;
    }
}
