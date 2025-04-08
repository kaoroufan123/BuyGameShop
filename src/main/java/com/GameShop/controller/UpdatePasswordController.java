package com.GameShop.controller;

import com.GameShop.exception.CustomException;
import com.GameShop.service.UpdatePasswordService;
import com.GameShop.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UpdatePasswordController
 * @Author KaoRouFan
 * @Date 2025/3/31 18:45
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/apiUP")
public class UpdatePasswordController {

    @Autowired
    private UpdatePasswordService updatePasswordService;

    @GetMapping("/linkUP")
    public String linkUP() {
        return "UpdatePassword";
    }

    @PostMapping("/updatePassword")
    @ResponseBody
    public Result updatePassword(@RequestParam("userId")int id, @RequestParam("oldPassword")String oldPassword,@RequestParam("password")String password) {

        //通过用户id查找旧密码和旧盐值
        boolean flag = updatePasswordService.findOldPasswordById(id,oldPassword);

        if(!flag){
            throw new CustomException("500", "密码不一致");
        }else{
            //更新密码和盐值
            int index = updatePasswordService.updatePassword(password, id);
            if(index != 1){
                throw new CustomException("500", "更新失败");
            }
        }
           return Result.success();
    }

}
