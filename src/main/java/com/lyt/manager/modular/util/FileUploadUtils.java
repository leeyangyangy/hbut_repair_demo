package com.lyt.manager.modular.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
     * //保存文件到服务器
     * String originalFilename = headerImg.getOriginalFilename();
     * try {
     * 保存文件
     * fileUpload.transferTo(new File( path+filename ));
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */
    //指定本地文件夹存储图片，写到需要保存的目录下
    @Value("${uploadTempDir}")
    String filePath;

    //    单文件上传工具类
    public String upload(MultipartFile fileUpload) {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println("原始名" + fileUpload.getOriginalFilename());
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
        if (fileUpload.length > 0) {
//            遍历文件
            for (MultipartFile multipartFile : fileUpload) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } else {
            return null;
        }
        return "上传成功";
    }

    /**
     * 参数解释:
     * @param file64 原始字符串
     *               prefix
     * @return String
     */
    public String uploadBase64(String file64) {
//        获取文件头 分割  data:image/png;
//        fileName 拼接上传后的文件名
        String fileName = "";
        fileName = String.valueOf(UUID.randomUUID());
        System.out.println("生成原始uuid" + fileName);
//        去-
        fileName = fileName.replace("-", "");
//        prefix是处理过的字符串,被解码
        String prefixName = file64.substring(file64.lastIndexOf(",") + 1);
        System.out.println("处理过后的prefix=\n" + prefixName);
        //        base64转字节流
        byte[] fileBytes = Base64Utils.decode(prefixName);
//         获取文件后缀
//        去尾部
        String suffixName = file64.substring(0, file64.indexOf(","));
        suffixName = suffixName.substring(suffixName.lastIndexOf("/"));
//        把 / 替换成 .
        suffixName = suffixName.replace("/", ".");
//        去 ;
        suffixName=suffixName.substring(0,suffixName.indexOf(";"));
//        拼接文件名
        fileName = fileName + suffixName;
        System.out.println(suffixName);
        System.out.println(fileName);
        try {
//            拼接路径和文件名
            FileOutputStream fileOuputStream = new FileOutputStream(filePath+fileName);
            fileOuputStream.write(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传文件失败");
            return null;
        }
        return fileName;
    }

}
