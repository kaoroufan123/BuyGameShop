package com.GameShop.dao;

import com.GameShop.entity.GameScreen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GameProductMessage
 * @Author KaoRouFan
 * @Date 2025/3/8 19:21
 * @Version 1.14.5.14
 */

@Repository
public interface GameProductMessageDao {
    //查询指定id的游戏截图
    public List<GameScreen> findGameScreenById(@Param("id") int id);

    //通过userId和gameId查询该游戏是否在该用户的游戏库中存在
    @Select("SELECT   COUNT(*)    FROM userwarehouse WHERE gameproduct_id = #{gameId} AND user_id = #{userId}")
    public int findUWHGameByUidGid(@Param("userId") int userId, @Param("gameId") int gameId);

    //通过userId和gameId查询该游戏是否在该用户的购物车中
    @Select("SELECT  COUNT(*)  FROM shoppingcar WHERE user_id = #{userId} AND gameproduct_id = #{gameId}")
    public int findSCGameByUidGid(@Param("userId") int userId, @Param("gameId") int gameId);

    //添加游戏到购物车(userId,gameProduct_id,price)
    @Insert("insert into shoppingcar(user_id,gameproduct_id,price)  values (#{userId},#{gameProduct_id},#{price})")
    public int insertSC(@Param("userId")int userId, @Param("gameProduct_id")int gpId, @Param("price")double price);
}
