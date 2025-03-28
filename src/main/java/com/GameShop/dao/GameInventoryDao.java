package com.GameShop.dao;

import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GameInventoryDao
 * @Author KaoRouFan
 * @Date 2025/3/27 07:59
 * @Version 1.14.5.14
 */

@Repository
public interface GameInventoryDao {

    //根据用户id查询用户有的游戏
    public List<UserWareHouse> findGameInventoryByUserId(@Param("id") int userId);


    //根据用户id查找库存游戏的竖型图片
    public List<UserWareHouse> findGameInventoryImageByUserId(@Param("id") int userId);
}
