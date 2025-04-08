package com.GameShop.controller;

import com.GameShop.entity.GameScreen;
import com.GameShop.exception.CustomException;
import com.GameShop.service.GameProductMessageService;
import com.GameShop.service.GameUwhInsService;
import com.GameShop.utils.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private GameUwhInsService gameUwhInsService;


    @RequestMapping("/gameScreen")
    @ResponseBody
    public String findGameScreen(@RequestParam(value = "id")int id){
        List<GameScreen> gameScreensList = gameProductMessageService.findGameScreenById(id);
        return JSON.toJSONString(gameScreensList);
    }

    @RequestMapping ("/findUWH")
    @ResponseBody
    public int findUWH(@RequestParam("userId") int userId,
                          @RequestParam("gameId") int gameId){

        System.out.println("userId = " + userId+" gameId = "+gameId);
        int findUWHIndex = gameProductMessageService.findUWHGameByUidGid(userId, gameId);

        if(findUWHIndex > 0){
            //如果库中存在则直接返回(+10表示库中含有该游戏)
            /*return Result.success(findUWHIndex+10);*/
            return findUWHIndex+10;
        }else{

            int findSCIndex = gameProductMessageService.findSCGameByUidGid(userId, gameId);
            if(findSCIndex > 0){
                //如果购物车中存在则返回(+100表示购物车中含有该游戏)
                /*return Result.success(findSCIndex+100);*/
                return findSCIndex+100;
            }else{
                //如果都不存在则直接返回(+1000表示都不存在)
                /*return Result.success(1000);*/
                return 1000;
            }
        }
    }

    @RequestMapping("/insertSC")
    @ResponseBody
    public Result insertSC(@RequestParam("gpId")int id,@RequestParam("userId")int userId,@RequestParam("gamePrice") double gamePrice){
        int index = gameProductMessageService.insertSC(userId, id, gamePrice);
        if(!(index  > 0)){
            throw new CustomException("500","添加失败");
        }else{
            return Result.success(index);
        }
    }

    @GetMapping("/linkSC")
    public String linkSC(){
        return "/GameShopCar";
    }

    @PostMapping("/insertUG")
    @ResponseBody
    public Result insUG(@RequestParam("orderNumber")String orderNumber,@RequestParam("userId")String userId,@RequestParam("gpId")String gameId,@RequestParam("payTime")String payTime){
        int insOrder = gameUwhInsService.gameOrder(orderNumber, userId, gameId, payTime);
        if(insOrder > 0){
            //查询订单的id
            int orderId = gameUwhInsService.findOrderNumber(orderNumber);
            if(orderId > 0){
                //如果查询成功则直接将免费游戏插入到用户的游戏库中
                int insUWH = gameUwhInsService.addGameToUWH(userId, gameId, String.valueOf(orderId));
                if(insUWH > 0){
                    return Result.success(insUWH);
                }else{
                    throw new CustomException("500","游戏添加失败");
                }
            }else{
                throw new CustomException("500","订单ID失败");
            }
        }else{
            throw new CustomException("500","订单创建失败");
        }
    }
}
