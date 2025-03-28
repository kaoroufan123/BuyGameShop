package com.GameShop.service;

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UpdateUserService
 * @Author KaoRouFan
 * @Date 2025/3/24 19:02
 * @Version 1.14.5.14
 */
public interface UpdateUserService {

    public User findUserById(int id);

    public int updateUserById(String name,String sex,String birthday,String phone,String signature,int id);
}
