package com.lyy.manager.modular.system.service;

import com.lyy.manager.modular.system.entity.Worker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyy.manager.modular.system.param.LoginParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface WorkerService extends IService<Worker> {

    //    查询和自己有关的工单 100001,100002
    Worker findNeedRepairOrdersByMno(@Param("mno") String mno);

    @MapKey("mno")
    Map<String,Worker> findAllWorker();

    /**
     * 师傅登录
     * @param loginParam
     * @return Worker
     */
    Worker workLogin(LoginParam loginParam);
}
