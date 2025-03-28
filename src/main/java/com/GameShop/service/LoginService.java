package com.GameShop.service;

import com.GameShop.dao.LoginDao;
import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName LoginService
 * @Author KaoRouFan
 * @Date 2025/3/17 15:07
 * @Version 1.14.5.14
 */

public interface LoginService {

    //使用shiro查询用户（只需邮箱）
    public User loginUser(@Param("email") String email);

    public int updateLoginLogTme(String logTime,String email);
}
