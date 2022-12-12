package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Supplier;
import com.lyt.manager.modular.system.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Resource
    private SupplierService supplierService;

    //    转发==>>更新页面
    @GetMapping("toUpdateSupplierById")
    public String toUpdateSupplierById(Integer id, HttpServletRequest request) {
        Supplier supplier = supplierService.findSupplierById(id);
        request.setAttribute("supplier", supplier);
        return "updateSupplier";
    }

    //    更新
    @PostMapping("updateSupplierById")
    public String updateSupplierById(Supplier supplier) {
        System.out.println(supplier);
        supplierService.updateSupplierById(supplier);
        return "redirect:/supplierList.jsp";
    }

    //    添加
    @PostMapping("addSupplier")
    public String addSupplier(Supplier supplier) {
        System.out.println(supplier);
        if(supplier.getSupplierName().trim().equals("")) return "redirect:/supplierList.jsp";
        if(supplier.getSupplierName().trim().equals(supplierService.findSupplierByName(supplier.getSupplierName())))
            return "redirect:/supplierList.jsp";
        int total = supplierService.addSupplier(supplier);
        System.out.println("total=" + total);
        return "redirect:/supplierList.jsp";
    }

    @GetMapping("deleteSupplierById")
    public String deleteSupplierById(Integer id) {
        int total = supplierService.delSupplierByName(id);
        System.out.println("total=" + total);
        return "redirect:/supplierList.jsp";
    }


    @ResponseBody
    @PostMapping("checkSupplier")
    public boolean checkSupplier(String supplierName){
        System.out.println(supplierName);
        Supplier supplier = supplierService.findSupplierByName(supplierName);
        if (supplier==null){
            System.out.println("true");
            return true;
        }else {
            System.out.println("false");
            return false;
        }

    }
}

