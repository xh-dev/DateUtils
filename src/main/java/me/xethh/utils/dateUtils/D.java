package me.xethh.utils.dateUtils;

import me.xethh.utils.dateUtils.dateFactory.DateFactory;
import me.xethh.utils.dateUtils.datetimeFactory.DatetimeFactory;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilder;
import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;

/**
 * Short cut for accessing DatetimeBuilderFactor and DateBuilderFactory
 */
public class D {
    /**
     * Provide access to DatetimeFactory
     *
     * @return Default DatetimeFactory Object
     */
    public static DatetimeFactory dt() {
        return DatetimeFactory.instance();
    }

    /**
     * Provide access to DateFactory
     *
     * @return Default DateFactory Object
     */
    public static DateFactory d() {
        return DateFactory.instance();
    }

    /**
     * Provide access to DateFormatBuilder
     *
     * @return Raw {@link DateFormatBuilder} instance
     */
    public static DateFormatBuilder f() {
        return DateFormatBuilderInterface.get();
    }
}
