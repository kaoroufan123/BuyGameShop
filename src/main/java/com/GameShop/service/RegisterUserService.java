package com.GameShop.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName RegisterUserService
 * @Author KaoRouFan
 * @Date 2025/2/18 11:23
 * @Version 1.14.5.14
 */

public interface RegisterUserService {
    //查询是否有重复邮箱
    public int checkUserEmail(String email);

    //用户注册
    public int registerUser(String name,String email,
                            String password,String phone,
                            String regTime,String salt);
}
