package com.GameShop.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @ClassName GameUwhInsDao
 * @Author KaoRouFan
 * @Date 2025/4/6 20:47
 * @Version 1.14.5.14
 */

@Repository
public interface GameUwhInsDao {

    //当用户购物游戏商品时创建一条订单
    @Insert("INSERT  INTO orders(ordernumber, user_id, gameproduct_id, payTime) VALUES (#{orderNumber}, #{userId}, #{gameId}, #{payTime})")
    public int gameOrder(@Param("orderNumber")String orderNumber,@Param("userId")String userId,@Param("gameId")String gameId,@Param("payTime")String payTime);

    //查询订单的id
    @Select("SELECT id FROM orders WHERE ordernumber = #{orderNumber}")
    public String findOrderNumber(@Param("orderNumber")String orderNumber);

    //将游戏添加到用户的游戏库内
    @Insert("INSERT  INTO userwarehouse(user_id, gameproduct_id, addtime,order_id) VALUES (#{userId}, #{gameId}, #{addTime},#{orderId})")
    public int addGameToUWH(@Param("userId")String userId,@Param("gameId")String gameId,@Param("addTime")String addTime,@Param("orderId")String orderId);

    //删除购物车中的游戏
    @Delete("DELETE FROM shoppingcar WHERE gameproduct_id = #{gameId} AND user_id = #{userId}")
    public int deleteShoppingCar(@Param("gameId")String gameId,@Param("userId")String userId);
}
