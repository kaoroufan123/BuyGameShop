package com.GameShop.service;

import com.GameShop.entity.GameScreen;
import org.apache.ibatis.annotations.Param;

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

    //通过userId和gameId查询该游戏是否在该用户的游戏库中存在
    public int findUWHGameByUidGid(int userId, int gameId);

    public int findSCGameByUidGid(int userId,int gameId);

    public int insertSC(int userId, int gpId, double price);
}
