package com.starsea.vo;

public class VueAddPost {
    //Post(ObjectId groupId, String title, String username, String imgAddr, String mainBody)
    String groupId;

    String title;

    String username;

    String mainBody;

    public VueAddPost() {

    }

    public VueAddPost(String groupId, String title, String username, String mainBody) {
        this.groupId = groupId;
        this.title = title;
        this.username = username;
        this.mainBody = mainBody;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }
}
