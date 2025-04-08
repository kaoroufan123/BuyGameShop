package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ShopCar
 * @Author KaoRouFan
 * @Date 2025/4/2 23:24
 * @Version 1.14.5.14
 */

@Data
public class ShopCar implements Serializable {
    private int id;
    private int userId;
    private int gameProduct_id;
    private double price;
    private List<GameProduct> table_gameProduct;
}
