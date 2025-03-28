package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserWareHouse
 * @Author KaoRouFan
 * @Date 2025/3/21 08:34
 * @Version 1.14.5.14
 */

@Data
public class UserWareHouse implements Serializable {
    private int id;
    private int user_id;
    private int gameproduct_id;
    private String addTime;
    /*private List<User> table_user;*/
    private List<GameProduct> table_gameProduct;
}
