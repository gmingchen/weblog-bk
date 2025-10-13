package com.slipper.weblog.modules.column.model.vo;

import com.slipper.weblog.common.enums.StatusEnum;
import com.slipper.weblog.common.pojo.PageParam;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

@Data
public class ColumnPageReqVO extends PageParam {
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
