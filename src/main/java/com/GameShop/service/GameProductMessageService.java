package com.GameShop.service;

import com.GameShop.entity.GameScreen;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ClassName GameProductMessageService
 * @Author KaoRouFan
 * @Date 2025/3/8 19:28
 * @Version 1.14.5.14
 */

public interface GameProductMessageService {
    //查询指定id的游戏截图
    public List<GameScreen> findGameScreenById(int id);
}
