package com.lyt.manager.modular.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lyt.manager.framework.pojo.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Classify extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 产品大类主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品大类名称
     */
    private String classifyName;

    /**
     * 操作人
     */
    private String operator;


}
