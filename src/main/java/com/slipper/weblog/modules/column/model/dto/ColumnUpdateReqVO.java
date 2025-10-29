package com.slipper.weblog.modules.column.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class ColumnUpdateReqVO extends ColumnCreateDTO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
