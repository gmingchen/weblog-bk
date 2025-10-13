package com.slipper.weblog.modules.tag.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 标签
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("tag")
public class TagEntity extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 排序：越大位置越靠前
     */
    private Integer sort;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
