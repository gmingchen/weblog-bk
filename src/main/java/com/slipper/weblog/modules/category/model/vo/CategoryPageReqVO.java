package com.slipper.weblog.modules.category.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageParam;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class CategoryPageReqVO extends PageParam {
    /**
     * 父级ID 0-表示顶级
     */
    @NotNull(message = "父级ID不能为空")
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态：0-禁用 1-启用
     */
    @Enum(StatusEnum.class)
    private Integer status;
}
