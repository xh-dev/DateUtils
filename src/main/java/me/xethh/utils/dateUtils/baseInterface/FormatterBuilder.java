package me.xethh.utils.dateUtils.baseInterface;

import me.xethh.utils.dateUtils.formatBuilder.DateFormatBuilderInterface;
import me.xethh.utils.dateUtils.formatBuilder.FormatBuilderWrapper;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Interface for formatting date
 */
public interface FormatterBuilder {
    /**
     * formatting date builder with format
     *
     * @param format formatting string
     * @return formatted date
     */
    String format(String format);

    /**
     * formatting date builder with format
     *
     * @param format Format Enum included in this library
     * @return formatted date
     */
    String format(DateFormatBuilderInterface.Format format);

    /**
     * formatting date builder with format builder
     *
     * @param fmtBuilder format builder
     * @return formatted date
     */
    String format(DateFormatBuilderInterface fmtBuilder);

    /**
     * formatting date builder with {@link java.text.SimpleDateFormat}
     *
     * @param fmt {@link java.text.SimpleDateFormat}
     * @return formatted date
     */
    String format(SimpleDateFormat fmt);

    /**
     * Access the format builder wrapper to modify format freely
     *
     * @return FormatBuilderWrapper
     */
    FormatBuilderWrapper format();

    /**
     * Format builder with time zone and formatting string
     *
     * @param timeZone {@link java.util.TimeZone}
     * @param format   formatting string
     * @return formatted date
     */
    String format(TimeZone timeZone, String format);

    /**
     * Format builder with time zone and date format builder
     *
     * @param timeZone time zone
     * @param format   date format builder predefined formats
     * @return formatted date
     */
    String format(TimeZone timeZone, DateFormatBuilderInterface.Format format);

    /**
     * Format builder with time zone and date format builder
     *
     * @param timeZone   time zone
     * @param fmtBuilder date format builder
     * @return formatted date
     */
    String format(TimeZone timeZone, DateFormatBuilderInterface fmtBuilder);

    /**
     * Format builder with time zone and {@link java.text.SimpleDateFormat}
     *
     * @param timeZone time zone
     * @param fmt      {@link java.text.SimpleDateFormat}
     * @return formatted date
     */
    String format(TimeZone timeZone, SimpleDateFormat fmt);
}
