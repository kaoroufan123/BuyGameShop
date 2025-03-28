package com.GameShop.service;

import com.GameShop.entity.GameProduct;
import com.GameShop.utils.Page;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @ClassName IndexShopService
 * @Author KaoRouFan
 * @Date 2025/3/3 08:02
 * @Version 1.14.5.14
 */
public interface IndexShopService {
    public List<GameProduct> findAllGames();


    //查询游戏总记录数
    public int findTotalCount();

    //分页查询数据
    public List<GameProduct> getGamesByPage(int start, int total);

    //根据游戏id查询游戏详情
    public GameProduct findGameById( int id);

    //根据游戏名模糊查询游戏
    public List<GameProduct> findGamesLikeByName(String name);

    //根据Tag查找相关游戏
    public List<GameProduct> findGamesByTag(String tag);
}
