package com.starsea.vo;

public class VueAddBE {
    private String username;

    private String isbn;

    private String score;

    private String evaluation;

    public VueAddBE(String username, String isbn, String score, String evaluation) {
        this.username = username;
        this.isbn = isbn;
        this.score = score;
        this.evaluation = evaluation;
    }

    public VueAddBE() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
