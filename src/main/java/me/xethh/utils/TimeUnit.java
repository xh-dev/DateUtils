package me.xethh.utils;

import me.xethh.utils.dateManipulation.DateBuilder;
import me.xethh.utils.dateManipulation.DateBuilderFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xethhung
 * @date 8/3/2018
 */
public class TimeUnit {
    private long date;

    protected TimeUnit(long date){
        this.date = date;
    }

    public static TimeUnit from(Date date){
        return from(date.getTime());
    }
    public static TimeUnit from(long date){
        return new TimeUnit(date);
    }

    public Date asDate(){
        return new Date(date);
    }
    public long asLong(){
        return date;
    }

    public DateBuilder asBuilder(){
        return DateBuilderFactory.from(date);
    }

    public Calendar asCalendar(){
        Calendar d =Calendar.getInstance();
        d.setTimeInMillis(date);
        return d;
    }

    private static long MS_BASE=1000;
    private static long SECOND_BASE=60;
    private static long MIN_BASE=60;
    private static long HOUR_BASE=24;


    public long numberOfDays(){
        return numberOfDays(date);
    }
    public long numberOfHour(){
        return numberOfHour(date);
    }
    public long numberOfMin(){
        return numberOfMin(date);
    }
    public long numberOfSecond(){
        return numberOfSecond(date);
    }
    public long numberOfMS(){
        return date;
    }

    public static long numberOfDays(long date){
        return date/(MS_BASE*SECOND_BASE*MIN_BASE*HOUR_BASE);
    }
    public long numberOfHour(long date){
        return date/(MS_BASE*SECOND_BASE*MIN_BASE);
    }
    public long numberOfMin(long date){
        return date/(MS_BASE*SECOND_BASE);
    }
    public long numberOfSecond(long date){
        return date/(MS_BASE);
    }

    public static long eliminateDays(long date){
        return date%(MS_BASE*SECOND_BASE*MIN_BASE*HOUR_BASE);
    }
    public long eliminateHours(long date){
        return eliminateDays(date)%(MS_BASE*SECOND_BASE*MIN_BASE);
    }
    public long eliminateMin(long date){
        return eliminateHours(date)%(MS_BASE*SECOND_BASE);
    }
    public long eliminateSecond(long date){
        return eliminateMin(date)%(MS_BASE*SECOND_BASE);
    }
    public long eliminateMS(long date){
        return date%MS_BASE;
    }

    public long hoursOnly(long date){
        return numberOfHour(eliminateDays(date));
    }
    public long minOnly(long date){
        return numberOfMin(eliminateHours(date));
    }
    public long secOnly(long date){
        return numberOfSecond(eliminateMin(date));
    }
    public long msOnly(long date){
        return eliminateSecond(date);
    }

    public long hoursOnly(){
        return hoursOnly(date);
    }
    public long minOnly(){
        return minOnly(date);
    }
    public long secOnly(){
        return secOnly(date);
    }
    public long msOnly(){
        return msOnly(date);
    }
}
