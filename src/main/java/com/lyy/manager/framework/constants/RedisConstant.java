package com.lyy.manager.framework.constants;

/**
 * @Package: com.lyy.security.framwork.constants
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:09
 * @Description:
 */
public interface RedisConstant {

    /**
     * 登录用户 redis key前缀
     */
    String LOGIN_TOKEN_KEY = "login_token:";

    /**
     * 登录失效时间  15天
     */
    int LOGIN_TOKEN_INVALID_TIME = 15;

    /**
     * 登录失效时间 60S
     */
    int SMS_TIME_OUT = 120;
}
