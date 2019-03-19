package me.xethh.utils.dateManipulation.date;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.dateManipulation.*;
import me.xethh.utils.dateManipulation.buildInterfaces.Build;
import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.datetime.DatetimeFactory;
import me.xethh.utils.dateManipulation.formatBuilder.DateFormatBuilder;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateBuilderImpl implements DateBuilder {
    private DatetimeBuilder builder;
    public DateBuilderImpl(){
        this(DatetimeFactory.raw());
    }
    public DateBuilderImpl(Date builder, Build build){
        this(DatetimeFactory.from(builder,build));
    }
    public DateBuilderImpl(Date builder){
        this(DatetimeFactory.from(builder));
    }
    public DateBuilderImpl(Calendar cal, Build build){
        this(DatetimeFactory.from(cal,build));
    }
    public DateBuilderImpl(Calendar cal){
        this(DatetimeFactory.from(cal));
    }
    public DateBuilderImpl(DatetimeBuilder builder){
        this.builder = builder.minDayTime();
    }
    @Override
    public DateBuilder y(int year) {
        return new DateBuilderImpl(builder.y(year));
    }

    @Override
    public DateBuilder ym(int year, Month month) {
        return new DateBuilderImpl(builder.ym(year,month));
    }

    @Override
    public DateBuilder md(Month month, int day) {
        return new DateBuilderImpl(builder.md(month,day));
    }

    @Override
    public DateBuilder ymd(int year, Month month, int day) {
        return new DateBuilderImpl(builder.ymd(year, month, day));
    }

    @Override
    public DateBuilder minYear() {
        return new DateBuilderImpl(builder.minYear());
    }

    @Override
    public DateBuilder year(int year) {
        return new DateBuilderImpl(builder.year(year));
    }

    @Override
    public DateBuilder minMonth() {
        return new DateBuilderImpl(builder.minMonth());
    }

    @Override
    public DateBuilder month(Month month) {
        return new DateBuilderImpl(builder.month(month));
    }

    @Override
    public DateBuilder minDay() {
        return new DateBuilderImpl(builder.minDay());
    }

    @Override
    public DateBuilder day(int date) {
        return new DateBuilderImpl(builder.day(date));
    }

    @Override
    public DateBuilder firstDayOfMonth() {
        return new DateBuilderImpl(builder.firstDayOfMonth());
    }

    @Override
    public DateBuilder endDayOfMonth() {
        return new DateBuilderImpl(builder.endDayOfMonth());
    }

    @Override
    public DateBuilder addYear(int years) {
        return new DateBuilderImpl(builder.addYear(years));
    }

    @Override
    public DateBuilder lastYear() {
        return new DateBuilderImpl(builder.lastYear());
    }

    @Override
    public DateBuilder nextYear() {
        return new DateBuilderImpl(builder.nextYear());
    }

    @Override
    public DateBuilder lastMonth() {
        return new DateBuilderImpl(builder.lastMonth());
    }

    @Override
    public DateBuilder nextMonth() {
        return new DateBuilderImpl(builder.nextMonth());
    }

    @Override
    public DateBuilder addMonths(int months) {
        return new DateBuilderImpl(builder.addMonths(months));
    }

    @Override
    public DateBuilder addDays(int days) {
        return new DateBuilderImpl(builder.addDays(days));
    }

    @Override
    public DateBuilder yesterday() {
        return new DateBuilderImpl(builder.yesterday());
    }

    @Override
    public DateBuilder tomorrow() {
        return new DateBuilderImpl(builder.tomorrow());
    }

    @Override
    public DateBuilder nextWeekday(Weekday day) {
        return new DateBuilderImpl(builder.nextWeekday(day));
    }

    @Override
    public DateBuilder prevWeekday(Weekday day) {
        return new DateBuilderImpl(builder.prevWeekday(day));
    }

    @Override
    public DateBuilder startOfWeek(Weekday startDay) {
        return new DateBuilderImpl(builder.startOfWeek(startDay));
    }

    @Override
    public DateBuilder endOfWeek(Weekday startDay) {
        return new DateBuilderImpl(builder.endOfWeek(startDay));
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
    public boolean sameMonth(Long longDate) {
        return builder.sameMonth(longDate);
    }

    @Override
    public boolean sameMonth(Date date) {
        return builder.sameMonth(date);
    }

    @Override
    public boolean sameMonth(Calendar cal) {
        return builder.sameMonth(cal);
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
    public boolean laterEqualThan(Date date) {
        return laterEqualThan(date);
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
    public boolean before(Date date) {
        return builder.laterEqualThan(date);
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
    public DateBuilder now() {
        return new DateBuilderImpl(builder.now());
    }

    @Override
    public DateInfo view() {
        return builder.view();
    }

    @Override
    public DatetimeRange rangeTo(DateBuilder date) {
        return builder.rangeTo(date.asDatetimeBuilder());
    }

    @Override
    public DatetimeRange rangeTo(DatetimeBuilder date) {
        return builder.rangeTo(date);
    }

    @Override
    public DatetimeRange rangeFrom(DateBuilder date) {
        return builder.rangeFrom(date.asDatetimeBuilder());
    }

    @Override
    public DatetimeRange rangeFrom(DatetimeBuilder date) {
        return builder.rangeFrom(date);
    }

    @Override
    public DatetimeRange rangeTo(Date date) {
        return builder.rangeTo(date);
    }

    @Override
    public DatetimeRange rangeTo(Long dateLong) {
        return builder.rangeTo(dateLong);
    }

    @Override
    public DatetimeRange rangeTo(Calendar cal) {
        return builder.rangeTo(cal);
    }

    @Override
    public DatetimeRange rangeToSelf() {
        return builder.rangeTo(builder.asDate());
    }

    @Override
    public DatetimeRange rangeFrom(Date date) {
        return builder.rangeFrom(date);
    }

    @Override
    public DatetimeRange rangeFrom(Long dateLong) {
        return builder.rangeFrom(dateLong);
    }

    @Override
    public DatetimeRange rangeFrom(Calendar cal) {
        return builder.rangeFrom(cal);
    }

    @Override
    public boolean sameYear(DateBuilder builder) {
        return this.builder.sameYear(builder.asDatetimeBuilder());
    }

    @Override
    public boolean sameYear(DatetimeBuilder builder) {
        return this.builder.sameYear(builder.minDayTime());
    }

    @Override
    public boolean sameMonth(DateBuilder builder) {
        return this.builder.sameMonth(builder.asDatetimeBuilder());
    }

    @Override
    public boolean sameMonth(DatetimeBuilder builder) {
        return this.builder.sameMonth(builder.minDayTime());
    }

    @Override
    public boolean sameDay(DateBuilder builder) {
        return this.builder.sameDay(builder.asDatetimeBuilder());
    }

    @Override
    public boolean sameDay(DatetimeBuilder builder) {
        return this.builder.sameDay(builder.minDayTime());
    }

    @Override
    public boolean laterThan(DateBuilder datetimeBuilder) {
        return builder.laterThan(datetimeBuilder.asDatetimeBuilder());
    }

    @Override
    public boolean laterThan(DatetimeBuilder datetimeBuilder) {
        return builder.laterThan(datetimeBuilder.minDayTime());
    }

    @Override
    public boolean laterEqualThan(DateBuilder datetimeBuilder) {
        return builder.laterEqualThan(datetimeBuilder.asDatetimeBuilder());
    }

    @Override
    public boolean laterEqualThan(DatetimeBuilder datetimeBuilder) {
        return builder.laterEqualThan(datetimeBuilder.minDayTime());
    }

    @Override
    public boolean before(DateBuilder datetimeBuilder) {
        return builder.before(datetimeBuilder.asDatetimeBuilder());
    }

    @Override
    public boolean before(DatetimeBuilder datetimeBuilder) {
        return builder.before(datetimeBuilder.minDayTime());
    }

    @Override
    public boolean beforeEqual(DateBuilder datetimeBuilder) {
        return builder.beforeEqual(datetimeBuilder.asDatetimeBuilder());
    }

    @Override
    public boolean beforeEqual(DatetimeBuilder datetimeBuilder) {
        return builder.beforeEqual(datetimeBuilder.minDayTime());
    }

    @Override
    public TimeUnit diffFrom(DateBuilder date) {
        return builder.diffFrom(date.asDatetimeBuilder());
    }

    @Override
    public TimeUnit diffFrom(DatetimeBuilder date) {
        return builder.diffFrom(date.minDayTime());
    }

    @Override
    public TimeUnit diffTo(DateBuilder date) {
        return builder.diffTo(date.asDatetimeBuilder());
    }

    @Override
    public TimeUnit diffTo(DatetimeBuilder date) {
        return builder.diffTo(date.minDayTime());
    }

    @Override
    public DatetimeBuilder asDatetimeBuilder() {
        return builder;
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
    public String format(String format) {
        return builder.format(format);
    }

    @Override
    public String format(DateFormatBuilder.Format format) {
        return builder.format(format);
    }

    @Override
    public String format(DateFormatBuilder fmtBuilder) {
        return builder.format(fmtBuilder);
    }

    @Override
    public String format(SimpleDateFormat fmt) {
        return builder.format(fmt);
    }

    @Override
    public FormatBuilderWrapper format() {
        return builder.format();
    }

    @Override
    public String format(TimeZone timeZone, String format) {
        return builder.format(timeZone,format);
    }

    @Override
    public String format(TimeZone timeZone, DateFormatBuilder.Format format) {
        return builder.format(timeZone,format);
    }

    @Override
    public String format(TimeZone timeZone, SimpleDateFormat fmt) {
        return builder.format(timeZone,fmt);
    }

    @Override
    public TimeUnit diffFrom(Date date) {
        return builder.diffTo(date);
    }

    @Override
    public TimeUnit diffTo(Date date) {
        return builder.diffTo(date);
    }

    @Override
    public TimeUnit diffFrom(long date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(long date) {
        return diffTo(date);
    }

    @Override
    public TimeUnit diffFrom(Calendar date) {
        return diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(Calendar date) {
        return builder.diffTo(date);
    }
}
