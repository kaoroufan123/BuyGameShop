package com.GameShop.dao;

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName FindUserNameAndPhotoDao
 * @Author KaoRouFan
 * @Date 2025/3/26 09:09
 * @Version 1.14.5.14
 */

@Repository
public interface FindUserNameAndPhotoDao {

    public User findUserNameAndPhoto(@Param("id")int id);
}
