package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Administor
 * @Author KaoRouFan
 * @Date 2025/2/17 11:32
 * @Version 1.14.5.14
 */
/*使用@data注解简化getter/setter*/
@Data
/*管理员实体类*/
public class Administor implements Serializable {
    /*管理员id*/
    private int id;
    /*管理员名称*/
    private String name;
    /*管理员账号*/
    private String email;
    /*管理员密码*/
    private String password;
    /*管理员注册时间*/
    private String regTime;
    /*管理员上次登录时间*/
    private String logTime;
}
