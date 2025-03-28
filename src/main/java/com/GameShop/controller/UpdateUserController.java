package com.GameShop.controller;

import com.GameShop.entity.User;
import com.GameShop.service.UpdateUserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UpdateUserController
 * @Author KaoRouFan
 * @Date 2025/3/24 19:03
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/userUpdateController")
public class UpdateUserController {

    @Autowired
    private UpdateUserService updateUserService;


    @RequestMapping("/findUserById")
    @ResponseBody
    public String findUserById(@RequestParam("id") int id){
        User user = updateUserService.findUserById(id);
        return JSON.toJSONString(user);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public String finUserById(@RequestParam("name")String name,
                                            @RequestParam("sex")String sex,
                                            @RequestParam("birthday")String birthday,
                                            @RequestParam("phone")String phone,
                                            @RequestParam("signature")String signature,
                                            @RequestParam("id") int id){
        int index = updateUserService.updateUserById(name, sex, birthday, phone, signature, id);
        if(index > 0){
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/backLink")
    @ResponseBody
    public String backLink(){
        return "/userMessage/updateUser";
    }
}
