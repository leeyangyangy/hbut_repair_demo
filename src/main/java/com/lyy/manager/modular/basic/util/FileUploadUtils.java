package com.lyy.manager.modular.basic.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Package: com.lyy.manager.modular.basic.util
 * @Author: LEEYANGYANG
 * @Create: 2022/11/7 0:48
 * @Description: 文件上传工具类
 * 上传成功返回文件名，失败返回null
 */
@Component
public class FileUploadUtils {

    /**
     * if (!headerImg.isEmpty()) {
     *             //保存文件到服务器
     *             String originalFilename = headerImg.getOriginalFilename();
     *             try {
     *                              保存文件
     *                 fileUpload.transferTo(new File( path+filename ));
     *             } catch (IOException e) {
     *                 e.printStackTrace();
     *             }
     *         }
     *
     */
    //指定本地文件夹存储图片，写到需要保存的目录下
    @Value("${spring.filePath}")
    String filePath;

    //    单文件上传工具类
    public String upload(MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println("fileName=" + fileName);
//        非空判断
        if (ObjectUtil.isNotEmpty(fileName)) {
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("suffixName=" + suffixName);
            //重新生成文件名
            fileName = UUID.randomUUID() + suffixName;
//            分割-
            fileName = fileName.replace("-", "");
            System.out.println("fileName=" + fileName);
            try {
                //将图片保存到指定文件夹里
                fileUpload.transferTo(new File(filePath + fileName));
                //返回文件名
                return fileName;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    //    多文件上传工具类
    public String uploads(MultipartFile[] fileUpload) {
//        非空判断
        if(fileUpload.length>0){
//            遍历文件
            for (MultipartFile multipartFile:fileUpload){
//                获取原始文件名
                String fileName = multipartFile.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID() + suffixName;
                //            分割-
                fileName = fileName.replace("-", "");
                try {
                    //将图片保存到指定文件夹里
                    multipartFile.transferTo(new File(filePath + fileName));

//                    抛异常
                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }
            }
        }else {
            return null;
        }
        return "上传成功";
    }
}
