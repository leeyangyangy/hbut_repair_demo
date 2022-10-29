package com.lyy.manager.modular.system.param;

import lombok.Data;

/**
 * @Package: com.lyy.manager.modular.system.param
 * @Author: LEEYANGYANG
 * @Create: 2022/10/28 23:31
 * @Description:  实现动态sql，灵活使用学生或维修师傅
 */
@Data
public class NoParam {
    /**
     * 学生学号
     */
    private String sno;

    /**
     * 维修师傅工号
     */
    private String mno;

    /**
     * 工单id
     */
    private Integer id;

    /**
     * 工单状态
     */
    private String status;
}
