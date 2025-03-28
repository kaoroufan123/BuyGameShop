package com.GameShop.service.impl;

import com.GameShop.dao.GameInventoryDao;
import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.GameInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName GameInventoryServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/27 08:29
 * @Version 1.14.5.14
 */

@Service
public class GameInventoryServiceImpl implements GameInventoryService {

    @Autowired
    private GameInventoryDao gameInventoryDao;

    @Override
    public List<UserWareHouse> findGameInventoryByUserId(int userId) {
        return gameInventoryDao.findGameInventoryByUserId(userId);
    }

    @Override
    public List<UserWareHouse> findGameInventoryImageByUserId(int userId) {
        return gameInventoryDao.findGameInventoryImageByUserId(userId);
    }
}
