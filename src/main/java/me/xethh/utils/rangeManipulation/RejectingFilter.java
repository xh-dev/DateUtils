package me.xethh.utils.rangeManipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xethhung
 * Created on 8/30/2018
 */
public class RejectingFilter implements RangeFilter<RejectingFilter>{
    private DatetimeRange range;
    private List<OverlapType> rejectList = new LinkedList();
    public RejectingFilter(DatetimeRange range){
        this(range,new LinkedList<OverlapType>());
    }
    public RejectingFilter(DatetimeRange range, List<OverlapType> rejectList){
        this.range = range;
        this.rejectList.addAll(rejectList);
    }

    @Override
    public RejectingFilter item(OverlapType type){
        List<OverlapType> list = new ArrayList<>();
        list.add(type);
        list.addAll(this.rejectList);
        return new RejectingFilter(range,list);
    }

    @Override
    public RejectingFilter items(OverlapType[] types) {
        List<OverlapType> list = new ArrayList<>();
        if(types!=null){
            for(OverlapType type: types)
                list.add(type);
        }
        return items(list);
    }

    @Override
    public RejectingFilter items(Collection<OverlapType> types) {
        List<OverlapType> list = new ArrayList<>();
        list.addAll(list);
        if(types!=null){
            for(OverlapType type: types)
                list.add(type);
        }
        return new RejectingFilter(range,list);
    }

    public boolean isRejected(DatetimeRange newRange){
        if(rejectList.contains(range.overlappingPattern(newRange)))
            return true;
        else
            return false;
    }
    public boolean isAccepted(DatetimeRange newRange){
        return !isRejected(newRange);
    }
}
