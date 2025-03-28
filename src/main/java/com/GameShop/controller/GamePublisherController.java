package com.GameShop.controller;

import com.GameShop.entity.GameProduct;
import com.GameShop.entity.Publisher;
import com.GameShop.service.GamePublisherService;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName GamePublisherController
 * @Author KaoRouFan
 * @Date 2025/3/10 14:32
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/gamePublisher")
public class GamePublisherController {

    @Autowired
    private GamePublisherService gamePublisherService;

    @RequestMapping("/findGamePublisherWithName")
    public ModelAndView findGamePublisherWithName(@RequestParam(value = "name")String name){
        Publisher publisherWithName = gamePublisherService.findGamePublisherWithName(name);
        /*System.out.println(publisherWithName);*/
        // 2.将列表转为JSON字符串
        String publisherWithNameJSON = JSON.toJSONString(publisherWithName);
        ModelAndView mav = new ModelAndView();
        mav.addObject("publisherWithName", publisherWithNameJSON);
        mav.setViewName("PublisherIndex");
        return mav;
    }

    @RequestMapping("/findGameProductWithPublisherName")
    @ResponseBody
    public String findGameProductWithPublisherName(@RequestParam(value = "name")String name){
        List<GameProduct> gameProductWithPublisherName = gamePublisherService.findGameProductWithPublisherName(name);
        return JSON.toJSONString(gameProductWithPublisherName);
    }
}
