package com.GameShop.service.impl;

import com.GameShop.dao.UpdatePasswordDao;
import com.GameShop.entity.User;
import com.GameShop.service.UpdatePasswordService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.GameShop.utils.ShiroPasswordValidation.validatePassword;

/**
 * @ClassName UpdatePasswordServiceImpl
 * @Author KaoRouFan
 * @Date 2025/3/31 18:44
 * @Version 1.14.5.14
 */

@Service
public class UpdatePasswordServiceImpl implements UpdatePasswordService {

    @Autowired
    private UpdatePasswordDao updatePasswordDao;

    @Override
    public boolean findOldPasswordById(int id, String oldPassword) {

        //通过用户id查找旧密码和旧盐值
        User user = updatePasswordDao.findOldPasswordById(id);

        //判断旧密码与数据库的密码是否一致，直接返回
        return validatePassword(oldPassword, user.getPassword(), user.getSalt());
    }

    @Override
    public int updatePassword(String password,  int id) {

        //随机生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();

        String encryptedPwd = new SimpleHash(
                "MD5",             // 算法
                password,       // 原始密码
                ByteSource.Util.bytes(salt),  // 盐
                1000                 // 迭代次数
        ).toHex();             // 转为16进制

        return updatePasswordDao.updatePassword(encryptedPwd, salt, id);
    }
}
