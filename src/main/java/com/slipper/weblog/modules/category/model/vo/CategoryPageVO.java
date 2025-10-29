package com.slipper.weblog.modules.category.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Data
public class CategoryPageVO {
    /**
     * ID
     */
    private Long id;
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
     * 排序：越大位置越靠前
     */
    private Integer sort;
    /**
     * 状态：0-禁用 1-启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
