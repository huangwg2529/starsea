package com.starsea.service;

import com.starsea.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserByName(String username);
}
