package me.xethh.utils.dateManipulation;

public interface CalendarDateBuilder <T extends CalendarDateBuilder<T>>{
    T y(int year);
    T ym(int year, Month month);
    T md(Month month, int day);
    T ymd(int year, Month month, int day);

    /*
    Year part
     */
    T minYear();
    T year(final int year);

    /*
    Month part
     */
    T minMonth();

    /**
     * Set the month
     * @param month should be enum of Month
     * @return DateBuilder Object
     */
    T month(final Month month);


    /*
    Day part
     */
    T minDay();
    T day(final int date);
    T firstDayOfMonth();
    T endDayOfMonth();

    //Time operation
    /*
    Operation
     */
    T addYear(final int years);
    T lastYear();
    T nextYear();
    T lastMonth();
    T nextMonth();
    T addMonths(final int months);

    T addDays(final int days);
    T yesterday();
    T tomorrow();

    T nextWeekday(Weekday day);

    T prevWeekday(Weekday day);

    T startOfWeek(Weekday startDay);

    T endOfWeek(Weekday startDay);
}
