package me.xethh.utils.dateUtils.weekday;

/**
 * Enum for weekday
 */
public enum Weekday {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;

    /**
     * Weekday from ordinal form <br>
     * 0 {@literal ->} Sunday <br>
     * 1 {@literal ->} Monday <br>
     * 2 {@literal ->} Tuesday <br>
     * 3 {@literal ->} Wednesday <br>
     * 4 {@literal ->} Thursday <br>
     * 5 {@literal ->} Friday <br>
     * 6 {@literal ->} Saturday <br>
     *
     * @param day day of ordinal
     * @return Weekday
     */
    public static Weekday getByOrdinal(int day) {
        if (day < 0 || day > 6)
            throw new RuntimeException(
                    String.format("Week Day ordinal should not larger than 6 or smaller than 0 [value input is %d] ", day));
        for (Weekday wd : values())
            if (wd.ordinal() == day)
                return wd;
        throw new RuntimeException(String.format("Suitable value not found [value input is %d] ", day));
    }

    /**
     * Weekday from number literal form <br>
     * 0 {@literal ->} Sunday <br>
     * 1 {@literal ->} Monday <br>
     * 2 {@literal ->} Tuesday <br>
     * 3 {@literal ->} Wednesday <br>
     * 4 {@literal ->} Thursday <br>
     * 5 {@literal ->} Friday <br>
     * 6 {@literal ->} Saturday <br>
     * 7 {@literal ->} Sunday <br>
     *
     * @param day day in number form
     * @return Weekday
     */
    public static Weekday getByCalWeekday(int day) {
        if (day < 1 || day > 7)
            throw new RuntimeException(String.format("Day should not larger than 7 or smaller than 1 [value input is %d] ", day));
        if (day == 7)
            return Sunday;
        else
            return getByOrdinal(day);
    }

    /**
     * Weekday in number form <br>
     * 1 {@literal ->} Monday <br>
     * 2 {@literal ->} Tuesday <br>
     * 3 {@literal ->} Wednesday <br>
     * 4 {@literal ->} Thursday <br>
     * 5 {@literal ->} Friday <br>
     * 6 {@literal ->} Saturday <br>
     * 7 {@literal ->} Sunday <br>
     *
     * @return number liberal of weekday
     */
    public int getCalWeekDay() {
        if (ordinal() == 0)
            return 7;
        return ordinal();
    }

    /**
     * The next weekday <br>
     * {@literal e.g.} Saturday {@literal ->} Sunday <br>
     *
     * @return Weekday
     */
    public Weekday nextDay() {
        if (ordinal() == 6)
            return Sunday;
        else
            return getByOrdinal(ordinal() + 1);
    }

    /**
     * The previous weekday <br>
     * {@literal e.g.} Monday {@literal ->} Sunday
     *
     * @return Weekday
     */
    public Weekday prevDay() {
        if (ordinal() == 0)
            return Saturday;
        else
            return getByOrdinal(ordinal() - 1);
    }
}
