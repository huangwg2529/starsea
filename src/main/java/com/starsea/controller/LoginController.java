package com.starsea.controller;

import javax.validation.Valid;

import com.starsea.entity.Book;
import com.starsea.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.starsea.vo.VueLoginInfoVo;
import com.starsea.result.Result;
import com.starsea.result.ResultFactory;
import com.starsea.service.UserDao;
import com.starsea.entity.User;

import java.util.*;

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        //验证输入
        if (bindingResult.hasErrors()) {
            String message = String.format("登录失败:%s。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }

        //获取输入的账号密码
        String username = loginInfoVo.getUsername();
        String password = loginInfoVo.getPassword();

        System.out.println(username + "  login");

        //验证获取数据成功
        //System.out.println(username + "  " + password);

        User findUser = userDao.getUserByName(username);
        if(findUser!=null){
            if(Objects.equals(findUser.getPassword(), password)){
                System.out.println("login success");
                return ResultFactory.buildSuccessResult("登录成功。");
            }
        }
        String message = String.format("登录失败，用户名或密码不正确！");
        System.out.println("fail!");
        return ResultFactory.buildFailResult(message);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Register(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        System.out.println("register");
        //验证输入
        if (bindingResult.hasErrors()) {
            String message = String.format("注册失败: %s。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }

        //获取输入的账号密码
        String username = loginInfoVo.getUsername();
        String password = loginInfoVo.getPassword();

        System.out.println(username + "  register");

        User findUser = userDao.getUserByName(username);
        //User findUser = mongoTemplate.findOne(new Query(Criteria.where("username").is(username)), User.class);
        if(findUser==null || !Objects.equals(findUser.getUsername(), username)) {
            User newUser = new User(username, password);
            userDao.addUser(newUser);
            return ResultFactory.buildSuccessResult("注册成功。");
        }
        String message = String.format("注册失败，用户名已存在。");
        return ResultFactory.buildFailResult(message);
    }
}
