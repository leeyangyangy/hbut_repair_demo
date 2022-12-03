package com.lyt.manager.modular.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Storage extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 入库记录主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 入库产品名
     */
    private String productName;

    /**
     * 入库数量
     */
    private Long storageNumber;

    /**
     * 入库操作人
     */
    private String storageUser;

    /**
     * 入库时间
     */
    private Date storageTime;


}
