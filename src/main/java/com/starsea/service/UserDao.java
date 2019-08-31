package com.starsea.service;

import com.starsea.entity.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserByName(String username);

    public List<Post> getCollectPosts(String username);

    public List<Post> getStarPosts(String username);

    public List<Book> getCollectBooks(String username);

    public List<Movie> getCollectMovies(String username);

    public void updateCollectPosts(String username, ObjectId postId, int flag);

    public void updateStarPosts(String username, ObjectId postId, int flag);

    public void updateMyPosts(String username, ObjectId postId, int flag);

    public void updateMyGroups(String username, ObjectId groupId, int flag);

    public void updateCollectBooks(String username, String isbn);

    public void updateCollectMovies(String username, ObjectId movieId);

    public List<Post> getMyPosts(String username);

    public List<Group> getMyGroups(String username);
}
