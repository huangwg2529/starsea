package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(collection = "movieevaluations")
public class MovieEvaluation implements Serializable {
    @Id
    private ObjectId meId;

    private String username;

    private ObjectId movieId;

    private Date date;

    private String time;

    private double score;

    private String evaluation;

    private int likeNum;

    /**
     * 记录点赞用户
     */
    private List<String> starUsername;

    public MovieEvaluation() {

    }

    @PersistenceConstructor
    public MovieEvaluation(String username, ObjectId movieId, double score, String evaluation) {
        this.username = username;
        this.movieId = movieId;
        this.score = score;
        this.evaluation = evaluation;
        date = new Date();
        time = String.format("%tY年%<tm月%<td日", date) + " " + String.format("%tT", date);//2010年10月4日 17:31:11
        likeNum = 0;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getStarUsername() {
        return starUsername;
    }

    public void setStarUsername(List<String> starUsername) {
        this.starUsername = starUsername;
    }
}
