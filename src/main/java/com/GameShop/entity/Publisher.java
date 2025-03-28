package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Publisher
 * @Author KaoRouFan
 * @Date 2025/2/17 11:11
 * @Version 1.14.5.14
 */
/*使用@data注解简化getter/setter*/
@Data
/*游戏厂商实体类*/
public class Publisher implements Serializable {
    /*游戏厂商id*/
    private int id;
    /*游戏厂商名称*/
    private String name;
    /*游戏厂商账号*/
    private String email;
    /*游戏厂商密码*/
    private String password;
    /*游戏厂商头像*/
    private String photo;
    /*游戏厂商成立时间*/
    private String establishDate;
    /*游戏厂商简介*/
    private String intro;
    /*厂商余额*/
    private double balance;
}
