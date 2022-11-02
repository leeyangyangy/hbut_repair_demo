package com.lyy.manager.modular.system.controller;


import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.param.NoParam;
import com.lyy.manager.modular.system.service.OrdersService;
import com.lyy.manager.modular.system.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
@RequestMapping("/worker/orders")
public class WorkerController {

    @Resource
    private WorkerService workerService;
    @Resource
    private OrdersService ordersService;
    NoParam noParam = new NoParam();

    // 列出所有完成工单
//    @RequestMapping(value = "/orders/{mno}/finish", method = RequestMethod.GET)
    @GetMapping("/{mno}/finish")
    public ResponseData finish(@PathVariable("mno") String mno) {
//        判断非空
        if (mno != null) {
//            设置值
            noParam.setMno(mno);
//            执行功能
            List<Orders> list = ordersService.finAllFinishOrderByNo(noParam);
            if (list != null) {
                return ResponseData.success(20041, "数据查询成功!", list);
            } else {
                return ResponseData.success(20040, "数据查询成功,但是数据库中没数据", null);
            }
        } else {
            return ResponseData.error(20040, "请求资源为空，请检查", null);
        }
    }

    // 列出所有正在进行的工单
//    @RequestMapping(value = "/orders/{mno}/working", method = RequestMethod.GET)
    @GetMapping("/{mno}/working")
    public ResponseData working(@PathVariable("mno") String mno) {
        noParam.setMno(mno);
        List<Orders> list = ordersService.finAllFixingOrderByNo(noParam);
        if (list != null) {
            return ResponseData.success(20041,"数据查询成功!",list);
        } else {
            return ResponseData.error(20040,"没有正在处理的工单",0);
        }
    }

    // 列出所有正在进行的工单的详细信息
//    @RequestMapping(value = "/orders/{mno}/working/{id}/details", method = RequestMethod.GET)
    @GetMapping("/details")
    public ResponseData showDetail(@RequestBody NoParam noParam) {
//        noParam.setSno(sno);
//        noParam.setMno(mno);
//        noParam.setId(id);
        System.out.println("获取详细");
        Orders ordersDetails = ordersService.getStudentAddressById(noParam);
        if (ordersDetails != null) {
            return ResponseData.success(20041, "数据查询成功!", ordersDetails);
        } else {
            return ResponseData.error(20040, "获取失败，请联系管理员", null);
        }
    }

    //    师傅修改订单为已完成状态
//    @RequestMapping(value = "/orders/{mno}/update/{id}", method = RequestMethod.POST)
    @PutMapping("/{mno}/{id}")
    public ResponseData modifyFinish(@PathVariable("mno") String mno, @PathVariable("id") Integer id) {
        if (mno == null && id == 0) {
            System.out.println("请确认数据是否传递正确");
            return ResponseData.error(20030, "传递了空值，请检查", false);
        } else {
//            设置值
            Orders orders = new Orders();
            orders.setMno(mno);
            orders.setId(id);
            orders.setStatus("2");
            orders.setFinishTime(new Date());
//            执行功能
            int total = ordersService.updateStatusAndMnoAndIdInt(orders);
            if (total > 0) {
                System.out.println("更新成功");
                return ResponseData.success(20031, "更新成功", true);
            } else {
                return ResponseData.error(20030,"无法更新该资源,请尝试联系管理员",false);
            }
        }
    }

}

