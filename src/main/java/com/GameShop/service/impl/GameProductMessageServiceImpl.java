package com.GameShop.service.impl;

import com.GameShop.dao.GameProductMessageDao;
import com.GameShop.entity.GameScreen;
import com.GameShop.service.GameProductMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName GameProductMessageServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/8 19:29
 * @Version 1.14.5.14
 */
@Service
public class GameProductMessageServiceImpl implements GameProductMessageService {

    @Autowired
    private GameProductMessageDao gameProductMessageDao;

    @Override
    public List<GameScreen> findGameScreenById(int id) {
        return gameProductMessageDao.findGameScreenById(id);
    }
}
