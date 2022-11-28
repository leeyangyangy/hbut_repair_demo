package com.lyt.manager.modular.system.controller;

import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.service.PermissionService;
import com.lyt.manager.modular.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping
public class IndexController {

//    @Resource
//    private UserService userService;

//    @Resource
//    private PermissionService permissionService;

    @GetMapping
    public String index(HttpServletRequest request){
        System.out.println("---- 进入首页控制器 ----");
//        List<Permission> permissionList = permissionService.findAll();
//        request.setAttribute("permissionList", permissionList);
//        for (Permission permission:permissionList)
//            System.out.println(permission);
        return "login";
    }
}
