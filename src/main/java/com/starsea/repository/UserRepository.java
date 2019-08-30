package com.starsea.repository;

import com.starsea.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.starsea.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    //自定义查询方法，格式为“findBy+字段名+方法后缀”，方法传进的参数即字段的值
    //支持的查询类型：https://blog.csdn.net/laigood/article/details/7056093
    public User findByUsername(String username);
}
