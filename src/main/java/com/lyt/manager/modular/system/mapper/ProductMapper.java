package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface ProductMapper extends BaseMapper<Product> {

    //    查询全部物料
    List<Product> findAllProduct();

    //    添加物料
    int addProduct(Product product);

    //    删除物料
    int delProductById(Integer id);

    //    修改物料
    int updateProductById(Product product);

    //    查库存,决定是否执行
    Product findProductById(Integer id);

    //    出库
    int subProductValueById(@Param("id") Integer id, @Param("value") Integer value);

    //    入库
    int addProductValueById(@Param("id") Integer id, @Param("value") Integer value);

}
