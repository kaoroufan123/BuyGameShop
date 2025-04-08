package com.GameShop.dao;

import com.GameShop.entity.ShopCar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ShopCarDao
 * @Author KaoRouFan
 * @Date 2025/4/2 23:23
 * @Version 1.14.5.14
 */

@Repository
public interface ShopCarDao {

    //根据用户ID查找购物车信息
    public List<ShopCar> findShopCarByUserId(@Param("userId") int userId);

    //根据商品id删除购物车信息
    @Delete("DELETE FROM shoppingcar WHERE id = #{id} ")
    public int deleteShopCarByUserId(@Param("id")int id);

    //根据用户id和新余额修改用户余额
    @Update("UPDATE user SET balance = #{newBalance} WHERE id = #{userId}")
    public int updateNewBalance(@Param("userId") int userId,@Param("newBalance") int newBalance);
}
