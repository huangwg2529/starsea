package com.starsea.vo;

import org.bson.types.ObjectId;

public class VueMovieEvaluation {
    private String username;
    private ObjectId movieId;
    private String score;
    private String evaluation;

    public VueMovieEvaluation() {

    }

    public VueMovieEvaluation(String username, ObjectId movieId, String score, String evaluation) {
        this.username = username;
        this.movieId = movieId;
        this.score = score;
        this.evaluation = evaluation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ObjectId getMovieId() {
        return movieId;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
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
}
