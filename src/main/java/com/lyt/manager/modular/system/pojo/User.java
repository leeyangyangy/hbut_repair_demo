package com.lyt.manager.modular.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lyt.manager.framework.pojo.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 登录用户名
     */
    private String userId;

    /**
     * 登录用户密码
     */
    @TableField(select = false)
    private String password;

    /**
     * 用户权限
     */
    private Integer permissionId;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 一对一关联查询
     */
    private Permission permission;
}
