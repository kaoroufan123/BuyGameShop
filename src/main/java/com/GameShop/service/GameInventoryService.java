package com.GameShop.service;

import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GameInventoryService
 * @Author KaoRouFan
 * @Date 2025/3/27 08:28
 * @Version 1.14.5.14
 */
public interface GameInventoryService {

    //根据用户id查询用户有的游戏
    public List<UserWareHouse> findGameInventoryByUserId(int userId);


    //根据用户id查找库存游戏的竖型图片
    public List<UserWareHouse> findGameInventoryImageByUserId(int userId);
}
