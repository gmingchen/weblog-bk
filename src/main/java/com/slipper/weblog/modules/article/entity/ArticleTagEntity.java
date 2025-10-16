package com.slipper.weblog.modules.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章-标签
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("article__tag")
public class ArticleTagEntity extends BaseEntity {
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 标签ID
     */
    private Long tagId;
}
