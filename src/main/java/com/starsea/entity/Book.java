package com.starsea.entity;

import com.starsea.enums.BookType;
import com.starsea.enums.Region;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

import static org.springframework.data.mongodb.core.index.IndexDirection.ASCENDING;

@Document(collection = "books")

public class Book implements Serializable {
    @Id
    private ObjectId Id;
    /**
     * ISBN
     */
    private String isbn;
    /**
     * 书名
     */
    private String name;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String publishingCompany;
    /**
     * 出版年份
     */
    private int releaseYear;
    /**
     * 地区
     */
    private Region region;
    /**
     * 语言
     */
    private String language;
    /**
     * 类型
     */
    private BookType[] bookTypes;
    /**
     * 图片地址
     */
    private String imgAddr;
    /**
     * 价格
     */
    private double price;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 评分
     */
    private double score;
    /**
     * 评论数
     */
    private int evaluationNum = 0;

    public Book() {

    }

    @PersistenceConstructor
    public Book(String isbn, String name, String author, String publishingCompany, int releaseYear, Region region, String language, BookType[] bookTypes, String imgAddr, double price, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.releaseYear = releaseYear;
        this.region = region;
        this.language = language;
        this.bookTypes = bookTypes;
        this.imgAddr = imgAddr;
        this.price = price;
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ObjectId getId() {
        return Id;
    }

    public void setId(ObjectId id) {
        Id = id;
    }

    public int getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(int evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public BookType[] getBookTypes() {
        return bookTypes;
    }

    public void setBookTypes(BookType[] bookTypes) {
        this.bookTypes = bookTypes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
