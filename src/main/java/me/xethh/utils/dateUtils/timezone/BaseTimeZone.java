package me.xethh.utils.dateUtils.timezone;

import java.util.TimeZone;

/**
 * @author xethhung
 * Created on 5/25/2018
 */
public enum BaseTimeZone {
    /**
     * Timezone -0800
     */
    Etc_GMT_P8("Etc/GMT+8"),
    /**
     * Timezone zero
     */
    GMT("GMT"),
    /**
     * Timezone zero
     */
    UTC("UTC"),
    /**
     * Timezone zero
     */
    Greenwich("Greenwich"),
    /**
     * Timezone +0800
     */
    Etc_GMT_M8("Etc/GMT-8"),
    /**
     * Timezone +0800
     */
    Hongkong("Hongkong"),
    /**
     * Timezone +0800
     */
    Asia_Hong_Kong("Asia/Hong_Kong"),
    /**
     * Timezone +0800
     */
    Asia_Taipei("Asia/Taipei"),
    /**
     * Timezone +0800
     */
    Asia_Shanghai("Asia/Shanghai"),
    /**
     * Timezone +0800
     */
    Asia_Singapore("Asia/Singapore"),
    /**
     * Timezone +0800
     */
    Singapore("Singapore"),
    /**
     * Timezone +0900
     */
    Asia_Seoul("Asia/Seoul"),
    /**
     * Timezone +0900
     */
    Japan("Japan"),
    ;
    private String id;
    BaseTimeZone(String value){
        this.id = value;
    }

    public TimeZone timeZone(){
        return TimeZone.getTimeZone(id);
    }

}

