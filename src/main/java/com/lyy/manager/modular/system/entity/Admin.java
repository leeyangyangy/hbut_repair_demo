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
public class Admin extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 管理员姓名
     */
    private String name;

    /**
     * 管理员手机号
     */
    private String tel;

    /**
     * 头像
     */
    private String avatar;


}
