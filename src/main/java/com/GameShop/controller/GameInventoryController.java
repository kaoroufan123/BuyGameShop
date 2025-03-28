package com.GameShop.controller;

import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.GameInventoryService;
import com.GameShop.utils.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * @ClassName GameInventoryController
 * @Author KaoRouFan
 * @Date 2025/3/27 08:30
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/GameInventory")
public class GameInventoryController {

    @Autowired
    private GameInventoryService gameInventoryService;

    @RequestMapping("/Inventory")
    public  String LinkToInventory() {
        return "Inventory";
    }


    @RequestMapping("/findGameInventoryByUserId")
    @ResponseBody
    public String findGameInventoryByUserId(@RequestParam("userId") int userId) {
        List<UserWareHouse> userWareHouseList = gameInventoryService.findGameInventoryByUserId(userId);
        /*System.out.println(userWareHouseList);*/

        return JSON.toJSONString(userWareHouseList);
    }

    @RequestMapping("/findGameInventoryImageByUserId")
    @ResponseBody
    public String findGameInventoryImageByUserId(@RequestParam("userId") int userId) {
        List<UserWareHouse> userWareHouseList = gameInventoryService.findGameInventoryImageByUserId(userId);
        System.out.println(userWareHouseList);
        return JSON.toJSONString(userWareHouseList);
    }
}
