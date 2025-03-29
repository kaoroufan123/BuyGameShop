package com.GameShop.service.impl;

import com.GameShop.dao.UserRetrievePasswordDao;
import com.GameShop.service.UserRetrievePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserRetrievePasswordServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/29 15:03
 * @Version 1.14.5.14
 */

@Service
public class UserRetrievePasswordServiceImpl implements UserRetrievePasswordService {

    @Autowired
    private UserRetrievePasswordDao userRetrievePasswordDao;

    @Override
    public int retrievePassword(String email) {
        return userRetrievePasswordDao.retrievePassword(email);
    }

    @Override
    public int updatePassword(String password, String salt, String email) {
        return userRetrievePasswordDao.updatePassword(password, salt, email);
    }
}
