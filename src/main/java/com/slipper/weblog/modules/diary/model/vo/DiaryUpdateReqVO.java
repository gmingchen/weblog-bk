package com.slipper.weblog.modules.diary.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class DiaryUpdateReqVO extends DiaryCreateReqVO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
}
