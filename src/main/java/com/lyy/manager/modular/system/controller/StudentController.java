package com.lyy.manager.modular.system.controller;


import cn.hutool.core.codec.Base64;
import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.basic.util.FileUploadUtils;

import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.param.OrdersParam;

import com.lyy.manager.modular.system.service.OrdersService;
import com.lyy.manager.modular.system.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private FileUploadUtils fileUploadUtils;



    //    拼接图片最终渲染路径   http://localhost/images/test1.jpg
//    本地测试路径
//    public String hostPath = "http://localhost/images/";
//    远程路径
    public String hostPath = "http://leeyangy.xyz:8080/images/";
    //    restful风格           sno

    //    查询所有工单记录
//    @RequestMapping(value = "/orders/{sno}/all", method = RequestMethod.GET)
    @GetMapping("/{sno}")
    public ResponseData order(@PathVariable("sno") String sno) {
        NoParam noParam = new NoParam();
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
        NoParam noParam = new NoParam();
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
        NoParam noParam = new NoParam();
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
        NoParam noParam = new NoParam();
        noParam.setSno(sno);    //设置学号
        List<Orders> list = ordersService.finAllFinishOrderByNo(noParam);
        if (list != null) {
            return ResponseData.success(20041, "数据查询成功", list);
        } else {
            return ResponseData.error(20040, "数据查询失败，请重试!", null);
        }
    }

    //    添加
    @PostMapping("/add")
//    public ResponseData ordersCreate(@RequestBody OrdersParam ordersParam) {
    public ResponseData ordersCreate(OrdersParam ordersParam) {
        System.out.println(ordersParam);
        if (ordersParam.getFile64() == null) {
            System.out.println("文件上传为空");
        } else {
            String neeFileName = fileUploadUtils.uploadBase64(ordersParam.getFile64());
            if (neeFileName == null) System.out.println("文件错误");
            ordersParam.setPicture(hostPath + neeFileName);
        }
//        io流上传文件
//        MultipartFile fileUpload;
//        fileUpload.getOriginalFilename()
//        String fileName = fileUploadUtils.upload();

        if (studentService.addOrderByStudentNo(ordersParam) > 0) {
            return ResponseData.success(20011, "添加成功", true);
        } else {
            return ResponseData.error(20010, "添加失败", false);
        }
    }

    //    删除某个工单
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
    public ResponseData update(@RequestBody OrdersParam ordersParam,
                               @PathVariable("sno") String sno,
                               @PathVariable("id") Integer id ) {
//        为null则不需要修改图片
        if (ordersParam.getFile64() == null) {
            System.out.println("文件上传为空");
        } else {
            String newFileName = fileUploadUtils.uploadBase64(ordersParam.getFile64());
            if (newFileName == null) System.out.println("文件错误");
            ordersParam.setPicture(hostPath + newFileName);
        }

        //        ordersParam.set
        Orders orders = new Orders();
        orders.setId(id);
        orders.setSno(sno);
        orders.setVariety(ordersParam.getVariety());
        orders.setDetail(ordersParam.getDetail());
        orders.setPicture(orders.getPicture());
        System.out.println(orders);
//        total  判断
        int total = ordersService.updateStatusAndMnoAndIdInt(orders);
        if (total > 0) {
            System.out.println("修改成功");
            return ResponseData.success(20031, "修改成功", true);
        } else {
            System.out.println("修改失败，请联系管理员");
            return ResponseData.error(20030, "修改失败", false);
        }
    }

    //    查看某个详细工单
    @GetMapping("/{sno}/{id}")
    public ResponseData showDetail(@PathVariable("sno") String sno,
                                   @PathVariable("id") Integer id) {
        System.out.println("请求参数"+sno+"   "+id);
        System.out.println("获取详细");
        NoParam noParam = new NoParam();
        noParam.setId(id);
        noParam.setSno(sno);
        Orders ordersDetails = ordersService.getStudentAddressById(noParam);
        if (ordersDetails != null) {
            return ResponseData.success(20041, "数据查询成功!", ordersDetails);
        } else {
            return ResponseData.error(20040, "获取失败，请联系管理员", null);
        }
    }

}

