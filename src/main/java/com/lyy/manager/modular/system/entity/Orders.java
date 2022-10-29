package com.lyy.manager.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lyy.manager.framework.pojo.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Orders extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 工单id号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 维修师傅工号
     */
    private String mno;

    /**
     * 学生学号
     */
    private String sno;

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
     * 完成时间
     */
    private Date finishTime;

    private Student student;

}
