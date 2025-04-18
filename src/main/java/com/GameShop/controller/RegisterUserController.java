package com.GameShop.controller;

import com.GameShop.service.RegisterUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RegisterUserController
 * @Author KaoRouFan
 * @Date 2025/2/18 11:29
 * @Version 1.14.5.14
 */
@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {

    @Autowired
    private RegisterUserService registerUserService;

    @RequestMapping("/checkUserEmail")
    @ResponseBody
    public String checkUserEmail(@RequestParam(value = "email") String email) {
        int index = registerUserService.checkUserEmail(email);
        /*System.out.println(index);*/
        if(index == 1){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "phone") String phone,
                             @RequestParam(value = "regTime") String regTime) {

        String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); // 生成随机盐
        String encryptedPassword = new SimpleHash(
                "MD5",             // 算法
                password,       // 原始密码
                ByteSource.Util.bytes(salt),  // 盐
                1000                 // 迭代次数
        ).toHex();             // 转为16进制

        int indexInsert = registerUserService.registerUser(name, email, encryptedPassword, phone, regTime,salt);
        if(indexInsert > 0){
            return "success";
        }else{
            return "fail";
        }
    }
}
