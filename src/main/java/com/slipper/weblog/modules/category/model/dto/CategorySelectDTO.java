package com.slipper.weblog.modules.category.model.dto;

import lombok.Data;

/**
 * @author gumingchen
 */
@Data
public class CategorySelectDTO {
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
