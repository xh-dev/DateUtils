package me.xethh.utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateBuilder {
    private List<Build> builds=new ArrayList();
    private Calendar cal;
    private DateBuilder(final Date date){
        cal=Calendar.getInstance();
        builds.add(new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.setTime(date);
                return this;
            }
        });
    }
    private DateBuilder(List<Build> builds){
        cal=Calendar.getInstance();
        this.builds.add(new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                cal.set(Calendar.MONTH,0);
                cal.set(Calendar.DAY_OF_MONTH,1);
                cal.set(Calendar.HOUR_OF_DAY,0);
                cal.set(Calendar.MINUTE,0);
                cal.set(Calendar.SECOND,0);
                cal.set(Calendar.MILLISECOND,0);
                return this;
            }
        });
        this.builds.addAll(builds);
    }
    private DateBuilder(List<Build> builds, Build build){
        this(builds);
        this.builds.add(build);
    }
    public static DateBuilder get(Date date){
        return new DateBuilder(date);
    }
    public static DateBuilder get(){
        return new DateBuilder(new ArrayList());
    }
    public static DateBuilder get(List<Build> builds){
        return new DateBuilder(builds);
    }
    public static DateBuilder get(List<Build> builds,Build build){
        return new DateBuilder(builds,build);
    }
    public interface Build{
        Build apply(Calendar cal);
    }
    public DateBuilder minYear(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return this;
            }
        });
    }
    public DateBuilder year(final int year){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,year);
                return this;
            }
        });
    }

    public DateBuilder minMonth(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MONTH,0);
                return this;
            }
        });
    }
    /**
     * Set the month
     * @param month should be normally 1,2,...12 where 1=JAN, 2=FEB....
     * @return
     */
    public DateBuilder month(final int month){
        if(month<1 || month>12)
            throw new RuntimeException("Only acception 1-12 as month value");
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MONTH,month-1);
                return this;
            }
        });
    }

    public DateBuilder minDate(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return this;
            }
        });
    }
    public DateBuilder date(final int date){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return this;
            }
        });
    }
    public DateBuilder minHour(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return this;
            }
        });
    }
    public DateBuilder maxHour(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return this;
            }
        });
    }
    public DateBuilder hour(final int hour){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,hour);
                return this;
            }
        });
    }
    public DateBuilder minMinutes(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return this;
            }
        });
    }
    public DateBuilder maxMinutes(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return this;
            }
        });
    }
    public DateBuilder minutes(final int min){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,min);
                return this;
            }
        });
    }
    public DateBuilder minSecond(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return this;
            }
        });
    }
    public DateBuilder maxSecond(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return this;
            }
        });
    }
    public DateBuilder second(final int second){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,second);
                return this;
            }
        });
    }
    public DateBuilder minMS(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return this;
            }
        });
    }
    public DateBuilder maxMS(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return this;
            }
        });
    }
    public DateBuilder ms(final int ms){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return this;
            }
        });
    }

    public DateBuilder maxDayTime(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                cal.set(Calendar.MINUTE,59);
                cal.set(Calendar.SECOND,59);
                cal.set(Calendar.MILLISECOND,999);
                return this;
            }
        });
    }

    public DateBuilder minDayTime(){
        return DateBuilder.get(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                cal.set(Calendar.MINUTE,0);
                cal.set(Calendar.SECOND,0);
                cal.set(Calendar.MILLISECOND,0);
                return this;
            }
        });
    }

    public Date build(){
        for(Build build: builds)
            build.apply(cal);
        return cal.getTime();
    }
    public Calendar getCal(){
        return this.cal;
    }

}
