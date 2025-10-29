package com.slipper.weblog.modules.article.model.dto;

import com.slipper.weblog.modules.category.model.vo.CategoryBaseVO;
import com.slipper.weblog.modules.column.model.vo.ColumnBaseVO;
import com.slipper.weblog.modules.tag.model.vo.TagBaseVO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticleInfoVO {
    /**
     * ID
     */
    private Long id;
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
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    /**
     * 分类列表
     */
    private List<CategoryBaseVO> categoryList;
    /**
     * 标签列表
     */
    private List<TagBaseVO> tagList;
    /**
     * 专栏列表
     */
    private List<ColumnBaseVO> columnList;
}
