package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.mapper.PermissionMapper;
import com.lyt.manager.modular.system.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

//    查询全部用户等级
    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }
}
