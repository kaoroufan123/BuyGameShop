package com.GameShop.controller;

import com.GameShop.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginUserController
 * @Author KaoRouFan
 * @Date 2025/3/17 18:45
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/login")
public class LoginUserController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public Map<String, Object> loginUser(@RequestParam("email") String username,
                            @RequestParam("password") String password) {

        Map<String, Object> result = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
        if(!subject.isAuthenticated()) {
            try{
                subject.login(upToken);//会触发realm的认证逻辑
                result.put("code", 200);
                result.put("msg", "登录成功");

            } catch (LockedAccountException e){
                result.put("code", 500);
                result.put("msg", "该用户已被锁定");
            } catch (AuthenticationException e){
                result.put("code", 500);
                result.put("msg", "用户名或密码错误");
            }
        }
        return result;
    }

    @RequestMapping("/updateLogTime")
    @ResponseBody
    public String updateLogTime(@RequestParam("logTime")String logTime,
                                @RequestParam("email")String email){

        int updateIndex = loginService.updateLoginLogTme(logTime, email);
        /*System.out.println(updateIndex);*/
        if(updateIndex == 1){
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "/Index";
    }
}


