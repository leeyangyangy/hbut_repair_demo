package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Delivery;
import com.lyt.manager.modular.system.service.DeliveryService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("deliveryFilter")
public class DeliveryFilter implements Filter {

    @Resource
    private DeliveryService deliveryService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("---- deliveryFilter init ----");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- deliveryFilter doFilter ----");
        List<Delivery> allDelivery = deliveryService.findAllDelivery();
        servletRequest.setAttribute("allDelivery",allDelivery);
        //        向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
