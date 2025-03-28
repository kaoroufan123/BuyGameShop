package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName GameProduct
 * @Author KaoRouFan
 * @Date 2025/2/17 10:12
 * @Version 1.14.5.14
 */
@Data
public class GameProduct implements Serializable {
    /*游戏商品id*/
    private int id;
    /*游戏名称*/
    private String name;
    /*游戏头像*/
    private String gamePhoto;
    /*游戏厂商ID*/
    private int publisher_id;
    /*游戏tag*/
    private String tag;
    /*游戏介绍*/
    private String gameIntro;
    /*游戏发售时间*/
    private String issuingDate;
    /*游戏价格*/
    private double price;
    /*游戏评分*/
    private double mark;
    /*游戏销量*/
    private int saleNum;
    /*游戏厂商List*/
    private List<Publisher> publishersList;
    /* 游戏竖图 */
    private List<GameProduct_VerticalImg> table_verticalImgList;
}
