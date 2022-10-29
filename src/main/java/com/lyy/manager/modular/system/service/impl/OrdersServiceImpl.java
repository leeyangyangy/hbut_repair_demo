package com.lyy.manager.modular.system.service.impl;

import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.mapper.OrdersMapper;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import com.lyy.manager.modular.system.service.OrdersService;
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
 * @since 2022-10-26
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Override
    public List<Orders> findAllOrders() {
        return this.baseMapper.findAllOrders();
    }

    @Override
    public List<Orders> finAllFinishOrderByNo(NoParam noParam) {
        return this.baseMapper.finAllFinishOrderByNo(noParam);
    }

    @Override
    public int delOrderById(NoParam noParam) {
        return this.baseMapper.delOrderById(noParam);
    }

    @Override
    public List<Orders> findAllAnyOrdersByNo(NoParam noParam) {
        return this.baseMapper.findAllAnyOrdersByNo(noParam);
    }

    @Override
    public Orders getStudentAddressById(NoParam noParam) {
        return this.baseMapper.getStudentAddressById(noParam);
    }

    @Override
    public int updateStatusAndMnoAndIdInt(Orders orders) {
        return this.baseMapper.updateStatusAndMnoAndIdInt(orders);
    }

    @Override
    public List<Orders> finAllWaitForOrderByNo(NoParam noParam) {
        return this.baseMapper.finAllWaitForOrderByNo(noParam);
    }

    @Override
    public List<Orders> finAllFixingOrderByNo(NoParam noParam) {
        return this.baseMapper.finAllFixingOrderByNo(noParam);
    }
}
