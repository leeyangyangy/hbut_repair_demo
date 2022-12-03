package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.service.TypeService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("typeFilter")
public class TypeFilter implements Filter {

    @Resource
    private TypeService typeService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- typeFilter init ----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- typeFilter doFilter ----");
        List<Type> allType = typeService.findAllType();
        servletRequest.setAttribute("allType", allType);
        allType.forEach(type -> System.out.println(allType));
//        请求向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("---- typeFilter destroy ----");
    }
}
