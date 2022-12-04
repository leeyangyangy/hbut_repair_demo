package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Storage;
import com.lyt.manager.modular.system.mapper.StorageMapper;
import com.lyt.manager.modular.system.service.StorageService;
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
 * @since 2022-12-03
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Resource
    private StorageMapper storageMapper;

//    查询全部
    @Override
    public List<Storage> findAllStorage() {
        return storageMapper.findAllStorage();
    }

//    记录
    @Override
    public int addStorage(Storage storage) {
        return storageMapper.addStorage(storage);
    }
}
