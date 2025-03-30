package com.GameShop.service.impl;

import com.GameShop.dao.GameRefundDao;
import com.GameShop.entity.GameProduct;
import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.GameRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName GameRefundServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/30 08:58
 * @Version 1.14.5.14
 */

@Service
public class GameRefundServiceImpl implements GameRefundService {

    @Autowired
    private GameRefundDao gameRefundDao;

    @Override
    public List<UserWareHouse> findGameProductByUserId(String id) {
        return gameRefundDao.findGameProductByUserId(id);
    }
}
