package com.lyt.manager.framework.spring;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration("permissionFilter")
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- permissionFilter init ----");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- permissionFilter doFilter ----");

    }

    @Override
    public void destroy() {
        System.out.println("---- permissionFilter destroy ----");

    }
}
