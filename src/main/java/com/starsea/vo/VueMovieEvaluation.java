package com.starsea.vo;

import org.bson.types.ObjectId;

public class VueMovieEvaluation {
    private String username;
    private String id;
    private String score;
    private String evaluation;

    public VueMovieEvaluation() {

    }

    public VueMovieEvaluation(String username, String Id, String score, String evaluation) {
        this.username = username;
        this.id = Id;
        this.score = score;
        this.evaluation = evaluation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "VueMovieEvaluation{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", score='" + score + '\'' +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }
}
