package com.GameShop.service.impl;

import com.GameShop.dao.IndexShopDao;
import com.GameShop.entity.GameProduct;
import com.GameShop.utils.Page;
import com.GameShop.service.IndexShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName IndexShopServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/3 08:03
 * @Version 1.14.5.14
 */
@Service
public class IndexShopServiceImpl implements IndexShopService {

    @Autowired
    private IndexShopDao indexShopDao;

    @Override
    public List<GameProduct> findAllGames() {
        return indexShopDao.findAllGames();
    }


    @Override
    public int findTotalCount() {
        return indexShopDao.findTotalCount();
    }

    @Override
    public List<GameProduct> getGamesByPage(int start, int total){
        return indexShopDao.findAllGamesByCategory(start, total);
    }

    @Override
    public GameProduct findGameById(int id) {
        return indexShopDao.findGameById(id);
    }

    @Override
    public List<GameProduct> findGamesLikeByName(String name) {
        return indexShopDao.findGamesLikeByName(name);
    }

    @Override
    public List<GameProduct> findGamesByTag(String tag) {
        return indexShopDao.findGamesByTag(tag);
    }


}
