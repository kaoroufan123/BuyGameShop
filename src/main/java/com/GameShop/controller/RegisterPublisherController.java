package com.GameShop.controller;


import com.GameShop.service.RegisterPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RegisterPublisherController
 * @Author KaoRouFan
 * @Date 2025/2/17 15:23
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/BuyGamesShop")
public class RegisterPublisherController {

    @Autowired
    private RegisterPublisherService registerPublisherService;

    @RequestMapping("/registerPublisher")
    @ResponseBody
    /*String name,String account,String password,String establishDate*/
    public String registerPublisher(@RequestParam(value = "name")String name,
                                    @RequestParam(value = "account")String email,
                                    @RequestParam(value = "password")String password,
                                    @RequestParam(value = "establishDate")String establishDate) {
        int index = registerPublisherService.registerPublisher(name, email, password, establishDate);
        if (index > 0) {
            return "success";
        }else{
            return "fail";
        }
    }
}