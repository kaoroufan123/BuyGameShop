package com.GameShop.service;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserRetrievePasswordService
 * @Author KaoRouFan
 * @Date 2025/3/29 15:02
 * @Version 1.14.5.14
 */

public interface UserRetrievePasswordService {

    //查找邮箱是否存在
    public int retrievePassword(String email);

    //修改密码
    public int updatePassword(String password, String salt,String email);
}
