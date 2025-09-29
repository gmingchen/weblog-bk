package com.slipper.weblog.modules.tag.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TagCreateReqVO {
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 状态：0-禁用 1-启用
     */
    @Enum(StatusEnum.class)
    @NotNull(message = "状态不能为空")
    private Integer status;
}
