package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Delivery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyt.manager.modular.system.pojo.User;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-12-03
 */
public interface DeliveryMapper extends BaseMapper<Delivery> {
    //    查询全部
    List<Delivery> findAllDelivery();

    //    插入记录
    int addDelivery(Delivery delivery);

//    按姓名模糊查询
    List<Delivery> findDeliveryByLikeUserName(String name);
}
