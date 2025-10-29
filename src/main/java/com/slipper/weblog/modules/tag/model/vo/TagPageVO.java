package com.slipper.weblog.modules.tag.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gumingchen
 */
@Data
public class TagPageVO {
    /**
     * ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
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
