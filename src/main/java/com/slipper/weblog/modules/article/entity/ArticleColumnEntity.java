package com.slipper.weblog.modules.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 文章-专栏
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("article__column")
public class ArticleColumnEntity extends BaseEntity {
    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 专栏ID
     */
    private Long columnId;
}
