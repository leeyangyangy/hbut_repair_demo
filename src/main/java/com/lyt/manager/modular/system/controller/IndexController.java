package com.lyt.manager.modular.system.controller;

import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.service.PermissionService;
import com.lyt.manager.modular.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
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

//    此数据只需要转发一次
    @GetMapping("/aboutTeam")
    public String aboutTeam(Model model){
        String team="项目组员详情";
        String teacher="指导老师：杨红详老师";
        String maintainer="组长：李洋洋";
        String teamMembers="组员：杨逵，唐韩莉";
        String className="班级：22gbs计算1";
        String projectName="项目名：工厂物料管理系统";
//        List<Collection> collections=new ArrayList<>();
//        collections.add(maintainer),
//        model.addAllAttributes("")
        model.addAttribute("team",team);
        model.addAttribute("teacher",teacher);
        model.addAttribute("projectName",projectName);
        model.addAttribute("maintainer",maintainer);
        model.addAttribute("teamMembers",teamMembers);
        model.addAttribute("className",className);
        return "about";
    }
}
