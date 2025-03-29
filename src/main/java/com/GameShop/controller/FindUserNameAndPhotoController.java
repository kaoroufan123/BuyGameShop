package com.GameShop.controller;

import com.GameShop.entity.User;
import com.GameShop.service.FindUserNameAndPhotoService;
import com.GameShop.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FindUserNameAndPhoto
 * @Author KaoRouFan
 * @Date 2025/3/19 19:24
 * @Version 1.14.5.14
 */

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/user")
public class FindUserNameAndPhotoController {

    @Autowired
    private FindUserNameAndPhotoService findUserNameAndPhotoService;

    @RequestMapping("/findUserNAP")
    public Map<String, Object>   home() {
        // 从 Shiro 的 Session 中获取用户信息

        /*Subject currentUser  = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("user",user);*/

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User currentUser = (User) session.getAttribute("user");


        User user = findUserNameAndPhotoService.findUserNameAndPhoto(currentUser.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.getName());
        map.put("userPhoto", user.getPhoto());
        map.put("userBalance", user.getBalance());
        map.put("userId", user.getId());
        return map;
    }
}
