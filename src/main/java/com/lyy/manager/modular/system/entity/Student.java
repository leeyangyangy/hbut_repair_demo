package com.lyy.manager.modular.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lyy.manager.framework.pojo.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

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
public class Student extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生学号
     */
    private String sno;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 学生手机号
     */
    private String tel;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 学生住址
     */
    private String add;

    /**
     * 学生关联的工单
     */
    private List<Orders> ordersList;

    /**
     * 学生关联的反馈记录
     */
    private List<Feedback> feedbackList;

}
