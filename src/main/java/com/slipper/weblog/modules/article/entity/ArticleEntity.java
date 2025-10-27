package com.slipper.weblog.modules.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("article")
public class ArticleEntity extends BaseEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * URL友好标识符
     */
    private String slug;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 内容
     */
    private String content;
    /**
     * 摘要
     */
    private String excerpt;
    /**
     * 是否精选 0-否 1-是
     */
    private Integer isFeatured;
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
}
