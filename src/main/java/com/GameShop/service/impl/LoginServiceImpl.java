package com.GameShop.service.impl;

import com.GameShop.dao.LoginDao;
import com.GameShop.entity.User;
import com.GameShop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/17 15:08
 * @Version 1.14.5.14
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public User loginUser(String email) {
        return loginDao.loginUser(email);
    }

    @Override
    public int updateLoginLogTme(String logTime, String email) {
        return loginDao.updateLoginLogTme(logTime, email);
    }
}
