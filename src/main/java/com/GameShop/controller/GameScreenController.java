package com.GameShop.controller;

import com.GameShop.entity.GameScreen;
import com.GameShop.service.GameProductMessageService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName GameProductMessageController
 * @Author KaoRouFan
 * @Date 2025/3/8 20:16
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/game")
public class GameScreenController {

    @Autowired
    private GameProductMessageService gameProductMessageService;

    @RequestMapping("/gameScreen")
    @ResponseBody
    public String findGameScreen(@RequestParam(value = "id")int id){
        List<GameScreen> gameScreensList = gameProductMessageService.findGameScreenById(id);
        return JSON.toJSONString(gameScreensList);
    }
}
