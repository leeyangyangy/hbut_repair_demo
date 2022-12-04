package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Product;
import com.lyt.manager.modular.system.mapper.ProductMapper;
import com.lyt.manager.modular.system.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Resource
    private ProductMapper productMapper;

    //    添加物料
    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    //    出库
    @Override
    public int subProductValueById(@Param("id") Integer id, @Param(("value")) Integer value) {
        return productMapper.subProductValueById(id, value);
    }

    //    入库
    @Override
    public int addProductValueById(@Param("id") Integer id, @Param(("value")) Integer value) {
        return productMapper.addProductValueById(id, value);
    }

    //    删除物料
    @Override
    public int delProductById(Integer id) {
        return productMapper.delProductById(id);
    }

    //    查库存
    @Override
    public Product findProductById(Integer id) {
        return productMapper.findProductById(id);
    }

    //    修改物料
    @Override
    public int updateProductById(Product product) {
        return productMapper.updateProductById(product);
    }

    //    查询全部物料
    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }
}
