package com.slipper.weblog.modules.tag.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class TagUpdateDTO extends TagCreateDTO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
