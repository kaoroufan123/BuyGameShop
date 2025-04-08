package com.GameShop.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName GameUwhInsService
 * @Author KaoRouFan
 * @Date 2025/4/6 22:47
 * @Version 1.14.5.14
 */
public interface GameUwhInsService {

    //当用户购物游戏商品时创建一条订单
    public int gameOrder(String orderNumber, String userId, String gameId, String payTime);

    //查询订单的id
    public int findOrderNumber(String orderNumber);

    //将游戏添加到用户的游戏库内
    public int addGameToUWH(String userId,String gameId,String orderNumber);

    //删除购物车中的游戏
    public int deleteShoppingCar(String gameId,String userId);
}
