package com.lyy.manager.framework.spring;

import com.lyy.manager.framework.constants.SecurityConstant;
import com.lyy.manager.framework.redis.RedisCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

/**
 * @Package: com.lyy.security.framwork.spring
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 19:50
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private RedisCache redisCache;

    //执行失败的方法
    @Resource
    private AuthenticationEntryPointImpl authenticationEntryPointImpl;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 关闭跨站请求防护 CSRF禁用，因为不使用session。开启模拟请求，比如API POST测试工具的测试，不开启时，API POST为报403错误
        http.csrf().disable();

        // 基于token，所以不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 自定义放开权限校验的接口
        for (String notAuthResource : SecurityConstant.SECURITY_URL){
            http.authorizeRequests().antMatchers(notAuthResource).permitAll();
        }

        // 其他访问需要需要身份认证
        http.authorizeRequests().anyRequest().authenticated();

        // 开启跨域
        http.cors();

        // 不使用默认退出，自定义退出
        http.logout().disable();

        // 禁用缓存
        http.headers().frameOptions().disable();

        // 添加JWT过滤器 除已配置的其它请求都需经过此过滤器
        http.addFilter(new JwtAuthenticationTokenFilter(authenticationManager(), redisCache));

        // 认证失败执行开始的方法
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl);
    }

}
