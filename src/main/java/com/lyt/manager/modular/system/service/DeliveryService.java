package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.Delivery;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-12-03
 */
public interface DeliveryService extends IService<Delivery> {
    //    查询全部
    List<Delivery> findAllDelivery();

    //    插入记录
    int addDelivery(Delivery delivery);
}
