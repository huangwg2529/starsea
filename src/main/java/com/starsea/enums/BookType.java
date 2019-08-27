package com.starsea.enums;

public enum BookType {
    /**
     * 小说
     */
    FICTION("小说"),

    /**
     * 科幻
     */
    SCIENCE_FICTION("科幻"),
    /**
     * 武侠
     */
    SWORDSMAN("武侠"),

    /**
     * 言情
     */
    LOVE("言情"),

    /**
     * 历史
     */
    HISTORY("历史"),

    /**
     * 哲学
     */
    PHILOSOPHY("哲学"),

    /**
     * 传记
     */
    BIOGRAPHY("传记"),

    /**
     * 教育
     */
    EDUCATION("教育"),

    /**
     * 摄影
     */
    PHOTOGRAPHY("摄影"),

    /**
     * IT
     */
    IT("IT"),

    /**
     * 经济
     */
    ECONOMICS("经济"),

    /**
     * 推理
     */
    INFERENCE("推理");

    private String type;

    BookType(String type) {
        this.type = type;
    }
}
