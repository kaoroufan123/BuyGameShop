package com.GameShop.service;

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName findUserNameAndPhotoService
 * @Author KaoRouFan
 * @Date 2025/3/26 09:14
 * @Version 1.14.5.14
 */
public interface FindUserNameAndPhotoService {

    public User findUserNameAndPhoto(int id);
}
