package me.xethh.utils.dateUtils.range.datetime;

import me.xethh.utils.dateUtils.range.OverlapType;
import me.xethh.utils.dateUtils.range.range.RangeFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xethhung
 * Created on 8/30/2018
 */
public class AcceptingFilter implements RangeFilter<AcceptingFilter> {
    private DatetimeRange range;
    private List<OverlapType> acceptList = new LinkedList();
    public AcceptingFilter(DatetimeRange range){
        this(range,new LinkedList<OverlapType>());
    }
    public AcceptingFilter(DatetimeRange range, List<OverlapType> acceptList){
        this.range = range;
        this.acceptList.addAll(acceptList);
    }

    @Override
    public AcceptingFilter item(OverlapType type){
        List<OverlapType> list = new ArrayList<>();
        list.add(type);
        list.addAll(this.acceptList);
        return new AcceptingFilter(range,list);
    }

    @Override
    public AcceptingFilter items(OverlapType[] types) {
        List<OverlapType> list = new ArrayList<>();
        if(types!=null){
            for(OverlapType type: types)
                list.add(type);
        }
        return items(list);
    }

    @Override
    public AcceptingFilter items(Collection<OverlapType> types) {
        List<OverlapType> list = new ArrayList<>();
        list.addAll(this.acceptList);
        if(types!=null){
            for(OverlapType type: types)
                list.add(type);
        }
        return new AcceptingFilter(range,list);
    }

    public boolean isAccepted(DatetimeRange newRange){
        if(acceptList.contains(range.overlappingPattern(newRange)))
            return true;
        else
            return false;
    }
    public boolean isRejected(DatetimeRange newRange){
        return !isAccepted(newRange);
    }
}
