package com.GameShop.dao;

/**
 * @ClassName Login
 * @Author KaoRouFan
 * @Date 2025/2/20 18:52
 * @Version 1.14.5.14
 */

import com.GameShop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {

    //使用shiro查询用户（只需邮箱）
    public User loginUser(@Param("email") String email);

    //修改登录时间
    public int updateLoginLogTme(@Param("logTime")String logTime,@Param("email")String email);

}
