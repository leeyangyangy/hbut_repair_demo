package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Delivery;
import com.lyt.manager.modular.system.mapper.DeliveryMapper;
import com.lyt.manager.modular.system.service.DeliveryService;
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
 * @since 2022-12-03
 */
@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {


    @Resource
    private DeliveryMapper deliveryMapper;

    //    查询全部
    @Override
    public List<Delivery> findAllDelivery() {
        return deliveryMapper.findAllDelivery();
    }

    //    记录
    @Override
    public int addDelivery(Delivery delivery) {
        return deliveryMapper.addDelivery(delivery);
    }
}
