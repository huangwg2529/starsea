package com.starsea.controller;

import com.starsea.entity.Group;
import com.starsea.entity.Post;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class showPostController {
    @Autowired
    private PostDao postDao;
    @Autowired
    private GroupDao groupDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showPostIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Post> showPostIndex(int num) {
        return postDao.getPostByHeatDegree(num);
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

}

