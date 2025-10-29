package com.slipper.weblog.modules.diary.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class DiaryUpdateDTO extends DiaryCreateDTO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
