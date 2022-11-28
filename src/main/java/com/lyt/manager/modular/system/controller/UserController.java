package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.service.PermissionService;
import com.lyt.manager.modular.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 参数选型
     * 1.HttpServletRequest    只有通过转发方式到达目标页面就结束
     * 2.HttpSession           所有(多个)页面都需要用到的数据
     * 3.ServletContext        所有用户共享数据   数据一直在内存中，服务器重启才消失
     * 4.ModelAndView          方法返回值是ModelAndView
     * 5.Model                 只有通过转发方式到达目标页面就结束
     */

    //    用户登录
    @PostMapping("/login")
    public String login(User user, HttpServletRequest request, HttpSession session) {
        System.out.println("进入用户登录控制器");
        System.out.println("打印user数据" + user);
//        执行登录
        User login = userService.login(user);
        System.out.println(login);
        if (login != null) {
            session.setAttribute("login", login);
//            return "redirect:main";
            return "main";
        } else {
            request.setAttribute("msg", "账号密码错误,部门信息错误");
            return "login";
        }
    }

//    注销登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
//        使session失效
        session.invalidate();
        return "redirect:login";
    }

}

