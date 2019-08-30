package com.starsea.vo;

import org.bson.types.ObjectId;

public class StarEvaluation {
    private ObjectId beId;
    private String username;
    private String flag;

    public StarEvaluation() {

    }

    public StarEvaluation(ObjectId beId, String username, String flag) {
        this.beId = beId;
        this.username = username;
        this.flag = flag;
    }

    public ObjectId getBeId() {
        return beId;
    }

    public void setBeId(ObjectId beId) {
        this.beId = beId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
