package me.xethh.utils.rangeManipulation.range;

import me.xethh.utils.dateManipulation.buildInterfaces.DatetimeBackWrapper;

public interface BackWrapper<Editor extends DatetimeBackWrapper<Editor, T>, T extends Range> {
    Editor editStart();

    Editor editEnd();
}
