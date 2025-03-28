package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author KaoRouFan
 * @Date 2025/2/17 10:23
 * @Version 1.14.5.14
 */

/*使用@data注解简化getter/setter*/
@Data
/*用户实体类*/
public class User implements Serializable {
    /*用户id*/
    private int id;
    /*用户名称*/
    private String name;
    /*用户密码*/
    private String password;
    /*用户邮箱*/
    private String email;
    /*用户头像*/
    private String photo;
    /*用户性别*/
    private int sex;
    /*用户出生年月*/
    private String birthDate;
    /*用户手机号*/
    private String phone;
   /*用户注册时间*/
    private String regTime;
    /*用户上次登录时间*/
    private String logTime;
    /*用户个性签名*/
    private String signature;
    /*用户余额*/
    private double balance;
    /*用户状态*/
    private int status;
    /*盐值*/
    private String salt;
}
