package com.GameShop.dao;

import com.GameShop.entity.GameScreen;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName GameProductMessage
 * @Author KaoRouFan
 * @Date 2025/3/8 19:21
 * @Version 1.14.5.14
 */

@Repository
public interface GameProductMessageDao {
    //查询指定id的游戏截图
    public List<GameScreen> findGameScreenById(@Param("id") int id);
}
