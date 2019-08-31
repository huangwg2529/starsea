package com.starsea.controller;

import com.starsea.entity.Discuss;
import com.starsea.entity.Group;
import com.starsea.entity.Post;
import com.starsea.entity.User;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
import com.starsea.service.UserDao;
import com.starsea.vo.OperatePost;
import com.starsea.vo.VueAddDiscuss;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class showPostController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showPostIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showPostIndex(int num) {
        return postDao.getPostByHeatDegree(num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showPost", method = RequestMethod.GET)
    @ResponseBody
    public Post showPost(String postId) {
        return postDao.getPostById(new ObjectId(postId));
    }

    //flag 排序，1是按发帖时间，2是按热度，3是按最近回复时间
    @CrossOrigin
    @RequestMapping(value = "/api/showPostInGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showPostInGroup(String groupId, int flag, int num) {
        Group group = groupDao.getGroupByGroupId(new ObjectId(groupId));
        return postDao.getPostByGroup(group, flag, num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showTopPostInGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showTopPostInGroup(String groupId) {
        Group group = groupDao.getGroupByGroupId(new ObjectId(groupId));
        return postDao.getPostByIsTop(group);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showGreatPostInGroup", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showGreatPostInGroup(String groupId) {
        Group group = groupDao.getGroupByGroupId(new ObjectId(groupId));
        return postDao.getPostByIsGreat(group);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/addDiscuss", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addPost(@RequestBody VueAddDiscuss vueAddDiscuss) {
        ObjectId postId = new ObjectId(vueAddDiscuss.getPostId());
        String replierName = vueAddDiscuss.getReplierName();
        String imgAddr = userDao.getUserByName(replierName).getImgAddr();
        Discuss discuss = new Discuss(replierName, imgAddr, vueAddDiscuss.getBeReplierName(), vueAddDiscuss.getMainBody());
        postDao.addDiscuss(postDao.getPostById(postId), discuss);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/starPost", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String starPost(@RequestBody OperatePost operatePost) {
        ObjectId postId = new ObjectId(operatePost.getPostId());
        String username = operatePost.getUsername();
        int flag = operatePost.getFlag();
        postDao.updateLikeNum(postDao.getPostById(postId), flag);
        userDao.updateStarPosts(username, postId, flag);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/collectPost", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String collectPost(@RequestBody OperatePost operatePost) {
        ObjectId postId = new ObjectId(operatePost.getPostId());
        String username = operatePost.getUsername();
        int flag = operatePost.getFlag();
        postDao.updateCollectNum(postDao.getPostById(postId), flag);
        userDao.updateCollectPosts(username, postId, flag);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/isStarPost", method = RequestMethod.GET)
    @ResponseBody
    public boolean isStarPost(String postId, String username) {
        ObjectId thispostId = new ObjectId(postId);
        User user = userDao.getUserByName(username);
        return user.getStarPosts().contains(thispostId);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/isCollectPost", method = RequestMethod.GET)
    @ResponseBody
    public boolean isCollectPost(String postId, String username) {
        ObjectId thispostId = new ObjectId(postId);
        User user = userDao.getUserByName(username);
        return user.getCollectPosts().contains(thispostId);
    }




}

