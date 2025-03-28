package com.GameShop.service.impl;

import com.GameShop.dao.RegisterUserDao;
import com.GameShop.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RegisterUserServiceImpl
 * @Author KaoRouFan
 * @Date 2025/2/18 11:24
 * @Version 1.14.5.14
 */
@Service("RegisterUserService")
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private RegisterUserDao registerUserDao;

    @Override
    public int checkUserEmail(String email) {
        return registerUserDao.checkUserEmail(email);
    }

    @Override
    public int registerUser(String name, String email, String password, String phone, String regTime,String salt) {
        return registerUserDao.registerUser(name, email, password, phone, regTime,salt);
    }
}
