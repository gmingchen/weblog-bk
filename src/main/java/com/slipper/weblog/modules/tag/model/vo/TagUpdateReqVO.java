package com.slipper.weblog.modules.tag.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TagUpdateReqVO extends TagCreateReqVO  {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
