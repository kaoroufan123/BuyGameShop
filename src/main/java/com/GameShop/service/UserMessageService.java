package com.GameShop.service;

import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMessageService
 * @Author KaoRouFan
 * @Date 2025/3/21 09:13
 * @Version 1.14.5.14
 */
public interface UserMessageService {
    public List<String> findUserMessageHeaderById(int id);

    public List<UserWareHouse> findUserGamesById(int id);

    public double findUserBalanceById(int id);
}
