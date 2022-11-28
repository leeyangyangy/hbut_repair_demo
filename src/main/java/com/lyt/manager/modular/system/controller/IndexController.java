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

    /**
     * 参数选型
     * 1.HttpServletRequest    只有通过转发方式到达目标页面就结束
     * 2.HttpSession           所有(多个)页面都需要用到的数据
     * 3.ServletContext        所有用户共享数据   数据一直在内存中，服务器重启才消失
     * 4.ModelAndView          方法返回值是ModelAndView
     * 5.Model                 只有通过转发方式到达目标页面就结束
     */

    @GetMapping
    public String index(HttpServletRequest request){
        System.out.println("---- 进入首页控制器 ----");
        return "login";
    }
}
