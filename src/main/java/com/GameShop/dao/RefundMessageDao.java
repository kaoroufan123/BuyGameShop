package com.GameShop.dao;

import com.GameShop.entity.User;
import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RefundMessageDao
 * @Author KaoRouFan
 * @Date 2025/3/30 19:14
 * @Version 1.14.5.14
 */

    @Repository
    public interface RefundMessageDao {

        //通过id查找选中的游戏信息
        public UserWareHouse findGameById(@Param("id") int id,@Param("gpId")int gpId);

        //查找用户的余额
        public User findUserPrice(@Param("id")int id);

        //相加余额后将新的余额更新至数据库中
        public int updateUserBalance(@Param("newBalance")double newBalance,@Param("id")int id);

        //通过gameproduct_id删除用户库中的游戏
        public int deleteUWHByGpId(@Param("gpId")int gpId);
}
