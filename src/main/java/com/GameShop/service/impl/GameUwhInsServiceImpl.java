package com.GameShop.service.impl;

import com.GameShop.dao.GameUwhInsDao;
import com.GameShop.service.GameUwhInsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName GameUwhInsServiceImpl
 * @Author KaoRouFan
 * @Date 2025/4/6 22:50
 * @Version 1.14.5.14
 */

@Service
public class GameUwhInsServiceImpl implements GameUwhInsService {

    @Autowired
    private GameUwhInsDao gameUwhInsDao;


    @Override
    public int gameOrder(String orderNumber, String userId, String gameId, String payTime) {
        return gameUwhInsDao.gameOrder(orderNumber, userId, gameId, payTime);
    }

    @Override
    public int findOrderNumber(String orderNumber) {
        return Integer.parseInt(gameUwhInsDao.findOrderNumber(orderNumber));
    }

    @Override
    public int addGameToUWH(String userId, String gameId,  String orderNumber) {
        //获取当前日期
        String addTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return gameUwhInsDao.addGameToUWH(userId, gameId, addTime, orderNumber);
    }

    @Override
    public int deleteShoppingCar(String gameId, String userId) {
        return gameUwhInsDao.deleteShoppingCar(gameId, userId);
    }
}
