package com.GameShop.dao;

import com.GameShop.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TagDao
 * @Author KaoRouFan
 * @Date 2025/2/24 08:23
 * @Version 1.14.5.14
 */
@Repository
//查询游戏Tag显示在主页左侧
public interface TagDao {

    //查询所有Tag
    public List<Tag>  selectAllTags();

}
