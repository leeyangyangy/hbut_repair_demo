package com.lyy.manager.modular.system.service;

import com.lyy.manager.modular.system.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyy.manager.modular.system.param.LoginParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface AdminService extends IService<Admin> {
    //    管理员登录
    Admin adminLogin(LoginParam loginParam);

}
