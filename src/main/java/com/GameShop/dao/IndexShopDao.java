package com.GameShop.dao;

import com.GameShop.entity.GameProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName IndexShopDao
 * @Author KaoRouFan
 * @Date 2025/3/3 08:01
 * @Version 1.14.5.14
 */
@Repository
public interface IndexShopDao {
    //查询随机五个游戏显示在轮播图上
    public List<GameProduct> findAllGames();

    //查询游戏总记录数
    public int findTotalCount();

    //分页查询数据
    public List<GameProduct> findAllGamesByCategory(@Param("start")int start, @Param("total")int total);

    //根据游戏id查询游戏详情
    public GameProduct findGameById(@Param("id") int id);

    //根据游戏名模糊查询游戏
    public List<GameProduct> findGamesLikeByName(@Param("name")String name);

    //根据Tag查找相关游戏
    public List<GameProduct> findGamesByTag(@Param("tag")String tag);
}
