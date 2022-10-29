package com.lyy.manager.modular.system.service.impl;

import com.lyy.manager.modular.system.entity.Student;
import com.lyy.manager.modular.system.mapper.StudentMapper;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import com.lyy.manager.modular.system.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student studentLogin(LoginParam loginParam) {
//        return studentMapper.studentLogin(id, password);
        return this.baseMapper.studentLogin(loginParam);
    }

    @Override
    public Student studentFindAllOrders(String sno) {
        return this.baseMapper.studentFindAllOrders(sno);
    }

    @Override
    public int addOrderByStudentNo(OrdersParam ordersParam) {
        return this.baseMapper.addOrderByStudentNo(ordersParam);
    }

    @Override
    public Student studentFindAllFixingOrder(String sno) {
        return this.baseMapper.studentFindAllFixingOrder(sno);
    }

    @Override
    public int delOrderByStudentSnoAndOrderId(OrdersParam ordersParam) {
        return this.baseMapper.delOrderByStudentSnoAndOrderId(ordersParam);
    }

    @Override
    public Student studentFindAllNeedFixOrder(String sno) {
        return this.baseMapper.studentFindAllNeedFixOrder(sno);
    }

    @Override
    public Student studentFindAllFinishOrder(String sno) {
        return this.baseMapper.studentFindAllFinishOrder(sno);
    }
}
