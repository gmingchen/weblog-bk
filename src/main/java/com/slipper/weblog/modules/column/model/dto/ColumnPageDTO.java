package com.slipper.weblog.modules.column.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ColumnPageDTO {
    /**
     * ID
     */
    private Long id;
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
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
