package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Classify;
import com.lyt.manager.modular.system.service.ClassifyService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("classifyFilter")
public class ClassifyFilter implements Filter {

    @Resource
    private ClassifyService classifyService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- classifyFilter doFilter ----");
        List<Classify> allClassify = classifyService.findAllClassify();
        servletRequest.setAttribute("allClassify", allClassify);
        //        请求向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
