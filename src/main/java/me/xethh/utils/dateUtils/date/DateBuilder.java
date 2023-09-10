package me.xethh.utils.dateUtils.date;

import me.xethh.utils.dateUtils.baseInterface.CalendarDateBuilder;
import me.xethh.utils.dateUtils.dataInfo.DateInfo;
import me.xethh.utils.dateUtils.datetime.DatetimeBuilder;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.formatBuilder.FormatBuilderWrapper;
import me.xethh.utils.dateUtils.interfaces.Build;
import me.xethh.utils.dateUtils.month.Month;
import me.xethh.utils.dateUtils.range.datetime.DatetimeRange;
import me.xethh.utils.dateUtils.timeUnit.TimeUnit;
import me.xethh.utils.dateUtils.weekday.Weekday;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateBuilder implements DateBuilderInterface<DateBuilder> {
    private DatetimeBuilder builder;

    public DateBuilder() {
        this(DatetimeFactory.instance().raw());
    }

    public DateBuilder(Date builder, Build build) {
        this(DatetimeFactory.instance().from(builder, build));
    }

    public DateBuilder(Date builder) {
        this(DatetimeFactory.instance().from(builder));
    }

    public DateBuilder(Calendar cal, Build build) {
        this(DatetimeFactory.instance().from(cal, build));
    }

    public DateBuilder(Calendar cal) {
        this(DatetimeFactory.instance().from(cal));
    }

    public DateBuilder(DatetimeBuilder builder) {
        this.builder = builder.minDayTime();
    }

    @Override
    public DateBuilder y(int year) {
        return new DateBuilder(builder.y(year));
    }

    @Override
    public DateBuilder m(Month month) {
        return new DateBuilder(builder.m(month));
    }

    @Override
    public DateBuilder ym(int year, Month month) {
        return new DateBuilder(builder.ym(year, month));
    }

    @Override
    public DateBuilder md(Month month, int day) {
        return new DateBuilder(builder.md(month, day));
    }

    @Override
    public DateBuilder ymd(int year, Month month, int day) {
        return new DateBuilder(builder.ymd(year, month, day));
    }

    @Override
    public DateBuilder d(int day) {
        return new DateBuilder(builder.d(day));
    }

    @Override
    public DateBuilder minYear() {
        return new DateBuilder(builder.minYear());
    }

    @Override
    public DateBuilder year(int year) {
        return new DateBuilder(builder.year(year));
    }

    @Override
    public DateBuilder minMonth() {
        return new DateBuilder(builder.minMonth());
    }

    @Override
    public DateBuilder month(Month month) {
        return new DateBuilder(builder.month(month));
    }

    @Override
    public DateBuilder maxMonth() {
        return new DateBuilder(builder.maxMonth());
    }

    @Override
    public DateBuilder minDay() {
        return new DateBuilder(builder.minDay());
    }

    @Override
    public DateBuilder day(int date) {
        return new DateBuilder(builder.day(date));
    }

    @Override
    public DateBuilder maxDay() {
        return new DateBuilder(builder.maxDay());
    }

    @Override
    public DateBuilder firstDayOfMonth() {
        return new DateBuilder(builder.firstDayOfMonth());
    }

    @Override
    public DateBuilder endDayOfMonth() {
        return new DateBuilder(builder.endDayOfMonth());
    }

    @Override
    public DateBuilder addYear(int years) {
        return new DateBuilder(builder.addYear(years));
    }

    @Override
    public DateBuilder lastYear() {
        return new DateBuilder(builder.lastYear());
    }

    @Override
    public DateBuilder nextYear() {
        return new DateBuilder(builder.nextYear());
    }

    @Override
    public DateBuilder lastMonth() {
        return new DateBuilder(builder.lastMonth());
    }

    @Override
    public DateBuilder nextMonth() {
        return new DateBuilder(builder.nextMonth());
    }

    @Override
    public DateBuilder addMonths(int months) {
        return new DateBuilder(builder.addMonths(months));
    }

    @Override
    public DateBuilder addDays(int days) {
        return new DateBuilder(builder.addDays(days));
    }

    @Override
    public DateBuilder yesterday() {
        return new DateBuilder(builder.yesterday());
    }

    @Override
    public DateBuilder tomorrow() {
        return new DateBuilder(builder.tomorrow());
    }

    @Override
    public DateBuilder nextWeekday(Weekday startDay) {
        return new DateBuilder(builder.nextWeekday(startDay));
    }

    @Override
    public DateBuilder prevWeekday(Weekday startDay) {
        return new DateBuilder(builder.prevWeekday(startDay));
    }

    @Override
    public DateBuilder startOfWeek(Weekday startDay) {
        return new DateBuilder(builder.startOfWeek(startDay));
    }

    @Override
    public DateBuilder endOfWeek(Weekday startDay) {
        return new DateBuilder(builder.endOfWeek(startDay));
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
        return asCalendar().getTimeZone();
    }

    @Override
    public DateBuilder now() {
        return new DateBuilder(builder.now());
    }

    @Override
    public DateInfo view() {
        return builder.view();
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
        return builder.minDayTime().rangeTo(builder.maxDayTime().asDate());
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
    public <X extends CalendarDateBuilder<X>> DatetimeRange rangeTo(X date) {
        return builder.rangeTo(date.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> DatetimeRange rangeFrom(X date) {
        return builder.rangeFrom(date.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameDate(X builder) {
        return this.builder.sameDate(builder.asDate());
    }

    @Override
    public boolean sameDate(Long longDate) {
        return builder.sameDate(longDate);
    }

    @Override
    public boolean sameDate(Date date) {
        return builder.sameDate(date);
    }

    @Override
    public boolean sameDate(Calendar cal) {
        return builder.sameDate(cal);
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameYear(X builder) {
        return this.builder.sameYear(builder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameMonth(X builder) {
        return this.builder.sameMonth(builder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean sameDay(X builder) {
        return this.builder.sameDay(builder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean laterThan(X datetimeBuilder) {
        return builder.laterThan(datetimeBuilder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean laterEqualThan(X datetimeBuilder) {
        return builder.laterEqualThan(datetimeBuilder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean before(X datetimeBuilder) {
        return builder.before(datetimeBuilder.asDate());
    }

    @Override
    public <X extends CalendarDateBuilder<X>> boolean beforeEqual(X datetimeBuilder) {
        return builder.beforeEqual(datetimeBuilder.asDate());
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
    public ZonedDateTime asZonedDateTime() {
        var cal = asCalendar();
        return ZonedDateTime.ofInstant(cal.getTime().toInstant(), cal.getTimeZone().toZoneId());
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
    public String format(DateFormatBuilderInterface.Format format) {
        return builder.format(format);
    }

    @Override
    public <X extends DateFormatBuilderInterface<X>> String format(X fmtBuilder) {
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
        return builder.format(timeZone, format);
    }

    @Override
    public String format(TimeZone timeZone, DateFormatBuilderInterface.Format format) {
        return builder.format(timeZone, format);
    }

    @Override
    public<X extends DateFormatBuilderInterface<X>> String format(TimeZone timeZone, X fmtBuilder) {
        return builder.format(timeZone, fmtBuilder);
    }

    @Override
    public String format(TimeZone timeZone, SimpleDateFormat fmt) {
        return builder.format(timeZone, fmt);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateBuilder builder1 = (DateBuilder) o;
        return Objects.equals(builder, builder1.builder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(builder);
    }
}
