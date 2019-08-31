package com.starsea.controller;

import com.starsea.service.ServiceContactService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Controller
public class VerifyController {


    @Autowired
    private ServiceContactService serviceContactService;

    /**
     * 生成验证码
     */
    @CrossOrigin
    @RequestMapping(value = "/getVerify", method = RequestMethod.GET)
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("getVerify");
        serviceContactService.getVerify(request, response);
    }

    /**
     * 忘记密码页面校验验证码
     */
    @CrossOrigin
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST)
    public boolean checkVerify(This th) {
        System.out.println("checkVerify");
        return serviceContactService.checkVerify(th.verifyInput, th.session);
    }
}

class This {
    String verifyInput;

    HttpSession session;

    public This() {

    }

    public This(String verifyInput, HttpSession session) {
        this.verifyInput = verifyInput;
        this.session = session;
    }

    public String getVerifyInput() {
        return verifyInput;
    }

    public void setVerifyInput(String verifyInput) {
        this.verifyInput = verifyInput;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}