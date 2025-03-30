package com.GameShop.service;

import com.GameShop.entity.GameProduct;
import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GameRefundService
 * @Author KaoRouFan
 * @Date 2025/3/30 08:57
 * @Version 1.14.5.14
 */
public interface GameRefundService {

    //通过id查找用户游戏信息
    public List<UserWareHouse> findGameProductByUserId(String id);
}
