package com.lyy.manager.modular.system.controller;


import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.system.entity.Orders;
import com.lyy.manager.modular.system.entity.Worker;
import com.lyy.manager.modular.system.service.AdminService;
import com.lyy.manager.modular.system.service.OrdersService;
import com.lyy.manager.modular.system.service.WorkerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/admin/orders")
public class AdminController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private AdminService adminService;

    @Resource
    private WorkerService workerService;

//    查询所有工单
//    @RequestMapping("/orderList")
//    public List<Orders> orderList(){
//        List<Orders> list = ordersService.findAllOrders();
//        return list;
//    }

//    获取所有工单和师傅
//    @RequestMapping("/getAll")
    @GetMapping
    public ResponseData orderList() {
        List<Orders> ordersList = ordersService.findAllOrders();
        Map<String, Worker> workerList = workerService.findAllWorker();
        if (ordersList != null && workerList != null) {
            Map<String,Object> map=new HashMap<>();
//            worker  获取维修师傅信息
            map.put("worker",workerList);
//            获取所有工单
            map.put("orders",ordersList);
            return ResponseData.success(20041, "数据获取成功",map);
        } else {
            return ResponseData.error(20040, "查询失败,请重试!", null);
        }
    }

//    finAllWaitForOrderByNo

//    管理员修改工单状态为已派单和分配维修师傅
//    @RequestMapping(value = "/update/working/{id}", method = RequestMethod.POST)
    @PutMapping("/{id}")
    public ResponseData updateToWorking(@RequestBody Orders orders, @PathVariable("id") int id) {
//        orders.set
        orders.setId(id);
        orders.setStatus("1");
        int total = ordersService.updateStatusAndMnoAndIdInt(orders);
        if (total > 0) {
            System.out.println("修改成功");
            return ResponseData.success(20031, "修改成功", true);
        } else {
            System.out.println("修改失败，请联系管理员");
            return ResponseData.error(20030,"修改失败",false);
        }
    }


}

