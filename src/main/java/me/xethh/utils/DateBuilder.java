package me.xethh.utils;
import java.util.*;

public class DateBuilder {
    private List<Build> builds=new ArrayList();
    /*
    Constructors
     */
    private DateBuilder(final Date date){
        builds.add(new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.setTime(date);
                return this;
            }
        });
    }
    private DateBuilder(List<Build> builds){
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

    public static DateBuilder from(Date date){
        return new DateBuilder(date);
    }
    public static DateBuilder raw(){
        return new DateBuilder(new ArrayList());
    }
    public static DateBuilder from(List<Build> builds){
        return new DateBuilder(builds);
    }
    public static DateBuilder from(List<Build> builds, Build build){
        return new DateBuilder(builds,build);
    }
    public static DateBuilder now(){
        return new DateBuilder(new Date());
    }
    public static DateBuilder from(Calendar calendar){
        return from(calendar.getTime());
    }
    public static DateBuilder from(Long longDate){
        return from(new Date(longDate));
    }

    /*
    Generate date
     */
    public interface Build{
        Build apply(Calendar cal);
    }

    /*
    Year part
     */
    public DateBuilder minYear(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return this;
            }
        });
    }
    public DateBuilder year(final int year){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,year);
                return this;
            }
        });
    }

    /*
    Month part
     */
    public DateBuilder minMonth(){
        return DateBuilder.from(builds, new Build() {
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
    public DateBuilder month(final Month month){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MONTH,month.ordinal());
                return this;
            }
        });
    }


    /*
    Day part
     */
    public DateBuilder minDay(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return this;
            }
        });
    }
    public DateBuilder day(final int date){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return this;
            }
        });
    }
    public DateBuilder firstDayOfMonth(){
        return minDay();
    }


    /*
    Hour part
     */
    public DateBuilder minHour(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return this;
            }
        });
    }
    public DateBuilder maxHour(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return this;
            }
        });
    }
    public DateBuilder hour(final int hour){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,hour);
                return this;
            }
        });
    }

    /*
    Minute part
     */
    public DateBuilder minMinute(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return this;
            }
        });
    }
    public DateBuilder maxMinute(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return this;
            }
        });
    }
    public DateBuilder minute(final int min){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,min);
                return this;
            }
        });
    }

    /*
    Second part
     */
    public DateBuilder minSecond(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return this;
            }
        });
    }
    public DateBuilder maxSecond(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return this;
            }
        });
    }
    public DateBuilder second(final int second){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,second);
                return this;
            }
        });
    }

    /*
    Millisecond
     */
    public DateBuilder minMs(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return this;
            }
        });
    }
    public DateBuilder maxMs(){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return this;
            }
        });
    }
    public DateBuilder ms(final int ms){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return this;
            }
        });
    }

    /*
    Time manipulation
     */
    public DateBuilder maxDayTime(){
        return maxHour().maxMinute().maxSecond().maxMs();
    }
    public DateBuilder minDayTime(){
        return minHour().minMinute().minSecond().minMs();
    }
    public DateBuilder timePartOnly(){
        return minYear().minMonth().minDay();
    }

    public Date build(){
        return asCalendar().getTime();
    }
    public Calendar asCalendar(){
        Calendar cal = Calendar.getInstance();
        for(Build build: builds)
            build.apply(cal);
        return cal;
    }
    public Long asLong(){
        return build().getTime();
    }
    public DateComparator asComparator(){
        return DateComparator.from(this);
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public TimeOperation operate(){
       return TimeOperation.from(this);
    }

    public DateInfo view(){
        return DateInfo.from(build());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateBuilder that = (DateBuilder) o;
        return asLong().equals(that.asLong());
    }

    @Override
    public int hashCode() {
        return 4444;
    }

    @Override
    public String toString() {
        return "DateBuilder[" +DateFormatBuilder.ISO8601.format(build())+']';
    }
}
