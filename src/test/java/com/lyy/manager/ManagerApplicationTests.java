package com.lyy.manager;

import com.lyy.manager.modular.system.entity.*;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import com.lyy.manager.modular.system.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ManagerApplicationTests {

//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private OrdersService ordersService;
//
//    @Autowired
//    private WorkerService workerService;
//
//    @Autowired
//    private AdminService adminService;
//
//    @Autowired
//    private FeedbackService feedbackService;
//
//    NoParam noParam = new NoParam();
//    LoginParam loginParam = new LoginParam();
//    OrdersParam ordersParam = new OrdersParam();
//    Orders orders = new Orders();
//
//    //    学生登录     打印学社提交的工单信息     ----  pass
//    @Test
//    void contextLoads() {
//        loginParam.setUsername("200001");
//        loginParam.setPassword("testabc");
////        登录功能测试
//        Student student = studentService.studentLogin(loginParam);
////        打印信息
//        System.out.println("查询到学生信息:\n" + "学生姓名:" + student.getName() + ",学生学号:" + student.getSno());
////        1.打印学生提交的所有工单信息
//        Student stuOrdersAll = studentService.studentFindAllOrders("200001");
//        List<Orders> list = stuOrdersAll.getOrdersList();
//        for (Orders orders : list) {
//            System.out.println(orders);
//        }
//    }
//
//    /**
//     * 学生模块功能测试  2.学生创建工单
//     */
//    @Test
//    @Transient
//    public void testStudentFunction() {
//        ordersParam.setSno("200001");
//        if (ordersParam.getSno() == null) {
//            return;
//        }
//        ordersParam.setDetail("测试内容");
//        ordersParam.setPicture("假装有图片");
//        ordersParam.setVariety("网络");
////        测试添加工单  200002
//        int total = studentService.addOrderByStudentNo(ordersParam);
//
//        if (total > 0) {
//            System.out.println("添加成功");
//        } else {
//
//            System.out.println("添加失败");
//        }
//    }
//
//    /**
//     * 学生模块功能测试  3.学号查询学生所有正在处理的工单
//     */
//    @Test
//    public void testStudentFindAllFixingOrder() {
//        Student student = studentService.studentFindAllFixingOrder("200001");
//        List<Orders> list = student.getOrdersList();
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    /**
//     * 学生模块功能测试  4.学号查询学生所有已完成的工单
//     */
//    @Test
//    public void testStudentFindAllFinishOrder() {
//        Student student = studentService.studentFindAllFinishOrder("200001");
//        List<Orders> list = student.getOrdersList();
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    /**
//     * 学生模块功能测试  5.学号查询学生所有待处理的工单
//     */
//    @Test
//    public void tstStudentFindAllNeedFixOrder() {
//        try {
//            Student student = studentService.studentFindAllNeedFixOrder("200001");
//            if (student.getOrdersList() != null) {
//                List<Orders> list = student.getOrdersList();
//                list.forEach(orders -> System.out.println(orders));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("数据为空查询不到");
//        }
//    }
//
//    @Test
//    public void testDelOrderById() {
//        OrdersParam ordersParam = new OrdersParam();
//        ordersParam.setId(12);
//        ordersParam.setSno("200001");
//        int total = studentService.delOrderByStudentSnoAndOrderId(ordersParam);
//        if (total > 0) {
//            System.out.println("删除成功");
//        } else {
//            System.out.println("删除失败");
//        }
//    }
//
//
//    /**
//     * 管理员模块功能测试    ----  pass
//     */
//
////    管理员登录
//    @Test
//    public void testAdminLogin() {
//        loginParam.setUsername("admin");
//        loginParam.setPassword("admin");
//        Admin adminLogin = adminService.adminLogin(loginParam);
//        if (adminLogin == null) {
//            System.out.println("登录失败");
//        } else {
//            System.out.println("登录成功");
//            System.out.println(adminLogin);
//        }
//    }
//
//    //    查询所有状态的工单    ------    pass
//    @Test
//    public void testAdminFunction() {
//        List<Orders> list = ordersService.findAllOrders();
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    //    查询所有师傅    ----  pass
//    @Test
//    public void testFindAllWorker() {
//        Map<String, Worker> map = workerService.findAllWorker();
//        System.out.println("遍历主键:");
//        for (String mno : map.keySet()) {
//            System.out.println(mno);
//        }
//        System.out.println("遍历师傅姓名:");
//        for (Worker worker : map.values()) {
//            System.out.println(worker.getName());
//        }
//    }
//
//    /**
//     * 维修工人模块功能测试       ----  pass
//     */
//    @Test
//    public void testWorkerFUnction() {
////        根据id查询待完成情况
//        Worker worker = workerService.findNeedRepairOrdersByMno("100001");
//        List<Orders> list = worker.getOrdersList();
//        for (Orders orders : list) {
//            System.out.println(orders);
//        }
//    }
//
////    查询学生地址
//    @Test
//    public void testGetStudentAdd(){
//        noParam.setId(2);
//        noParam.setMno("100001");
//        noParam.setSno("200001");
//        Orders studentAddressById = ordersService.getStudentAddressById(noParam);
//        System.out.println("学生地址是："+studentAddressById.getStudent().getAdd());
//    }
//
//    //    查询学生反馈内容    ----  pass
//    @Test
//    public void testFindStudentFeedbackBySno() {
//        List<Feedback> list = feedbackService.findAllByFsno("200001");
//        list.forEach(feedback -> System.out.println(feedback));
//    }
//
//    //    共用查询模块测试   0----1---2  分别对应工单状态
//    @Test
//    public void testCommonModule2() {
////        noParam.setSno("200001");
//        noParam.setMno("100001");
//        List<Orders> list = ordersService.finAllFinishOrderByNo(noParam);
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    @Test
//    public void testCommonModule1() {
////        noParam.setSno("200001");
//        noParam.setMno("100001");
//        List<Orders> list = ordersService.finAllFixingOrderByNo(noParam);
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    @Test
//    public void testCommonModule0() {
////        noParam.setSno("200001");
//        noParam.setMno("100001");
//        List<Orders> list = ordersService.finAllWaitForOrderByNo(noParam);
//        list.forEach(orders -> System.out.println(orders));
//    }
//
//    @Test
//    public void testCommonModuleDelOrderById() {
//        noParam.setSno("200001");
////        noParam.setMno("100001");
//        noParam.setId(3);
//        int total = ordersService.delOrderById(noParam);
//        if (total > 0) {
//            System.out.println("删除成功");
//        } else {
//            System.out.println("删除失败，没有该工单");
//        }
//    }
//
//    //    修改工单状态   包括分配师傅    异常
//    @Test
//    public void testCommonModuleUpdateOrderById() {
//        orders.setSno("200002");
//        orders.setMno("100001");
//        orders.setStatus("2");
//        orders.setFinishTime(new Date());
//        orders.setId(2);
//        int total = ordersService.updateStatusAndMnoAndIdInt(orders);
//        if (total > 0) {
//            System.out.println("修改成功");
//        } else {
//            System.out.println("修改失败，请联系管理员");
//        }
//    }

//    师傅登录
//    @Test
//    public void testWordkerLogin(){
//        loginParam.setUsername("admin");
//        loginParam.setPassword("admin");
//        Worker workLogin = workerService.workLogin(loginParam);
//        if (workLogin!=null){
//            System.out.println("登录成功");
//        }else {
//            System.out.println("登录失败");
//        }
//    }

}
