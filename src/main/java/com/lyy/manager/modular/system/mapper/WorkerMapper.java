package com.lyy.manager.modular.system.mapper;

import com.lyy.manager.modular.system.entity.Student;
import com.lyy.manager.modular.system.entity.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyy.manager.modular.system.param.LoginParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface WorkerMapper extends BaseMapper<Worker> {

    /**
     * 师傅登录
      * @param loginParam
     * @return Worker
     */
    Worker workLogin(LoginParam loginParam);

    /**
     * 查询和自己有关的工单 100001,100002
      * @param mno
     * @return Worker
     */
    Worker findNeedRepairOrdersByMno(@Param("mno") String mno);

    /**
     * 管理员分配师傅
      * @return @MapKey("mno")
     */
    @MapKey("mno")
    Map<String,Worker> findAllWorker();
}
