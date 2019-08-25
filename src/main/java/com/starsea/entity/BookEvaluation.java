package com.starsea.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "bookevaluations")
public class BookEvaluation implements Serializable {
    @Id
    private ObjectId beId;

    private String username;

    private String isbn;

    private double score;

    private String evaluation;

    public BookEvaluation() {

    }

    public BookEvaluation(String username, String isbn, double score, String evaluation) {
        this.username = username;
        this.isbn = isbn;
        this.score = score;
        this.evaluation = evaluation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ObjectId getBeId() {
        return beId;
    }

    public void setBeId(ObjectId beId) {
        this.beId = beId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
