package com.GameShop.dao;

import com.GameShop.entity.GameProduct;
import com.GameShop.entity.Publisher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GamePulisherDao
 * @Author KaoRouFan
 * @Date 2025/3/10 14:13
 * @Version 1.14.5.14
 */

@Repository
public interface GamePublisherDao {

    //使用前端传的name查找游戏开发者
    public Publisher findGamePublisherWithName(@Param("name") String name);

    //使用开发者的name查找对应开发者的所有游戏
    public List<GameProduct> findGameProductWithPublisherName(@Param("name")String name);
}
