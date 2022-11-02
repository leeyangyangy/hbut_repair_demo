package com.lyy.manager.framework.spring;

import com.lyy.manager.framework.exception.ServiceException;
import com.lyy.manager.framework.exception.enums.AuthExceptionEnum;
import com.lyy.manager.framework.respone.ResponseUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: com.lyy.security.framwork.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 21:11
 * @Description:
 */
@Configuration
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //执行的方法
        ResponseUtils.responseExceptionError(response,
                AuthExceptionEnum.REQUEST_TOKEN_ERROR.getCode(),
                AuthExceptionEnum.REQUEST_TOKEN_ERROR.getMessage(),
                new ServiceException(AuthExceptionEnum.REQUEST_TOKEN_ERROR).getStackTrace()[0].toString());

    }

}
