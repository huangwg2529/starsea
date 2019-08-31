package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

//注释此类将被映射到数据库的users集合
@Document(collection = "users") //相当于sql的table

public class User implements Serializable {
    @Id
    private ObjectId userId;
    //创建单字段索引（默认ASCENDING 升序、DESCENDING 降序）
    @Indexed(direction =DESCENDING)
    @Field
    private String username;
    @Field
    private String password;
    @Field
    private String signature;
    @Field
    private String imgAddr = "http://114.115.131.124:8666/image/book/test.png";

    /**
     * 评论过的电影
     */
    private List<ObjectId> collectMovies;

    /**
     * 评论过的书籍
     */
    private List<ObjectId> collectBooks;

    /**
     * 点赞过的帖子
     */
    private List<ObjectId> starPosts;

    private List<ObjectId> collectPosts;

    private List<ObjectId> myPosts;

    private List<ObjectId> myGroups;

    public User() {

    }

    @PersistenceConstructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(ObjectId id) {
        this.userId = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public List<ObjectId> getCollectMovies() {
        return collectMovies;
    }

    public void setCollectMovies(List<ObjectId> collectMovies) {
        this.collectMovies = collectMovies;
    }

    public List<ObjectId> getCollectBooks() {
        return collectBooks;
    }

    public void setCollectBooks(List<ObjectId> collectBooks) {
        this.collectBooks = collectBooks;
    }

    public List<ObjectId> getStarPosts() {
        return starPosts;
    }

    public void setStarPosts(List<ObjectId> starPosts) {
        this.starPosts = starPosts;
    }

    public List<ObjectId> getCollectPosts() {
        return collectPosts;
    }

    public void setCollectPosts(List<ObjectId> collectPosts) {
        this.collectPosts = collectPosts;
    }

    public List<ObjectId> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<ObjectId> myPosts) {
        this.myPosts = myPosts;
    }

    public List<ObjectId> getMyGroups() {
        return myGroups;
    }

    public void setMyGroups(List<ObjectId> myGroups) {
        this.myGroups = myGroups;
    }
}
