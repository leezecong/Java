/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.joolun.com
 * 注意：
 * 本软件为www.joolun.com开发研制，未经购买不得使用
 * 购买后可获得全部源代码（禁止转卖、分享、上传到码云、github等开源平台）
 * 一经发现盗用、分享等行为，将追究法律责任，后果自负
 */
package com.joolun.cloud.mall.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;

/**
 * 保障服务
 *
 * @author JL
 * @date 2020-02-09 23:31:36
 */
@Data
@TableName("ensure")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "保障服务")
public class Ensure extends Model<Ensure> {
    private static final long serialVersionUID=1L;

    /**
     * PK
     */
	@ApiModelProperty(value = "PK")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 所属租户
     */
	@ApiModelProperty(value = "所属租户")
    private String tenantId;
    /**
     * 逻辑删除标记（0：显示；1：隐藏）
     */
	@ApiModelProperty(value = "逻辑删除标记")
    private String delFlag;
    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 最后更新时间
     */
	@ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;
    /**
     * 创建者ID
     */
	@ApiModelProperty(value = "创建者ID")
    private String createId;
    /**
     * 保障名
     */
	@ApiModelProperty(value = "保障名")
    private String name;
    /**
     * 保障详情
     */
	@ApiModelProperty(value = "保障详情")
    private String detail;
    /**
     * 机构ID
     */
    @ApiModelProperty(value = "机构ID")
    private String organId;

}
