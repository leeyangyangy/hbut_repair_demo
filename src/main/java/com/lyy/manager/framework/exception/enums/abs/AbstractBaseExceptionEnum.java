package com.lyy.manager.framework.exception.enums.abs;

/**
 * @Package: com.lyy.security.framwork.exception
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:29
 * @Description:
 */

public interface AbstractBaseExceptionEnum {

    /**
     * 获取异常的状态码
     */
    Integer getCode();

    /**
     * 获取异常的提示信息
     */
    String getMessage();
}
