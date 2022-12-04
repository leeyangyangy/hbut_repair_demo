package com.lyt.manager.framework.spring.filter;


import com.lyt.manager.modular.system.pojo.Storage;
import com.lyt.manager.modular.system.service.StorageService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Controller("storageFilter")
public class StorageFilter implements Filter {

    @Resource
    private StorageService storageService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- deliveryFilter doFilter ----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- deliveryFilter doFilter ----");
        List<Storage> allStorage = storageService.findAllStorage();
        servletRequest.setAttribute("allStorage",allStorage);
        //        向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
