package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.mapper.UserMapper;
import com.lyt.manager.modular.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

//    根据用户id修改用户信息
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

//    新增用户
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    //    根据用户id删除
    @Override
    public int deleteByUserId(String userId) {
        return userMapper.deleteByUserId(userId);
    }

    //    查询全部用户
    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

//    按用户id查找
    @Override
    public User findUserByUserId(String userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
