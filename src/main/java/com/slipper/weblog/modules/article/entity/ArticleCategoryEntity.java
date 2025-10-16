package com.slipper.weblog.modules.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章-分类
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("article__category")
public class ArticleCategoryEntity extends BaseEntity {
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 分类ID
     */
    private Long categoryId;
}
