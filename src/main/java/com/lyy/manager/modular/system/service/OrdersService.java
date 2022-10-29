package com.lyy.manager.modular.system.service;

import com.lyy.manager.modular.system.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyy.manager.modular.system.param.NoParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface OrdersService extends IService<Orders> {
    //    查询所有工单
    List<Orders> findAllOrders();


    /**
     * 学生和师傅共用模块 1
     * 查询已完成  == 2
     * 根据学号sno/师傅工号查询学生所有工单
     * 如果参数为null 则是管理员查询全部，
     * 如果参数是sno，查询指定学生的工单
     * 如果参数是mno  查询指定师傅的工单
     *
     * @return List<Orders>
     */
    List<Orders> finAllFinishOrderByNo(NoParam noParam);

    /**
     * 学生和师傅共用模块 2
     * 查询正在处理  == 1
     * 根据学号sno/师傅工号查询学生所有工单
     * 如果参数为null 则是管理员查询全部，
     * 如果参数是sno，查询指定学生的工单
     * 如果参数是mno  查询指定师傅的工单
     *
     * @return List<Orders>
     */
    List<Orders> finAllFixingOrderByNo(NoParam noParam);

    /**
     * 学生和师傅共用模块 3
     * 查询等待处理  == 0
     * 根据学号sno/师傅工号查询学生所有工单
     * 如果参数为null 则是管理员查询全部，
     * 如果参数是sno，查询指定学生的工单
     * 如果参数是mno  查询指定师傅的工单
     *
     * @return List<Orders>
     */
    List<Orders> finAllWaitForOrderByNo(NoParam noParam);

    /**
     * 学生和师傅共用模块 4
     * 查询所有  == 0
     * 根据学号sno/师傅工号查询学生所有工单
     * 如果参数为null 则是管理员查询全部，
     * 如果参数是sno，查询指定学生的工单
     * 如果参数是mno  查询指定师傅的工单
     *
     * @return List<Orders>
     */

    List<Orders> findAllAnyOrdersByNo(NoParam noParam);

    /**
     * 所有用户共用删除模块
     * 所有用户可以通过自己的专属 工号或学号再或者是工单主键id删除此工单
     *                                            主键id不应出现在这
     */
    int delOrderById(NoParam noParam);

    /**
     * 管理员和维修师傅共用更新数据模块
     * @param orders
     * @return int
     */
    int updateStatusAndMnoAndIdInt(Orders orders);

    /**
     *  查询工单具体的学生地址信息
     * @param noParam
     * @return
     */
    Orders getStudentAddressById(NoParam noParam);

}
