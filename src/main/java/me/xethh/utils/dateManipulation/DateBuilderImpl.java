package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static me.xethh.utils.dateManipulation.Weekday.Saturday;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;

public class DateBuilderImpl implements DateBuilder {
    private Calendar cal;
    /*
    Constructors
     */
    protected DateBuilderImpl(){
        cal = Calendar.getInstance(DateFactory.defaultTimezone());
        cal.set(Calendar.YEAR,1970);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
    }
    protected DateBuilderImpl(final Date date){
        cal = Calendar.getInstance(DateFactory.defaultTimezone());
        cal.setTime(date);
    }
    protected DateBuilderImpl(Calendar cal){
        this.cal = (Calendar) cal.clone();
    }
    protected DateBuilderImpl(Calendar cal, Build build){
        this(cal);
        build.apply(this.cal);
    }

    public DateBuilder y(int year){
        return year(year);
    }
    public DateBuilder ym(int year, Month month){
        return year(year).month(month);
    }

    @Override
    public DateBuilder md(Month month, int day) {
        return month(month).day(day);
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
    /*
    Year part
     */
    public DateBuilder minYear(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return cal;
            }
        });
    }
    public DateBuilder year(final int year){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder minMonth(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH,0);
                return cal;
            }
        });
    }

    public DateBuilder month(final Month month){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder minDay(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return cal;

            }
        });
    }
    public DateBuilder day(final int date){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return cal;

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
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return cal;

            }
        });
    }
    public DateBuilder maxHour(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return cal;

            }
        });
    }
    public DateBuilder hour(final int hour){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder minMinute(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return cal;

            }
        });
    }
    public DateBuilder maxMinute(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return cal;

            }
        });
    }
    public DateBuilder minute(final int min){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder minSecond(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return cal;

            }
        });
    }
    public DateBuilder maxSecond(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return cal;

            }
        });
    }
    public DateBuilder second(final int second){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder minMs(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return cal;

            }
        });
    }
    public DateBuilder maxMs(){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return cal;

            }
        });
    }
    public DateBuilder ms(final int ms){
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return cal;
            }
        });
    }

    public DateBuilder timeZone(final BaseTimeZone timeZone){
        return DateFactory.from(cal, new Build() {
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
    public DateBuilder maxDayTime(){
        return maxHour().maxMinute().maxSecond().maxMs();
    }

    @Override
    public DateBuilder maxDayTimeSec() {
        return maxHour().maxMinute().maxSecond().minMs();
    }

    @Override
    public DateBuilder maxDayTimeMin() {
        return maxHour().maxMinute().minSecond().minMs();
    }

    public DateBuilder minDayTime(){
        return minHour().minMinute().minSecond().minMs();
    }

    public DateBuilder timePartOnly(){
        return minYear().minMonth().minDay();
    }

    @Override
    public DateBuilder now() {
        return DateFactory.from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(Calendar.getInstance(DateFactory.defaultTimezone()).getTimeInMillis());
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

    public DatetimeRange rangeTo(DateBuilder date){
        return rangeTo(date.asDate());
    }

    public DatetimeRange rangeFrom(DateBuilder date){
        return rangeFrom(date.asDate());
    }

    public DatetimeRange rangeTo(Date date){
        return DatetimeRange.of(asDate(),date);
    }

    @Override
    public DatetimeRange rangeToSelf() {
        return rangeTo(now());
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
        if (o instanceof DateBuilder){
            return asLong().equals(((DateBuilder) o).asLong());
        }
        else
            return false;
    }

    //Time operation
    /*
    Operation
     */
    public DateBuilder addYear(final int years){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return cal;

            }
        });
    }
    public DateBuilder lastYear(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,-1);
                return cal;

            }
        });
    }
    public DateBuilder nextYear(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,1);
                return cal;

            }
        });
    }
    public DateBuilder lastMonth(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,-1);
                return cal;

            }
        });
    }
    public DateBuilder nextMonth(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,1);
                return cal;

            }
        });
    }
    public DateBuilder addMonths(final int months){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return cal;

            }
        });
    }

    public DateBuilder addDays(final int days){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return cal;

            }
        });
    }
    public DateBuilder yesterday(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,-1);
                return cal;

            }
        });
    }
    public DateBuilder tomorrow(){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,1);
                return cal;

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
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(cal.getTimeInMillis()+time);
                return cal;

            }
        });
    }

    public DateBuilder addHours(final int hours){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return cal;

            }
        });
    }

    public DateBuilder addMins(final int mins){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return cal;

            }
        });
    }

    public DateBuilder addSecond(final int sec){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return cal;

            }
        });
    }

    public DateBuilder addMS(final int ms){
        return new DateBuilderImpl(asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return cal;

            }
        });
    }

    //Compare operation
    public boolean sameDatetime(DateBuilder builder){
        return asLong().equals(builder.asLong());
    }
    public boolean sameDatetime(Long longDate){
        return sameDatetime(DateFactory.from(longDate));
    }
    public boolean sameDatetime(Date date){
        return sameDatetime(DateFactory.from(date));
    }
    public boolean sameDatetime(Calendar cal){
        return sameDatetime(DateFactory.from(cal));

    }

    public boolean sameYear(DateBuilder builder){
        return view().year().equals(builder.view().year());
    }
    public boolean sameYear(Long longDate){
        return sameYear(DateFactory.from(longDate));
    }
    public boolean sameYear(Date date){
        return sameYear(DateFactory.from(date));
    }
    public boolean sameYear(Calendar cal){
        return sameYear(DateFactory.from(cal));
    }

    public boolean sameMonth(DateBuilder builder){
        return this.minDayTime().view().month().equals(builder.minDayTime().view().month());
    }
    public boolean sameMonth(Long longDate){
        return sameMonth(DateFactory.from(longDate));
    }
    public boolean sameMonth(Date date){
        return sameMonth(DateFactory.from(date));
    }
    public boolean sameMonth(Calendar cal){
        return sameMonth(DateFactory.from(cal));
    }

    public boolean sameDay(DateBuilder builder){
        return this.minDayTime().equals(builder.minDayTime());
    }
    public boolean sameDay(Long longDate){
        return sameDay(DateFactory.from(longDate));
    }
    public boolean sameDay(Date date){
        return sameDay(DateFactory.from(date));
    }
    public boolean sameDay(Calendar cal){
        return sameDay(DateFactory.from(cal));
    }

    public boolean sameTime(DateBuilder dateBuilder){
        return timePartOnly().equals(dateBuilder.timePartOnly());
    }
    public boolean sameTime(Long dateLong){
        return sameTime(DateFactory.from(dateLong));
    }
    public boolean sameTime(Date date){
        return sameTime(DateFactory.from(date).timePartOnly());
    }
    public boolean sameTime(Calendar calendar){
        return sameTime(DateFactory.from(calendar).timePartOnly());
    }

    public boolean sameHMS(DateBuilder dateBuilder){
        return timePartOnly().minMs().equals(dateBuilder.timePartOnly().minMs());
    }
    public boolean sameHMS(Long dateLong){
        return sameHMS(DateFactory.from(dateLong));
    }
    public boolean sameHMS(Date date){
        return sameHMS(DateFactory.from(date).timePartOnly());
    }
    public boolean sameHMS(Calendar calendar){
        return sameHMS(DateFactory.from(calendar).timePartOnly());
    }

    public boolean sameHM(DateBuilder dateBuilder){
        return timePartOnly().minSecond().minMs().equals(dateBuilder.timePartOnly().minSecond().minMs());
    }
    public boolean sameHM(Long dateLong){
        return sameHM(DateFactory.from(dateLong));
    }
    public boolean sameHM(Date date){
        return sameHM(DateFactory.from(date).timePartOnly());
    }
    public boolean sameHM(Calendar calendar){
        return sameHM(DateFactory.from(calendar).timePartOnly());
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
    public TimeUnit diffFrom(Date date) {
        return TimeUnit.timeDiff(date,this.asDate());
    }

    @Override
    public TimeUnit diffTo(Date date) {
        return TimeUnit.timeDiff(this.asDate(),date);
    }

    @Override
    public TimeUnit diffFrom(DateBuilder date) {
        return TimeUnit.timeDiff(date.asDate(),this.asDate());
    }

    @Override
    public TimeUnit diffTo(DateBuilder date) {
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
        return "DateBuilder[" +DateFormatBuilder.Format.ISO8601.getFormatter().format(asDate())+']';
    }
}
