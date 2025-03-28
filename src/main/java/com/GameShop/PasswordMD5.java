package com.GameShop;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * @ClassName PasswordMD5
 * @Author KaoRouFan
 * @Date 2025/3/17 15:11
 * @Version 1.14.5.14
 */
public class PasswordMD5 {


    public static void main(String[] args) {

        // 注册时生成加密密码
        /*String salt1 = new SecureRandomNumberGenerator().nextBytes().toHex(); // 生成随机盐
        String encryptedPwd = new SimpleHash(
                "MD5",             // 算法
                "123456",       // 原始密码
                ByteSource.Util.bytes(salt1),  // 盐
                1000                 // 迭代次数
        ).toHex();             // 转为16进制
         System.out.println("加密迭代后的密码:"+encryptedPwd);
        System.out.println("盐是:"+salt1);*/


        // 验证原理
        String dbPassword = "9b64c5f00039ea6a14db871ba330cd4d"; // 数据库存储的密码
        String inputPassword = "7355608"; // 用户输入的密码
        String salt = "61f7400676fe3696f7e082efedacdf03";       // 数据库存储的盐值
        int iterations = 1000;              // 与注册时相同的迭代次数

// Shiro内部计算
        String computedHash = new SimpleHash("MD5", inputPassword, salt, iterations).toHex();

// 最终比较
        boolean flag = dbPassword.equals(computedHash); // 返回true则验证通过
        System.out.println(flag);
    }
}
