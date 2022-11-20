package com.lyy.manager.modular.system.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Package: com.lyy.manager.modular.system.param
 * @Author: LEEYANGYANG
 * @Create: 2022/10/27 0:57
 * @Description:
 */
@Data
public class OrdersParam {

    /**
     * 工单id号
     */
    private Integer id;

    /**
     * 学生学号
     */
    private String sno;

    /**
     * 维修师傅工号
     */
    private String mno;

    /**
     * 报修种类
     */
    private String variety;

    /**
     * 问题图片
     */
    private String picture;

    /**
     * 问题描述
     */
    private String detail;

    /**
     * 工单状态
     */
    private String status;

    /**
     * 工单状态
     */
    private MultipartFile file;
}
