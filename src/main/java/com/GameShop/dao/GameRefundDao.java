package com.GameShop.dao;

import com.GameShop.entity.GameProduct;
import com.GameShop.entity.UserWareHouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GameRefundDao
 * @Author KaoRouFan
 * @Date 2025/3/30 08:47
 * @Version 1.14.5.14
 */

@Repository
public interface GameRefundDao {

    //通过id查找用户游戏信息
    public List<UserWareHouse> findGameProductByUserId(@Param("id") String id);
}
