package com.lyy.manager.framework.exception.enums;

import com.lyy.manager.framework.exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * @Package: com.lyy.security.framwork.exception
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:30
 * @Description:
 */
public enum  AuthExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 账号或密码为空
     */
    ACCOUNT_PWD_EMPTY(1, "账号或密码为空，请检查account或password参数"),

    /**
     * 账号密码错误
     */
    ACCOUNT_PWD_ERROR(2, "账号或密码错误，请检查account或password参数"),


    /**
     * 请求token为空
     */
    REQUEST_TOKEN_EMPTY(3, "请求token为空，请携带token访问本接口"),

    /**
     * token格式不正确，token请以Bearer开头
     */
    NOT_VALID_TOKEN_TYPE(4, "token格式不正确，"),

    /**
     * 请求token错误
     */
    REQUEST_TOKEN_ERROR(5, "请求token错误"),

    /**
     * 账号被冻结
     */
    ACCOUNT_FREEZE_ERROR(6, "账号被冻结，请联系管理员"),

    /**
     * 登录已过期
     */
    LOGIN_EXPIRED(7, "登录已过期，请重新登录"),

    /**
     * 无登录用户
     */
    NO_LOGIN_USER(8, "无登录用户"),

    /**
     * 验证码错误
     */
    CONSTANT_EMPTY_ERROR(9, "验证码错误");

    private final Integer code;

    private final String message;

    AuthExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

