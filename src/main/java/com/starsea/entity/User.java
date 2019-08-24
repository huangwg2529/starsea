package com.starsea.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

//注释此类将被映射到数据库的users集合
@Document(collection = "users") //相当于sql的table

public class User implements Serializable {
    @Id
    private ObjectId id;
    //创建单字段索引（默认ASCENDING 升序、DESCENDING 降序）
    @Indexed(direction = DESCENDING)
    @Field
    private String username;
    @Field
    private String password;
    @Field
    private String email;

    public User() {

    }

    @PersistenceConstructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
