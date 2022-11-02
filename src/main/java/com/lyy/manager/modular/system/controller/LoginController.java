package com.lyy.manager.modular.system.controller;

import com.lyy.manager.framework.constants.RedisConstant;
import com.lyy.manager.framework.jwt.JwtUtils;
import com.lyy.manager.framework.redis.RedisCache;
import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.framework.spring.LoginUserInfo;
import com.lyy.manager.modular.system.entity.Admin;
import com.lyy.manager.modular.system.entity.Student;
import com.lyy.manager.modular.system.entity.Worker;
import com.lyy.manager.modular.system.param.LoginParam;
import com.lyy.manager.modular.system.service.AdminService;
import com.lyy.manager.modular.system.service.StudentService;
import com.lyy.manager.modular.system.service.WorkerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;


/**
 * @Package: com.lyy.manager.modular.system.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/10/29 2:34
 * @Description: 登录控制器
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private AdminService adminService;
    @Resource
    private StudentService studentService;
    @Resource
    private WorkerService workerService;

    @Resource
    private RedisCache redisCache;

    //    jwt && token
    LoginUserInfo info = new LoginUserInfo();

    //    管理员登录
    @PostMapping("/admin")
    public ResponseData admin(@RequestBody LoginParam loginParam, HttpServletResponse response) {
        System.out.println("---- 管理员登录 ----");
        Admin admin = adminService.adminLogin(loginParam);
        if (admin != null) {
            System.out.println("登录成功");
            //            创建token
            info.setAccount(admin.getUsername());
            info.setName(admin.getName());
//            主要是判断id是否被篡改了
            info.setId(admin.getId().longValue());
            //拼接redisKey
            String redisKey = RedisConstant.LOGIN_TOKEN_KEY + info.getId();
            //login_token:123
            redisCache.setCache(redisKey, info, RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
            response.setHeader("Authorization", JwtUtils.createToken(info.getId()));
            return ResponseData.success(200, "登录成功", admin);
        }
        System.out.println("登录失败");
        return ResponseData.error(500, "登录失败", false);
    }

    //    登录相关模块
    @PostMapping("/student")
    public ResponseData student(@RequestBody LoginParam loginParam, HttpServletResponse response) {
        Student student = studentService.studentLogin(loginParam);
        if (student != null) {
//            创建token
            info.setAccount(student.getSno());
            info.setName(student.getName());
//            主要是判断id是否被篡改了
            info.setId(Long.valueOf(student.getSno()));
            //拼接redisKey
            String redisKey = RedisConstant.LOGIN_TOKEN_KEY + info.getId();
            //login_token:123
            redisCache.setCache(redisKey, info, RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
            response.setHeader("Authorization", JwtUtils.createToken(info.getId()));
            return ResponseData.success(200, "成功", student);
        }
        return ResponseData.error(500, "学号或密码错误", false);
    }

    //    师傅登录
    @PostMapping("/worker")
    public ResponseData worker(@RequestBody LoginParam loginParam, HttpServletResponse response) {
        System.out.println("---- 管理员登录 ----");
        Worker worker = workerService.workLogin(loginParam);
        if (worker != null) {
            System.out.println("登录成功");
            //            创建token
            info.setAccount(worker.getMno());
            info.setName(worker.getName());
//            主要是判断id是否被篡改了
            info.setId(Long.valueOf(worker.getMno()));
            //拼接redisKey
            String redisKey = RedisConstant.LOGIN_TOKEN_KEY + info.getId();
            //login_token:123
            redisCache.setCache(redisKey, info, RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
            response.setHeader("Authorization", JwtUtils.createToken(info.getId()));
            return ResponseData.success(200, "登录成功", worker);
        }
        System.out.println("登录失败");
        return ResponseData.error(500, "登录失败", false);
    }

}
