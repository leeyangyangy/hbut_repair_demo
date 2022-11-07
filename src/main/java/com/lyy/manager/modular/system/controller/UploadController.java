package com.lyy.manager.modular.system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.lyy.manager.framework.respone.ResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Package: com.lyy.manager.modular.system.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/11/5 18:09
 * @Description:
 */
@RestController
public class UploadController {

    //指定本地文件夹存储图片，写到需要保存的目录下
    @Value("${spring.filePath}")
    String filePath;

    @PostMapping("/upload")
    public ResponseData upload(MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println("fileName=" + fileName);
        if (ObjectUtil.isNotEmpty(fileName)) {
            //获取文件后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("suffixName=" + suffixName);
            //重新生成文件名
            fileName = UUID.randomUUID() + suffixName;
            fileName=fileName.replace("-","");
            System.out.println("fileName="+fileName);
            try {
                //将图片保存到static文件夹里
                fileUpload.transferTo(new File(filePath + fileName));
                //返回提示信息
                return ResponseData.success(200, "上传成功", true);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseData.error(-1, "上传失败", e);
            }
        } else {
            return ResponseData.error(-1, "上传失败", "文件为空");
        }
    }

    @PostMapping("/uploads")
    public ResponseData uploads(MultipartFile[] fileUpload) {
//        非空判断
        if(fileUpload.length>0){
//            遍历文件
            for (MultipartFile multipartFile:fileUpload){
//                获取原始文件名
                String fileName = multipartFile.getOriginalFilename();
                System.out.println("original file name:"+fileName);
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID() + suffixName;
                //            分割-
                fileName = fileName.replace("-", "");
                System.out.println("new name: "+fileName);
                try {
                    //将图片保存到指定文件夹里
                    multipartFile.transferTo(new File(filePath + fileName));
                    System.out.println("上传成功");
//                    抛异常
                }catch (Exception e){
                    e.printStackTrace();
                    return ResponseData.error(500,"上传错误，请联系管理员",null);
                }
            }
        }else {
            return null;
        }
        return ResponseData.success(200,"上传成功",true);
    }

}
