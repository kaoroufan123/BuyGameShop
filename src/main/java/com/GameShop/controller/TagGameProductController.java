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
 * @ClassName TagGameProductController
 * @Author KaoRouFan
 * @Date 2025/3/11 08:53
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/tag")
public class TagGameProductController {

    @Autowired
    private IndexShopService indexShopService;

    @RequestMapping("/findGamesByTag")
    @ResponseBody
    public String findGamesByTag(@RequestParam(value = "tag") String tag){
        List<GameProduct> gamesByTag = indexShopService.findGamesByTag(tag);
        return JSON.toJSONString(gamesByTag);
    }
}
