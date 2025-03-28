package com.GameShop.service;

import com.GameShop.entity.GameProduct;
import com.GameShop.entity.Publisher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GamePublisherService
 * @Author KaoRouFan
 * @Date 2025/3/10 14:30
 * @Version 1.14.5.14
 */
public interface GamePublisherService {

    //使用前端传的name查找游戏开发者
    public Publisher findGamePublisherWithName( String name);

    //使用开发者的name查找对应开发者的所有游戏
    public List<GameProduct> findGameProductWithPublisherName(String name);
}
