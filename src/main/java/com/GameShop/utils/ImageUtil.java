package com.GameShop.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author xiaoDong
 * @version 1.0.0
 * @ClassName ImageUtil.java
 * @Description TODO
 * @createTime 2023年10月15日 21:33:00
 */
public class ImageUtil {
    /**
     * 上传图片
     *
     * @param request
     * @param pictureFile
     * @throws IOException
     */
    public static String upload(HttpServletRequest request,
                                MultipartFile pictureFile) throws IOException {
        String imgPath = null;//装配后的图片地址
        //上传图片
        if (pictureFile != null && !pictureFile.isEmpty()) {
            // 使用UUID给图片重命名，并去掉四个“-”
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            // 获取文件的扩展名
            String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
            // 设置图片上传路径
            String url = request.getSession().getServletContext().getRealPath("/static/upload");
            //设置本地上传路径
            //"user.dir"是指用户当前工作目录。如果你是在IDE中运行项目，这个目录就是你当前项目所在的根目录
            String workDirectory = System.getProperty("user.dir");
            String localDirString = workDirectory+"/src/main/webapp/static/upload";

            System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            //创建本地件
            File localDirPath = new File(localDirString);
            // 检验文件夹是否存在
            isFolderExists(url);
            // 本地的文件路径
            File localFilePath = new File(localDirPath + File.separator+ name+ "."  + ext);//文件目录+文件名称
            //将图片保存到本地
            pictureFile.transferTo(localFilePath);
            // 服务器中文件的路径
            File root_FilePath= new File(url + "/" + name + "." + ext);
            //从本地路径复制一份文件到tomcat服务器的下//避免重新部署是图片资源丢失
            Files.copy(localFilePath.toPath(), root_FilePath.toPath());
            System.out.println("上传图片到本地保存的路径：" + localFilePath);
            System.out.println("上传图片到部署项目的路径：" + root_FilePath);

            // 装配图片地址
            imgPath = "static/upload/" + name + "." + ext;
            System.out.println("装配图片地址:" + imgPath);
        }
        return imgPath;
    }

    /**
     * 验证文件夹是否存在
     *
     * @param strFolder
     * @return
     */
    public static boolean isFolderExists(String strFolder) {
        File file = new File(strFolder);
        //判断文件夹的父文件夹是否已创建
        if (!file.getParentFile().exists()) {
            //如果父文件夹创建成功
            if (file.getParentFile().mkdir()) {
                //创建子文件夹
                if (file.mkdir()) {
                    return true;
                }
            } else {
                return false;
            }
        }
        System.out.println("-----------------文件上传路径：" + strFolder);
        return true;
    }
}
