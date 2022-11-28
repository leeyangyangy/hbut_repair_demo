package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.mapper.UserMapper;
import com.lyt.manager.modular.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
