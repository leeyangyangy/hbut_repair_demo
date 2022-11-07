package com.lyy.manager.modular.system.controller;


import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.basic.util.FileUploadUtils;
import com.lyy.manager.modular.system.entity.Feedback;
import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.param.OrdersParam;
import com.lyy.manager.modular.system.service.FeedbackService;
import com.lyy.manager.modular.system.service.OrdersService;
import com.lyy.manager.modular.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private FileUploadUtils fileUploadUtils;

    NoParam noParam = new NoParam();

    //    拼接图片最终渲染路径   http://localhost/images/test1.jpg
    public String hostPath = "http://localhost/images/";
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
//    public ResponseData ordersCreate(@RequestBody OrdersParam ordersParam) {
    public ResponseData create(@PathVariable("sno") String sno,
                               @RequestParam("variety") String variety,
                               @RequestParam("detail") String detail,
                               @RequestPart MultipartFile picture) {
        System.out.println(picture);
        OrdersParam ordersParam = new OrdersParam();
//        ordersParam.set
        ordersParam.setSno(sno);
        ordersParam.setVariety(variety);
        ordersParam.setDetail(detail);
        System.out.println(ordersParam);
        String newFilename = fileUploadUtils.upload(picture);
        if (newFilename == null) System.out.println("文件错误");
        ordersParam.setPicture(hostPath + newFilename);
//        MultipartFile fileUpload;
//        fileUpload.getOriginalFilename()
//        String fileName = fileUploadUtils.upload();

        if (studentService.addOrderByStudentNo(ordersParam) > 0) {
            return ResponseData.success(20011, "添加成功", true);
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

    //-------------------------------
    //    修改
    @PutMapping(value = "/{sno}/{id}")
//    public ResponseData ordersCreate(@RequestBody OrdersParam ordersParam) {
    public ResponseData update(@PathVariable("sno") String sno,
                               @PathVariable("id") Integer id,
                               @RequestParam("variety") String variety,
                               @RequestParam("detail") String detail,
                               @RequestPart MultipartFile picture) {
//        ordersParam.set
        Orders orders = new Orders();
        orders.setId(id);
        orders.setSno(sno);
        orders.setVariety(variety);
        orders.setDetail(detail);
        System.out.println(orders);
        String newFilename = fileUploadUtils.upload(picture);
        if (newFilename == null) System.out.println("文件错误");
        orders.setPicture(hostPath + newFilename);
        int total = ordersService.updateStatusAndMnoAndIdInt(orders);
        if (total > 0) {
            System.out.println("修改成功");
            return ResponseData.success(20031, "修改成功", true);
        } else {
            System.out.println("修改失败，请联系管理员");
            return ResponseData.error(20030, "修改失败", false);
        }
    }
}

