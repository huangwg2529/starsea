package com.starsea.service;

import com.starsea.entity.User;
import com.starsea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;

    //增
    @Override
    public void addUser(User user){
        userRepository.insert(user);
    }

    //删
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    //改
    @Override
    public void updateUser(User user) {
        //userRepository.
    }


    //查
    @Override
    public User getUserByName(String username){
        return userRepository.findByUsername(username);
        //return mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), User.class);
    }
}
