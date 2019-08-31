package com.starsea.vo;

public class VueJoinGroup {
    private String groupId;

    private String username;

    public VueJoinGroup() {

    }

    public VueJoinGroup(String groupId, String username) {
        this.groupId = groupId;
        this.username = username;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
