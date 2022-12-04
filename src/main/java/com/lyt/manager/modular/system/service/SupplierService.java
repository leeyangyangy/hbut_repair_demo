package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface SupplierService extends IService<Supplier> {

    //    查询全部
    List<Supplier> findAllSupplier();

    //    按id修改
    int updateSupplierById(Supplier supplier);

    //    按id查找
    Supplier findSupplierById(Integer id);

    //    按id删除
    int delSupplierByName(Integer id);

    //    按名查找
    Supplier findSupplierByName(String supplierName);

    //    添加供应商
    int addSupplier(Supplier supplier);
}
