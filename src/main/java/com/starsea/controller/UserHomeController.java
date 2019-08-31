package com.starsea.controller;

import com.starsea.entity.*;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
import com.starsea.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserHomeController {
    @Autowired
    private UserDao userDao;

    /*
    @CrossOrigin
    @RequestMapping(value = "/api/showUser", method = RequestMethod.GET)
    @ResponseBody
    public User showUser(String username) {
        return userDao.getUserByName(username);
    }
     */

    @CrossOrigin
    @RequestMapping(value = "/api/showSignature", method = RequestMethod.GET)
    @ResponseBody
    public String showSignature(String username) {
        return userDao.getUserByName(username).getSignature();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showCollectMovies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> showCollectMovies(String username) {
        return userDao.getCollectMovies(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showCollectBooks", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> showCollectBooks(String username) {
        return userDao.getCollectBooks(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showMyGroups", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> showMyGroups(String username) {
        return userDao.getMyGroups(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showMyPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showMyPosts(String username) {
        return userDao.getMyPosts(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showCollectPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showCollectPosts(String username) {
        return userDao.getCollectPosts(username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showStarPosts", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showStarPosts(String username) {
        return userDao.getStarPosts(username);
    }

}
