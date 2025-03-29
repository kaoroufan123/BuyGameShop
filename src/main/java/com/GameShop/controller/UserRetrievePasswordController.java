package com.GameShop.controller;

import com.GameShop.service.UserRetrievePasswordService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserRetrievePasswordController
 * @Author KaoRouFan
 * @Date 2025/3/29 15:04
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/retrievePassword")
public class UserRetrievePasswordController {

    @Autowired
    private UserRetrievePasswordService userRetrievePasswordService;

    @RequestMapping("/findEmail")
    @ResponseBody
    public String findEmail(@RequestParam("email")String email){
        int indexEmail = userRetrievePasswordService.retrievePassword(email);
        if(indexEmail == 1){
            return "has";
        }else{
            return "none";
        }
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public String updatePassword(@RequestParam("password")String password, @RequestParam("email")String email){

        String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); // 生成随机盐
        String encryptedPassword = new SimpleHash(
                "MD5",             // 算法
                password,       // 原始密码
                ByteSource.Util.bytes(salt),  // 盐
                1000                 // 迭代次数
        ).toHex();             // 转为16进制

        int indexUpdate = userRetrievePasswordService.updatePassword(encryptedPassword, salt,email);
        if(indexUpdate == 1){
            return "success";
        }else{
            return "fail";
        }
    }
}
