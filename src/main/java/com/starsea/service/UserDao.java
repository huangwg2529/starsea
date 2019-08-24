package com.starsea.service;

import com.starsea.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    public String addUser(User user);
    public User getUserByName(String username);
}
