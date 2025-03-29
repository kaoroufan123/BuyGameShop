package com.GameShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName GameServiceController
 * @Author KaoRouFan
 * @Date 2025/3/29 07:52
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/service")
public class GameServiceController {

    @RequestMapping("/linkService")
    public String ServiceLink(){
        return "Service";
    }

    @RequestMapping("/registerUser")
    public String ServiceLinkREG(){
        return "RegisterUser";
    }

    @RequestMapping("/retrievePassword")
    public String RetrievePassword(){
        return "RetrievePassword";
    }
}
