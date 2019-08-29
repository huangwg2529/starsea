package com.starsea.entity;

public class Discuss {
    /**
     * 识别id
     */
    private int discussId;
    /**
     * 回复者
     */
    private String replierName;

    private String imgAddr;

    /**
     * 被回复者
     */
    private String beReplierName;

    private String time;

    private String mainBody;

    private int likeNum;

    public Discuss() {

    }

    public Discuss(String replierName, String imgAddr, String beReplierName, String time, String mainBody) {
        this.replierName = replierName;
        this.imgAddr = imgAddr;
        this.beReplierName = beReplierName;
        this.time = time;
        this.mainBody = mainBody;
        likeNum = 0;
    }

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getBeReplierName() {
        return beReplierName;
    }

    public void setBeReplierName(String beReplierName) {
        this.beReplierName = beReplierName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }
}
