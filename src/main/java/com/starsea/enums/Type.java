package com.starsea.enums;

/**
 * 影视类型
 */
public enum Type {
    /**
     * 喜剧
     */
    COMEDY("喜剧"),
    /**
     * 动作
     */
    ACTION("动作"),
    /**
     * 爱情
     */
    LOVE("爱情"),
    /**
     * 科幻
     */
    SCIENCE_FICTION("科幻"),
    /**
     * 动画
     */
    ANIMATION("动画"),
    /**
     * 武侠
     */
    SWORDSMAN("武侠"),
    /**
     * 历史
     */
    HISTORY("历史"),
    /**
     * 战争
     */
    WAR("战争"),
    /**
     * 剧情
     */
    PLOT("剧情");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
