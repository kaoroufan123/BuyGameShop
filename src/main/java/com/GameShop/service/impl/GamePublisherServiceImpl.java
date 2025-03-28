package com.GameShop.service.impl;

import com.GameShop.dao.GameProductMessageDao;
import com.GameShop.dao.GamePublisherDao;
import com.GameShop.entity.GameProduct;
import com.GameShop.entity.Publisher;
import com.GameShop.service.GamePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GamePublisherServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/10 14:31
 * @Version 1.14.5.14
 */
@Service
public class GamePublisherServiceImpl implements GamePublisherService {

    @Autowired
    private GamePublisherDao gamePublisherDao;

    @Override
    public Publisher findGamePublisherWithName(String name) {
        return gamePublisherDao.findGamePublisherWithName(name);
    }

    @Override
    public List<GameProduct> findGameProductWithPublisherName(String name) {
        return gamePublisherDao.findGameProductWithPublisherName(name);
    }
}
