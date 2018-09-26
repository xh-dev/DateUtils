package me.xethh.utils.dateManipulation;

import me.xethh.utils.TimeUnit;
import me.xethh.utils.rangeManipulation.BuilderOperation;
import me.xethh.utils.rangeManipulation.DatetimeRange;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class DatetimeRangeContainedBuilder implements DateBuilder<DatetimeRangeContainedBuilder>,BuilderWrapper<DatetimeRange> {
    private DateBuilderImpl builder;
    DatetimeRange parent;
    /*
    Constructors
     */
    protected DatetimeRangeContainedBuilder(final Date date,DatetimeRange range){
        this.parent= range;
        builder= DateFactory.from(date);
    }
    protected DatetimeRangeContainedBuilder(List<Build> builds,DatetimeRange range){
        this.parent= range;
        if(builder==null)
            builder = DateFactory.raw();
        builder.getBuilds().addAll(builds);
    }
    protected DatetimeRangeContainedBuilder(List<Build> builds, Build build, DatetimeRange range){
        this(builds,range);
        builder.getBuilds().add(build);
    }
    @Override
    public DatetimeRangeContainedBuilder y(int year) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.y(year);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ym(int year, Month month) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.ym(year,month);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ymd(int year, Month month, int day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.ymd(year,month,day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hmsms(int hour, int minute, int second, int mSecond) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.hmsms(hour,minute,second,mSecond);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hms(int hour, int minute, int second) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.hms(hour,minute,second);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hm(int hour, int minute) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.hm(hour,minute);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder h(int hour) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.h(hour);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder year(int year) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.year(year);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder month(Month month) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.month(month);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minDay() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minDay();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder day(int date) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.day(date);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder firstDayOfMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.firstDayOfMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder endDayOfMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.endDayOfMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minHour() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minHour();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxHour() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder.maxHour();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder hour(int hour) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.hour(hour);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMinute() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minMinute();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxMinute() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.maxMinute();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minute(int min) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minute(min);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minSecond() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minSecond();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxSecond() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.maxSecond();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder second(int second) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.second(second);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minMs() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minMs();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxMs() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.maxMs();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder ms(int ms) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.ms(ms);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder timeZone(BaseTimeZone timeZone) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.timeZone(timeZone);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder maxDayTime() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.maxDayTime();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder minDayTime() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.minDayTime();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder timePartOnly() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.timePartOnly();
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
    public List<Build> getBuilds() {
        return builder.getBuilds();
    }

    @Override
    public DateInfo view() {
        return builder.view();
    }

    @Override
    public DatetimeRange rangeTo(DatetimeRangeContainedBuilder date) {
        return DatetimeRange.of(builder.asDate(),date.asDate());
    }

    @Override
    public DatetimeRange rangeFrom(DatetimeRangeContainedBuilder date) {
        return DatetimeRange.of(date.asDate(),builder.asDate());
    }

    @Override
    public DatetimeRange rangeTo(Date date) {
        return DatetimeRange.of(builder.asDate(),date);
    }

    @Override
    public DatetimeRange rangeFrom(Date date) {
        return DatetimeRange.of(date,builder.asDate());
    }

    @Override
    public DatetimeRange rangeWithBuilder(BuilderOperation start, BuilderOperation end) {
        return DatetimeRange.of(start.oper().asDate(),end.oper().asDate());
    }

    @Override
    public DatetimeRangeContainedBuilder addYear(int years) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addYear(years);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder lastYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.lastYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextYear() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.nextYear();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder lastMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.lastMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextMonth() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.nextMonth();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMonths(int months) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addMonths(months);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addDays(int days) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addDays(days);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder yesterday() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.yesterday();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder tomorrow() {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.tomorrow();
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder nextWeekday(Weekday day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.nextWeekday(day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder prevWeekday(Weekday day) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.prevWeekday(day);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder startOfWeek(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.startOfWeek(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder endOfWeek(Weekday startDay) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.endOfWeek(startDay);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addTime(long time) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addTime(time);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addHours(int hours) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addHours(hours);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMins(int mins) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addMins(mins);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addSecond(int sec) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addSecond(sec);
        return bd;
    }

    @Override
    public DatetimeRangeContainedBuilder addMS(int ms) {
        DatetimeRangeContainedBuilder bd = new DatetimeRangeContainedBuilder(builder.getBuilds(), parent);
        bd.builder=bd.builder.addMS(ms);
        return bd;
    }

    @Override
    public boolean sameDatetime(DatetimeRangeContainedBuilder builder) {
        return this.builder.sameDatetime(builder.builder);
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
    public boolean sameYear(DatetimeRangeContainedBuilder builder) {
        return this.builder.sameYear(builder.builder);
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
    public boolean sameMonth(DatetimeRangeContainedBuilder builder) {
        return this.builder.sameMonth(builder.builder);
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
    public boolean sameDay(DatetimeRangeContainedBuilder builder) {
        return this.builder.sameDay(builder.builder);
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
    public boolean sameTime(DatetimeRangeContainedBuilder dateBuilder) {
        return this.builder.sameTime(dateBuilder.builder);
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
    public boolean sameHMS(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.sameHMS(dateBuilder.builder);
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
    public boolean sameHM(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.sameHM(dateBuilder.builder);
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
    public boolean laterThan(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.laterThan(dateBuilder.builder);
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
    public boolean laterEqualThan(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.laterEqualThan(dateBuilder.builder);
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
    public boolean before(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.before(dateBuilder.builder);
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
    public boolean beforeEqual(DatetimeRangeContainedBuilder dateBuilder) {
        return builder.beforeEqual(dateBuilder.builder);
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
    public TimeUnit diffFrom(Date date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(Date date) {
        return builder.diffTo(date);
    }

    @Override
    public TimeUnit diffFrom(DateBuilder date) {
        return builder.diffFrom(date);
    }

    @Override
    public TimeUnit diffTo(DateBuilder date) {
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
    public DatetimeRange back() {
        DatetimeRange range;
        if(parent.getEditingMode()==DatetimeRange.EDITING.START) {
            range = DatetimeRange.of(asDate(),parent.getEnd());
            range.clearEditingMode();
            return range;
        }
        if(parent.getEditingMode()==DatetimeRange.EDITING.END) {
            range = DatetimeRange.of(parent.getStart(),asDate());
            range.clearEditingMode();
            return range;
        }
        return parent;
    }
}
