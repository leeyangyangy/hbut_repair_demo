package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.Storage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyy
 * @since 2022-12-03
 */
public interface StorageService extends IService<Storage> {
    //    查询全部
    List<Storage> findAllStorage();

    //    插入记录
    int addStorage(Storage storage);
}
