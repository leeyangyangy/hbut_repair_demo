package com.lyy.manager.framework.spring;

import cn.hutool.core.util.ObjectUtil;
import com.lyy.manager.framework.constants.AuthHeadConstant;
import com.lyy.manager.framework.constants.RedisConstant;
import com.lyy.manager.framework.exception.ServiceException;
import com.lyy.manager.framework.exception.enums.AuthExceptionEnum;
import com.lyy.manager.framework.jwt.JwtUtils;
import com.lyy.manager.framework.redis.RedisCache;
import com.lyy.manager.framework.respone.ResponseUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.lyy.security.framwork.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 19:58
 * @Description:
 */
public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {


    //初始化 变量RedisCache
    private final RedisCache redisCache;


    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager, RedisCache redisCache) {
        super(authenticationManager);
        this.redisCache = redisCache;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //        获取当前认证信息
        String token = request.getHeader(AuthHeadConstant.Authorization);
        //解析jwt  返回用户id
        Long key = JwtUtils.getUserIdFromToken(token);
        //判断key是否为空
        if (ObjectUtil.isNotEmpty(key)) {
            //拼接redisKey
            String redisKey = RedisConstant.LOGIN_TOKEN_KEY + key;
            //获取用户的缓存信息,转换成登录用户
            LoginUserInfo loginUserInfo = redisCache.getCache(redisKey);
            //判断redis缓存记录为空，抛出登录过期异常
            if (ObjectUtil.isNull(loginUserInfo)) {
                //获取response信息,提示AuthExceptionEnum.LOGIN_EXPIRED
                ResponseUtils.responseExceptionError(response,
                        AuthExceptionEnum.LOGIN_EXPIRED.getCode(),
                        AuthExceptionEnum.LOGIN_EXPIRED.getMessage(),
                        new ServiceException(AuthExceptionEnum.LOGIN_EXPIRED).getStackTrace()[0].toString());
                return;
            }
            //刷新缓存时间
            redisCache.setCache(redisKey, loginUserInfo, RedisConstant.LOGIN_TOKEN_INVALID_TIME, TimeUnit.DAYS);
            /**
             * 设置SpringSecurityContext上下文，方便获取当前登录用户信息
             */
            //根据 loginUserInfo用户的缓存信息 构建新的Authentication
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(
                    loginUserInfo, null, null);
            //存放authentication到SecurityContextHolder
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // 放行
        filterChain.doFilter(request, response);
    }


}
