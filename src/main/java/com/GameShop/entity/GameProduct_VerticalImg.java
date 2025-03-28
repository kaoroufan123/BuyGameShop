package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName GameProduct_VerticalImg
 * @Author KaoRouFan
 * @Date 2025/3/27 08:18
 * @Version 1.14.5.14
 */

@Data
public class GameProduct_VerticalImg implements Serializable {
    private int id;
    private int gameProduct_id;
    private String verticalImage;

}
