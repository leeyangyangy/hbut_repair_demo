package com.lyy.manager.modular.system.controller;


import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.system.entity.Feedback;
import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import com.lyy.manager.modular.system.service.FeedbackService;
import com.lyy.manager.modular.system.service.OrdersService;
import com.lyy.manager.modular.system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/student/orders")
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    private OrdersService ordersService;
    NoParam noParam = new NoParam();

    //    restful风格           sno
    //查询所有工单记录
//    @RequestMapping(value = "/orders/{sno}/all", method = RequestMethod.GET)
//    public List<Orders> order(@PathVariable("sno") Integer sno) {
//        try {
//            Student studentFindAllOrders = studentService.studentFindAllOrders(sno);
//            List<Orders> list = studentFindAllOrders.getOrdersList();
//            return list;
////            return ResponseData.success(200,"数据请求成功",stuOrdersAll.getOrdersList());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    //    查询所有工单记录
//    @RequestMapping(value = "/orders/{sno}/all", method = RequestMethod.GET)
    @GetMapping("/{sno}")
    public ResponseData order(@PathVariable("sno") String sno) {
//        try {
//            Student studentFindAllOrders = studentService.studentFindAllOrders(sno);
//            List<Orders> list = studentFindAllOrders.getOrdersList();
//            return ResponseData.success(studentFindAllOrders);
////            return ResponseData.success(200,"数据请求成功",stuOrdersAll.getOrdersList());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseData.error(null);
//        }
        noParam.setSno(sno);
        List<Orders> list = ordersService.findAllAnyOrdersByNo(noParam);
        if (list != null) {
            System.out.println("查询成功");
            return ResponseData.success(20041, "数据查询成功", list);
        } else {
            System.out.println("没有对应的数据");
            return ResponseData.error(20040, "找不到对应数据", null);
        }

    }

    //    查询已派单
    @GetMapping(value = "/{sno}/working")
    public ResponseData ordersWorking(@PathVariable("sno") String sno) {
        noParam.setSno(sno);    //设置学号
        List<Orders> list = ordersService.finAllFixingOrderByNo(noParam);
        if (list != null) {
            return ResponseData.success(20041, "请求成功", list);
        } else {
            return ResponseData.error(20040, "数据查询失败，请重试!", null);
        }
    }

    //    查询待处理
    @GetMapping(value = "/{sno}/wait")
    public ResponseData ordersWait(@PathVariable("sno") String sno) {
        noParam.setSno(sno);    //设置学号
        List<Orders> list = ordersService.finAllWaitForOrderByNo(noParam);
        if (list != null) {
            return ResponseData.success(20041, "数据查询成功", list);
        } else {
            return ResponseData.error(20040, "数据查询失败，请重试!", null);
        }
    }

//    查询完成的工单
    @GetMapping(value = "/{sno}/finished")
    public ResponseData ordersFinished(@PathVariable("sno") String sno) {
        noParam.setSno(sno);    //设置学号
        List<Orders> list = ordersService.finAllFinishOrderByNo(noParam);
        if (list != null) {
            return ResponseData.success(20041, "数据查询成功", list);
        } else {
            return ResponseData.error(20040, "数据查询失败，请重试!", null);
        }
    }


    //-------------------------------
    //    添加
    @PostMapping(value = "/{sno}")
    public ResponseData ordersCreate(@RequestBody OrdersParam ordersParam) {
        if (studentService.addOrderByStudentNo(ordersParam) > 0) {
            return ResponseData.success(20011, "添加成功",true);
        } else {
            return ResponseData.error(20010, "添加失败", false);
        }
    }

    //    删除
//    @Transient
//    @RequestMapping(value = "/orders/{sno}/del/{id}", method = RequestMethod.GET)
//    public ResponseData del(@RequestBody OrdersParam ordersParam) {
//        if (studentService.delOrderByStudentSnoAndOrderId(ordersParam) > 0) {
//            return ResponseData.success(200, "删除成功", null);
//        } else {
//            return ResponseData.error(404, "请求资源不存在", null);
//        }
//    }

    //    删除某个工单
//    @RequestMapping(value = "/orders/{sno}/del/{id}", method = RequestMethod.GET)
    @DeleteMapping("/{sno}/{id}")
    public ResponseData del(@PathVariable("sno") String sno, @PathVariable("id") Integer id) {
        OrdersParam ordersParam = new OrdersParam();
        ordersParam.setSno(sno);
        ordersParam.setId(id);
        if (studentService.delOrderByStudentSnoAndOrderId(ordersParam) > 0) {
            return ResponseData.success(20021, "删除成功", true);
        } else {
            return ResponseData.error(20020, "删除失败", false);
        }
    }

}

