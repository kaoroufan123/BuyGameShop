package com.GameShop.service.impl;

import com.GameShop.dao.FindUserNameAndPhotoDao;
import com.GameShop.entity.User;
import com.GameShop.service.FindUserNameAndPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FindUserNameAndPhotoServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/26 09:15
 * @Version 1.14.5.14
 */

@Service
public class FindUserNameAndPhotoServiceImpl implements FindUserNameAndPhotoService {

    @Autowired
    private FindUserNameAndPhotoDao findUserNameAndPhotoDao;

    @Override
    public User findUserNameAndPhoto(int id) {
        return findUserNameAndPhotoDao.findUserNameAndPhoto(id);
    }
}
