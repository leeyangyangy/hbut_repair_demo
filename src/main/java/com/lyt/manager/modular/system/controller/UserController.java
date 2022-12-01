package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.service.PermissionService;
import com.lyt.manager.modular.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private PermissionService permissionService;

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
    public String logout(HttpSession session) {
//        使session失效
        session.invalidate();
        return "redirect:/";
    }

    //    获取所有用户
    @GetMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request) {
        List<User> allUser = userService.findAllUser();
        request.setAttribute("allUser", allUser);
        return "userList";
    }

    //    修改用户信息
//    转发到更新页面
    @GetMapping("/toUpdateUser")
    public String toUpdateUser(String userId, HttpServletRequest request) {
        System.out.println(userId);
        User user = userService.findUserByUserId(userId);
        System.out.println(user);
        request.setAttribute("userInfo", user);
        List<Permission> permissionList = permissionService.findAll();
        request.setAttribute("permissionList", permissionList);
        return "updateUser";

    }

//    更新用户表信息
    @PostMapping("/updateUserByUserId")
    public String updateUserByUserId(User user) {
        System.out.println("进入更新控制器");
        System.out.println(user);
//        System.out.println(userService.updateById(user));
        userService.updateUserById(user);
        //        删除完成，重定向到用户列表
        return "redirect:findAllUser";
    }

    //    直接删除
    @GetMapping("/deleteUserByUserId")
    public String deleteUser(String userId) {
        System.out.println(userId);
        userService.deleteByUserId(userId);
        //        删除完成，重定向到用户列表
        return "redirect:findAllUser";
    }

    //    用户添加
    @PostMapping("/add")
    public String add(User user) {
        System.out.println(user);
        userService.addUser(user);
//        添加完成，重定向到用户列表
        return "redirect:findAllUser";
    }

    @RequestMapping("/checkUserId")
    @ResponseBody
    public Boolean checkUserId(String userId) {
        System.out.println(userId);
        User user = userService.findUserByUserId(userId);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
}

