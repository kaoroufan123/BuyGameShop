package com.GameShop.controller;

import com.GameShop.service.UpdateUserImgService;
import com.GameShop.utils.FileUploadListener;
import com.GameShop.utils.ImageUtil;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


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

           /* // 增加文件空判断
            if (file.isEmpty()) {
                throw new IllegalArgumentException("请选择上传文件");
            }

            // 生成唯一文件名
            String fileName = UUID.randomUUID() + ".jpg";

            // 保存文件
            File dest = new File(uploadDir + fileName);

            try(InputStream input = file.getInputStream()){
                Files.copy(input,dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
           // file.transferTo(dest);*/
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
