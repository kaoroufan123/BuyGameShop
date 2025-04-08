package com.GameShop.dao;

import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMessageDao
 * @Author KaoRouFan
 * @Date 2025/3/21 08:31
 * @Version 1.14.5.14
 */

@Repository
public interface UserMessageDao {

    //根据用户id查询用户信息和用户所有的游戏
    public List<String> findUserMessageHeaderById(@Param("id") int id);

    //根据用户id查询用户的游戏库
    public List<UserWareHouse> findUserGamesById(@Param("id") int id);

    //根据用户id查询用户余额
    @Select("SELECT balance FROM user WHERE id = #{userId}")
    public double findUserBalanceById(@Param("userId") int id);
}
