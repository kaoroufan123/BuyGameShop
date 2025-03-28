package com.GameShop.service.impl;

import com.GameShop.dao.UpdateUserDao;
import com.GameShop.entity.User;
import com.GameShop.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UpdateUserServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/24 19:02
 * @Version 1.14.5.14
 */
@Service
public class UpdateUserServiceImpl implements UpdateUserService {

    @Autowired
    private UpdateUserDao updateUserDao;

    @Override
    public User findUserById(int id) {
        return updateUserDao.findUserById(id);
    }

    @Override
    public int updateUserById(String name, String sex, String birthday, String phone, String signature, int id) {
        return updateUserDao.updateUserById(name, sex, birthday, phone, signature, id);
    }
}
