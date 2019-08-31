package com.starsea.vo;

public class VueAddDiscuss {
    String postId;

    String replierName;

    String beReplierName;

    String mainBody;

    public VueAddDiscuss() {

    }

    public VueAddDiscuss(String postId, String replierName, String beReplierName, String mainBody) {
        this.postId = postId;
        this.replierName = replierName;
        this.beReplierName = beReplierName;
        this.mainBody = mainBody;
    }

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName;
    }

    public String getBeReplierName() {
        return beReplierName;
    }

    public void setBeReplierName(String beReplierName) {
        this.beReplierName = beReplierName;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
