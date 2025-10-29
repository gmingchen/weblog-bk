package com.slipper.weblog.modules.diary.model.dto;

import com.slipper.weblog.common.enums.DiaryStatusEnum;
import com.slipper.weblog.common.enums.WhetherEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author gumingchen
 */
@Data
public class DiaryCreateDTO {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 心情ID
     */
    @NotNull(message = "心情ID不能为空")
    private Long moodId;
    /**
     * 天气ID
     */
    @NotNull(message = "天气ID不能为空")
    private Long weatherId;
    /**
     * 地址
     */
    private String location;
    /**
     * 是否私密 0-否 1-是
     */
    @Enum(WhetherEnum.class)
    @NotNull(message = "是否私密不能为空")
    private Integer isPrivate;
    /**
     * 状态：0-草稿 1-发布 2-归档
     */
    @Enum(DiaryStatusEnum.class)
    @NotNull(message = "状态不能为空")
    private Integer status;
}
