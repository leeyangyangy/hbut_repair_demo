package com.lyy.manager.modular.system.mapper;

import com.lyy.manager.modular.system.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyy.manager.modular.system.param.LoginParam;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface AdminMapper extends BaseMapper<Admin> {
    //    管理员登录
    Admin adminLogin(LoginParam loginParam);

}
