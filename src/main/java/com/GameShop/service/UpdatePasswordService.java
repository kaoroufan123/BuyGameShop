package com.GameShop.service;

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UpdatePasswordSerivce
 * @Author KaoRouFan
 * @Date 2025/3/31 18:39
 * @Version 1.14.5.14
 */
public interface UpdatePasswordService {

    //通过用户id查找旧密码和旧盐值
    public boolean findOldPasswordById(int id,String oldPassword);



    //通过用户id修改用户密码和盐值
    public int updatePassword(String password,int id);
}
