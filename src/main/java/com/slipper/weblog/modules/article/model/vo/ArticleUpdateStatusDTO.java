package com.slipper.weblog.modules.article.model.vo;

import com.slipper.weblog.common.enums.DiaryStatusEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class ArticleUpdateStatusDTO {
    /**
     * ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;
    /**
     * 状态：0-草稿 1-发布 2-归档
     */
    @NotNull(message = "状态不能为空")
    @Enum(DiaryStatusEnum.class)
    private Integer status;
}
