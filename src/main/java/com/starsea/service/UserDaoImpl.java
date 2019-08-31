package com.starsea.service;

import com.starsea.entity.*;
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
    @Autowired
    private GroupDao groupDao;

    @Override
    public void addUser(User user){
        userRepository.insert(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void updateUser(User user) {
        //userRepository.
    }

    @Override
    public User getUserByName(String username){
        return userRepository.findByUsername(username);
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

    public List<Post> getMyPosts(String username) {
        List<ObjectId> ids = getUserByName(username).getMyPosts();
        List<Post> myPosts = new ArrayList<Post>();
        for(int i=0; i<ids.size(); i++) {
            myPosts.add(postDao.getPostById(ids.get(i)));
        }
        return myPosts;
    }

    public List<Group> getMyGroups(String username) {
        List<ObjectId> ids = getUserByName(username).getMyGroups();
        List<Group> myGroups = new ArrayList<Group>();
        for(int i=0; i<ids.size(); i++) {
            myGroups.add(groupDao.getGroupByGroupId(ids.get(i)));
        }
        return myGroups;
    }

    public void updateCollectPosts(String username, ObjectId postId, int flag) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> collectPosts = getUserByName(username).getCollectPosts();
        if(collectPosts == null) {
             collectPosts = new ArrayList<ObjectId>();
        }
        if(flag == 1) {
            collectPosts.add(postId);
        } else if(flag == -1) {
            collectPosts.remove(postId);
        }
        Update update = new Update();
        update.set("collectPosts", collectPosts);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateStarPosts(String username, ObjectId postId, int flag) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> starPosts = getUserByName(username).getStarPosts();
        if(starPosts == null) {
            starPosts = new ArrayList<ObjectId>();
        }
        if(flag == 1) {
            starPosts.add(postId);
        } else if(flag == -1) {
            starPosts.remove(postId);
        }
        Update update = new Update();
        update.set("starPosts", starPosts);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateMyPosts(String username, ObjectId postId, int flag) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> myPosts = getUserByName(username).getMyPosts();
        if(myPosts == null) {
            myPosts = new ArrayList<ObjectId>();
        }
        if(flag == 1) {
            myPosts.add(postId);
        } else if(flag == -1) {
            myPosts.remove(postId);
        }
        Update update = new Update();
        update.set("myPosts", myPosts);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateMyGroups(String username, ObjectId groupId, int flag) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> myGroups = getUserByName(username).getMyGroups();
        if(myGroups == null) {
            myGroups = new ArrayList<ObjectId>();
        }
        if(flag == 1) {
            myGroups.add(groupId);
        } else if(flag == -1) {
            myGroups.remove(groupId);
        }
        Update update = new Update();
        update.set("myGroups", myGroups);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateCollectBooks(String username, ObjectId Id) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> collectBooks = getUserByName(username).getCollectBooks();
        if(collectBooks == null) {
            collectBooks = new ArrayList<ObjectId>();
        }
        collectBooks.add(Id);
        Update update = new Update();
        update.set("collectBooks", collectBooks);
        mongoTemplate.updateFirst(query, update, User.class);
    }

    public void updateCollectMovies(String username, ObjectId movieId) {
        Query query = new Query(Criteria.where("username").is(username));
        List<ObjectId> collectMovies = getUserByName(username).getCollectMovies();
        if(collectMovies == null) {
            collectMovies = new ArrayList<ObjectId>();
        }
        collectMovies.add(movieId);
        Update update = new Update();
        update.set("collectMovies", collectMovies);
        mongoTemplate.updateFirst(query, update, User.class);
    }

}
