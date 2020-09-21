package me.xethh.utils.dateUtils.formatBuilder;

import me.xethh.utils.dateUtils.datetime.DatetimeBuilderInterface;
import me.xethh.utils.dateUtils.timezone.BaseTimeZone;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 7/19/2018
 */
public class FormatBuilderWrapper<D extends DatetimeBuilderInterface<D>> implements FormatWrapper, DateFormatBuilderInterface<FormatBuilderWrapper<D>> {
    D builder;
    DateFormatBuilder formatBuilder;

    public FormatBuilderWrapper(D builder) {
        this.builder = builder;
        this.formatBuilder = DateFormatBuilder.get();
    }

    public FormatBuilderWrapper(D builder, DateFormatBuilder formatBuilder) {
        this.builder = builder;
        this.formatBuilder = formatBuilder;
    }

    @Override
    public String format() {
        return build().format(builder.asDate());
    }

    @Override
    public FormatBuilderWrapper<D> year4Digit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.year4Digit());
    }

    @Override
    public FormatBuilderWrapper<D> year2Digit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.year2Digit());
    }

    @Override
    public FormatBuilderWrapper<D> month2Digit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.month2Digit());
    }

    @Override
    public FormatBuilderWrapper<D> month3Letters() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.month3Letters());
    }

    @Override
    public FormatBuilderWrapper<D> monthFullName() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.monthFullName());
    }

    @Override
    public FormatBuilderWrapper<D> dayWithDigit(int digit) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.dayWithDigit(digit));
    }

    @Override
    public FormatBuilderWrapper<D> day2Digit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.day2Digit());
    }

    @Override
    public FormatBuilderWrapper<D> day1Digit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.day1Digit());
    }

    @Override
    public FormatBuilderWrapper<D> hourInDay24() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.hourInDay24());
    }

    @Override
    public FormatBuilderWrapper<D> hourInDay12() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.hourInDay12());
    }

    @Override
    public FormatBuilderWrapper<D> apm() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.apm());
    }

    @Override
    public FormatBuilderWrapper<D> minute() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.minute());
    }

    @Override
    public FormatBuilderWrapper<D> second() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.second());
    }

    @Override
    public FormatBuilderWrapper<D> ms() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.ms());
    }

    @Override
    public FormatBuilderWrapper<D> GeneralTimeZone() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.GeneralTimeZone());
    }

    @Override
    public FormatBuilderWrapper<D> TimeZoneRFC822() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.TimeZoneRFC822());
    }

    @Override
    public FormatBuilderWrapper<D> TimeZoneISO8601OneDigit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.TimeZoneISO8601OneDigit());
    }

    @Override
    public FormatBuilderWrapper<D> TimeZoneISO8601TwoDigit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.TimeZoneISO8601TwoDigit());
    }

    @Override
    public FormatBuilderWrapper<D> TimeZoneISO8601ThreeDigit() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.TimeZoneISO8601ThreeDigit());
    }

    @Override
    public FormatBuilderWrapper<D> custFormat(String string) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.custFormat(string));
    }

    @Override
    public FormatBuilderWrapper<D> pad(String string) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.pad(string));
    }

    @Override
    public FormatBuilderWrapper<D> hyphen() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.hyphen());
    }

    @Override
    public FormatBuilderWrapper<D> space() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.space());
    }

    @Override
    public FormatBuilderWrapper<D> colon() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.colon());
    }

    @Override
    public FormatBuilderWrapper<D> dot() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.dot());
    }

    @Override
    public FormatBuilderWrapper<D> underLine() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.underLine());
    }

    @Override
    public FormatBuilderWrapper<D> v1() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v1());
    }

    @Override
    public FormatBuilderWrapper<D> v2() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v2());
    }

    @Override
    public FormatBuilderWrapper<D> v3() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v3());
    }

    @Override
    public FormatBuilderWrapper<D> v4() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v4());
    }

    @Override
    public FormatBuilderWrapper<D> v5() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v5());
    }

    @Override
    public FormatBuilderWrapper<D> v6() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v6());
    }

    @Override
    public FormatBuilderWrapper<D> v7() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v7());
    }

    @Override
    public FormatBuilderWrapper<D> v8() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v8());
    }

    @Override
    public FormatBuilderWrapper<D> v9() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v9());
    }

    @Override
    public FormatBuilderWrapper<D> v10() {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v10());
    }

    @Override
    public FormatBuilderWrapper<D> v(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v(v));
    }

    @Override
    public FormatBuilderWrapper<D> v1(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v1(v));
    }

    @Override
    public FormatBuilderWrapper<D> v2(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v2(v));
    }

    @Override
    public FormatBuilderWrapper<D> v3(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v3(v));
    }

    @Override
    public FormatBuilderWrapper<D> v4(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v4(v));
    }

    @Override
    public FormatBuilderWrapper<D> v5(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v5(v));
    }

    @Override
    public FormatBuilderWrapper<D> v6(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v6(v));
    }

    @Override
    public FormatBuilderWrapper<D> v7(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v7(v));
    }

    @Override
    public FormatBuilderWrapper<D> v8(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v8(v));
    }

    @Override
    public FormatBuilderWrapper<D> v9(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v9(v));
    }

    @Override
    public FormatBuilderWrapper<D> v10(String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v10(v));
    }

    @Override
    public FormatBuilderWrapper<D> v(String k, String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.v(k, v));
    }

    @Override
    public String getVariable(String k) {
        return formatBuilder.getVariable(k);
    }

    @Override
    public FormatBuilderWrapper<D> setVariable(String k, String v) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.setVariable(k, v));
    }

    @Override
    public FormatBuilderWrapper<D> timeZone(BaseTimeZone timeZone) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.timeZone(timeZone));
    }

    @Override
    public FormatBuilderWrapper<D> timeZone(TimeZone timeZone) {
        return new FormatBuilderWrapper<>(builder, formatBuilder.timeZone(timeZone));
    }

    @Override
    public SimpleDateFormat build() {
        return formatBuilder.build();
    }
}
