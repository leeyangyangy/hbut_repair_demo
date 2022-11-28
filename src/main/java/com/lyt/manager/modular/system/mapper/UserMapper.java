package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface UserMapper extends BaseMapper<User> {
//    用户登录
    User login(User user);
}
