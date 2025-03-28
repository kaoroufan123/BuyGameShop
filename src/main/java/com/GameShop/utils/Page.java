package com.GameShop.utils;

import com.GameShop.entity.GameProduct;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Page
 * @Author KaoRouFan
 * @Date 2025/3/4 18:31
 * @Version 1.14.5.14
 */

@Data
public class Page implements Serializable {
    private int start;//起始页
    private int pageAll;//总页数
    private int total;//每页条数
    private int nowPage;//当前页
    private List<GameProduct> gameProductList;     //数据
}
