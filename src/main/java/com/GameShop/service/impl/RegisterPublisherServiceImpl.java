package com.GameShop.service.impl;

import com.GameShop.entity.Publisher;
import com.GameShop.service.RegisterPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GameShop.dao.RegisterPublisherDao;

/**
 * @ClassName RegisterPublisherServiceImpl
 * @Author KaoRouFan
 * @Date 2025/2/17 15:13
 * @Version 1.14.5.14
 */
@Service("RegisterPublisherService")
public class RegisterPublisherServiceImpl implements RegisterPublisherService {

    @Autowired
    private RegisterPublisherDao registerPublisherDao;


    @Override
    public int registerPublisher(String name, String email, String password, String establishDate) {
        return registerPublisherDao.registerPublisher(name, email, password, establishDate);
    }
}
