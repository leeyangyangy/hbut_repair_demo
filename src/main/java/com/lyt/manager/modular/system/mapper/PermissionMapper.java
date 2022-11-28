package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface PermissionMapper extends BaseMapper<Permission> {

//    查询全部用户等级
    List<Permission> findAll();
}
