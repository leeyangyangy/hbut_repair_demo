package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //    用户登录
    @PostMapping("/login")
    public String login(User user, HttpServletRequest request, HttpSession session) {
        System.out.println("进入用户登录控制器");
        System.out.println("打印user数据" + user);
//        执行登录
        User login = userService.login(user);
        if (login != null) {
            session.setAttribute("login", login);
            return "main";
        } else {
            request.setAttribute("msg", "账号密码错误");
            return "login";
        }
    }


}

