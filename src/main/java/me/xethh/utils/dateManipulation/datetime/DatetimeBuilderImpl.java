package me.xethh.utils.dateManipulation.datetime;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.Month;
import me.xethh.utils.dateManipulation.Weekday;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.dataInfo.DateInfo;
import me.xethh.utils.dateManipulation.date.DateBuilder;
import me.xethh.utils.dateManipulation.dateFactory.DateFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilderImpl;
import me.xethh.utils.dateManipulation.formatBuilder.FormatBuilderWrapper;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;
import me.xethh.utils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.datetime.DatetimeRange;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static me.xethh.utils.dateManipulation.Month.DEC;
import static me.xethh.utils.dateManipulation.Month.JAN;
import static me.xethh.utils.dateManipulation.Weekday.Saturday;
import static me.xethh.utils.dateManipulation.Weekday.Sunday;

public class DatetimeBuilderImpl implements DatetimeBuilder {
    private Calendar cal;
    /*
    Constructors
     */
    public DatetimeBuilderImpl(TimeZone timeZone){
        cal = Calendar.getInstance(timeZone);
        cal.set(Calendar.YEAR,1970);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
    }
    public DatetimeBuilderImpl(TimeZone timeZone, final Date date){
        this(timeZone);
        cal.setTime(date);
    }
    public DatetimeBuilderImpl(TimeZone timeZone, Calendar cal){
        this(timeZone);
        this.cal = (Calendar) cal.clone();
    }
    public DatetimeBuilderImpl(TimeZone timeZone, Calendar cal, Build build){
        this(timeZone, cal);
        build.apply(this.cal);
    }

    @Override
    public DatetimeBuilder y(int year){
        return year(year);
    }

    @Override
    public DatetimeBuilder m(Month month) {
        return month(month);
    }

    @Override
    public DatetimeBuilder ym(int year, Month month){
        return year(year).month(month);
    }

    @Override
    public DatetimeBuilder md(Month month, int day) {
        return month(month).day(day);
    }

    @Override
    public DatetimeBuilder ymd(int year, Month month, int day){
        return year(year).month(month).day(day);
    }

    @Override
    public DatetimeBuilder d(int day) {
        return day(day);
    }

    @Override
    public DatetimeBuilder hmsms(int hour, int minute, int second, int mSecond){
        return hour(hour).minute(minute).second(second).ms(mSecond);
    }
    @Override
    public DatetimeBuilder hms(int hour, int minute, int second){
        return hour(hour).minute(minute).second(second).minMs();
    }
    @Override
    public DatetimeBuilder hm(int hour, int minute){
        return hour(hour).minute(minute).minSecond().minMs();
    }
    @Override
    public DatetimeBuilder h(int hour){
        return hour(hour).minMinute().minSecond().minMs();
    }
    /*
    Year part
     */
    @Override
    public DatetimeBuilder minYear(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.YEAR,1970);
                return cal;
            }
        });
    }
    @Override
    public DatetimeBuilder year(final int year){
        return DatetimeFactory.instance().from(cal, new Build() {
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
    @Override
    public DatetimeBuilder minMonth(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH,JAN.toJavaCalNumber());
                return cal;
            }
        });
    }

    @Override
    public DatetimeBuilder month(final Month month){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH,month.ordinal());
                return cal;
            }
        });
    }

    @Override
    public DatetimeBuilder maxMonth() {
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MONTH, DEC.toJavaCalNumber());
                return cal;
            }
        });
    }


    /*
    Day part
     */
    @Override
    public DatetimeBuilder minDay(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder day(final int date){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.DAY_OF_MONTH,date);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder maxDay() {
        return nextMonth().minDay().yesterday();
    }

    @Override
    public DatetimeBuilder firstDayOfMonth(){
        return minDay();
    }
    @Override
    public DatetimeBuilder endDayOfMonth(){
        return maxDay();
    }


    /*
    Hour part
     */
    @Override
    public DatetimeBuilder minHour(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,0);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder maxHour(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.HOUR_OF_DAY,23);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder hour(final int hour){
        return DatetimeFactory.instance().from(cal, new Build() {
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
    @Override
    public DatetimeBuilder minMinute(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,0);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder maxMinute(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MINUTE,59);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder minute(final int min){
        return DatetimeFactory.instance().from(cal, new Build() {
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
    @Override
    public DatetimeBuilder minSecond(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,0);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder maxSecond(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.SECOND,59);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder second(final int second){
        return DatetimeFactory.instance().from(cal, new Build() {
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
    @Override
    public DatetimeBuilder minMs(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,0);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder maxMs(){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,999);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder ms(final int ms){
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.set(Calendar.MILLISECOND,ms);
                return cal;
            }
        });
    }

    @Override
    public DatetimeBuilder timeZone(final BaseTimeZone timeZone){
        return timeZone(timeZone.timeZone());
    }

    @Override
    public DatetimeBuilder timeZone(final TimeZone timeZone) {
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeZone(timeZone);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder swapTimeZone(BaseTimeZone timeZone) {
        return swapTimeZone(timeZone.timeZone());
    }

    @Override
    public DatetimeBuilder swapTimeZone(final TimeZone timeZone) {
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.getTime();
                cal.setTimeZone(timeZone);
                return cal;

            }
        });
    }

    /*
    Time manipulation
     */
    @Override
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

    @Override
    public DatetimeBuilder minDayTime(){
        return minHour().minMinute().minSecond().minMs();
    }

    @Override
    public DatetimeBuilder timePartOnly(){
        return minYear().minMonth().minDay();
    }

    @Override
    public DateBuilder asDateBuilder() {
        return DateFactory.instance().from(this);
    }

    @Override
    public DatetimeBuilder now() {
        return DatetimeFactory.instance().from(cal, new Build() {
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(Calendar.getInstance(DatetimeFactory.instance().getTimezone()).getTimeInMillis());
                return cal;
            }
        });
    }

    @Override
    public Date asDate(){
        return asCalendar().getTime();
    }
    @Override
    public Calendar asCalendar(){
        return (Calendar) cal.clone();
    }
    @Override
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

    @Override
    public DateInfo view(){
        return DateInfo.from(getTimeZone(), asDate());
    }

    @Override
    public DatetimeRange rangeTo(DatetimeBuilder date){
        return rangeTo(date.asDate());
    }

    @Override
    public DatetimeRange rangeFrom(DatetimeBuilder date){
        return rangeFrom(date.asDate());
    }

    @Override
    public DatetimeRange rangeTo(Date date){
        return DatetimeFactory.rangeOf(asDate(), date);
    }

    @Override
    public DatetimeRange rangeTo(Long dateLong) {
        return rangeTo(DatetimeFactory.instance().from(dateLong));
    }

    @Override
    public DatetimeRange rangeTo(Calendar cal) {
        return rangeTo(DatetimeFactory.instance().from(cal));
    }

    @Override
    public DatetimeRange rangeToSelf() {
        return rangeTo(this);
    }

    @Override
    public DatetimeRange rangeFrom(Date date){
        return DatetimeFactory.rangeOf(date, asDate());
    }

    @Override
    public DatetimeRange rangeFrom(Long dateLong) {
        return rangeFrom(DatetimeFactory.instance().from(dateLong));
    }

    @Override
    public DatetimeRange rangeFrom(Calendar cal) {
        return rangeFrom(DatetimeFactory.instance().from(cal));
    }


    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end){
        return DatetimeFactory.rangeOf(start.oper().asDate(),end.oper().asDate());
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
    @Override
    public DatetimeBuilder addYear(final int years){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,years);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder lastYear(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,-1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder nextYear(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.YEAR,1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder lastMonth(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,-1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder nextMonth(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder addMonths(final int months){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MONTH,months);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder addDays(final int days){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,days);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder yesterday(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,-1);
                return cal;

            }
        });
    }
    @Override
    public DatetimeBuilder tomorrow(){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.DAY_OF_MONTH,1);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder nextWeekday(Weekday startDay){
        if(view().weekday()== startDay)
            return addDays(7);
        else{
            Weekday dayOfThis = view().weekday();

            if(dayOfThis.ordinal()> startDay.ordinal()){
                return addDays(Weekday.Saturday.ordinal()-dayOfThis.ordinal()+ startDay.ordinal()-Sunday.ordinal()+1);
            }
            else{
                return addDays(startDay.ordinal()-dayOfThis.ordinal());
            }
        }
    }

    @Override
    public DatetimeBuilder prevWeekday(Weekday startDay){
        if(view().weekday()== startDay)
            return addDays(-7);
        else{
            Weekday dayOfThis = view().weekday();

            if(dayOfThis.ordinal()> startDay.ordinal()){
                return addDays((dayOfThis.ordinal()- startDay.ordinal())*-1);
            }
            else{
                return addDays(-1*(dayOfThis.ordinal()+Saturday.ordinal()- startDay.ordinal()+1));
            }
        }
    }

    @Override
    public DatetimeBuilder startOfWeek(Weekday startDay){
        if(view().weekday()==startDay)
            return this;
        else
            return prevWeekday(startDay);
    }

    @Override
    public DatetimeBuilder endOfWeek(Weekday startDay){
        return startOfWeek(startDay).addDays(6);
    }

    @Override
    public DatetimeBuilder addTime(final long time){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.setTimeInMillis(cal.getTimeInMillis()+time);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder addHours(final int hours){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.HOUR_OF_DAY,hours);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder addMins(final int mins){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MINUTE,mins);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder addSecond(final int sec){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.SECOND,sec);
                return cal;

            }
        });
    }

    @Override
    public DatetimeBuilder addMS(final int ms){
        return new DatetimeBuilderImpl(asCalendar().getTimeZone(), asCalendar(), new Build(){
            @Override
            public Calendar apply(Calendar cal) {
                cal.add(Calendar.MILLISECOND,ms);
                return cal;

            }
        });
    }

    //Compare operation
    @Override
    public boolean sameDate(DatetimeBuilder builder) {
        return minDayTime().sameDatetime(builder.minDayTime());
    }

    @Override
    public boolean sameDate(Long longDate) {
        return sameDate(DatetimeFactory.instance(cal.getTimeZone()).from(longDate));
    }

    @Override
    public boolean sameDate(Date date) {
        return sameDate(DatetimeFactory.instance(cal.getTimeZone()).from(date));
    }

    @Override
    public boolean sameDate(Calendar cal) {
        return sameDate(DatetimeFactory.instance(cal.getTimeZone()).from(cal));
    }
    @Override
    public boolean sameDatetime(DatetimeBuilder builder){
        return asLong().equals(builder.asLong());
    }
    @Override
    public boolean sameDatetime(Long longDate){
        return sameDatetime(DatetimeFactory.instance().from(longDate));
    }
    @Override
    public boolean sameDatetime(Date date){
        return sameDatetime(DatetimeFactory.instance().from(date));
    }
    @Override
    public boolean sameDatetime(Calendar cal){
        return sameDatetime(DatetimeFactory.instance().from(cal));

    }

    @Override
    public boolean sameYear(DatetimeBuilder builder){
        return view().year().equals(builder.view().year());
    }
    @Override
    public boolean sameYear(Long longDate){
        return sameYear(DatetimeFactory.instance().from(longDate));
    }
    @Override
    public boolean sameYear(Date date){
        return sameYear(DatetimeFactory.instance().from(date));
    }
    @Override
    public boolean sameYear(Calendar cal){
        return sameYear(DatetimeFactory.instance().from(cal));
    }

    @Override
    public boolean sameMonth(DatetimeBuilder builder){
        return this.minDayTime().view().month().equals(builder.minDayTime().view().month());
    }
    @Override
    public boolean sameMonth(Long longDate){
        return sameMonth(DatetimeFactory.instance().from(longDate));
    }
    @Override
    public boolean sameMonth(Date date){
        return sameMonth(DatetimeFactory.instance().from(date));
    }
    @Override
    public boolean sameMonth(Calendar cal){
        return sameMonth(DatetimeFactory.instance().from(cal));
    }

    @Override
    public boolean sameDay(DatetimeBuilder builder){
        return this.view().day().equals(builder.view().day());
    }
    @Override
    public boolean sameDay(Long longDate){
        return sameDay(DatetimeFactory.instance().from(longDate));
    }
    @Override
    public boolean sameDay(Date date){
        return sameDay(DatetimeFactory.instance().from(date));
    }
    @Override
    public boolean sameDay(Calendar cal){
        return sameDay(DatetimeFactory.instance().from(cal));
    }

    @Override
    public boolean sameTime(DatetimeBuilder datetimeBuilder){
        return timePartOnly().equals(datetimeBuilder.timePartOnly());
    }
    @Override
    public boolean sameTime(Long dateLong){
        return sameTime(DatetimeFactory.instance().from(dateLong));
    }
    @Override
    public boolean sameTime(Date date){
        return sameTime(DatetimeFactory.instance().from(date).timePartOnly());
    }
    @Override
    public boolean sameTime(Calendar calendar){
        return sameTime(DatetimeFactory.instance().from(calendar).timePartOnly());
    }

    @Override
    public boolean sameHMS(DatetimeBuilder datetimeBuilder){
        return timePartOnly().minMs().equals(datetimeBuilder.timePartOnly().minMs());
    }
    @Override
    public boolean sameHMS(Long dateLong){
        return sameHMS(DatetimeFactory.instance().from(dateLong));
    }
    @Override
    public boolean sameHMS(Date date){
        return sameHMS(DatetimeFactory.instance().from(date).timePartOnly());
    }
    @Override
    public boolean sameHMS(Calendar calendar){
        return sameHMS(DatetimeFactory.instance().from(calendar).timePartOnly());
    }

    @Override
    public boolean sameHM(DatetimeBuilder datetimeBuilder){
        return timePartOnly().minSecond().minMs().equals(datetimeBuilder.timePartOnly().minSecond().minMs());
    }
    @Override
    public boolean sameHM(Long dateLong){
        return sameHM(DatetimeFactory.instance().from(dateLong));
    }
    @Override
    public boolean sameHM(Date date){
        return sameHM(DatetimeFactory.instance().from(date).timePartOnly());
    }
    @Override
    public boolean sameHM(Calendar calendar){
        return sameHM(DatetimeFactory.instance().from(calendar).timePartOnly());
    }

    @Override
    public boolean laterThan(DatetimeBuilder datetimeBuilder){
        return laterThan(datetimeBuilder.asLong());
    }
    @Override
    public boolean laterThan(Date date){
        return laterThan(date.getTime());
    }
    @Override
    public boolean laterThan(Long longDate){
        return asLong()>(longDate);
    }
    @Override
    public boolean laterThan(Calendar calendar){
        return laterThan(calendar.getTime().getTime());
    }

    @Override
    public boolean laterEqualThan(DatetimeBuilder datetimeBuilder){
        return laterEqualThan(datetimeBuilder.asLong());
    }
    @Override
    public boolean laterEqualThan(Date date){
        return laterEqualThan(date.getTime());
    }
    @Override
    public boolean laterEqualThan(Long longDate){
        return asLong()>=(longDate);
    }
    @Override
    public boolean laterEqualThan(Calendar calendar){
        return laterEqualThan(calendar.getTime().getTime());
    }

    @Override
    public boolean before(DatetimeBuilder datetimeBuilder){
        return !laterEqualThan(datetimeBuilder.asLong());
    }
    @Override
    public boolean before(Date date){
        return !laterEqualThan(date.getTime());
    }
    @Override
    public boolean before(Long longDate){
        return !laterEqualThan(longDate);
    }
    @Override
    public boolean before(Calendar calendar){
        return !laterEqualThan(calendar.getTime().getTime());
    }

    @Override
    public boolean beforeEqual(DatetimeBuilder datetimeBuilder){
        return !laterThan(datetimeBuilder.asLong());
    }
    @Override
    public boolean beforeEqual(Date date){
        return !laterThan(date.getTime());
    }
    @Override
    public boolean beforeEqual(Long longDate){
        return !laterThan(longDate);
    }
    @Override
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
    public String format(TimeZone timeZone, DateFormatBuilder fmtBuilder) {
        return format(fmtBuilder.timeZone(timeZone));
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

    @Override
    public TimeZone getTimeZone(){
        return cal.getTimeZone();
    }
}
