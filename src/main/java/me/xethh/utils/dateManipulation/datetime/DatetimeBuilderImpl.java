package me.xethh.utils.dateManipulation.datetime;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.date.DateFactory;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static me.xethh.utils.dateManipulation.Weekday.Saturday;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;

public class DatetimeBuilderImpl implements DatetimeBuilder {
    private Calendar cal;
    /*
    Constructors
     */
    public DatetimeBuilderImpl(){
        cal = Calendar.getInstance(DatetimeFactory.defaultTimezone());
        cal.set(Calendar.YEAR,1970);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
    }
    public DatetimeBuilderImpl(final Date date){
        cal = Calendar.getInstance(DatetimeFactory.defaultTimezone());
        cal.setTime(date);
    }
    public DatetimeBuilderImpl(Calendar cal){
        this.cal = (Calendar) cal.clone();
    }
    public DatetimeBuilderImpl(Calendar cal, Build build){
        this(cal);
        build.apply(this.cal);
    }

    public DatetimeBuilder y(int year){
        return year(year);
    }
    public DatetimeBuilder ym(int year, Month month){
        return year(year).month(month);
    }

    @Override
    public DatetimeBuilder md(Month month, int day) {
        return month(month).day(day);
    }

    public DatetimeBuilder ymd(int year, Month month, int day){
        return year(year).month(month).day(day);
    }
    public DatetimeBuilder hmsms(int hour, int minute, int second, int mSecond){
        return hour(hour).minute(minute).second(second).ms(mSecond);
    }
    public DatetimeBuilder hms(int hour, int minute, int second){
        return hour(hour).minute(minute).second(second).minMs();
    }
    public DatetimeBuilder hm(int hour, int minute){
        return hour(hour).minute(minute).minSecond().minMs();
    }
    public DatetimeBuilder h(int hour){
        return hour(hour).minMinute().minSecond().minMs();
    }
    /*
    Year part
     */
    public DatetimeBuilder minYear(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return cal;
            }
        });
    }
    public DatetimeBuilder year(final int year){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.YEAR,year);
                return cal;
            }
        });
    }

    /*
    Month part
     */
    public DatetimeBuilder minMonth(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH,0);
                return cal;
            }
        });
    }

    public DatetimeBuilder month(final Month month){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH,month.ordinal());
                return cal;
            }
        });
    }


    /*
    Day part
     */
    public DatetimeBuilder minDay(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return cal;

            }
        });
    }
    public DatetimeBuilder day(final int date){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return cal;

            }
        });
    }
    public DatetimeBuilder firstDayOfMonth(){
        return minDay();
    }
    public DatetimeBuilder endDayOfMonth(){
        return nextMonth().minDay().yesterday();
    }


    /*
    Hour part
     */
    public DatetimeBuilder minHour(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return cal;

            }
        });
    }
    public DatetimeBuilder maxHour(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return cal;

            }
        });
    }
    public DatetimeBuilder hour(final int hour){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,hour);
                return cal;

            }
        });
    }

    /*
    Minute part
     */
    public DatetimeBuilder minMinute(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return cal;

            }
        });
    }
    public DatetimeBuilder maxMinute(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return cal;

            }
        });
    }
    public DatetimeBuilder minute(final int min){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,min);
                return cal;

            }
        });
    }

    /*
    Second part
     */
    public DatetimeBuilder minSecond(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return cal;

            }
        });
    }
    public DatetimeBuilder maxSecond(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return cal;

            }
        });
    }
    public DatetimeBuilder second(final int second){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,second);
                return cal;

            }
        });
    }

    /*
    Millisecond
     */
    public DatetimeBuilder minMs(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return cal;

            }
        });
    }
    public DatetimeBuilder maxMs(){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return cal;

            }
        });
    }
    public DatetimeBuilder ms(final int ms){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return cal;
            }
        });
    }

    public DatetimeBuilder timeZone(final BaseTimeZone timeZone){
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeZone(timeZone.timeZone());
                return cal;

            }
        });
    }

    /*
    Time manipulation
     */
    public DatetimeBuilder maxDayTime(){
        return maxHour().maxMinute().maxSecond().maxMs();
    }

    @Override
    public DatetimeBuilder maxDayTimeSec() {
        return maxHour().maxMinute().maxSecond().minMs();
    }

    @Override
    public DatetimeBuilder maxDayTimeMin() {
        return maxHour().maxMinute().minSecond().minMs();
    }

    public DatetimeBuilder minDayTime(){
        return minHour().minMinute().minSecond().minMs();
    }

    public DatetimeBuilder timePartOnly(){
        return minYear().minMonth().minDay();
    }

    @Override
    public DateBuilder asDateBuilder() {
        return DateFactory.from(this);
    }

    @Override
    public DatetimeBuilder now() {
        return DatetimeFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(Calendar.getInstance(DatetimeFactory.defaultTimezone()).getTimeInMillis());
                return cal;
            }
        });
    }

    public Date asDate(){
        return asCalendar().getTime();
    }
    public Calendar asCalendar(){
        return (Calendar) cal.clone();
    }
    public Long asLong(){
        return asDate().getTime();
    }

    @Override
    public java.sql.Date asSqlDate() {
        return new java.sql.Date(asLong());
    }

    @Override
    public Time asSqlTime() {
        return new java.sql.Time(asLong());
    }

    @Override
    public Timestamp asSqlTimestamp() {
        return new java.sql.Timestamp(asLong());
    }

    public DateInfo view(){
        return DateInfo.from(asDate());
    }

    public DatetimeRange rangeTo(DatetimeBuilder date){
        return rangeTo(date.asDate());
    }

    public DatetimeRange rangeFrom(DatetimeBuilder date){
        return rangeFrom(date.asDate());
    }

    public DatetimeRange rangeTo(Date date){
        return DatetimeRange.of(asDate(), date);
    }

    @Override
    public DatetimeRange rangeTo(Long dateLong) {
        return rangeTo(DatetimeFactory.from(dateLong));
    }

    @Override
    public DatetimeRange rangeTo(Calendar cal) {
        return rangeTo(DatetimeFactory.from(cal));
    }

    @Override
    public DatetimeRange rangeToSelf() {
        return rangeTo(this);
    }

    public DatetimeRange rangeFrom(Date date){
        return DatetimeRange.of(date, asDate());
    }

    @Override
    public DatetimeRange rangeFrom(Long dateLong) {
        return rangeFrom(DatetimeFactory.from(dateLong));
    }

    @Override
    public DatetimeRange rangeFrom(Calendar cal) {
        return rangeFrom(DatetimeFactory.from(cal));
    }

    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end){
        return DatetimeRange.of(start.oper().asDate(),end.oper().asDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null ) return false;
        if (o instanceof Date){
            return asLong().equals(((Date) o).getTime());
        }
        if (o instanceof Calendar){
            return asLong().equals(((Calendar) o).getTimeInMillis());
        }
        if (o instanceof Long){
            return asLong().equals(o);
        }
        if (o instanceof DatetimeBuilder){
            return asLong().equals(((DatetimeBuilder) o).asLong());
        }
        else
            return false;
    }

    //Time operation
    /*
    Operation
     */
    public DatetimeBuilder addYear(final int years){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return cal;

            }
        });
    }
    public DatetimeBuilder lastYear(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,-1);
                return cal;

            }
        });
    }
    public DatetimeBuilder nextYear(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,1);
                return cal;

            }
        });
    }
    public DatetimeBuilder lastMonth(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,-1);
                return cal;

            }
        });
    }
    public DatetimeBuilder nextMonth(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,1);
                return cal;

            }
        });
    }
    public DatetimeBuilder addMonths(final int months){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return cal;

            }
        });
    }

    public DatetimeBuilder addDays(final int days){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return cal;

            }
        });
    }
    public DatetimeBuilder yesterday(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,-1);
                return cal;

            }
        });
    }
    public DatetimeBuilder tomorrow(){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,1);
                return cal;

            }
        });
    }

    public DatetimeBuilder nextWeekday(Weekday day){
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

    public DatetimeBuilder prevWeekday(Weekday day){
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

    public DatetimeBuilder startOfWeek(Weekday startDay){
        if(view().weekday()==startDay)
            return this;
        else
            return prevWeekday(startDay);
    }

    public DatetimeBuilder endOfWeek(Weekday startDay){
        return startOfWeek(startDay).addDays(6);
    }

    public DatetimeBuilder addTime(final long time){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(cal.getTimeInMillis()+time);
                return cal;

            }
        });
    }

    public DatetimeBuilder addHours(final int hours){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return cal;

            }
        });
    }

    public DatetimeBuilder addMins(final int mins){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return cal;

            }
        });
    }

    public DatetimeBuilder addSecond(final int sec){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return cal;

            }
        });
    }

    public DatetimeBuilder addMS(final int ms){
        return new DatetimeBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return cal;

            }
        });
    }

    //Compare operation
    public boolean sameDatetime(DatetimeBuilder builder){
        return asLong().equals(builder.asLong());
    }
    public boolean sameDatetime(Long longDate){
        return sameDatetime(DatetimeFactory.from(longDate));
    }
    public boolean sameDatetime(Date date){
        return sameDatetime(DatetimeFactory.from(date));
    }
    public boolean sameDatetime(Calendar cal){
        return sameDatetime(DatetimeFactory.from(cal));

    }

    public boolean sameYear(DatetimeBuilder builder){
        return view().year().equals(builder.view().year());
    }
    public boolean sameYear(Long longDate){
        return sameYear(DatetimeFactory.from(longDate));
    }
    public boolean sameYear(Date date){
        return sameYear(DatetimeFactory.from(date));
    }
    public boolean sameYear(Calendar cal){
        return sameYear(DatetimeFactory.from(cal));
    }

    public boolean sameMonth(DatetimeBuilder builder){
        return this.minDayTime().view().month().equals(builder.minDayTime().view().month());
    }
    public boolean sameMonth(Long longDate){
        return sameMonth(DatetimeFactory.from(longDate));
    }
    public boolean sameMonth(Date date){
        return sameMonth(DatetimeFactory.from(date));
    }
    public boolean sameMonth(Calendar cal){
        return sameMonth(DatetimeFactory.from(cal));
    }

    public boolean sameDay(DatetimeBuilder builder){
        return this.minDayTime().equals(builder.minDayTime());
    }
    public boolean sameDay(Long longDate){
        return sameDay(DatetimeFactory.from(longDate));
    }
    public boolean sameDay(Date date){
        return sameDay(DatetimeFactory.from(date));
    }
    public boolean sameDay(Calendar cal){
        return sameDay(DatetimeFactory.from(cal));
    }

    public boolean sameTime(DatetimeBuilder datetimeBuilder){
        return timePartOnly().equals(datetimeBuilder.timePartOnly());
    }
    public boolean sameTime(Long dateLong){
        return sameTime(DatetimeFactory.from(dateLong));
    }
    public boolean sameTime(Date date){
        return sameTime(DatetimeFactory.from(date).timePartOnly());
    }
    public boolean sameTime(Calendar calendar){
        return sameTime(DatetimeFactory.from(calendar).timePartOnly());
    }

    public boolean sameHMS(DatetimeBuilder datetimeBuilder){
        return timePartOnly().minMs().equals(datetimeBuilder.timePartOnly().minMs());
    }
    public boolean sameHMS(Long dateLong){
        return sameHMS(DatetimeFactory.from(dateLong));
    }
    public boolean sameHMS(Date date){
        return sameHMS(DatetimeFactory.from(date).timePartOnly());
    }
    public boolean sameHMS(Calendar calendar){
        return sameHMS(DatetimeFactory.from(calendar).timePartOnly());
    }

    public boolean sameHM(DatetimeBuilder datetimeBuilder){
        return timePartOnly().minSecond().minMs().equals(datetimeBuilder.timePartOnly().minSecond().minMs());
    }
    public boolean sameHM(Long dateLong){
        return sameHM(DatetimeFactory.from(dateLong));
    }
    public boolean sameHM(Date date){
        return sameHM(DatetimeFactory.from(date).timePartOnly());
    }
    public boolean sameHM(Calendar calendar){
        return sameHM(DatetimeFactory.from(calendar).timePartOnly());
    }

    public boolean laterThan(DatetimeBuilder datetimeBuilder){
        return laterThan(datetimeBuilder.asLong());
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

    public boolean laterEqualThan(DatetimeBuilder datetimeBuilder){
        return laterEqualThan(datetimeBuilder.asLong());
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

    public boolean before(DatetimeBuilder datetimeBuilder){
        return !laterEqualThan(datetimeBuilder.asLong());
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

    public boolean beforeEqual(DatetimeBuilder datetimeBuilder){
        return !laterThan(datetimeBuilder.asLong());
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
    public TimeUnit diffFrom(Date date) {
        return TimeUnit.timeDiff(date,this.asDate());
    }

    @Override
    public TimeUnit diffTo(Date date) {
        return TimeUnit.timeDiff(this.asDate(),date);
    }

    @Override
    public TimeUnit diffFrom(DatetimeBuilder date) {
        return TimeUnit.timeDiff(date.asDate(),this.asDate());
    }

    @Override
    public TimeUnit diffTo(DatetimeBuilder date) {
        return TimeUnit.timeDiff(this.asDate(),date.asDate());
    }

    @Override
    public TimeUnit diffFrom(long date) {
        return TimeUnit.timeDiff(date,asLong());
    }

    @Override
    public TimeUnit diffTo(long date) {
        return TimeUnit.timeDiff(asLong(),date);
    }

    @Override
    public TimeUnit diffFrom(Calendar cal) {
        return TimeUnit.timeDiff(cal.getTime(),asDate());
    }

    @Override
    public TimeUnit diffTo(Calendar cal) {
        return TimeUnit.timeDiff(asDate(),cal.getTime());
    }

    @Override
    public String format(String format) {
        return format(DateFormatBuilderImpl.get().custFormat(format));
    }

    @Override
    public String format(DateFormatBuilder.Format format) {
        return format(DateFormatBuilderImpl.get().custFormat(format.format()));
    }

    @Override
    public String format(SimpleDateFormat fmt) {
        return fmt.format(asDate());
    }

    @Override
    public String format(DateFormatBuilder fmtBuilder) {
        return fmtBuilder.build().format(asDate());
    }

    @Override
    public FormatBuilderWrapper format() {
        return new FormatBuilderWrapper(this);
    }

    @Override
    public String format(TimeZone timeZone, String format) {
        return format(DateFormatBuilderImpl.get().custFormat(format).timeZone(timeZone));
    }

    @Override
    public String format(TimeZone timeZone, DateFormatBuilder.Format format) {
        return format(DateFormatBuilderImpl.get().custFormat(format.format()).timeZone(timeZone));
    }

    @Override
    public String format(TimeZone timeZone, SimpleDateFormat fmt) {
        fmt.setTimeZone(timeZone);
        return format(fmt);
    }

    @Override
    public int hashCode() {
        return 4444;
    }

    @Override
    public String toString() {
        return "DatetimeBuilder[" +DateFormatBuilder.Format.ISO8601.getFormatter().format(asDate())+']';
    }

    public static void main(String[] args){
        System.out.println("123");
    }
}
