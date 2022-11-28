package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface PermissionService extends IService<Permission> {
    //    查询全部用户等级
    List<Permission> findAll();
}
