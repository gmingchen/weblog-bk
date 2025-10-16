package com.slipper.weblog.modules.like.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 点赞
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("like")
public class LikeEntity extends BaseEntity {
    /**
     * 关联目标ID 文章ID、日记ID 根据type决定是什么ID
     * 留言板不需要
     */
    private Long targetId;
    /**
     * 类型: 1-文章 2-日记 3-留言
     */
    private Integer type;
}
