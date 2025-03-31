package com.GameShop.service.impl;

import com.GameShop.dao.RefundMessageDao;
import com.GameShop.entity.User;
import com.GameShop.entity.UserWareHouse;
import com.GameShop.service.RefundMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RefundMessageServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/30 19:25
 * @Version 1.14.5.14
 */

@Service
public class RefundMessageServiceImpl implements RefundMessageService {

    @Autowired
    private RefundMessageDao refundMessageDao;

    @Autowired
    private RefundMessageService refundMessageService;

    @Override
    public UserWareHouse findGameById(int id,int gpId) {
        return refundMessageDao.findGameById(id,gpId);
    }

    @Override
    public User findUserPrice(int id) {
        return refundMessageDao.findUserPrice(id);
    }

    @Override
    public int updateUserBalance(double newBalance, int id) {
        // 查找用户余额
        User user = refundMessageService.findUserPrice(id);
        //用户余额 + 退款金额 = 新的余额
        user.setBalance(user.getBalance() + newBalance);
        return refundMessageDao.updateUserBalance(user.getBalance(),id);
    }

    @Override
    public int deleteUWHByGpId(int gpId) {
        return refundMessageDao.deleteUWHByGpId(gpId);
    }
}
