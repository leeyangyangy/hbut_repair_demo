package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Supplier;
import com.lyt.manager.modular.system.service.SupplierService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("supplierFilter")
public class SupplierFilter implements Filter {

    @Resource
    private SupplierService supplierService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- supplier doFilter ----");
        List<Supplier> allSupplier = supplierService.findAllSupplier();
        allSupplier.forEach(supplier -> System.out.println(supplier));
        servletRequest.setAttribute("allSupplier",allSupplier);
//        放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
