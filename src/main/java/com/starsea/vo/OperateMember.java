package com.starsea.vo;

public class OperateMember {

    private String groupId;

    private String username;

    public OperateMember() {

    }

    public OperateMember(String groupId, String username) {
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
