package com.lyy.manager.modular.system.mapper;

import com.lyy.manager.modular.system.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 学生登录
     *
     * @param loginParam
     * @return Student
     */
    Student studentLogin(LoginParam loginParam);

    /**
     * 查询学生工单  所有提交工单
     *
     * @param sno
     * @return Student
     */
    Student studentFindAllOrders(@Param("sno") String sno);

    /**
     * 工单创建   通过学生学号进行插入(包括问题信息在内)  学生学号做了外键约束
     *
     * @param ordersParam
     * @return int
     */
    int addOrderByStudentNo(OrdersParam ordersParam);

    /**
     * 查询学生工单  已派单 == 正在处理
      * @param sno
     * @return Student
     */
    Student studentFindAllFixingOrder(@Param("sno") String sno);

    /**
     * 查询学生工单  待接单 == 待处理
      * @param sno
     * @return Student
     */
    Student studentFindAllNeedFixOrder(@Param("sno") String sno);

    /**
     * 查询学生工单  待接单 == 待处理
      * @param sno
     * @return Student
     */
    Student studentFindAllFinishOrder(@Param("sno") String sno);

    /**
     * 删除学生工单   传入学生学号和工单id
      * @param ordersParam
     * @return int
     */
    int delOrderByStudentSnoAndOrderId(OrdersParam ordersParam);
}
