package com.lyt.manager.modular.system.paramter;

import com.lyt.manager.modular.system.pojo.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductParamter extends Product {

    /**
     * 添加一个参数判断是url还是实体文件
     * 最终判断，获取文件名+后缀 插回picture字段
     */
    String pic;

    /**
     * 文件类
     */
    MultipartFile pics;

}
