package com.slipper.weblog.modules.category.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class CategoryUpdateDTO extends CategoryCreateDTO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
