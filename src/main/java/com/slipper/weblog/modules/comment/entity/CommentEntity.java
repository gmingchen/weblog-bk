package com.slipper.weblog.modules.comment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 评论
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("comment")
public class CommentEntity extends BaseEntity {
    /**
     * 关联目标ID 文章ID、日记ID 根据type决定是什么ID
     * 留言板不需要
     */
    private Long targetId;
    /**
     * 内容
     */
    private String content;
    /**
     * 父级ID 0-表示顶级
     */
    private Long parentId;
    /**
     * 类型: 1-文章 2-日记 3-留言
     */
    private Integer type;
    /**
     * 是否私密 0-否 1-是
     */
    private Integer isPrivate;
    /**
     * 是否匿名 0-否 1-是
     */
    private Integer isAnonymous;
    /**
     * 状态 0-待审核 1-审核通过 2-审核拒绝
     */
    private Integer status;
}
