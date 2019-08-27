package com.starsea.entity;

import com.starsea.enums.Region;
import com.starsea.enums.Type;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "movies")
public class Movie implements Serializable {
    @Id
    private ObjectId movieId;
    /**
     * 电影名字
     */
    private String name;
    /**
     * 导演
     */
    private String director;
    /**
     * 主演
     */
    private String stars;
    /**
     * 影视类型
     */
    private String types;
    /**
     * 所属地区
     */
    private String region;
    /**
     * 语言
     */
    private String language;
    /**
     * 上映年份
     */
    private int releaseYear;
    /**
     * 评分
     */
    private double score;
    /**
     * 评论人数
     */
    private int evaluationNum = 0;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 图片路径
     */
    private String imgAddr;

    public Movie() {

    }

    @PersistenceConstructor
    public Movie(String name, String director, String stars, String types, String region, String language, int releaseYear, String introduction) {
        this.name = name;
        this.director = director;
        this.stars = stars;
        this.types = types;
        this.region = region;
        this.language = language;
        this.releaseYear = releaseYear;
        this.introduction = introduction;
    }

    public ObjectId getMovieId() {
        return movieId;
    }

    public void setMovieId(ObjectId movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(int evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

