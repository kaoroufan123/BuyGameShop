package com.GameShop.controller;

import com.GameShop.entity.User;
import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.RefundMessageService;
import com.GameShop.utils.Result;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName RefundMessageController
 * @Author KaoRouFan
 * @Date 2025/3/30 19:26
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/refundMessage")
public class RefundMessageController {

    @Autowired
    private RefundMessageService refundMessageService;

    int gpId;

    @RequestMapping("/linkRM")
    public String linkRM(@RequestParam("gpId")int gpId){
        this.gpId = gpId;
        return "RefundMessage";
    }

    @RequestMapping("/findGameById")
    @ResponseBody
    public String findGameById(@RequestParam("userId")int userId){
        UserWareHouse gameById = refundMessageService.findGameById(userId, gpId);
        return JSON.toJSONString(gameById);
    }

    @RequestMapping("/refundGame")
    @ResponseBody
    public Result refundGame(@RequestParam("newBalance")double newBalance,
                             @RequestParam("userId")int userId,
                             @RequestParam("gpId") int gpId){
        int updateUserBalance = refundMessageService.updateUserBalance(newBalance, userId);
        int deleteUWHByGpId = refundMessageService.deleteUWHByGpId(gpId);
        if(updateUserBalance == 1 && deleteUWHByGpId == 1){
            return Result.success();
        }else{
            return Result.error();
        }
    }
}
