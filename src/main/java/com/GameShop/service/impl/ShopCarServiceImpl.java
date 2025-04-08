package com.GameShop.service.impl;

import com.GameShop.dao.ShopCarDao;
import com.GameShop.entity.ShopCar;
import com.GameShop.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShopCarServiceImpl
 * @Author KaoRouFan
 * @Date 2025/4/2 23:47
 * @Version 1.14.5.14
 */

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarDao shopCarDao;

    @Override
    public List<ShopCar> findShopCarByUserId(int userId) {
        return shopCarDao.findShopCarByUserId(userId);
    }

    @Override
    public int deleteShopCarByUserId(int id) {
        return shopCarDao.deleteShopCarByUserId(id);
    }

    @Override
    public int updateNewBalance(int userId, int newBalance) {
        return shopCarDao.updateNewBalance(userId, newBalance);
    }
}
