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
public class Worker extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 维修师傅id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 维修师傅工号
     */
    private String mno;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 维修师傅姓名
     */
    private String name;

    /**
     * 维修师傅手机号
     */
    private String tel;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 关联的工单
     * 三种状态  待接单，接单中，已完成
     */
    private List<Orders> ordersList;

}
