package com.slipper.weblog.modules.category.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分类
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("category")
public class CategoryEntity extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 父级ID 0-表示顶级
     */
    private Long parentId;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
