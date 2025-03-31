package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Order
 * @Author KaoRouFan
 * @Date 2025/3/31 08:45
 * @Version 1.14.5.14
 */

@Data
public class Order implements Serializable {
    private int id;
    private int orderNumber;
    private int userId;
    private int gameProduct_id;
    private String payTime;
}
