package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName GameScreen
 * @Author KaoRouFan
 * @Date 2025/3/8 19:22
 * @Version 1.14.5.14
 */

@Data
public class GameScreen implements Serializable {
    private int id;
    private String gameProduct_id;
    private String screenShot;
}
