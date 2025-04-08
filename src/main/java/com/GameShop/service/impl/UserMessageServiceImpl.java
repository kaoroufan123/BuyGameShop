package com.GameShop.service.impl;

import com.GameShop.dao.UserMessageDao;
import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserMessageServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/21 09:14
 * @Version 1.14.5.14
 */

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    private UserMessageDao userMessageDao;

    @Override
    public List<String> findUserMessageHeaderById(int id) {
        return userMessageDao.findUserMessageHeaderById(id);
    }

    @Override
    public List<UserWareHouse> findUserGamesById(int id) {
        return userMessageDao.findUserGamesById(id);
    }

    @Override
    public double findUserBalanceById(int id) {
        return userMessageDao.findUserBalanceById(id);
    }
}
