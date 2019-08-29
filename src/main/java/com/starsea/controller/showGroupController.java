package com.starsea.controller;

import com.starsea.entity.Group;
import com.starsea.service.GroupDao;
import com.starsea.service.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class showGroupController {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private PostDao postDao;

    /*
    @CrossOrigin
    @RequestMapping(value = "/api/showGroupIndex", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> showGroupIndex(int num) {

    }

     */

}
