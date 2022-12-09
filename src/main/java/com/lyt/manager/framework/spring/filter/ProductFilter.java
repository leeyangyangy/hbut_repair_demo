package com.lyt.manager.framework.spring.filter;

import com.lyt.manager.modular.system.pojo.Product;
import com.lyt.manager.modular.system.service.ProductService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Configuration("productFilter")
public class ProductFilter implements Filter {

    @Resource
    private ProductService productService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("---- productFilter doFilter ----");
        List<Product> allProduct = productService.findAllProduct();
        servletRequest.setAttribute("allProduct", allProduct);
        //        请求向下传递
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
