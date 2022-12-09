package com.lyt.manager.framework.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;

import static com.lyt.manager.modular.util.JudgeSystemUtils.OSNAME;

@Slf4j
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    //获取配置文件中图片的路径
    @Value("file:D:/images/")
    private String mImagesPath;

//    @Value("D:/images/")
//    String linuxPath = "/home/admin/upload/images/";

    //    访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        判断系统？
        if (OSNAME.equals("Linux")){
            mImagesPath="/home/admin/upload/images/";
        }
        // TODO Auto-generated method stub
        if (mImagesPath.equals("") || mImagesPath.equals("${spring.imagesPath}")) {
//            获取资源路径
            String imagesPath = WebMvcConfiguration.class.getClassLoader().getResource("").getPath();
//            非空判断
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
//            获取最终路径
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/images/";
            mImagesPath = imagesPath;
        }
        log.info("------imagesPath=" + mImagesPath);
//        资源映射
        registry.addResourceHandler("/images/**").addResourceLocations(mImagesPath);
    }
}
