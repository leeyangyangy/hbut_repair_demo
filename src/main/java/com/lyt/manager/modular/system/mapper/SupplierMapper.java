package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Supplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface SupplierMapper extends BaseMapper<Supplier> {

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
