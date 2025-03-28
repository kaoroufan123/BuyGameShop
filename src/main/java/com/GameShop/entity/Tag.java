package com.GameShop.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Tag
 * @Author KaoRouFan
 * @Date 2025/2/17 11:36
 * @Version 1.14.5.14
 */
/*使用@data注解简化getter/setter*/
@Data
/*Tag实体类*/
public class Tag implements Serializable {
    /*分类id*/
    private int id;
    /*分类名称*/
    private String tagName;
}
