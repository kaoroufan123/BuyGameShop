package com.GameShop.realm;

import com.GameShop.entity.User;
import com.GameShop.service.LoginService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @ClassName MyRealm
 * @Author KaoRouFan
 * @Date 2025/3/17 09:05
 * @Version 1.14.5.14
 */

public class MyRealm  extends AuthorizingRealm {


    @Autowired
    private LoginService loginService;

    //密码加密
    public MyRealm() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //加密方式
        matcher.setHashAlgorithmName("md5");
        //加密次数
        matcher.setHashIterations(1000);
        //存储散列后的密码是否为16进制
        matcher.isStoredCredentialsHexEncoded();
        //存储到realm中
        this.setCredentialsMatcher(matcher);
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*System.out.println("执行认证逻辑");*/

        // 将token转换为用户名密码token
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 从数据库查询用户信息
        String username = upToken.getUsername();
        User user = loginService.loginUser(username);

        // 用户不存在验证
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        //用户是否禁用验证
        if(user.getStatus() == 1){
            throw new LockedAccountException("用户已被禁用");
        }

        //将用户存储进session中
        Subject currentUser  = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("user",user);

        // 返回认证信息对象
        return new SimpleAuthenticationInfo(
                user.getName(),    // 用户名（principal）
                user.getPassword(),   // 数据库存储的加密密码（credentials）
                ByteSource.Util.bytes(user.getSalt()),  // 盐值（需要存到数据库）
                getName()             // realm名称
        );
    }
}
