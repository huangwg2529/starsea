package com.starsea.vo;

public class StarMovieEvaluation {
    private String meId;
    private String username;
    private String flag;

    public StarMovieEvaluation() {

    }

    public StarMovieEvaluation(String meId, String username, String flag) {
        this.meId = meId;
        this.username = username;
        this.flag = flag;
    }

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
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
