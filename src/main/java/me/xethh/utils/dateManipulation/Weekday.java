package me.xethh.utils.dateManipulation;

public enum Weekday {
    Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday;
    public int getCalWeekDay(){
        return ordinal()+1;
    }
}
