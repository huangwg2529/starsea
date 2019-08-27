package com.starsea.enums;

/**
 * 书籍影视所属地区
 */
public enum Region {
    /**
     * 中国大陆
     */
    CHINESE_MAINLAND("中国大陆"),
    /**
     * 香港
     */
    HONGKONG("香港"),
    /**
     * 台湾
     */
    TAIWAN("台湾"),
    /**
     * 日本
     */
    JAPAN("日本"),
    /**
     * 韩国
     */
    KOREA("韩国"),
    /**
     * 欧美
     */
    EUROPE_AND_AMERICA("欧美");

    private String region;

    Region(String region) {
        this.region = region;
    }
}
