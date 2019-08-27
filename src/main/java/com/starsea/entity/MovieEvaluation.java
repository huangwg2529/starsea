package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "movieevaluations")
public class MovieEvaluation implements Serializable {
    @Id
    private ObjectId meId;

    private String username;

    private ObjectId movieId;

    private double score;

    private String evaluation;

    public MovieEvaluation() {

    }

    @PersistenceConstructor

    public MovieEvaluation(String username, ObjectId movieId, double score, String evaluation) {
        this.username = username;
        this.movieId = movieId;
        this.score = score;
        this.evaluation = evaluation;
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

    public ObjectId getMovieId() {
        return movieId;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
