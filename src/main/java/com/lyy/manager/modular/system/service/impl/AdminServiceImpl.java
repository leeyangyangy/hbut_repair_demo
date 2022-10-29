package com.lyy.manager.modular.system.service.impl;

import com.lyy.manager.modular.system.entity.Admin;
import com.lyy.manager.modular.system.mapper.AdminMapper;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin adminLogin(LoginParam loginParam) {
        return this.baseMapper.adminLogin(loginParam);
    }
}
