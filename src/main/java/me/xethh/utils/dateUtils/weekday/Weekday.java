package me.xethh.utils.dateUtils.weekday;

public enum Weekday {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

    public int getCalWeekDay() {
        if (ordinal() == 0)
            return 7;
        return ordinal();
    }

    public static Weekday getByOrdinal(int day) {
        if (day < 0 || day > 6)
            throw new RuntimeException(
                    String.format("Week Day ordinal should not larger than 6 or smaller than 0 [value input is %d] ", day));
        for (Weekday wd : values())
            if (wd.ordinal() == day)
                return wd;
        throw new RuntimeException(String.format("Suitable value not found [value input is %d] ", day));
    }

    public static Weekday getByCalWeekday(int day) {
        if (day < 1 || day > 7)
            throw new RuntimeException(String.format("Day should not larger than 7 or smaller than 1 [value input is %d] ", day));
        if (day == 7)
            return Sunday;
        else
            return getByOrdinal(day);
    }

    public Weekday nextDay() {
        if (ordinal() == 6)
            return Sunday;
        else
            return getByOrdinal(ordinal() + 1);
    }

    public Weekday prevDay() {
        if (ordinal() == 0)
            return Saturday;
        else
            return getByOrdinal(ordinal() - 1);
    }
}
