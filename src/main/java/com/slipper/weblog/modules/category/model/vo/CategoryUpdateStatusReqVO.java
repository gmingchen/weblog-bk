package com.slipper.weblog.modules.category.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class CategoryUpdateStatusReqVO {
    /**
     * ID数组
     */
    @NotNull(message = "ID不能为空")
    @Size(min = 1, message = "至少有一个ID")
    private List<Long> ids;
    /**
     * 状态：0-禁用 1-启用
     */
    @NotNull(message = "状态不能为空")
    @Enum(StatusEnum.class)
    private Integer status;
}
