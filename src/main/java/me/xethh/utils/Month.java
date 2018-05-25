package me.xethh.utils;

/**
 * @author xethhung
 * @date 5/25/2018
 */
public enum Month{
    JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC;

    public int toNumber(){
        return ordinal()+1;
    }

    public static Month ofOrdinal(int num){
        for(Month value:Month.values())
            if(num==value.ordinal())
                return value;
        throw new RuntimeException(String.format("Value[%d] not support for month", num));
    }

    public Month previous(){
        if(ordinal()==0)
            return DEC;
        else
            return Month.values()[ordinal()-1];
    }

    public Month next(){
        if(ordinal()==11)
            return JAN;
        else
            return Month.values()[ordinal()+1];
    }
}

