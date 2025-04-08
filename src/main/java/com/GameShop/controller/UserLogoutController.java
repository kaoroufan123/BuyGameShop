package com.GameShop.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLogoutController
 * @Author KaoRouFan
 * @Date 2025/3/18 18:47
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/auth")
public class UserLogoutController {


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 获取当前用户主体
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // 执行注销（会清除session和认证信息）
            subject.logout();
        }
        // 重定向到登录页面
        return "redirect:/Login";
    }
}
