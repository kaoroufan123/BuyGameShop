package com.GameShop.controller;

import com.GameShop.service.UpdateUserImgService;
import com.GameShop.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName UpdateUserImgController
 * @Author KaoRouFan
 * @Date 2025/3/25 18:53
 * @Version 1.14.5.14
 */

@Controller
@RequestMapping("/userUpdateImgController")
public class UpdateUserImgController {

    @Autowired
    private UpdateUserImgService updateUserImgService;

    @Value("D:\\apache-maven-3.6.1\\Works\\BuyGameShop\\src\\main\\webapp\\img\\userTx\\")
    private String uploadDir;

    @RequestMapping("/uploadAvatar")
    @ResponseBody
    public Map<String, Object> uploadAvatar(@RequestParam("avatar") MultipartFile file,
                                            @RequestParam("userId") int id, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            String photoPath = ImageUtil.upload(request, file);
            System.out.println(photoPath);
            // 更新数据库
            updateUserImgService.updateUserPhoto(id, photoPath);
            result.put("success", true);

        } catch (Exception e) {
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/UpdateImg")
    public String linkImgUpdate(){
        return "UpdateUserImg";
    }
}
