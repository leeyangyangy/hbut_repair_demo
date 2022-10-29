package com.lyy.manager.modular.system.param;

import lombok.Data;

/**
 * @Package: com.lyy.manager.modular.system.param
 * @Author: LEEYANGYANG
 * @Create: 2022/10/28 23:36
 * @Description: 登录用户名和密码
 */
@Data
public class LoginParam {

    /**
     * 管理员用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
