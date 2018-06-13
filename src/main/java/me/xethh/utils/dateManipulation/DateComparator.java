package me.xethh.utils.dateManipulation;

import java.util.Calendar;
import java.util.Date;

public class DateComparator {
    DateBuilder builder = null;
    private DateComparator(DateBuilder builder){
        this.builder = builder;
    }

    public static DateComparator now(){
        return new DateComparator(DateBuilder.now());
    }
    public static DateComparator from(DateBuilder builder){
        return new DateComparator(builder);
    }
    public static DateComparator from(Long dateLong){
        return new DateComparator(DateBuilder.from(new Date(dateLong)));
    }
    public static DateComparator from(Date date){
        return new DateComparator(DateBuilder.from(date));
    }
    public static DateComparator from(Calendar calendar){
        return new DateComparator(DateBuilder.from(calendar));
    }

    public DateBuilder asBuilder(){
        return this.builder;
    }
    public Date asDate(){
        return this.builder.asDate();
    }
    public Long asLong(){
        return this.builder.asDate().getTime();
    }
    public Calendar asCalendar(){
        return this.builder.asCalendar();
    }
    public DateInfo view(){
        return DateInfo.from(builder.asDate());
    }
    public TimeOperation operate(){
        return TimeOperation.from(builder);
    }

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
        return asBuilder().view().year().equals(builder.view().year());
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
        return this.builder.minDayTime().view().month().equals(builder.minDayTime().view().month());
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
        return this.builder.minDayTime().equals(builder.minDayTime());
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
        return builder.timePartOnly().equals(dateBuilder.timePartOnly());
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
        return builder.timePartOnly().minMs().equals(dateBuilder.timePartOnly().minMs());
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
        return builder.timePartOnly().minSecond().minMs().equals(dateBuilder.timePartOnly().minSecond().minMs());
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
        return builder.asLong()>(longDate);
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
        return builder.asLong()>=(longDate);
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
}
