package com.slipper.weblog.modules.diary.model.vo;

import com.slipper.weblog.common.enums.WhetherEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class DiaryUpdatePrivateReqVO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
    /**
     * 是否私密 0-否 1-是
     */
    @NotNull(message = "是否私密不能为空")
    @Enum(WhetherEnum.class)
    private Integer isPrivate;
}
