package com.GameShop.controller;

import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.GameRefundService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName GameRefundController
 * @Author KaoRouFan
 * @Date 2025/3/30 08:46
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/GameRefund")
public class GameRefundController {

    @Autowired
    private GameRefundService gameRefundService;

    @RequestMapping("/linkGR")
    public String linkGR(){
        return "GameRefund";
    }

    @RequestMapping("/findGPByUserId")
    @ResponseBody
    public String findGameProductByUserId(@RequestParam("id") String id) {
        List<UserWareHouse> ugpList = gameRefundService.findGameProductByUserId(id);
        return JSON.toJSONString(ugpList);
    }
}
