package me.xethh.utils.dateManipulation;

import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static me.xethh.utils.dateManipulation.Weekday.Saturday;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;

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
        if(builds.size()==0)
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

    public DateBuilder y(int year){
        return year(year);
    }
    public DateBuilder ym(int year, Month month){
        return year(year).month(month);
    }
    public DateBuilder ymd(int year, Month month, int day){
        return year(year).month(month).day(day);
    }
    public DateBuilder hmsms(int hour, int minute, int second, int mSecond){
        return hour(hour).minute(minute).second(second).ms(mSecond);
    }
    public DateBuilder hms(int hour, int minute, int second){
        return hour(hour).minute(minute).second(second).minMs();
    }
    public DateBuilder hm(int hour, int minute){
        return hour(hour).minute(minute).minSecond().minMs();
    }
    public DateBuilder h(int hour){
        return hour(hour).minMinute().minSecond().minMs();
    }
    public static DateBuilder from(Date date){
        return new DateBuilder(date);
    }
    public static DateBuilder from(Date date,Build build){
        DateBuilder builder = new DateBuilder(date);
        return DateBuilder.from(builder.builds,build);
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
    public DateBuilder endDayOfMonth(){
        return nextMonth().minDay().yesterday();
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

    public DateBuilder timeZone(final BaseTimeZone timeZone){
        return DateBuilder.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.setTimeZone(timeZone.timeZone());
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

    public Date asDate(){
        return asCalendar().getTime();
    }
    public Calendar asCalendar(){
        Calendar cal = Calendar.getInstance();
        for(Build build: builds)
            build.apply(cal);
        return cal;
    }
    public Long asLong(){
        return asDate().getTime();
    }
    public List<Build> getBuilds() {
        return builds;
    }

    public DateInfo view(){
        return DateInfo.from(asDate());
    }

    public DatetimeRange rangeFromNowTo(DateBuilder date){
        return rangeFromNowTo(date.asDate());
    }

    public DatetimeRange rangeToNow(DateBuilder date){
        return rangeToNow(date.asDate());
    }

    public DatetimeRange rangeFromNowTo(Date date){
        return DatetimeRange.of(asDate(),date);
    }

    public DatetimeRange rangeToNow(Date date){
        return DatetimeRange.of(date,asDate());
    }

    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end){
        return DatetimeRange.of(start.oper().asDate(),end.oper().asDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateBuilder that = (DateBuilder) o;
        return asLong().equals(that.asLong());
    }

    //Time operation
    /*
    Operation
     */
    public DateBuilder addYear(final int years){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return this;
            }
        });
    }
    public DateBuilder lastYear(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,-1);
                return this;
            }
        });
    }
    public DateBuilder nextYear(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,1);
                return this;
            }
        });
    }
    public DateBuilder lastMonth(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,-1);
                return this;
            }
        });
    }
    public DateBuilder nextMonth(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,1);
                return this;
            }
        });
    }
    public DateBuilder addMonths(final int months){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return this;
            }
        });
    }

    public DateBuilder addDays(final int days){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return this;
            }
        });
    }
    public DateBuilder yesterday(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,-1);
                return this;
            }
        });
    }
    public DateBuilder tomorrow(){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,1);
                return this;
            }
        });
    }

    public DateBuilder nextWeekday(Weekday day){
        if(view().weekday()==day)
            return addDays(7);
        else{
            Weekday dayOfThis = view().weekday();

            if(dayOfThis.ordinal()>day.ordinal()){
                return addDays(Weekday.Saturday.ordinal()-dayOfThis.ordinal()+day.ordinal()-Sunday.ordinal()+1);
            }
            else{
                return addDays(day.ordinal()-dayOfThis.ordinal());
            }
        }
    }

    public DateBuilder prevWeekday(Weekday day){
        if(view().weekday()==day)
            return addDays(-7);
        else{
            Weekday dayOfThis = view().weekday();

            if(dayOfThis.ordinal()>day.ordinal()){
                return addDays((dayOfThis.ordinal()-day.ordinal())*-1);
            }
            else{
                return addDays(-1*(dayOfThis.ordinal()+Saturday.ordinal()-day.ordinal()+1));
            }
        }
    }

    public DateBuilder startOfWeek(Weekday startDay){
        if(view().weekday()==startDay)
            return this;
        else
            return prevWeekday(startDay);
    }

    public DateBuilder endOfWeek(Weekday startDay){
        return startOfWeek(startDay).addDays(6);
    }

    public DateBuilder addTime(final long time){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.setTimeInMillis(cal.getTimeInMillis()+time);
                return this;
            }
        });
    }

    public DateBuilder addHours(final int hours){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return this;
            }
        });
    }

    public DateBuilder addMins(final int mins){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return this;
            }
        });
    }

    public DateBuilder addSecond(final int sec){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return this;
            }
        });
    }

    public DateBuilder addMS(final int ms){
        return new DateBuilder(this.builds,new DateBuilder.Build(){
            @Override
            public DateBuilder.Build apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return this;
            }
        });
    }

    //Compare operation
    public boolean sameDatetime(DateBuilder builder){
        return asLong().equals(builder.asLong());
    }
    public boolean sameDatetime(Long longDate){
        return sameDatetime(DateBuilder.from(longDate));
    }
    public boolean sameDatetime(Date date){
        return sameDatetime(DateBuilder.from(date));
    }
    public boolean sameDatetime(Calendar cal){
        return sameDatetime(DateBuilder.from(cal));

    }

    public boolean sameYear(DateBuilder builder){
        return view().year().equals(builder.view().year());
    }
    public boolean sameYear(Long longDate){
        return sameYear(DateBuilder.from(longDate));
    }
    public boolean sameYear(Date date){
        return sameYear(DateBuilder.from(date));
    }
    public boolean sameYear(Calendar cal){
        return sameYear(DateBuilder.from(cal));
    }

    public boolean sameMonth(DateBuilder builder){
        return this.minDayTime().view().month().equals(builder.minDayTime().view().month());
    }
    public boolean sameMonth(Long longDate){
        return sameMonth(DateBuilder.from(longDate));
    }
    public boolean sameMonth(Date date){
        return sameMonth(DateBuilder.from(date));
    }
    public boolean sameMonth(Calendar cal){
        return sameMonth(DateBuilder.from(cal));
    }

    public boolean sameDay(DateBuilder builder){
        return this.minDayTime().equals(builder.minDayTime());
    }
    public boolean sameDay(Long longDate){
        return sameDay(DateBuilder.from(longDate));
    }
    public boolean sameDay(Date date){
        return sameDay(DateBuilder.from(date));
    }
    public boolean sameDay(Calendar cal){
        return sameDay(DateBuilder.from(cal));
    }

    public boolean sameTime(DateBuilder dateBuilder){
        return timePartOnly().equals(dateBuilder.timePartOnly());
    }
    public boolean sameTime(Long dateLong){
        return sameTime(DateBuilder.from(dateLong));
    }
    public boolean sameTime(Date date){
        return sameTime(DateBuilder.from(date).timePartOnly());
    }
    public boolean sameTime(Calendar calendar){
        return sameTime(DateBuilder.from(calendar).timePartOnly());
    }

    public boolean sameHMS(DateBuilder dateBuilder){
        return timePartOnly().minMs().equals(dateBuilder.timePartOnly().minMs());
    }
    public boolean sameHMS(Long dateLong){
        return sameHMS(DateBuilder.from(dateLong));
    }
    public boolean sameHMS(Date date){
        return sameHMS(DateBuilder.from(date).timePartOnly());
    }
    public boolean sameHMS(Calendar calendar){
        return sameHMS(DateBuilder.from(calendar).timePartOnly());
    }

    public boolean sameHM(DateBuilder dateBuilder){
        return timePartOnly().minSecond().minMs().equals(dateBuilder.timePartOnly().minSecond().minMs());
    }
    public boolean sameHM(Long dateLong){
        return sameHM(DateBuilder.from(dateLong));
    }
    public boolean sameHM(Date date){
        return sameHM(DateBuilder.from(date).timePartOnly());
    }
    public boolean sameHM(Calendar calendar){
        return sameHM(DateBuilder.from(calendar).timePartOnly());
    }

    public boolean laterThan(DateBuilder dateBuilder){
        return laterThan(dateBuilder.asLong());
    }
    public boolean laterThan(Date date){
        return laterThan(date.getTime());
    }
    public boolean laterThan(Long longDate){
        return asLong()>(longDate);
    }
    public boolean laterThan(Calendar calendar){
        return laterThan(calendar.getTime().getTime());
    }

    public boolean laterEqualThan(DateBuilder dateBuilder){
        return laterEqualThan(dateBuilder.asLong());
    }
    public boolean laterEqualThan(Date date){
        return laterEqualThan(date.getTime());
    }
    public boolean laterEqualThan(Long longDate){
        return asLong()>=(longDate);
    }
    public boolean laterEqualThan(Calendar calendar){
        return laterEqualThan(calendar.getTime().getTime());
    }

    public boolean before(DateBuilder dateBuilder){
        return !laterEqualThan(dateBuilder.asLong());
    }
    public boolean before(Date date){
        return !laterEqualThan(date.getTime());
    }
    public boolean before(Long longDate){
        return !laterEqualThan(longDate);
    }
    public boolean before(Calendar calendar){
        return !laterEqualThan(calendar.getTime().getTime());
    }

    public boolean beforeEqual(DateBuilder dateBuilder){
        return !laterThan(dateBuilder.asLong());
    }
    public boolean beforeEqual(Date date){
        return !laterThan(date.getTime());
    }
    public boolean beforeEqual(Long longDate){
        return !laterThan(longDate);
    }
    public boolean beforeEqual(Calendar calendar){
        return !laterThan(calendar.getTime().getTime());
    }

    @Override
    public int hashCode() {
        return 4444;
    }

    @Override
    public String toString() {
        return "DateBuilder[" +DateFormatBuilder.ISO8601.format(asDate())+']';
    }
}
