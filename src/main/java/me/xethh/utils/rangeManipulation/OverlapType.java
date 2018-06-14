package me.xethh.utils.rangeManipulation;

/**
 * @author xethhung
 * @date 6/13/2018
 */
public enum OverlapType {
    Covering,           //[10-20] compare to [12-19]
    CoveringOnLeft,     //[10-20] compare to [10-15]
    CoveringOnRight,    //[10-20] compare to [15-20]
    CoveredBy,          //[12-19] compare to [10-20]
    CoveredOnLeft,      //[10-15] compare to [10-20]
    CoveredOnRight,     //[15-20] compare to [10-20]
    JoinOnLeft,         //[15-20] compare to [10-15]
    JoinOnRight,        //[10-15] compare to [15-20]
    OverlapOnLeft,      //[10-17] compare to [13-20]
    OverLapOnRight,     //[13-20] compare to [10-17]
    Same,               //[5-10] compare to [5-10]

    ComesFirst,         //[1-5] compare to [6-10]
    ComesLater,         //[6-10] compare to [1-5]

    TargetIsNull,       //Compare target is null
    TargetInvalid,      //Compare target is not a valid datetime range
    Invalid,;           //datetime range is not valid

}
