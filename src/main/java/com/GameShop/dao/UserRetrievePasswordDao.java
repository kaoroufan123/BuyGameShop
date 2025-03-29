package com.GameShop.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRetrievePasswordDap
 * @Author KaoRouFan
 * @Date 2025/3/29 14:46
 * @Version 1.14.5.14
 */

@Repository
public interface UserRetrievePasswordDao {

    //查找邮箱是否存在
    public int retrievePassword(@Param("email")String email);

    //用户找回密码（修改密码）
    public int updatePassword(@Param("password")String password, @Param("salt")String salt,@Param("email")String email);
}
