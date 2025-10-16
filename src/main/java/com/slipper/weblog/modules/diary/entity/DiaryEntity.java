package com.slipper.weblog.modules.diary.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 日记
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("diary")
public class DiaryEntity extends BaseEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 心情ID
     */
    private Long moodId;
    /**
     * 天气ID
     */
    private Long weatherId;
    /**
     * 地址
     */
    private String location;
    /**
     * 是否私密 0-否 1-是
     */
    private Integer isPrivate;
    /**
     * 状态：0-草稿 1-发布 2-归档
     */
    private Integer status;
}
