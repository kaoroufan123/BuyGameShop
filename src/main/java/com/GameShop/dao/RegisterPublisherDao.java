package com.GameShop.dao;

import com.GameShop.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RegisterPublisher
 * @Author KaoRouFan
 * @Date 2025/2/17 14:58
 * @Version 1.14.5.14
 */
@Repository // 游戏厂商注册
public interface RegisterPublisherDao {

    // 注册游戏厂商
    //String name,String account,String password,String photo
    // 前端给后端提供 用户名 账号 密码 注册时间 其余为默认值
    public int registerPublisher(@Param("name")String name,@Param("email")String email,
                                 @Param("password")String password,@Param("establishDate")String establishDate);
}
