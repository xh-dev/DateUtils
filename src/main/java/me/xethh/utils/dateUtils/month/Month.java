package me.xethh.utils.dateUtils.month;

/**
 * @author xethhung
 * Created on 5/25/2018
 */
public enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    public static Month ofCalendar(int num) {
        for (Month value : Month.values())
            if (num == value.ordinal() + 1)
                return value;
        throw new RuntimeException(String.format("Value[%d] not support for calender month", num));
    }

    public static Month ofOrdinal(int num) {
        for (Month value : Month.values())
            if (num == value.ordinal())
                return value;
        throw new RuntimeException(String.format("Value[%d] not support for month", num));
    }

    public int toCalNumber() {
        return ordinal() + 1;
    }

    public int toJavaCalNumber() {
        return ordinal();
    }

    public Month previous() {
        if (ordinal() == 0)
            return DEC;
        else
            return Month.values()[ordinal() - 1];
    }

    public Month next() {
        if (ordinal() == 11)
            return JAN;
        else
            return Month.values()[ordinal() + 1];
    }

    public java.time.Month asTimeMonth(){
        return java.time.Month.of(toCalNumber());
    }
}

