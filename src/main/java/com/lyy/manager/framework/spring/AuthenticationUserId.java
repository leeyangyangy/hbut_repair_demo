package com.lyy.manager.framework.spring;


import cn.hutool.core.util.ObjectUtil;
import com.lyy.manager.framework.constants.AuthHeadConstant;
import com.lyy.manager.framework.jwt.JwtUtils;
import com.lyy.manager.framework.respone.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class AuthenticationUserId implements HandlerInterceptor {
    //        添加处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预拦截");
        ResponseData responseData = new ResponseData();
        responseData.setCode(403);
//        获取用户信息
//        获取当前认证token信息
        String token = request.getHeader(AuthHeadConstant.Authorization);
//        获取请求url
        String sno = request.getRequestURI();
//        System.out.println("原 请求地址来源=" + sno);
//        分割url，提取id信息
        sno = sno.substring(sno.lastIndexOf("/") + 1);
//        System.out.println("分离后的url=" + sno);
//        Long new_sno = Long.valueOf(sno);
//        请求头为空，放行
        //解析jwt  返回用户id
        Long key = JwtUtils.getUserIdFromToken(token);
//        System.out.println("拦截器的   jwt 用户id是" + key);
        //判断key是否为空
        if (ObjectUtil.isNotEmpty(key) && Long.valueOf(sno).equals(key)) {
//            System.out.println("非空  放行，true，继续后面操作");
            return true;
        } else {
//            System.out.println("非法操作，false，拦截");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("请求拦截");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        获取当前认证信息
//        String token = request.getHeader(AuthHeadConstant.Authorization);
//        System.out.println(token);

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
