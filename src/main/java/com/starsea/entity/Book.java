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

    private String isbn;
    @Indexed(direction =ASCENDING)
    private String name;

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

    private BookType[] bookTypes;

    private String imgAddr;

    private int price;

    private String introduction;

    private double score;

    private int evaluationNum = 0;

    public Book() {

    }


    public Book(String isbn, String name, String author, String imgAddr, int price, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.imgAddr = imgAddr;
        this.price = price;
        this.introduction = introduction;
    }

    @PersistenceConstructor
    public Book(String isbn, String name, String author, String publishingCompany, int releaseYear, Region region, BookType[] bookTypes, String imgAddr, int price, String introduction, double score, int evaluationNum) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.releaseYear = releaseYear;
        this.region = region;
        this.bookTypes = bookTypes;
        this.imgAddr = imgAddr;
        this.price = price;
        this.introduction = introduction;
        this.score = score;
        this.evaluationNum = evaluationNum;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
}
