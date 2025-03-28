package com.GameShop.dao;

/**
 * @ClassName UpdateUserDao
 * @Author KaoRouFan
 * @Date 2025/3/24 18:43
 * @Version 1.14.5.14
 */

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateUserDao {

    //查询用户信息
    public User findUserById(@Param("id")int id);

    //更新用户信息
    public int updateUserById(@Param("name")String name,
                                            @Param("sex")String sex,
                                            @Param("birthday")String birthday,
                                            @Param("phone")String phone,
                                            @Param("signature")String signature,
                                            @Param("id") int id);
}
