package com.starsea.controller;

import com.starsea.entity.Group;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
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

    @CrossOrigin
    @RequestMapping(value = "/api/showGroupIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> showGroupIndex(int num) {
        return groupDao.getGroupByHeatDegree(num);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/showGroup", method = RequestMethod.GET)
    @ResponseBody
    public Group showGroupIndex(String groupId) {
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




    /*
        @CrossOrigin
    @RequestMapping(value = "/api/addBookEvaluation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String addBookEvaluation(@RequestBody VueAddBE vueAddBE) {
        String username = vueAddBE.getUsername();
        double score = Double.parseDouble(vueAddBE.getScore());
        String isbn = vueAddBE.getIsbn();
        String evaluation = vueAddBE.getEvaluation();
        if(vueAddBE.getEvaluation().length() < 25) {
            return "请输入25个字符或以上的内容！";
        }
        BookEvaluation bookEvaluation = new BookEvaluation(username, isbn, score, evaluation);
        bookEvaluationDao.addBookEvaluation(bookEvaluation);
        return "SUCCESS";
    }
     */



}
