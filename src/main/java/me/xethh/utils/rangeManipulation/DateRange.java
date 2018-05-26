package me.xethh.utils.rangeManipulation;

import me.xethh.utils.dateManipulation.DateBuilder;

import java.util.Date;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public class DateRange {

    private Date start,end;
    private DateRange(Date start, Date end){
        this.start = start;
        this.end = end;
    }

    public boolean isValid(){
        return start.getTime()>end.getTime();
    }
}
