package com.slipper.weblog.modules.diary.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DiaryInfoDTO {
    /**
     * ID
     */
    private Long id;
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
     * 心情名称
     */
    private String moodName;
    /**
     * 心情Emoji
     */
    private String moodEmoji;
    /**
     * 天气ID
     */
    private Long weatherId;
    /**
     * 天气I名称
     */
    private String weatherName;
    /**
     * 天气IEmoji
     */
    private String weatherEmoji;
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
    /**
     * 浏览量
     */
    private Integer viewCount;
    /**
     * 评论量
     */
    private Integer commentCount;
    /**
     * 点赞量
     */
    private Integer likeCount;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
