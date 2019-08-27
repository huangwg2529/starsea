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

    private String name;

    private String director;

    private String stars;
    /**
     * 影视类型
     */
    private Type[] types;
    /**
     * 所属地区
     */
    private Region region;
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

    private String introduction;

    private String imgAddr;

    public Movie() {

    }

    @PersistenceConstructor
    public Movie(String name, String director, String stars, Type[] types, Region region, int releaseYear, String introduction) {
        this.name = name;
        this.director = director;
        this.stars = stars;
        this.types = types;
        this.region = region;
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

    public Type[] getTypes() {
        return types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
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
}

