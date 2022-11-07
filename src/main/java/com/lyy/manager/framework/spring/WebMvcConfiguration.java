package com.lyy.manager.framework.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Package: com.lyy.manager.framework.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/11/5 14:42
 * @Description:
 */

/**
 * WebMvcConfigurer食用方法
 *  实现WebMvcConfigurer接口，重写addResourceHandlers方法 添加资源映射路径
 *  调用registry 的 addResourceHandler("/**").addResourceLocations("classpath:/路径/")完成映射添加
 */
@Slf4j
@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {
    //获取配置文件中图片的路径
    @Value("${spring.imagesPath}")
    private String mImagesPath;

//    访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
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
