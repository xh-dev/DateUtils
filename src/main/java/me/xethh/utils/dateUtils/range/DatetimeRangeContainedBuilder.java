package me.xethh.utils.dateUtils.range;

import me.xethh.utils.dateUtils.baseInterface.CalendarDateBuilder;
import me.xethh.utils.dateUtils.baseInterface.DateRangeBuilderInterface;
import me.xethh.utils.dateUtils.baseInterface.TimeUnitConverter;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.date.DateBuilder;
import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.formatBuilder.FormatBuilderWrapper;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.interfaces.DatetimeBackWrapper;
import me.xethh.utils.dateUtils.interfaces.EDITING;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeRangeContainedBuilder implements DatetimeBackWrapper<DatetimeRangeContainedBuilder, DatetimeRange> {
    DatetimeRange parent;
    private DatetimeBuilder builder;

    /*
    Constructors
     */
    public DatetimeRangeContainedBuilder(final Date date, DatetimeRange range) {
        this.parent = range;
        builder = DatetimeFactory.instance().from(date);
    }

    public DatetimeRangeContainedBuilder(Calendar cal, DatetimeRange range) {
        this.parent = range;
        builder = DatetimeFactory.instance().from(cal);
    }

    public DatetimeRangeContainedBuilder(Calendar cal, Build build, DatetimeRange range) {
        this(build.apply(cal), range);
    }

    @Override
    public DatetimeRangeContainedBuilder y(int year) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.y(year);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder m(Month month) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.m(month);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ym(int year, Month month) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.ym(year, month);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder md(Month month, int day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.md(month, day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ymd(int year, Month month, int day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.ymd(year, month, day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder d(int day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.d(day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hmsms(int hour, int minute, int second, int mSecond) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.hmsms(hour, minute, second, mSecond);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hms(int hour, int minute, int second) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.hms(hour, minute, second);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hm(int hour, int minute) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.hm(hour, minute);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder h(int hour) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.h(hour);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder year(int year) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.year(year);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder month(Month month) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.month(month);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minDay() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minDay();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder day(int date) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.day(date);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxDay() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxDay();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder firstDayOfMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.firstDayOfMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder endDayOfMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.endDayOfMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minHour() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minHour();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxHour() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxHour();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hour(int hour) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.hour(hour);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMinute() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minMinute();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxMinute() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxMinute();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minute(int min) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minute(min);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minSecond() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minSecond();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxSecond() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxSecond();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder second(int second) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.second(second);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMs() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minMs();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxMs() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxMs();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ms(int ms) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.ms(ms);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder timeZone(BaseTimeZone timeZone) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.timeZone(timeZone);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder timeZone(TimeZone timeZone) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.timeZone(timeZone);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder swapTimeZone(BaseTimeZone timeZone) {
        return swapTimeZone(timeZone.timeZone());
    }

    @Override
    public DatetimeRangeContainedBuilder swapTimeZone(TimeZone timeZone) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.swapTimeZone(timeZone);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxDayTime() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxDayTime();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxDayTimeSec() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxDayTimeSec();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxDayTimeMin() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.maxDayTimeMin();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minDayTime() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.minDayTime();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder timePartOnly() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.timePartOnly();
        return bd;
    }

    @Override
    public DateBuilder asDateBuilder() {
        return DateFactory.instance().from(builder);
    }

    @Override
    public DatetimeRangeContainedBuilder now() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.now();
        return bd;
    }

    @Override
    public Date asDate() {
        return builder.asDate();
    }

    @Override
    public Calendar asCalendar() {
        return builder.asCalendar();
    }

    @Override
    public Long asLong() {
        return builder.asLong();
    }

    @Override
    public java.sql.Date asSqlDate() {
        return builder.asSqlDate();
    }

    @Override
    public Time asSqlTime() {
        return builder.asSqlTime();
    }

    @Override
    public Timestamp asSqlTimestamp() {
        return builder.asSqlTimestamp();
    }

    @Override
    public DateInfo view() {
        return builder.view();
    }

    @Override
    public <X extends CalendarDateBuilder<X>> DatetimeRange rangeTo(X date) {
        return builder.rangeTo(date);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> DatetimeRange rangeFrom(X date) {
        return builder.rangeFrom(date);
    }

    @Override
    public DatetimeRange rangeTo(Date date) {
        return rangeTo(DatetimeFactory.instance().from(date));
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
        return builder.rangeToSelf();
    }

    @Override
    public DatetimeRange rangeFrom(Date date) {
        return rangeFrom(DatetimeFactory.instance().from(date));
    }

    @Override
    public DatetimeRange rangeFrom(Long dateLong) {
        return rangeFrom(DatetimeFactory.instance().from(dateLong));
    }

    @Override
    public DatetimeRange rangeFrom(Calendar cal) {
        return rangeFrom(DatetimeFactory.instance().from(cal));
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameDate(X builder) {
        return this.builder.sameDate(builder);
    }

    @Override
    public boolean sameDate(Long longDate) {
        return this.builder.sameDate(longDate);
    }

    @Override
    public boolean sameDate(Date date) {
        return this.builder.sameDate(date);
    }

    @Override
    public boolean sameDate(Calendar cal) {
        return this.builder.sameDate(cal);
    }

    @Override
    public DatetimeRangeContainedBuilder addYear(int years) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addYear(years);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder lastYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.lastYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.nextYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder lastMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.lastMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.nextMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMonths(int months) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addMonths(months);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addDays(int days) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addDays(days);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder yesterday() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.yesterday();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder tomorrow() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.tomorrow();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextWeekday(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.nextWeekday(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder prevWeekday(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.prevWeekday(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder startOfWeek(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.startOfWeek(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder endOfWeek(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.endOfWeek(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addTime(long time) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addTime(time);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addHours(int hours) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addHours(hours);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMins(int mins) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addMins(mins);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addSecond(int sec) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addSecond(sec);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMS(int ms) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.asCalendar(), parent);
        bd.builder = bd.builder.addMS(ms);
        return bd;
    }

    @Override
    public boolean sameDatetime(DatetimeBuilderInterface builder) {
        return this.builder.sameDatetime(builder);
    }

    @Override
    public boolean sameDatetime(Long longDate) {
        return builder.sameDatetime(longDate);
    }

    @Override
    public boolean sameDatetime(Date date) {
        return builder.sameDatetime(date);
    }

    @Override
    public boolean sameDatetime(Calendar cal) {
        return builder.sameDatetime(cal);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameYear(X builder) {
        return this.builder.sameYear(builder);
    }

    @Override
    public boolean sameYear(Long longDate) {
        return builder.sameYear(longDate);
    }

    @Override
    public boolean sameYear(Date date) {
        return builder.sameYear(date);
    }

    @Override
    public boolean sameYear(Calendar cal) {
        return builder.sameYear(cal);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameMonth(X builder) {
        return this.builder.sameMonth(builder);
    }

    @Override
    public boolean sameMonth(Long longDate) {
        return this.builder.sameMonth(longDate);
    }

    @Override
    public boolean sameMonth(Date date) {
        return this.builder.sameMonth(date);
    }

    @Override
    public boolean sameMonth(Calendar cal) {
        return this.builder.sameMonth(cal);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameDay(X builder) {
        return this.builder.sameDay(builder);
    }

    @Override
    public boolean sameDay(Long longDate) {
        return builder.sameDay(longDate);
    }

    @Override
    public boolean sameDay(Date date) {
        return builder.sameDay(date);
    }

    @Override
    public boolean sameDay(Calendar cal) {
        return builder.sameDay(cal);
    }

    @Override
    public boolean sameTime(DatetimeBuilderInterface datetimeBuilder) {
        return this.builder.sameTime(datetimeBuilder);
    }

    @Override
    public boolean sameTime(Long dateLong) {
        return builder.sameTime(dateLong);
    }

    @Override
    public boolean sameTime(Date date) {
        return builder.sameTime(date);
    }

    @Override
    public boolean sameTime(Calendar calendar) {
        return builder.sameTime(calendar);
    }

    @Override
    public boolean sameHMS(DatetimeBuilderInterface datetimeBuilder) {
        return builder.sameHMS(datetimeBuilder);
    }

    @Override
    public boolean sameHMS(Long dateLong) {
        return builder.sameHMS(dateLong);
    }

    @Override
    public boolean sameHMS(Date date) {
        return builder.sameHMS(date);
    }

    @Override
    public boolean sameHMS(Calendar calendar) {
        return builder.sameHMS(calendar);
    }

    @Override
    public boolean sameHM(DatetimeBuilderInterface datetimeBuilder) {
        return builder.sameHM(datetimeBuilder);
    }

    @Override
    public boolean sameHM(Long dateLong) {
        return builder.sameHM(dateLong);
    }

    @Override
    public boolean sameHM(Date date) {
        return builder.sameHM(date);
    }

    @Override
    public boolean sameHM(Calendar calendar) {
        return builder.sameHM(calendar);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean laterThan(X datetimeBuilder) {
        return builder.laterThan(datetimeBuilder);
    }

    @Override
    public boolean laterThan(Date date) {
        return builder.laterThan(date);
    }

    @Override
    public boolean laterThan(Long longDate) {
        return builder.laterThan(longDate);
    }

    @Override
    public boolean laterThan(Calendar calendar) {
        return builder.laterThan(calendar);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean laterEqualThan(X datetimeBuilder) {
        return builder.laterEqualThan(datetimeBuilder);
    }

    @Override
    public boolean laterEqualThan(Date date) {
        return builder.laterEqualThan(date);
    }

    @Override
    public boolean laterEqualThan(Long longDate) {
        return builder.laterEqualThan(longDate);
    }

    @Override
    public boolean laterEqualThan(Calendar calendar) {
        return builder.laterEqualThan(calendar);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean before(X datetimeBuilder) {
        return builder.before(datetimeBuilder);
    }

    @Override
    public boolean before(Date date) {
        return builder.before(date);
    }

    @Override
    public boolean before(Long longDate) {
        return builder.before(longDate);
    }

    @Override
    public boolean before(Calendar calendar) {
        return builder.before(calendar);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean beforeEqual(X datetimeBuilder) {
        return builder.beforeEqual(datetimeBuilder);
    }

    @Override
    public boolean beforeEqual(Date date) {
        return builder.beforeEqual(date);
    }

    @Override
    public boolean beforeEqual(Long longDate) {
        return builder.beforeEqual(longDate);
    }

    @Override
    public boolean beforeEqual(Calendar calendar) {
        return builder.beforeEqual(calendar);
    }

    @Override
    public TimeZone getTimeZone() {
        return builder.getTimeZone();
    }

    @Override
    public TimeUnit diffFrom(Date date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(Date date) {
        return builder.diffTo(date);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> TimeUnit diffFrom(X date) {
        return builder.diffFrom(date.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> TimeUnit diffTo(X date) {
        return builder.diffTo(date.asDate());
    }

    @Override
    public TimeUnit diffFrom(long date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(long date) {
        return builder.diffTo(date);
    }

    @Override
    public TimeUnit diffFrom(Calendar date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(Calendar date) {
        return builder.diffTo(date);
    }

    @Override
    public String format(String format) {
        return this.builder.format(format);
    }

    @Override
    public String format(DateFormatBuilderInterface.Format format) {
        return this.builder.format(format);
    }

    @Override
    public String format(SimpleDateFormat fmt) {
        return fmt.format(asDate());
    }

    @Override
    public String format(DateFormatBuilderInterface fmtBuilder) {
        return fmtBuilder.build().format(asDate());
    }

    @Override
    public FormatBuilderWrapper format() {
        return new FormatBuilderWrapper(this);
    }

    @Override
    public String format(TimeZone timeZone, String format) {
        return builder.format(timeZone, format);
    }

    @Override
    public String format(TimeZone timeZone, DateFormatBuilderInterface.Format format) {
        return builder.format(timeZone, format);
    }

    @Override
    public String format(TimeZone timeZone, DateFormatBuilderInterface fmtBuilder) {
        return this.format(timeZone, fmtBuilder.build());
    }

    @Override
    public String format(TimeZone timeZone, SimpleDateFormat fmt) {
        return builder.format(timeZone, fmt);
    }

    @Override
    public DatetimeRange back() {
        DatetimeRange range;
        if (parent.getEditingMode() == EDITING.START) {
            range = DatetimeFactory.rangeOf(asDate(), parent.endAsDate());
            range.clearEditingMode();
            return range;
        }
        if (parent.getEditingMode() == EDITING.END) {
            range = DatetimeFactory.rangeOf(parent.startAsDate(), asDate());
            range.clearEditingMode();
            return range;
        }
        return parent;
    }
}
