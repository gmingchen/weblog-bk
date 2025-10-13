package com.slipper.weblog.modules.column.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class ColumnCreateReqVO {
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 封面图
     */
    @NotBlank(message = "封面图不能为空")
    private String cover;
    /**
     * 排序：越大位置越靠前
     */
    @NotNull(message = "排序不能为空")
    private Integer sort;
    /**
     * 状态：0-禁用 1-启用
     */
    @Enum(StatusEnum.class)
    @NotNull(message = "状态不能为空")
    private Integer status;
}
