package com.lyy.manager.modular.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.lyy.manager.modular.system.controller
 * @Author: LEEYANGYANG
 * @Create: 2022/11/5 17:30
 * @Description:
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(HttpServletRequest request){
        request.setAttribute("images","http://localhost/images/test1.jpg");
        System.out.println("---- index.html ----");
        return "/index";
    }
}
