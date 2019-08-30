package com.starsea.service;

import com.starsea.entity.Book;
import com.starsea.entity.Movie;
import com.starsea.entity.Post;
import com.starsea.entity.User;
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

    public void updateCollectPosts(String username, ObjectId postId);

    public void updateStarPosts(String username, ObjectId postId);

    public void updateCollectBooks(String username, ObjectId Id);

    public void updateCollectMovies(String username, ObjectId movieId);
}
