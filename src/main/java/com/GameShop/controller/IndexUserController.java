package com.GameShop.controller;

import com.GameShop.entity.GameProduct;
import com.GameShop.utils.Page;
import com.GameShop.service.IndexShopService;
import com.alibaba.fastjson.JSON;
import com.GameShop.entity.Tag;
import com.GameShop.service.TagService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexUserController
 * @Author KaoRouFan
 * @Date 2025/2/24 08:32
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/index")
public class IndexUserController {

    @Autowired
    private TagService tagService;

    @Autowired
    private IndexShopService indexShopService;

    @RequestMapping("/findAllTags")
    @ResponseBody
    public String findAllTags() {
        List<Tag> tags = tagService.selectAllTags();
        return JSON.toJSONString(tags);
    }

    @RequestMapping("/findAllGames")
    @ResponseBody
    public String findAllGames() {
        List<GameProduct> games = indexShopService.findAllGames();
        return JSON.toJSONString(games);
    }


    @RequestMapping("/findGamesPage")
    @ResponseBody
    public String findGamesPage(@RequestParam(value = "nowPage", defaultValue = "1") Integer nowPage) {

        Page page = new Page();
        int index = nowPage;
        page.setNowPage(index);//当前页
        page.setTotal(5);//每页条数
        page.setStart(1);//起始页
        int dataAll = indexShopService.findTotalCount();//数据总数

        //计算总页数

       /* 逻辑：
        * 1.数据总数/每页条数=总页数
        * 2.总页数%每页条数!=0
        * 3.总页数++
        */
        int s = dataAll / page.getTotal();
        if (s % page.getTotal() != 0) {
            s++;
        }
        page.setPageAll(s);//总页数
        page.setGameProductList(indexShopService.getGamesByPage((page.getNowPage() - 1) * page.getTotal(), page.getTotal()));
        return JSON.toJSONString(page);
    }


    @RequestMapping("/indexGamesMessage")
    public String indexGamesMessage(@RequestParam(value = "id")int id, Model model) {
        GameProduct gameProduct = indexShopService.findGameById(id);

        // 2.将列表转为JSON字符串
        String jsonData = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonData = mapper.writeValueAsString(gameProduct);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("gameProduct", jsonData);
        return  "GameProductIndex";
    }

    @RequestMapping("/linkUserMessage")
    public String linkUserMessage() {
        return "UserMessage";
    }

    @RequestMapping("/support")
    public String SupportGames(){
        return "Support";
    }
}
