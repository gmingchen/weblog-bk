package com.slipper.weblog.modules.column.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class ColumnUpdateReqVO extends ColumnCreateReqVO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
