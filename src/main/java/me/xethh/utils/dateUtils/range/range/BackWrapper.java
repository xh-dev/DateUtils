package me.xethh.utils.dateUtils.range.range;

import me.xethh.utils.dateUtils.interfaces.DatetimeBackWrapper;

public interface BackWrapper<Editor extends DatetimeBackWrapper<Editor, T>, T extends Range> {
    Editor editStart();

    Editor editEnd();
}
