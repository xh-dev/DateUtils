package me.xethh.utils.dateManipulation;

import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static me.xethh.utils.dateManipulation.Weekday.Saturday;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;

public class DateBuilderImpl implements DateBuilder<DateBuilderImpl> {
    private List<Build> builds=new ArrayList();
    /*
    Constructors
     */
    protected DateBuilderImpl(final Date date){
        builds.add(new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.setTime(date);
                return this;
            }
        });
    }
    protected DateBuilderImpl(List<Build> builds){
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
    protected DateBuilderImpl(List<Build> builds, Build build){
        this(builds);
        this.builds.add(build);
    }

    public DateBuilderImpl y(int year){
        return year(year);
    }
    public DateBuilderImpl ym(int year, Month month){
        return year(year).month(month);
    }
    public DateBuilderImpl ymd(int year, Month month, int day){
        return year(year).month(month).day(day);
    }
    public DateBuilderImpl hmsms(int hour, int minute, int second, int mSecond){
        return hour(hour).minute(minute).second(second).ms(mSecond);
    }
    public DateBuilderImpl hms(int hour, int minute, int second){
        return hour(hour).minute(minute).second(second).minMs();
    }
    public DateBuilderImpl hm(int hour, int minute){
        return hour(hour).minute(minute).minSecond().minMs();
    }
    public DateBuilderImpl h(int hour){
        return hour(hour).minMinute().minSecond().minMs();
    }
    /*
    Year part
     */
    public DateBuilderImpl minYear(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return this;
            }
        });
    }
    public DateBuilderImpl year(final int year){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl minMonth(){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl month(final Month month){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl minDay(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return this;
            }
        });
    }
    public DateBuilderImpl day(final int date){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return this;
            }
        });
    }
    public DateBuilderImpl firstDayOfMonth(){
        return minDay();
    }
    public DateBuilderImpl endDayOfMonth(){
        return nextMonth().minDay().yesterday();
    }


    /*
    Hour part
     */
    public DateBuilderImpl minHour(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return this;
            }
        });
    }
    public DateBuilderImpl maxHour(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return this;
            }
        });
    }
    public DateBuilderImpl hour(final int hour){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl minMinute(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return this;
            }
        });
    }
    public DateBuilderImpl maxMinute(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return this;
            }
        });
    }
    public DateBuilderImpl minute(final int min){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl minSecond(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return this;
            }
        });
    }
    public DateBuilderImpl maxSecond(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return this;
            }
        });
    }
    public DateBuilderImpl second(final int second){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl minMs(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return this;
            }
        });
    }
    public DateBuilderImpl maxMs(){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return this;
            }
        });
    }
    public DateBuilderImpl ms(final int ms){
        return DateBuilderFactory.from(builds, new Build() {
            @Override
            public Build apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return this;
            }
        });
    }

    public DateBuilderImpl timeZone(final BaseTimeZone timeZone){
        return DateBuilderFactory.from(builds, new Build() {
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
    public DateBuilderImpl maxDayTime(){
        return maxHour().maxMinute().maxSecond().maxMs();
    }
    public DateBuilderImpl minDayTime(){
        return minHour().minMinute().minSecond().minMs();
    }
    public DateBuilderImpl timePartOnly(){
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

    public DatetimeRange rangeTo(DateBuilderImpl date){
        return rangeTo(date.asDate());
    }

    public DatetimeRange rangeFrom(DateBuilderImpl date){
        return rangeFrom(date.asDate());
    }

    public DatetimeRange rangeTo(Date date){
        return DatetimeRange.of(asDate(),date);
    }

    public DatetimeRange rangeFrom(Date date){
        return DatetimeRange.of(date,asDate());
    }

    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end){
        return DatetimeRange.of(start.oper().asDate(),end.oper().asDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateBuilderImpl that = (DateBuilderImpl) o;
        return asLong().equals(that.asLong());
    }

    //Time operation
    /*
    Operation
     */
    public DateBuilderImpl addYear(final int years){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return this;
            }
        });
    }
    public DateBuilderImpl lastYear(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,-1);
                return this;
            }
        });
    }
    public DateBuilderImpl nextYear(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.YEAR,1);
                return this;
            }
        });
    }
    public DateBuilderImpl lastMonth(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,-1);
                return this;
            }
        });
    }
    public DateBuilderImpl nextMonth(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,1);
                return this;
            }
        });
    }
    public DateBuilderImpl addMonths(final int months){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return this;
            }
        });
    }

    public DateBuilderImpl addDays(final int days){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return this;
            }
        });
    }
    public DateBuilderImpl yesterday(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,-1);
                return this;
            }
        });
    }
    public DateBuilderImpl tomorrow(){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,1);
                return this;
            }
        });
    }

    public DateBuilderImpl nextWeekday(Weekday day){
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

    public DateBuilderImpl prevWeekday(Weekday day){
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

    public DateBuilderImpl startOfWeek(Weekday startDay){
        if(view().weekday()==startDay)
            return this;
        else
            return prevWeekday(startDay);
    }

    public DateBuilderImpl endOfWeek(Weekday startDay){
        return startOfWeek(startDay).addDays(6);
    }

    public DateBuilderImpl addTime(final long time){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.setTimeInMillis(cal.getTimeInMillis()+time);
                return this;
            }
        });
    }

    public DateBuilderImpl addHours(final int hours){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return this;
            }
        });
    }

    public DateBuilderImpl addMins(final int mins){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return this;
            }
        });
    }

    public DateBuilderImpl addSecond(final int sec){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return this;
            }
        });
    }

    public DateBuilderImpl addMS(final int ms){
        return new DateBuilderImpl(this.builds,new Build(){
            @Override
            public Build apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return this;
            }
        });
    }

    //Compare operation
    public boolean sameDatetime(DateBuilderImpl builder){
        return asLong().equals(builder.asLong());
    }
    public boolean sameDatetime(Long longDate){
        return sameDatetime(DateBuilderFactory.from(longDate));
    }
    public boolean sameDatetime(Date date){
        return sameDatetime(DateBuilderFactory.from(date));
    }
    public boolean sameDatetime(Calendar cal){
        return sameDatetime(DateBuilderFactory.from(cal));

    }

    public boolean sameYear(DateBuilderImpl builder){
        return view().year().equals(builder.view().year());
    }
    public boolean sameYear(Long longDate){
        return sameYear(DateBuilderFactory.from(longDate));
    }
    public boolean sameYear(Date date){
        return sameYear(DateBuilderFactory.from(date));
    }
    public boolean sameYear(Calendar cal){
        return sameYear(DateBuilderFactory.from(cal));
    }

    public boolean sameMonth(DateBuilderImpl builder){
        return this.minDayTime().view().month().equals(builder.minDayTime().view().month());
    }
    public boolean sameMonth(Long longDate){
        return sameMonth(DateBuilderFactory.from(longDate));
    }
    public boolean sameMonth(Date date){
        return sameMonth(DateBuilderFactory.from(date));
    }
    public boolean sameMonth(Calendar cal){
        return sameMonth(DateBuilderFactory.from(cal));
    }

    public boolean sameDay(DateBuilderImpl builder){
        return this.minDayTime().equals(builder.minDayTime());
    }
    public boolean sameDay(Long longDate){
        return sameDay(DateBuilderFactory.from(longDate));
    }
    public boolean sameDay(Date date){
        return sameDay(DateBuilderFactory.from(date));
    }
    public boolean sameDay(Calendar cal){
        return sameDay(DateBuilderFactory.from(cal));
    }

    public boolean sameTime(DateBuilderImpl dateBuilder){
        return timePartOnly().equals(dateBuilder.timePartOnly());
    }
    public boolean sameTime(Long dateLong){
        return sameTime(DateBuilderFactory.from(dateLong));
    }
    public boolean sameTime(Date date){
        return sameTime(DateBuilderFactory.from(date).timePartOnly());
    }
    public boolean sameTime(Calendar calendar){
        return sameTime(DateBuilderFactory.from(calendar).timePartOnly());
    }

    public boolean sameHMS(DateBuilderImpl dateBuilder){
        return timePartOnly().minMs().equals(dateBuilder.timePartOnly().minMs());
    }
    public boolean sameHMS(Long dateLong){
        return sameHMS(DateBuilderFactory.from(dateLong));
    }
    public boolean sameHMS(Date date){
        return sameHMS(DateBuilderFactory.from(date).timePartOnly());
    }
    public boolean sameHMS(Calendar calendar){
        return sameHMS(DateBuilderFactory.from(calendar).timePartOnly());
    }

    public boolean sameHM(DateBuilderImpl dateBuilder){
        return timePartOnly().minSecond().minMs().equals(dateBuilder.timePartOnly().minSecond().minMs());
    }
    public boolean sameHM(Long dateLong){
        return sameHM(DateBuilderFactory.from(dateLong));
    }
    public boolean sameHM(Date date){
        return sameHM(DateBuilderFactory.from(date).timePartOnly());
    }
    public boolean sameHM(Calendar calendar){
        return sameHM(DateBuilderFactory.from(calendar).timePartOnly());
    }

    public boolean laterThan(DateBuilderImpl dateBuilder){
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

    public boolean laterEqualThan(DateBuilderImpl dateBuilder){
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

    public boolean before(DateBuilderImpl dateBuilder){
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

    public boolean beforeEqual(DateBuilderImpl dateBuilder){
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
