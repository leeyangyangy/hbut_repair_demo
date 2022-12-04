package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-12-03
 */
public interface StorageMapper extends BaseMapper<Storage> {
    //    查询全部
    List<Storage> findAllStorage();

    //    插入记录
    int addStorage(Storage storage);
}
