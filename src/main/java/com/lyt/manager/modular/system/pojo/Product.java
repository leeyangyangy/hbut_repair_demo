package com.lyt.manager.modular.system.pojo;

import java.math.BigDecimal;
import java.util.Date;

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
public class Product extends BaseTimeEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 产品主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品简介
     */
    private String productProfile;

    /**
     * 产品图片
     */
    private String productPicture;

    /**
     * 产品大类，关联大类id
     */
    private String productClassify;

    /**
     * 产品小类
     */
    private String productType;

    /**
     * 产品数量
     */
    private Long productValue;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 产品数量单位
     */
    private String productUnits;

    /**
     * 产品警告值
     */
    private Integer productWarn;

    /**
     * 产品状态
     */
    private String productStatus;

    /**
     * 产品供应商
     */
    private String productSupplier;

    /**
     * 操作人
     */
    private String productOperator;

    /**
     * 出库时间
     */
    private Date deliverTime;
}
