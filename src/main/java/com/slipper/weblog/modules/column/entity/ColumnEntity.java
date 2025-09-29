package com.slipper.weblog.modules.column.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.slipper.weblog.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 专栏
 * @author gumingchen
 */
@Data
@Accessors(chain = true)
@TableName("column")
public class ColumnEntity extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
}
