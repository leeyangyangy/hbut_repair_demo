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
@RequestMapping("/admin")
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
    @RequestMapping("/orders/getAll")
    public ResponseData orderList() {
        List<Orders> ordersList = ordersService.findAllOrders();
        Map<String, Worker> workerList = workerService.findAllWorker();
        if (ordersList != null && workerList != null) {
            List<Object> object=new ArrayList<>();
            object.add(ordersList);
            object.add(workerList);
            return ResponseData.success(200, "数据获取成功",object);
        } else {
            return ResponseData.error(404, "数据获取失败", 0);
        }
    }

//    finAllWaitForOrderByNo

    @RequestMapping(value = "/orders/update/working/{id}", method = RequestMethod.POST)
    public ResponseData updateToWorking(@RequestBody Orders orders, @PathVariable("id") int id) {
//        orders.set
        orders.setId(id);
        orders.setStatus("1");
        int total = ordersService.updateStatusAndMnoAndIdInt(orders);
        if (total > 0) {
            System.out.println("修改成功");
            return ResponseData.success(200, "修改成功", 1);
        } else {
            System.out.println("修改失败，请联系管理员");
            return ResponseData.error(500,"修改失败",0);
        }
    }


}

