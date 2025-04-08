package com.GameShop.dao;

import com.GameShop.entity.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UpdatePasswordDao
 * @Author KaoRouFan
 * @Date 2025/3/31 16:22
 * @Version 1.14.5.14
 */

@Repository
public interface UpdatePasswordDao {

    //通过用户id查找旧密码和旧盐值
    @Select("select password,salt from user where id = #{id}")
    public User findOldPasswordById(@Param("id")int id);

    //通过用户id修改用户密码和盐值
    @Update("update user set password = #{password},salt = #{salt} where id = #{id}")
    public int updatePassword(@Param("password") String password, @Param("salt")String salt, @Param("id")int id);
}
