package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface UserMapper extends BaseMapper<User> {
    //    用户登录
    User login(User user);

    //    查询全部用户
    List<User> findAllUser();

    //    按userId查询用户
    User findUserByUserId(String userId);

    //    根据id修改用户
    int updateUserById(User user);

//    根据id删除用户
    int deleteByUserId(String userId);

//    新增用户，默认是不允许有登录权限的
    int addUser(User user);
}
