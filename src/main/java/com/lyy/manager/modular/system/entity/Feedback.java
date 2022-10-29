package com.lyy.manager.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Feedback extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈信息id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 反馈填写文本
     */
    private String feedback;

    /**
     * 关联学生学号
     */
    private String fsno;


}
