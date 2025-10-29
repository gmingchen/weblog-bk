package com.slipper.weblog.modules.category.model.vo;

import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class CategoryBaseVO {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级ID 0-表示顶级
     */
    private Long parentId;
}
