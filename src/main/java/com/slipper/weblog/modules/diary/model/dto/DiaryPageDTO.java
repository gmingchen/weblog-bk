package com.slipper.weblog.modules.diary.model.dto;

import com.slipper.weblog.common.enums.DiaryStatusEnum;
import com.slipper.weblog.common.enums.WhetherEnum;
import com.slipper.weblog.common.pojo.PageParam;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class DiaryPageDTO extends PageParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 心情ID
     */
    private Long moodId;
    /**
     * 天气ID
     */
    private Long weatherId;

    /**
     * 是否私密 0-否 1-是
     */
    @Enum(WhetherEnum.class)
    private Integer isPrivate;
    /**
     * 状态：0-草稿 1-发布 2-归档
     */
    @Enum(DiaryStatusEnum.class)
    private Integer status;
}
