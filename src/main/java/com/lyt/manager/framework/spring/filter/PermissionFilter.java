package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Permission;
import com.lyt.manager.modular.system.service.PermissionService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("permissionFilter")
public class PermissionFilter implements Filter {

    @Resource
    private PermissionService permissionService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- permissionFilter init ----");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- permissionFilter doFilter ----");
        List<Permission> permissionList = permissionService.findAll();
        servletRequest.setAttribute("permissionList", permissionList);
        for (Permission permission:permissionList)
            System.out.println(permission);
//        请求向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("---- permissionFilter destroy ----");

    }
}
