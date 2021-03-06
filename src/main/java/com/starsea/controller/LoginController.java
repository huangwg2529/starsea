package com.starsea.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        //验证输入
        if (bindingResult.hasErrors()) {
            String message = String.format("%s。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        //获取输入的账号密码
        String username = loginInfoVo.getUsername();
        String password = loginInfoVo.getPassword();

        User findUser = userDao.getUserByName(username);
        if(findUser!=null){
            if(Objects.equals(findUser.getPassword(), password)){
                return ResultFactory.buildSuccessResult("登录成功。");
            }
        }
        String message = String.format("用户名或密码不正确！");
        return ResultFactory.buildFailResult(message);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Register(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        System.out.println("register");
        //验证输入
        if (bindingResult.hasErrors()) {
            String message = String.format("%s。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }

        //获取输入的账号密码
        String username = loginInfoVo.getUsername();
        String password = loginInfoVo.getPassword();

        if(username.length()<3 || username.length()>12) {
            String message = "用户名必须是3-12个字符！";
            return ResultFactory.buildFailResult(message);
        }

        char[] arr = password.toCharArray();
        int len = arr.length;
        if(len < 8 || len >16) {
            String message = "密码必须是8-16个字符！";
            return ResultFactory.buildFailResult(message);
        }
        boolean wordFlag = false;
        boolean numFlag = false;
        for(int i=0; i<len; i++) {
            if(arr[i]>'0' && arr[i]<'9') {
                numFlag = true;
            } else if(arr[i]>'a' && arr[i]<'z') {
                wordFlag = true;
            } else if(arr[i]>'A' && arr[i]<'Z') {
                wordFlag = true;
            }
        }
        if(!(wordFlag&&numFlag)) {
            String message = "密码必须同时包含字母和数字！";
            return ResultFactory.buildFailResult(message);
        }

        User findUser = userDao.getUserByName(username);
        if(findUser==null || !Objects.equals(findUser.getUsername(), username)) {
            User newUser = new User(username, password);
            userDao.addUser(newUser);
            return ResultFactory.buildSuccessResult("注册成功。");
        }
        String message = "用户名已存在。";
        return ResultFactory.buildFailResult(message);
    }
}
