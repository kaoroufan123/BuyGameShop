package com.GameShop.utils;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FileUploadListener
 * @Author KaoRouFan
 * @Date 2025/3/26 17:20
 * @Version 1.14.5.14
 */
@WebListener
public class FileUploadListener  implements ServletContextListener {
    private static final String UPLOAD_DIR = "/img/userTx";
    private Map<String, String> fileCache = new HashMap<>();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String uploadPath = context.getRealPath(UPLOAD_DIR);
        // 创建目录（如果不存在）
        File uploadDir = new File(uploadPath);
        if (uploadDir.exists()) {
            for (File file : uploadDir.listFiles()) {
                String fileName = file.getName();
                String accessUrl = context.getContextPath() + "/img/userTx/" + fileName;
                context.setAttribute(fileName, accessUrl); // 缓存文件 URL
            }

        }

        // 扫描已有文件并缓存
        scanAndCacheFiles(uploadDir, context);
    }

    private void scanAndCacheFiles(File dir, ServletContext context) {
        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    // 缓存文件名和访问路径
                    String fileName = file.getName();
                    String accessUrl = context.getContextPath() + UPLOAD_DIR + "/" + fileName;
                    fileCache.put(fileName, accessUrl);
                }
            }
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        fileCache.clear();
    }
}
