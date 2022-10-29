package com.lyy.manager.modular.system.service.impl;

import com.lyy.manager.modular.system.entity.Worker;
import com.lyy.manager.modular.system.mapper.WorkerMapper;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.service.WorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements WorkerService {

    @Override
    public Map<String, Worker> findAllWorker() {
        return this.baseMapper.findAllWorker();
    }

    @Override
    public Worker workLogin(LoginParam loginParam) {
        return this.baseMapper.workLogin(loginParam);
    }

    @Override
    public Worker findNeedRepairOrdersByMno(String mno) {
        return this.baseMapper.findNeedRepairOrdersByMno(mno);
    }
}
