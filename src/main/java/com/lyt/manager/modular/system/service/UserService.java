package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface UserService extends IService<User> {
    //    用户登录
    User login(User user);
}
