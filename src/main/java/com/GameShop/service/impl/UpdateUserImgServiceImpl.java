package com.GameShop.service.impl;

import com.GameShop.dao.UpdateUserImgDao;
import com.GameShop.entity.User;
import com.GameShop.service.UpdateUserImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UpdateUserImgServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/25 18:48
 * @Version 1.14.5.14
 */
@Service
public class UpdateUserImgServiceImpl implements UpdateUserImgService {

    @Autowired
    private UpdateUserImgDao updateUserImgDao;

    @Override
    @Transactional
    public int updateUserPhoto(int id, String photo) {
        return updateUserImgDao.updateUserPhoto(id, photo);
    }
}
