package com.GameShop.service;

import com.GameShop.entity.ShopCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName ShopCarService
 * @Author KaoRouFan
 * @Date 2025/4/2 23:46
 * @Version 1.14.5.14
 */
public interface ShopCarService {

    //根据用户ID查找购物车信息
    public List<ShopCar> findShopCarByUserId(int userId);

    //根据商品id删除购物车信息
    public int deleteShopCarByUserId(@Param("id")int id);

    //根据用户id和新余额修改用户余额
    public int updateNewBalance(int userId,int newBalance);
}
