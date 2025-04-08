package com.GameShop.controller;

import com.GameShop.entity.ShopCar;
import com.GameShop.exception.CustomException;
import com.GameShop.service.GameUwhInsService;
import com.GameShop.service.ShopCarService;
import com.GameShop.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GameShopCarController
 * @Author KaoRouFan
 * @Date 2025/4/5 23:04
 * @Version 1.14.5.14
 */

@RestController
@RequestMapping("/shopCar")
public class GameShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @Autowired
    private GameUwhInsService gameUwhInsService;

    @PostMapping("/findShopCarByUserId")
    public Result findShopCarByUserId(@RequestParam("userId") int userId) {
        List<ShopCar> shopCars = shopCarService.findShopCarByUserId(userId);
        /*System.out.println(shopCars);*/
        return Result.success(shopCars);
    }

    @GetMapping("/deleteShopCarByUserId")
    public Result deleteShopCarByUserId(@RequestParam("id") int id) {
        int indexDel = shopCarService.deleteShopCarByUserId(id);
        if(indexDel == 0) {
            throw new CustomException("500","删除失败");
        }else{
            return Result.success(indexDel);
        }
    }

    @PostMapping("/insertUwh")
    public Result insertUwh(@RequestParam("orderNumber")String orderNumber,@RequestParam("userId")String userId,@RequestParam("gpId")String gameId,@RequestParam("payTime")String payTime){
        //创建订单
        int indexIns = gameUwhInsService.gameOrder(orderNumber, userId, gameId, payTime);
        if(indexIns > 0){
            //查询订单的id
            int orderId = gameUwhInsService.findOrderNumber(orderNumber);
            if(orderId > 0){
                //如果查询成功则直接将游戏插入到用户的游戏库中
                int insUWH = gameUwhInsService.addGameToUWH(userId, gameId, String.valueOf(orderId));
                if(insUWH > 0){
                    int deleteSC = gameUwhInsService.deleteShoppingCar(gameId, userId);
                    if(deleteSC > 0){
                        return Result.success(deleteSC);
                    }else{
                        throw new CustomException("500","购物车删除失败");
                    }
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

    @PostMapping("/updateUserBalance")
    public Result updateUserBalance(@RequestParam("userId") int userId,@RequestParam("balance")int balance){
        int updateBalance = shopCarService.updateNewBalance(userId, balance);
        if(updateBalance > 0){
            return Result.success(updateBalance);
        }else{
            throw new CustomException("500","余额修改失败");
        }
    }
}
