package com.starsea.service;

import com.starsea.util.RandomValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class ServiceContactService {
    private final static Logger LOGGER = LoggerFactory.getLogger(RandomValidateCodeUtil.class);

    /**
     * 生成验证码
     */
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            LOGGER.error("获取验证码失败");
            e.printStackTrace();
        }
    }

    /**
     * 忘记密码页面校验验证码
     */
    public boolean checkVerify(String verifyInput, HttpSession session){
        try {
            //从session中获取随机数
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(verifyInput)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("验证码校验失败");
            e.printStackTrace();
            return false;
        }
    }

}