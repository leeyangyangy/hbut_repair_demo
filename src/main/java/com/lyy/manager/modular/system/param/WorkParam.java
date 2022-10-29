package com.lyy.manager.modular.system.param;

import lombok.Data;

/**
 * @Package: com.lyy.manager.modular.system.param
 * @Author: LEEYANGYANG
 * @Create: 2022/10/27 23:49
 * @Description:
 */
@Data
public class WorkParam {

    /**
     * 维修师傅工号
     */
    private String mno;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 维修师傅姓名
     */
    private String name;
}
