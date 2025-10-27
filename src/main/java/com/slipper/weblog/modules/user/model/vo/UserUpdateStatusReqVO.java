package com.slipper.weblog.modules.user.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class UserUpdateStatusReqVO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
    /**
     * 状态：0-禁用 1-启用
     */
    @NotNull(message = "状态不能为空")
    @Enum(StatusEnum.class)
    private Integer status;
}
