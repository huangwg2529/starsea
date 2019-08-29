package com.starsea.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "bookevaluations")
public class BookEvaluation implements Serializable {
    @Id
    private ObjectId beId;

    private String username;

    private String isbn;

    private Date date;

    /**
     * 添加以前端便于使用
     */
    private String time;

    private double score;

    private String evaluation;
    /**
     * 点赞数
     */
    private int likeNum;

    public BookEvaluation() {

    }

    public BookEvaluation(String username, String isbn, double score, String evaluation) {
        this.username = username;
        this.isbn = isbn;
        this.score = score;
        this.evaluation = evaluation;
        date = new Date();
        time = String.format("%tY年%<tm月%<td日", date) + " " + String.format("%tT", date);//2010年10月4日 17:31:11
        likeNum = 0;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setScore(double score) {
        this.score = score;
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

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }
}
