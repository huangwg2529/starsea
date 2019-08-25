package com.starsea.entity;

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

    private String imgAddr;

    private int price;

    private String introduction;

    private double score;

    public Book() {

    }

    @PersistenceConstructor
    public Book(String isbn, String name, String author, String imgAddr, int price, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
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

}
