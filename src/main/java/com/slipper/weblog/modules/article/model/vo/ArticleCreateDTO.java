package com.slipper.weblog.modules.article.model.vo;

import com.slipper.weblog.common.enums.ArticleStatusEnum;
import com.slipper.weblog.common.enums.DiaryStatusEnum;
import com.slipper.weblog.common.enums.WhetherEnum;
import com.slipper.weblog.core.validator.constraints.Enum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author gumingchen
 */
@Data
public class ArticleCreateDTO {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * URL友好标识符
     */
    @NotBlank(message = "URL友好标识符不能为空")
    private String slug;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 摘要
     */
    @NotBlank(message = "摘要不能为空")
    private String excerpt;
    /**
     * 是否精选 0-否 1-是
     */
    @Enum(WhetherEnum.class)
    @NotNull(message = "是否精选不能为空")
    private Integer isFeatured;
    /**
     * 状态：0-草稿 1-发布 2-归档
     */
    @Enum(ArticleStatusEnum.class)
    @NotNull(message = "状态不能为空")
    private Integer status;
    /**
     * 分类ID数组
     */
    @NotNull(message = "分类不能为空")
    @Size(min = 1, message = "至少有一个分类")
    private List<Long> categoryIds;
    /**
     * 标签ID数组
     */
    @NotNull(message = "标签不能为空")
    @Size(min = 1, message = "至少有一个标签")
    private List<Long> tagIds;
    /**
     * 专栏ID数组
     */
    private List<Long> columnIds;
}
