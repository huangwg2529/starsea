package com.starsea.controller;

import com.starsea.entity.Group;
import com.starsea.entity.Post;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
import com.starsea.service.UserDao;
import com.starsea.vo.VueAddPost;
import com.starsea.vo.VueJoinGroup;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class showGroupController {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    @CrossOrigin
    @RequestMapping(value = "/api/showGroupIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> showGroupIndex(int num) {
        return groupDao.getGroupByHeatDegree(num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showGroup", method = RequestMethod.GET)
    @ResponseBody
    public Group showGroup(String groupId) {
        System.out.println("show");
        return groupDao.getGroupByGroupId(new ObjectId(groupId));
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showGroupMember", method = RequestMethod.GET)
    @ResponseBody
    public List<String> showGroupMember(String groupId) {
        Group group = groupDao.getGroupByGroupId(new ObjectId(groupId));
        return group.getMembersName();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/joinGroup", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String joinGroup(@RequestBody VueJoinGroup vueJoinGroup) {
        String username = vueJoinGroup.getUsername();
        String groupId = vueJoinGroup.getGroupId();
        Group group = groupDao.getGroupByGroupId(new ObjectId(groupId));
        groupDao.addGroupMember(group, username);
        return "SUCCESS";
    }

    @CrossOrigin
    @RequestMapping(value = "/api/isJoinGroup", method = RequestMethod.GET)
    @ResponseBody
    public boolean isBookEvaluation(String groupId, String username) {
        return groupDao.isJoinGroup(new ObjectId(groupId), username);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/addPost", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addPost(@RequestBody VueAddPost vueAddPost) {
        String username = vueAddPost.getUsername();
        String imgAddr = userDao.getUserByName(username).getImgAddr();
        String title = vueAddPost.getTitle();
        String mainBody = vueAddPost.getMainBody();
        ObjectId groupId = new ObjectId(vueAddPost.getGroupId());
        Post post = new Post(groupId, title, username, imgAddr, mainBody);
        postDao.addPost(post);
        return "SUCCESS";
    }

}
