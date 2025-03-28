package com.GameShop.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RegisterUserDao
 * @Author KaoRouFan
 * @Date 2025/2/18 10:46
 * @Version 1.14.5.14
 */
@Repository
//用户注册
public interface RegisterUserDao {
    //查询是否有重复邮箱
    public int checkUserEmail(@Param("email")String email);

    //用户注册
    /*
    * 前端给后端提供 用户名 邮箱 密码 手机 注册时间
    * photo为 默认图片
    * sex为"2"（保密）
    * birthdate为"2000-01-01"
    * logTime为"2000-01-01"
    * signature为"无"
    * balance为"0"
    * status为"0"
    */
    public int registerUser(@Param("name")String name,@Param("email")String email,
                                        @Param("password")String password,@Param("phone")String phone,
                                        @Param("regTime")String regTime,@Param("salt")String salt);
}
