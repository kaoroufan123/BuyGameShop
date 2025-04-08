package com.GameShop.utils;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ClassName validatePassword
 * @Author KaoRouFan
 * @Date 2025/4/1 08:05
 * @Version 1.14.5.14
 */
public class ShiroPasswordValidation {

    public static boolean validatePassword(String plainPassword, String dbPassword, String salt) {

        // 1. 使用 MD5 算法迭代 1000 次生成哈希
        SimpleHash calculatedHash = new SimpleHash(
                "MD5",                   // 算法
                plainPassword,           // 明文密码
                ByteSource.Util.bytes(salt),        // 盐值
                1000                     // 迭代次数
        );

        // 2. 比较哈希值（不区分大小写）
        return calculatedHash.toHex().equalsIgnoreCase(dbPassword);
    }
}

