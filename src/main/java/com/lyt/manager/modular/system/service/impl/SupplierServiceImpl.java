package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Supplier;
import com.lyt.manager.modular.system.mapper.SupplierMapper;
import com.lyt.manager.modular.system.service.SupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    //    查询全部
    @Override
    public List<Supplier> findAllSupplier() {
        return supplierMapper.findAllSupplier();
    }

    //    按id更新供应商信息
    @Override
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }

//    添加供应商
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    //    按名查找
    @Override
    public Supplier findSupplierByName(String supplierName) {
        return supplierMapper.findSupplierByName(supplierName);
    }

    //    按id查找供应商信息
    @Override
    public Supplier findSupplierById(Integer id) {
        return supplierMapper.findSupplierById(id);
    }

    //    按id删除供应商
    @Override
    public int delSupplierByName(Integer id) {
        return supplierMapper.delSupplierByName(id);
    }
}
