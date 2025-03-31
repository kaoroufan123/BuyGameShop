package com.GameShop.service;

import com.GameShop.entity.User;
import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName RefundMessageService
 * @Author KaoRouFan
 * @Date 2025/3/30 19:25
 * @Version 1.14.5.14
 */


public interface RefundMessageService {

    //通过id查找选中的游戏信息
    public UserWareHouse findGameById(int id,int gpId);

    //查找用户的余额
    public User findUserPrice(int id);

    //相加余额后将新的余额更新至数据库中
    public int updateUserBalance(double newBalance,int id);

    //通过gameproduct_id删除用户库中的游戏
    public int deleteUWHByGpId(int gpId);
}
