package me.xethh.utils.dateManipulation.formatBuilder;

import me.xethh.utils.dateManipulation.datetime.DatetimeBuilder;
import me.xethh.utils.dateManipulation.timezone.BaseTimeZone;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class FormatBuilderWrapper implements FormatWrapper, DateFormatBuilder<FormatBuilderWrapper> {
    DatetimeBuilder builder;
    DateFormatBuilder formatBuilder;
    public FormatBuilderWrapper(DatetimeBuilder builder){
        this.builder = builder;
        this.formatBuilder = DateFormatBuilderImpl.get();
    }
    public FormatBuilderWrapper(DatetimeBuilder builder, DateFormatBuilder formatBuilder){
        this.builder = builder;
        this.formatBuilder = formatBuilder;
    }
    @Override
    public String format() {
        return build().format(builder.asDate());
    }

    @Override
    public FormatBuilderWrapper year4Digit() {
        return new FormatBuilderWrapper(builder, formatBuilder.year4Digit());
    }

    @Override
    public FormatBuilderWrapper year2Digit() {
        return new FormatBuilderWrapper(builder, formatBuilder.year2Digit());
    }

    @Override
    public FormatBuilderWrapper month2Digit() {
        return new FormatBuilderWrapper(builder, formatBuilder.month2Digit());
    }

    @Override
    public FormatBuilderWrapper month3Letters() {
        return new FormatBuilderWrapper(builder, formatBuilder.month3Letters());
    }

    @Override
    public FormatBuilderWrapper monthFullName() {
        return new FormatBuilderWrapper(builder, formatBuilder.monthFullName());
    }

    @Override
    public FormatBuilderWrapper dayWithDigit(int digit) {
        return new FormatBuilderWrapper(builder, formatBuilder.dayWithDigit(digit));
    }

    @Override
    public FormatBuilderWrapper day2Digit() {
        return new FormatBuilderWrapper(builder, formatBuilder.day2Digit());
    }

    @Override
    public FormatBuilderWrapper day1Digit() {
        return new FormatBuilderWrapper(builder, formatBuilder.day1Digit());
    }

    @Override
    public FormatBuilderWrapper hourInDay24() {
        return new FormatBuilderWrapper(builder, formatBuilder.hourInDay24());
    }

    @Override
    public FormatBuilderWrapper hourInDay12() {
        return new FormatBuilderWrapper(builder, formatBuilder.hourInDay12());
    }

    @Override
    public FormatBuilderWrapper apm() {
        return new FormatBuilderWrapper(builder, formatBuilder.apm());
    }

    @Override
    public FormatBuilderWrapper minute() {
        return new FormatBuilderWrapper(builder, formatBuilder.minute());
    }

    @Override
    public FormatBuilderWrapper second() {
        return new FormatBuilderWrapper(builder, formatBuilder.second());
    }

    @Override
    public FormatBuilderWrapper ms() {
        return new FormatBuilderWrapper(builder, formatBuilder.ms());
    }

    @Override
    public FormatBuilderWrapper GeneralTimeZone() {
        return new FormatBuilderWrapper(builder, formatBuilder.GeneralTimeZone());
    }

    @Override
    public FormatBuilderWrapper TimeZoneRFC822() {
        return new FormatBuilderWrapper(builder, formatBuilder.TimeZoneRFC822());
    }

    @Override
    public FormatBuilderWrapper TimeZoneISO8601OneDigit() {
        return new FormatBuilderWrapper(builder, formatBuilder.TimeZoneISO8601OneDigit());
    }

    @Override
    public FormatBuilderWrapper TimeZoneISO8601TwoDigit() {
        return new FormatBuilderWrapper(builder, formatBuilder.TimeZoneISO8601TwoDigit());
    }

    @Override
    public FormatBuilderWrapper TimeZoneISO8601ThreeDigit() {
        return new FormatBuilderWrapper(builder, formatBuilder.TimeZoneISO8601ThreeDigit());
    }

    @Override
    public FormatBuilderWrapper custFormat(String string) {
        return new FormatBuilderWrapper(builder, formatBuilder.custFormat(string));
    }

    @Override
    public FormatBuilderWrapper pad(String string) {
        return new FormatBuilderWrapper(builder, formatBuilder.pad(string));
    }

    @Override
    public FormatBuilderWrapper hyphen() {
        return new FormatBuilderWrapper(builder, formatBuilder.hyphen());
    }

    @Override
    public FormatBuilderWrapper space() {
        return new FormatBuilderWrapper(builder, formatBuilder.space());
    }

    @Override
    public FormatBuilderWrapper colon() {
        return new FormatBuilderWrapper(builder, formatBuilder.colon());
    }

    @Override
    public FormatBuilderWrapper dot() {
        return new FormatBuilderWrapper(builder, formatBuilder.dot());
    }

    @Override
    public FormatBuilderWrapper underLine() {
        return new FormatBuilderWrapper(builder, formatBuilder.underLine());
    }

    @Override
    public FormatBuilderWrapper v1() {
        return new FormatBuilderWrapper(builder, formatBuilder.v1());
    }

    @Override
    public FormatBuilderWrapper v2() {
        return new FormatBuilderWrapper(builder, formatBuilder.v2());
    }

    @Override
    public FormatBuilderWrapper v3() {
        return new FormatBuilderWrapper(builder, formatBuilder.v3());
    }

    @Override
    public FormatBuilderWrapper v4() {
        return new FormatBuilderWrapper(builder, formatBuilder.v4());
    }

    @Override
    public FormatBuilderWrapper v5() {
        return new FormatBuilderWrapper(builder, formatBuilder.v5());
    }

    @Override
    public FormatBuilderWrapper v6() {
        return new FormatBuilderWrapper(builder, formatBuilder.v6());
    }

    @Override
    public FormatBuilderWrapper v7() {
        return new FormatBuilderWrapper(builder, formatBuilder.v7());
    }

    @Override
    public FormatBuilderWrapper v8() {
        return new FormatBuilderWrapper(builder, formatBuilder.v8());
    }

    @Override
    public FormatBuilderWrapper v9() {
        return new FormatBuilderWrapper(builder, formatBuilder.v9());
    }

    @Override
    public FormatBuilderWrapper v10() {
        return new FormatBuilderWrapper(builder, formatBuilder.v10());
    }

    @Override
    public FormatBuilderWrapper v(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v(v));
    }

    @Override
    public FormatBuilderWrapper v1(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v1(v));
    }

    @Override
    public FormatBuilderWrapper v2(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v2(v));
    }

    @Override
    public FormatBuilderWrapper v3(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v3(v));
    }

    @Override
    public FormatBuilderWrapper v4(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder. v4(v));
    }

    @Override
    public FormatBuilderWrapper v5(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v5(v));
    }

    @Override
    public FormatBuilderWrapper v6(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v6(v));
    }

    @Override
    public FormatBuilderWrapper v7(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v7(v));
    }

    @Override
    public FormatBuilderWrapper v8(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v8(v));
    }

    @Override
    public FormatBuilderWrapper v9(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v9(v));
    }

    @Override
    public FormatBuilderWrapper v10(String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v10(v));
    }

    @Override
    public FormatBuilderWrapper v(String k, String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.v(k,v));
    }

    @Override
    public String getVariable(String k) {
        return formatBuilder.getVariable(k);
    }

    @Override
    public FormatBuilderWrapper setVariable(String k, String v) {
        return new FormatBuilderWrapper(builder, formatBuilder.setVariable(k,v));
    }

    @Override
    public FormatBuilderWrapper timeZone(BaseTimeZone timeZone) {
        return new FormatBuilderWrapper(builder, formatBuilder.timeZone(timeZone));
    }

    @Override
    public FormatBuilderWrapper timeZone(TimeZone timeZone) {
        return new FormatBuilderWrapper(builder, formatBuilder.timeZone(timeZone));
    }

    @Override
    public SimpleDateFormat build() {
        return formatBuilder.build();
    }
}
