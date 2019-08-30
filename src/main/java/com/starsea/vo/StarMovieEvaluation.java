package com.starsea.vo;

import org.bson.types.ObjectId;

public class StarMovieEvaluation {
    private ObjectId meId;
    private String username;
    private String flag;

    public StarMovieEvaluation() {

    }

    public StarMovieEvaluation(ObjectId beId, String username, String flag) {
        this.meId = meId;
        this.username = username;
        this.flag = flag;
    }

    public ObjectId getMeId() {
        return meId;
    }

    public void setMeId(ObjectId meId) {
        this.meId = meId;
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
