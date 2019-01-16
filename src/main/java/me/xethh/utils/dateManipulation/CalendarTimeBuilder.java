package me.xethh.utils.dateManipulation;

public interface CalendarTimeBuilder<T extends CalendarTimeBuilder<T>> {
    T hmsms(int hour, int minute, int second, int mSecond);
    T hms(int hour, int minute, int second);
    T hm(int hour, int minute);
    T h(int hour);


    /*
    Hour part
     */
    T minHour();
    T maxHour();
    T hour(final int hour);

    /*
    Minute part
     */
    T minMinute();
    T maxMinute();
    T minute(final int min);

    /*
    Second part
     */
    T minSecond();
    T maxSecond();
    T second(final int second);

    /*
    Millisecond
     */
    T minMs();
    T maxMs();
    T ms(final int ms);

    /*
    Time manipulation
     */

    /**
     * Cast the date builder object to maximum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.999
     * @return maximum date time value up to millisecond
     */
    T maxDayTime();
    /**
     * Cast the date builder object to maximum day time of the day up to second
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:59.000
     * @return maximum date time value up to second
     */
    T maxDayTimeSec();
    /**
     * Cast the date builder object to maximum day time of the day up to minutes
     * 2018-11-12 23:33:44.444 to 2018-11-12 23:59:00.000
     * @return maximum date time value up to minutes
     */
    T maxDayTimeMin();
    /**
     * Cast the date builder object to minimum day time of the day up to millisecond
     * 2018-11-12 23:33:44.444 to 2018-11-12 00:00:00.000
     * @return minimum date time value up to millisecond
     */
    T minDayTime();
}
