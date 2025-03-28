package com.GameShop.controller;

import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.UserMessageService;
import com.alibaba.fastjson.JSON;
import org.apache.tomcat.jni.SSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserMessageController
 * @Author KaoRouFan
 * @Date 2025/3/21 09:16
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/userMessage")
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    @RequestMapping("/findUserMessageById")
    @ResponseBody
    public String findUserMessageById(@RequestParam("userId")int id){
        List<String > user = userMessageService.findUserMessageHeaderById(id);
        return  JSON.toJSONString(user);
    }

    @RequestMapping("/findUserGamesById")
    @ResponseBody
    public String findUserGamesById(@RequestParam("userId")int id){
        List<UserWareHouse> userGames = userMessageService.findUserGamesById(id);
        return  JSON.toJSONString(userGames);
    }

    @RequestMapping("/updateUser")
    public String linkUpdateUser(){
        return "UpdateUser";
    }
}
