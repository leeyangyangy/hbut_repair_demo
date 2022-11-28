package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Product;
import com.lyt.manager.modular.system.mapper.ProductMapper;
import com.lyt.manager.modular.system.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
