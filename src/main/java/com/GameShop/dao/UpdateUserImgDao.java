package com.GameShop.dao;

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UpdateUserImgDao.xml
 * @Author KaoRouFan
 * @Date 2025/3/25 18:36
 * @Version 1.14.5.14
 */

@Repository
public interface UpdateUserImgDao {

    public int updateUserPhoto(@Param("id") int userId, @Param("photo") String photo);

}
