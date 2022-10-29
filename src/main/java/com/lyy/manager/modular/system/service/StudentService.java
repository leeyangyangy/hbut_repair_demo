package com.lyy.manager.modular.system.service;

import com.lyy.manager.modular.system.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface StudentService extends IService<Student> {

    //    学生登录
    Student studentLogin(LoginParam loginParam);

    //    查询学生工单  所有提交工单
    Student studentFindAllOrders(@Param("sno") String sno);

    //    工单创建   通过学生学号进行插入(包括问题信息在内)  学生学号做了外键约束
    int addOrderByStudentNo(OrdersParam ordersParam);

    //    查询学生工单  已派单 == 正在处理
    Student studentFindAllFixingOrder(@Param("sno") String sno);

    //    查询学生工单  待接单 == 待处理
    Student studentFindAllNeedFixOrder(@Param("sno") String sno);

    //    查询学生工单  待接单 == 待处理
    Student studentFindAllFinishOrder(@Param("sno") String sno);

    //  删除学生工单   传入学生学号和工单id
    int delOrderByStudentSnoAndOrderId(OrdersParam ordersParam);
}
