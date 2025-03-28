package com.GameShop.controller;

import com.GameShop.entity.GameProduct;
import com.GameShop.service.IndexShopService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName GameProductLikeController
 * @Author KaoRouFan
 * @Date 2025/3/9 18:49
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/gameProduct")
public class GameProductLikeController {

    @Autowired
    private IndexShopService indexShopService;

    @RequestMapping("/findGameProductLike")
    @ResponseBody
    public String findGameProductLikeWithId(@RequestParam(value = "name")String name){
        List<GameProduct> gamesLikeByName = indexShopService.findGamesLikeByName(name);
        return JSON.toJSONString(gamesLikeByName);
    }
}
