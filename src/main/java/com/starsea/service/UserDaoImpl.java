package com.starsea.service;

import com.starsea.entity.Book;
import com.starsea.entity.Movie;
import com.starsea.entity.Post;
import com.starsea.entity.User;
import com.starsea.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private MovieDao movieDao;
    @Autowired
    private PostDao postDao;

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

    @Override
    public List<Book> getCollectBooks(String username) {
        User user = getUserByName(username);
        List<ObjectId> ids = user.getCollectBooks();
        List<Book> collectBooks = new ArrayList<Book>();
        for(int i=0; i<ids.size(); i++) {
            collectBooks.add(bookDao.getBookByBookId(ids.get(i)));
        }
        return collectBooks;
    }

    public List<Movie> getCollectMovies(String username) {
        List<ObjectId> ids = getUserByName(username).getCollectMovies();
        List<Movie> collectMovies = new ArrayList<Movie>();
        for(int i=0; i<ids.size(); i++) {
            collectMovies.add(movieDao.getMovieByMovieId(ids.get(i)));
        }
        return collectMovies;
    }

    public List<Post> getCollectPosts(String username) {
        List<ObjectId> ids = getUserByName(username).getCollectPosts();
        List<Post> collectPosts = new ArrayList<Post>();
        for(int i=0; i<ids.size(); i++) {
            collectPosts.add(postDao.getPostById(ids.get(i)));
        }
        return collectPosts;
    }

    public List<Post> getStarPosts(String username) {
        List<ObjectId> ids = getUserByName(username).getStarPosts();
        List<Post> starPosts = new ArrayList<Post>();
        for(int i=0; i<ids.size(); i++) {
            starPosts.add(postDao.getPostById(ids.get(i)));
        }
        return starPosts;
    }

    public void updateCollectPosts(String username, ObjectId postId) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> collectPosts = getUserByName(username).getCollectPosts();
        collectPosts.add(postId);
        Update update = new Update();
        update.set("collectPosts", collectPosts);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateStarPosts(String username, ObjectId postId) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> starPosts = getUserByName(username).getStarPosts();
        starPosts.add(postId);
        Update update = new Update();
        update.set("starPosts", starPosts);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateCollectBooks(String username, ObjectId Id) {

    }

    public void updateCollectMovies(String username, ObjectId movieId) {

    }

}
